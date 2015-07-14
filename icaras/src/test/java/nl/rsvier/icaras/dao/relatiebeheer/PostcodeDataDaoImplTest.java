package nl.rsvier.icaras.dao.relatiebeheer;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import nl.rsvier.icaras.core.relatiebeheer.Adres;
import nl.rsvier.icaras.core.relatiebeheer.PostcodeData;

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
		String postcode = "7940XX";
		Adres adres = postcodeDao.zoekAdres(postcode);
		
		assertNotNull(adres);
		assertTrue(adres.getStraat().equals("Troelstraplein"));
		assertTrue(adres.getPostcode().equals(postcode));
		assertTrue(adres.getPlaats().equals("Meppel"));
		assertTrue(adres.getProvincie().equals("Drenthe"));
	}
	
	@Test
	@Transactional
	public void testZoekPostcodeData() {
		String postcode = "7940XX";
		
		PostcodeData pData = postcodeDao.zoekPostcodeData(postcode);
		
		assertNotNull(pData);
		assertTrue(pData.getStraat().equals("Troelstraplein"));
		assertTrue(pData.getPostcode().equals(postcode));
		assertTrue(pData.getStad().equals("Meppel"));
		assertTrue(pData.getProvincie().equals("Drenthe"));
		assertTrue(pData.getGemeente().equals("Meppel"));
		assertTrue(pData.getLon().equals(6.1977201775604));
		assertTrue(pData.getLat().equals(52.7047653217626));

		
	}
}
