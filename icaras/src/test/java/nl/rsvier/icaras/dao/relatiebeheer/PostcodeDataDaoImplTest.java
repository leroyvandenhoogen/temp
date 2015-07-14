package nl.rsvier.icaras.dao.relatiebeheer;

import javax.transaction.Transactional;

import nl.rsvier.icaras.core.relatiebeheer.Adres;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:icarastestdb-context.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class PostcodeDataDaoImplTest {
	
	@Autowired
	private PostcodeDataDaoImpl postcodeDao;
	
	@Test
	@Transactional
	public void testZoekAdres() {
		String postcode = "3972TP";
		Adres adres = postcodeDao.zoekAdres(postcode);
		
		System.out.println(adres);
	}
	
}
