package nl.rsvier.icaras.dao.relatiebeheer;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import nl.rsvier.icaras.core.TestIdentiteitsbewijs;
import nl.rsvier.icaras.core.TestPersoon;
import nl.rsvier.icaras.core.relatiebeheer.Identiteitsbewijs;
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
public class IdentiteitsbewijsDaoImplTest {
	
	@Autowired
	private IdentiteitsbewijsDaoImpl identiteitsbewijsDao;
	@Autowired
	private IdentiteitsbewijsTypeDaoImpl identiteitsbewijsTypeDao;
	@Autowired
	private PersoonDaoImpl persoonDao;
	
	private Identiteitsbewijs identiteitsbewijs1;
	private Identiteitsbewijs identiteitsbewijs2;
	
	private Persoon persoon1;
	private Persoon persoon2;
	
	@Before
	@Transactional
	public void setUp() {
		identiteitsbewijs1 = TestIdentiteitsbewijs.maakIdentiteitsbewijs1();
		identiteitsbewijs2 = TestIdentiteitsbewijs.maakIdentiteitsbewijs2();
		
		persoon1 = TestPersoon.maakTestPersoon1();
		persoon2 = TestPersoon.maakTestPersoon2();
		
		persoonDao.save(persoon1);
		persoonDao.save(persoon2);		
		
		persoonDao.flush();
		
		//Persoon in identiteitsbewijs mag niet null zijn
		identiteitsbewijs1.setPersoon(persoon1);
		identiteitsbewijs2.setPersoon(persoon2);
		
		identiteitsbewijsTypeDao.addIdentiteitsbewijsType("paspoort", identiteitsbewijs1);
		identiteitsbewijsTypeDao.addIdentiteitsbewijsType("rijbewijs", identiteitsbewijs2);
		
	}
	
	@Test
	@Transactional
	public void testSaveEnGetIdentiteitsbewijs() {

		identiteitsbewijsDao.save(identiteitsbewijs1);
		identiteitsbewijsDao.save(identiteitsbewijs2);
		
		identiteitsbewijsDao.flushAndClear();
		
		assertNotNull(identiteitsbewijsDao.getById(identiteitsbewijs1.getNummer()));
		assertNotNull(identiteitsbewijsDao.getById(identiteitsbewijs2.getNummer()));
		
		Identiteitsbewijs testIdentiteitsbewijs1 = identiteitsbewijsDao.getByIdEager(identiteitsbewijs1.getNummer());
		Identiteitsbewijs testIdentiteitsbewijs2 = identiteitsbewijsDao.getByIdEager(identiteitsbewijs2.getNummer());
		
		System.out.println("TESTTEST" + testIdentiteitsbewijs1.getPersoon().getVoornaam());
		System.out.println("DBDBDB" + identiteitsbewijs1.getPersoon().getVoornaam());
		
		identiteitsbewijsDao.flushAndClear();
		
		System.out.println("TESTTEST" + testIdentiteitsbewijs1.getPersoon().getVoornaam());
		System.out.println("DBDBDB" + identiteitsbewijs1.getPersoon().getVoornaam());
		
		//Equals van Identiteitsbewijs
		assertTrue(testIdentiteitsbewijs1.equals(identiteitsbewijsDao.getByIdEager(identiteitsbewijs1.getNummer())));
		assertTrue(testIdentiteitsbewijs2.equals(identiteitsbewijsDao.getByIdEager(identiteitsbewijs2.getNummer())));
		
		assertTrue(testIdentiteitsbewijs1.getIdentiteitsbewijsType().getType().equalsIgnoreCase("paspoort"));
		assertTrue(testIdentiteitsbewijs2.getIdentiteitsbewijsType().getType().equalsIgnoreCase("rijbewijs"));
		
		assertFalse(testIdentiteitsbewijs1.equals(testIdentiteitsbewijs2));
		assertFalse(identiteitsbewijsDao.getByIdEager(identiteitsbewijs1.getNummer()).equals(identiteitsbewijsDao.getByIdEager(identiteitsbewijs2.getNummer())));
		
	}
	
}
