package nl.rsvier.icaras.dao.relatiebeheer;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import nl.rsvier.icaras.core.TestAdres;
import nl.rsvier.icaras.core.relatiebeheer.Adres;
import nl.rsvier.icaras.core.relatiebeheer.AdresType;
import nl.rsvier.icaras.core.relatiebeheer.Persoon;

import org.junit.Before;
import org.junit.Ignore;
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
public class AdresDaoImplTest {
	
	@Autowired
	private AdresDaoImpl adresDao;
	@Autowired
	private AdresTypeDaoImpl adresTypeDao;
	
	private Adres adres1;
	private Adres adres2;
	
	@Before
	@Transactional
	public void setUp() {
		adres1 = TestAdres.maakTestAdres1();
		adres2 = TestAdres.maakTestAdres2();
		
	}
	
	
	@Test
	@Transactional
	public void testSaveEnGetAdres() {
		adresTypeDao.addAdresType("post", adres1);
		adresTypeDao.addAdresType("huis", adres2);
		adresTypeDao.flushAndClear();
		
		adresDao.save(adres1);
		adresDao.save(adres2);
		
		adresDao.flushAndClear();
		
		assertNotNull(adresDao.getById(adres1.getId()));
		assertNotNull(adresDao.getById(adres2.getId()));
		
		Adres testAdres1 = adresDao.getById(adres1.getId());
		Adres testAdres2 = adresDao.getById(adres2.getId());
		
		//Equals van adres
		assertTrue(
				"attributen vanuit database zijn gelijk aan die van het adres voor save",
				testAdres1.equals(adres1));
		assertTrue(adres1.getAdresType().getType().equalsIgnoreCase("post"));
		assertTrue(
				"attributen vanuit database zijn gelijk aan die van het adres voor save",
				testAdres2.equals(adres2));
		assertTrue(adres2.getAdresType().getType().equalsIgnoreCase("huis"));
		assertFalse(
				testAdres1.equals(testAdres2));
		
	}
	
	
	@Test
	@Transactional
	public void testUpdateAdres() {
		adresTypeDao.addAdresType("post", adres1);
		adresTypeDao.flushAndClear();
		adresDao.save(adres1);
		adresDao.flushAndClear();
		
		Adres testAdres1 = new Adres();
		
		testAdres1 = TestAdres.maakTestAdres1();
		adresTypeDao.addAdresType("post", testAdres1);
		
		assertNotNull(adresDao.getById(adres1.getId()));
		
		assertTrue(adresDao.getById(adres1.getId()).equals(testAdres1));
		adresDao.clear();
		
//		adresDao.getById(adres1.getId()).setStraat("AndereStraat");
		adres1.setStraat("AndereStraat");
		adresDao.update(adres1);
		adresDao.flushAndClear();
//		adresDao.clear();
		
		assertFalse(adresDao.getById(adres1.getId()).equals(testAdres1));
	}
	
	
	@Test
	@Transactional
	public void testDeleteAdres() {
		adresTypeDao.addAdresType("post", adres1);
		adresTypeDao.flushAndClear();
		adresDao.save(adres1);
		adresDao.flushAndClear();
		
		assertNotNull(adresDao.getById(adres1.getId()));
		
		adresDao.delete(adresDao.getById(adres1.getId()));
		
		assertNull(adresDao.getById(adres1.getId()));
	}
	
	@Test
	@Transactional
	public void testGetAllAdressen() {
		adresTypeDao.addAdresType("post", adres1);
		adresTypeDao.addAdresType("huis", adres2);
		adresTypeDao.flushAndClear();
		
		adresDao.save(adres1);
		adresDao.save(adres2);
		
		adresDao.flushAndClear();
		
		assertNotNull(adresDao.getById(adres1.getId()));
		assertNotNull(adresDao.getById(adres2.getId()));
		
		Adres testAdres1 = adresDao.getById(adres1.getId());
		Adres testAdres2 = adresDao.getById(adres2.getId());
		
		ArrayList<Adres> adresList = new ArrayList<Adres>();
		adresList.add(testAdres1);
		adresList.add(testAdres2);
		
		assertTrue(adresDao.getAll().equals(adresList));
	}
	

}
