package nl.rsvier.icaras.dao.relatiebeheer;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.transaction.Transactional;

import nl.rsvier.icaras.core.TestDigitaalAdres;
import nl.rsvier.icaras.core.relatiebeheer.DigitaalAdres;

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
public class DigitaalAdresDaoImplTest {

	@Autowired
	private DigitaalAdresDaoImpl digitaalAdresDao;
	@Autowired
	private DigitaalAdresTypeDaoImpl digitaalAdresTypeDao;
	
	private DigitaalAdres digitaalAdres1;
	private DigitaalAdres digitaalAdres2;
	
	@Before
	@Transactional
	public void setUp() {
		digitaalAdres1 = TestDigitaalAdres.maakDigitaalAdres1();
		digitaalAdres2 = TestDigitaalAdres.maakDigitaalAdres2();
		
		digitaalAdresTypeDao.addDigitaalAdresType("email", digitaalAdres1);
		digitaalAdresTypeDao.addDigitaalAdresType("telefoonnummer", digitaalAdres2);
		
	}
	
	@Test
	@Transactional
	public void testSaveEnGetDigitaalAdres() {
		digitaalAdresDao.save(digitaalAdres1);
		digitaalAdresDao.save(digitaalAdres2);
		
		digitaalAdresDao.flushAndClear();
		
		assertNotNull(digitaalAdresDao.getById(digitaalAdres1.getId()));
		assertNotNull(digitaalAdresDao.getById(digitaalAdres2.getId()));
		
		DigitaalAdres testDigitaalAdres1 = digitaalAdresDao.getById(digitaalAdres1.getId());
		DigitaalAdres testDigitaalAdres2 = digitaalAdresDao.getById(digitaalAdres2.getId());
		
		digitaalAdresDao.flushAndClear();
		
		//Equals van DigitaalAdres
		assertTrue(testDigitaalAdres1.equals(digitaalAdresDao.getById(digitaalAdres1.getId())));
		assertTrue(testDigitaalAdres2.equals(digitaalAdresDao.getById(digitaalAdres2.getId())));
		
		assertTrue(testDigitaalAdres1.getDigitaalAdresType().getType().equalsIgnoreCase("email"));
		assertTrue(testDigitaalAdres2.getDigitaalAdresType().getType().equalsIgnoreCase("telefoonnummer"));
		
		assertFalse(testDigitaalAdres1.equals(testDigitaalAdres2));
		assertFalse(digitaalAdresDao.getById(digitaalAdres1.getId()).equals(digitaalAdresDao.getById(digitaalAdres2.getId())));
		
	}
	
	@Test
	@Transactional
	public void testUpdateDigitaalAdres() {
		digitaalAdresDao.save(digitaalAdres1);
		digitaalAdresDao.flushAndClear();
		
		assertNotNull(digitaalAdresDao.getById(digitaalAdres1.getId()));
		
		DigitaalAdres testDigitaalAdres1 = TestDigitaalAdres.maakDigitaalAdres1();
		digitaalAdresTypeDao.addDigitaalAdresType("email", testDigitaalAdres1);
		
		digitaalAdresDao.flushAndClear();
		
		assertTrue(digitaalAdresDao.getById(digitaalAdres1.getId()).equals(testDigitaalAdres1));
		digitaalAdresDao.clear();
		
		digitaalAdres1.setContactvoorkeur(!(digitaalAdres1.isContactvoorkeur()));
		digitaalAdresDao.update(digitaalAdres1);
		digitaalAdresDao.flushAndClear();
		
		assertFalse(digitaalAdresDao.getById(digitaalAdres1.getId()).equals(testDigitaalAdres1));
	}
	
	@Test
	@Transactional
	public void testDeleteBedrijf() {
		digitaalAdresDao.save(digitaalAdres1);
		digitaalAdresDao.flushAndClear();
		
		assertNotNull(digitaalAdresDao.getById(digitaalAdres1.getId()));
		digitaalAdresDao.clear();
		
		digitaalAdresDao.delete(digitaalAdres1);
		
		assertNull(digitaalAdresDao.getById(digitaalAdres1.getId()));
	}
	
	@Test
	@Transactional
	public void testGetAllDigitaleAdressen() {
		digitaalAdresDao.save(digitaalAdres1);
		digitaalAdresDao.save(digitaalAdres2);
		digitaalAdresDao.flushAndClear();
		
		assertNotNull(digitaalAdresDao.getById(digitaalAdres1.getId()));
		assertNotNull(digitaalAdresDao.getById(digitaalAdres2.getId()));
		
		DigitaalAdres testDigitaalAdres1 = digitaalAdresDao.getById(digitaalAdres1.getId());
		DigitaalAdres testDigitaalAdres2 = digitaalAdresDao.getById(digitaalAdres2.getId());
		
		ArrayList<DigitaalAdres> digitaalAdresList = new ArrayList<DigitaalAdres>();
		digitaalAdresList.add(testDigitaalAdres1);
		digitaalAdresList.add(testDigitaalAdres2);
		
		assertTrue(digitaalAdresDao.getAll().equals(digitaalAdresList));
	}
}

