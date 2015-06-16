package nl.rsvier.icaras.dao.relatiebeheer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import nl.rsvier.icaras.core.TestBedrijf;
import nl.rsvier.icaras.core.relatiebeheer.Bedrijf;

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
public class BedrijfDaoImplTest {

	@Autowired
	private BedrijfDaoImpl bedrijfDao;
	
	private Bedrijf bedrijf1;
	private Bedrijf bedrijf2;
	
	@Before
	@Transactional
	public void setUp() {
		bedrijf1 = TestBedrijf.maakTestBedrijf1();
		bedrijf2 = TestBedrijf.maakTestBedrijf2();
		
	}
	
	@Test
	@Transactional
	public void testSearch() {
		bedrijfDao.save(bedrijf1);
		List<Bedrijf> lijst = bedrijfDao.search("Best");
		assertNotNull(lijst.size());
		assertTrue(lijst.get(0).equals(bedrijf1));
	}
	
	@Test
	@Transactional
	public void testSaveEnGetBedrijf() {
		bedrijfDao.save(bedrijf1);
		bedrijfDao.save(bedrijf2);
		
		bedrijfDao.flushAndClear();
		
		assertNotNull(bedrijfDao.getById(bedrijf1.getId()));
		assertNotNull(bedrijfDao.getById(bedrijf2.getId()));
		
		Bedrijf testBedrijf1 = bedrijfDao.getById(bedrijf1.getId());
		Bedrijf testBedrijf2 = bedrijfDao.getById(bedrijf2.getId());
		
		//Equals van bedrijf
		assertTrue(testBedrijf1.equals(bedrijf1));
		assertTrue(testBedrijf2.equals(bedrijf2));
		assertFalse(testBedrijf1.equals(testBedrijf2));
	}
	
	@Test
	@Transactional
	public void testUpdateBedrijf() {
		bedrijfDao.save(bedrijf1);
		bedrijfDao.flushAndClear();
		
		Bedrijf testBedrijf1 = TestBedrijf.maakTestBedrijf1();
		
		assertNotNull(bedrijfDao.getById(bedrijf1.getId()));
		
		assertTrue(bedrijfDao.getById(bedrijf1.getId()).equals(testBedrijf1));
		bedrijfDao.clear();
		
		bedrijf1.setNaam("Changed");
		bedrijfDao.update(bedrijf1);
		bedrijfDao.flushAndClear();
		
		assertFalse(bedrijfDao.getById(bedrijf1.getId()).equals(testBedrijf1));
	}
	
	@Test
	@Transactional
	public void testDeleteBedrijf() {
		bedrijfDao.save(bedrijf1);
		bedrijfDao.flushAndClear();
		
		assertNotNull(bedrijfDao.getById(bedrijf1.getId()));
		bedrijfDao.clear();
		
//		bedrijfDao.delete(bedrijfDao.getById(bedrijf1.getId()));
		bedrijfDao.delete(bedrijf1);
		
		assertNull(bedrijfDao.getById(bedrijf1.getId()));
	}
	
	@Test
	@Transactional
	public void testGetAllBedrijven() {
		bedrijfDao.save(bedrijf1);
		bedrijfDao.save(bedrijf2);
		bedrijfDao.flushAndClear();
		
		assertNotNull(bedrijfDao.getById(bedrijf1.getId()));
		assertNotNull(bedrijfDao.getById(bedrijf2.getId()));
		
		Bedrijf testBedrijf1 = bedrijfDao.getById(bedrijf1.getId());
		Bedrijf testBedrijf2 = bedrijfDao.getById(bedrijf2.getId());
		
		ArrayList<Bedrijf> bedrijfList = new ArrayList<Bedrijf>();
		bedrijfList.add(testBedrijf1);
		bedrijfList.add(testBedrijf2);
		
		assertTrue(bedrijfDao.getAll().containsAll(bedrijfList));
	}
	
}
