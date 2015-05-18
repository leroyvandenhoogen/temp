package nl.rsvier.icaras.dao.relatiebeheer;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import nl.rsvier.icaras.core.TestPersoon;
import nl.rsvier.icaras.core.TestPersoonsrol;
import nl.rsvier.icaras.core.relatiebeheer.Persoon;
import nl.rsvier.icaras.core.relatiebeheer.Persoonsrol;
import nl.rsvier.icaras.core.relatiebeheer.PersoonsrolId;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:icarastestdb-context.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class PersoonsrolDaoImplTest {

	@Autowired
	private PersoonsrolDaoImpl dao;
	@Autowired
	private RolDaoImpl rolDao;
	@Autowired
	private PersoonDaoImpl persoonDao;
	
	private Persoonsrol persoonsrol1;
	private Persoonsrol persoonsrol2;
	
	@Before
	public void setUp() {
		persoonsrol1 = TestPersoonsrol.maakPersoonsrol1();
		persoonsrol2 = TestPersoonsrol.maakPersoonsrol2();
		Persoon persoon1 = TestPersoon.maakTestPersoon1();
		Persoon persoon2 = TestPersoon.maakTestPersoon2();
		persoonDao.save(persoon1);
		persoonDao.save(persoon2);
		persoonsrol1.setPersoon(persoon1);
		persoonsrol2.setPersoon(persoon2);
		rolDao.addRol("Cursist", persoonsrol1);
		rolDao.addRol("Cursist", persoonsrol2);
		PersoonsrolId id = new PersoonsrolId();
		id.setPersoonId(persoon1.getId());
		id.setRolId(persoonsrol1.getRol().getId());
		id.setBegindatum(new GregorianCalendar(2015, 0, 1).getTime());
		PersoonsrolId id2 = new PersoonsrolId();
		id2.setPersoonId(persoon2.getId());
		id2.setRolId(persoonsrol2.getRol().getId());
		id2.setBegindatum(new GregorianCalendar(2015, 11, 11).getTime());
		persoonsrol1.setId(id);
		persoonsrol2.setId(id2);
	}
	
	@Test
	@Transactional
	public void testSaveEnGetPersoonsrol() {
		dao.save(persoonsrol1);
		dao.save(persoonsrol2);
		
		dao.flushAndClear();
		
		assertNotNull(dao.getById(persoonsrol1.getId()));
		assertNotNull(dao.getById(persoonsrol2.getId()));
		
		Persoonsrol testPersoonsrol1 = dao.getById(persoonsrol1.getId());
		Persoonsrol testPersoonsrol2 = dao.getById(persoonsrol2.getId());
		
		assertTrue("attributen vanuit database zijn gelijk aan die van persoonsrol voor save",
				testPersoonsrol1.equals(persoonsrol1));
		
		assertTrue("attributen vanuit database zijn gelijk aan die van persoonsrol voor save",
				testPersoonsrol2.equals(persoonsrol2));
		assertFalse(testPersoonsrol1.equals(testPersoonsrol2));
	}
	
	@Test
	@Transactional
	public void testUpdate() {
		dao.save(persoonsrol1);
		dao.save(persoonsrol2);
		
		dao.flushAndClear();
		
		assertFalse(dao.getById(persoonsrol1.getId()).equals(dao.getById(persoonsrol2.getId())));
		
		
//		assertNotNull(dao.getById(persoonsrol1.getId()));
//		assertNotNull(dao.getById(persoonsrol2.getId()));
//		
//		Persoonsrol testPersoonsrol1 = dao.getById(persoonsrol1.getId());
//		Persoonsrol testPersoonsrol2 = dao.getById(persoonsrol2.getId());
//		
//		assertTrue("attributen vanuit database zijn gelijk aan die van persoonsrol voor save",
//				testPersoonsrol1.equals(persoonsrol1));
//		
//		assertTrue("attributen vanuit database zijn gelijk aan die van persoonsrol voor save",
//				testPersoonsrol2.equals(persoonsrol2));
//		assertFalse(testPersoonsrol1.equals(testPersoonsrol2));
		
		
		
		
	}
}
