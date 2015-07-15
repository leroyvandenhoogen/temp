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
	
	/**
	 * Test op Adres zoeken met bestaande postcode
	 */
	@Test
	@Transactional
	public void testZoekAdres_postcode () {
		String postcode = "7940XX";
		Adres adres = postcodeDao.zoekAdres(postcode);
		
		assertNotNull(adres);
		assertTrue(adres.getStraat().equals("Troelstraplein"));
		assertTrue(adres.getPostcode().equals(postcode));
		assertTrue(adres.getPlaats().equals("Meppel"));
		assertTrue(adres.getProvincie().equals("Drenthe"));
	}
	
	/**
	 * Test op PostcodeData zoeken met bestaande postcode
	 * PostcodeData bevat behalve adresgegevens ook nog extra velden zoals Gemeente, Provincie,
	 * latitude en longitude
	 */
	@Test
	@Transactional
	public void testZoekPostcodeData_postcode () {
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
	
	/**
	 * Test op Adres zoeken met postcode en huisnummer
	 */
	@Test
	@Transactional
	public void testZoekAdres_postcodenummer() {
		String postcode = "7940XX";
		int nummer = 5;
		Adres adres = postcodeDao.zoekAdres(postcode, nummer);
		
		assertNotNull(adres);
		assertTrue(adres.getStraat().equals("Troelstraplein"));
		assertTrue(adres.getPostcode().equals(postcode));
		assertTrue(adres.getPlaats().equals("Meppel"));
		assertTrue(adres.getProvincie().equals("Drenthe"));
	}
	
	/**
	 * Test op PostcodeData zoeken met correcte combinatie van postcode en huisnummer
	 * deze straat heeft zowel even als oneven nummers
	 */
	@Test
	@Transactional
	public void testZoekPostcodeData_postcodenummer () {
		String postcode = "7940XX";
		int nummer = 5;
		PostcodeData pData = postcodeDao.zoekPostcodeData(postcode, nummer);
		
		assertNotNull(pData);
		assertTrue(pData.getMinnumber() <= nummer);
		assertTrue(pData.getMaxnumber() >= nummer);
		assertTrue(pData.getNummertype().equals("odd") || pData.getNummertype().equals("mixed"));
		assertTrue(pData.getStraat().equals("Troelstraplein"));
		assertTrue(pData.getPostcode().equals(postcode));
		assertTrue(pData.getStad().equals("Meppel"));
		assertTrue(pData.getProvincie().equals("Drenthe"));
		assertTrue(pData.getGemeente().equals("Meppel"));
		assertTrue(pData.getLon().equals(6.1977201775604));
		assertTrue(pData.getLat().equals(52.7047653217626));	
	}
	
	/**
	 * Test op PostcodeData zoeken met correcte combinatie van postcode en huisnummer
	 * deze straat heeft alleen oneven nummers
	 */
	@Test
	@Transactional
	public void testZoekPostcodeData_postcodenummer2 () {
		String postcode = "7941AA";
		int nummer = 5;
		PostcodeData pData = postcodeDao.zoekPostcodeData(postcode, nummer);
		
		assertNotNull(pData);
		assertTrue(pData.getMinnumber() <= nummer);
		assertTrue(pData.getMaxnumber() >= nummer);
		assertTrue(pData.getNummertype().equals("odd") || pData.getNummertype().equals("mixed"));
		assertTrue(pData.getStraat().equals("Hoofdstraat"));
		assertTrue(pData.getPostcode().equals(postcode));
		assertTrue(pData.getStad().equals("Meppel"));
		assertTrue(pData.getProvincie().equals("Drenthe"));
		assertTrue(pData.getGemeente().equals("Meppel"));
		assertTrue(pData.getLon().equals(6.1900102053232));
		assertTrue(pData.getLat().equals(52.6987080538780));	
	}
	
	/**
	 * Test op PostcodeData zoeken met verkeerde combinatie van postcode en huisnummer
	 * deze straat heeft alleen oneven nummers
	 */
	@Test
	@Transactional
	public void testZoekPostcodeData_postcodenummer3 () {
		String postcode = "7941AA";
		int nummer = 4;
		PostcodeData pData = postcodeDao.zoekPostcodeData(postcode, nummer);
		
		assertNull(pData);	
	}
}
