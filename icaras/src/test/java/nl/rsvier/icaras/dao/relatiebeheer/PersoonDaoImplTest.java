package nl.rsvier.icaras.dao.relatiebeheer;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import nl.rsvier.icaras.core.TestPersoon;
import nl.rsvier.icaras.core.relatiebeheer.Persoon;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:icarastestdb-context.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class PersoonDaoImplTest {
	
	@Autowired
	private PersoonDaoImpl persoonDao;
	
	private Persoon persoon1;
	private Persoon persoon2;
	
	@Before
	public void setUp() {
		persoon1 = TestPersoon.maakTestPersoon1();
		persoon2 = TestPersoon.maakTestPersoon2();
	}
	
	@Test
	@Transactional
	public void testSaveEnGetPersoon() {
		persoonDao.save(persoon1);
		persoonDao.save(persoon2);
		
		persoonDao.flushAndClear();
		
		assertNotNull(persoonDao.getById(persoon1.getId()));
		assertNotNull(persoonDao.getById(persoon2.getId()));
		
		Persoon testPersoon1 = persoonDao.getById(persoon1.getId());
		Persoon testPersoon2 = persoonDao.getById(persoon2.getId());
		
		//Equals van persoon
		assertTrue(
				"attributen vanuit database zijn gelijk aan die van het persoon voor save",
				testPersoon1.equals(persoon1));
		assertTrue(
				"attributen vanuit database zijn gelijk aan die van het persoon voor save",
				testPersoon2.equals(persoon2));
		assertFalse(
				testPersoon1.equals(testPersoon2));
		
	}
	
	@Test
	@Transactional
	public void testUpdatePersoon() {
		persoonDao.save(persoon1);
		persoonDao.save(persoon2);
		persoonDao.flushAndClear();
		
		assertFalse(persoonDao.getById(persoon1.getId()).equals(persoonDao.getById(persoon2.getId())));
		assertFalse(persoonDao.getById(persoon1.getId()).hashCode() == persoonDao.getById(persoon2.getId()).hashCode());
		
		persoonDao.flushAndClear();
		
		persoon2.setAchternaam(persoon1.getAchternaam());
		persoon2.setTussenvoegsel(persoon1.getTussenvoegsel());
		persoon2.setVoornaam(persoon1.getVoornaam());
		persoon2.setGeboortedatum(persoon1.getGeboortedatum());
		persoon2.setGeboorteplaats(persoon1.getGeboorteplaats());
		persoon2.setGeslacht(persoon1.getGeslacht());
		persoon2.setRijbewijs(persoon1.getRijbewijs());
		persoon2.setNationaliteit(persoon1.getNationaliteit());
		
		persoonDao.flushAndClear();
		
		persoonDao.update(persoon1);
		persoonDao.update(persoon2);
		persoonDao.flushAndClear();
		
		assertTrue(persoonDao.getById(persoon1.getId()).equals(persoonDao.getById(persoon2.getId())));
		assertTrue(persoonDao.getById(persoon1.getId()).hashCode() == persoonDao.getById(persoon2.getId()).hashCode());
	}
	
	@Test
	@Transactional
	public void testDeletePersoon() {
		persoonDao.save(persoon1);
		persoonDao.flushAndClear();
		
		assertNotNull(persoonDao.getById(persoon1.getId()));
		
		persoonDao.delete(persoonDao.getById(persoon1.getId()));
		persoonDao.flushAndClear();
		
		assertNull(persoonDao.getById(persoon1.getId()));		
	}
	
	/*
	 * Voorafgaand deze test moet de tabel leeg zijn, anders faalt de assertTrue().
	 */
	@Test
	@Transactional
	public void testGetAllPersonen() {
		persoonDao.save(persoon1);
		persoonDao.save(persoon2);
		persoonDao.flushAndClear();
		
		Persoon testPersoon1 = persoonDao.getById(persoon1.getId());
		Persoon testPersoon2 = persoonDao.getById(persoon2.getId());
		persoonDao.flushAndClear();
		List<Persoon> testlijst = new ArrayList<Persoon>();
		testlijst.add(testPersoon1);
		testlijst.add(testPersoon2);
		
		assertTrue(persoonDao.getAll().containsAll(testlijst));
	}
	
	@Test
	@Transactional
	public void testSearchPersoon() {
		persoonDao.save(persoon1);
		persoonDao.save(persoon2);
		
		persoonDao.flushAndClear();
		
		List<Persoon> sjaak	= persoonDao.search("Sjaak", "Trekhaak");
		assertTrue(sjaak.get(0).equals(persoon1));
		List<Persoon> koos = persoonDao.search("Koos", "Kansloos");
		assertTrue(koos.get(0).equals(persoon2));
		
		List<Persoon> sjaakLowerCase = persoonDao.search("sjaak", "trekhaak");
		assertTrue(sjaakLowerCase.get(0).equals(persoon1));
		List<Persoon> koosLowerCase = persoonDao.search("koos", "kansloos");
		assertTrue(koosLowerCase.get(0).equals(persoon2));
		
	}
	
	@Test
	@Transactional
	public void testSearchFullPersoon() {
		persoonDao.save(persoon1);
		persoonDao.save(persoon2);
		
		persoonDao.flushAndClear();
		
		List<Persoon> sjaakVoornaam = persoonDao.searchFull("sjaak");
		assertTrue(sjaakVoornaam.contains(persoon1));
		
		List<Persoon> sjaakAchternaam = persoonDao.searchFull("trekhaak");
		assertTrue(sjaakAchternaam.contains(persoon1));
		
		List<Persoon> sjaakVoornaamIncomplete = persoonDao.searchFull("sja");
		assertTrue(sjaakVoornaamIncomplete.contains(persoon1));
		
		List<Persoon> sjaakAchternaamIncomplete = persoonDao.searchFull("trek");
		assertTrue(sjaakAchternaamIncomplete.contains(persoon1));
		
		List<Persoon> sjaak	= persoonDao.searchFull("sjaak trekhaak");
		assertTrue(sjaak.contains(persoon1));
		
		List<Persoon> sjaak2 = persoonDao.searchFull("sjaak, trekhaak");
		assertTrue(sjaak2.contains(persoon1));
		
		List<Persoon> sjaak3 = persoonDao.searchFull("sjaak,trekhaak");
		assertTrue(sjaak3.contains(persoon1));
		
		List<Persoon> sjaakIncomplete = persoonDao.searchFull("sja trek");
		assertTrue(sjaakIncomplete.contains(persoon1));
		
		List<Persoon> sjaakIncomplete2 = persoonDao.searchFull("s trek");
		assertTrue(sjaakIncomplete2.contains(persoon1));
		
		List<Persoon> sjaakReverse = persoonDao.searchFull("trekhaak sjaak");
		assertTrue(sjaakReverse.contains(persoon1));
		
		List<Persoon> sjaakReverse2 = persoonDao.searchFull("trekhaak, sjaak");
		assertTrue(sjaakReverse2.contains(persoon1));
		
		List<Persoon> sjaakReverse3 = persoonDao.searchFull("trekhaak,sjaak");
		assertTrue(sjaakReverse3.contains(persoon1));
		
		List<Persoon> sjaakIncompleteReverse = persoonDao.searchFull("trek sja");
		assertTrue(sjaakIncompleteReverse.contains(persoon1));
	}
}

