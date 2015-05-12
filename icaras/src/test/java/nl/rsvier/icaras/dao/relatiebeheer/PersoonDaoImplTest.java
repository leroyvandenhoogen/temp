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
		persoonDao.flush();
		
		assertFalse(persoonDao.getById(persoon1.getId()).equals(persoonDao.getById(persoon2.getId())));
		assertFalse(persoonDao.getById(persoon1.getId()).hashCode() == persoonDao.getById(persoon2.getId()).hashCode());
		
		persoonDao.getById(persoon2.getId()).setAchternaam(persoonDao.getById(persoon1.getId()).getAchternaam());
		persoonDao.getById(persoon2.getId()).setTussenvoegsel(persoonDao.getById(persoon1.getId()).getTussenvoegsel());
		persoonDao.getById(persoon2.getId()).setVoornaam(persoonDao.getById(persoon1.getId()).getVoornaam());
		persoonDao.getById(persoon2.getId()).setGeboortedatum(persoonDao.getById(persoon1.getId()).getGeboortedatum());
		persoonDao.getById(persoon2.getId()).setGeboorteplaats(persoonDao.getById(persoon1.getId()).getGeboorteplaats());
		persoonDao.getById(persoon2.getId()).setGeslacht(persoonDao.getById(persoon1.getId()).getGeslacht());
		persoonDao.getById(persoon2.getId()).setRijbewijs(persoonDao.getById(persoon1.getId()).getRijbewijs());
		persoonDao.getById(persoon2.getId()).setNationaliteit(persoonDao.getById(persoon1.getId()).getNationaliteit());
		
		persoonDao.update(persoon1);
		persoonDao.update(persoon2);
		persoonDao.flushAndClear();
		
		assertTrue("attributen geupdate achternaam is gelijk aan attributen ingeladen persoon met dezelfde id",
				persoonDao.getById(persoon1.getId()).equals(persoonDao.getById(persoon2.getId())));
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
		List<Persoon> testlijst = new ArrayList<Persoon>();
		testlijst.add(testPersoon1);
		testlijst.add(testPersoon2);
		
		assertTrue(persoonDao.getAll().equals(testlijst));
	}
}
