package nl.rsvier.icaras;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import nl.rsvier.icaras.core.TestAdres;
import nl.rsvier.icaras.core.TestDigitaalAdres;
import nl.rsvier.icaras.core.TestPersoon;
import nl.rsvier.icaras.core.relatiebeheer.Adres;
import nl.rsvier.icaras.core.relatiebeheer.DigitaalAdres;
import nl.rsvier.icaras.core.relatiebeheer.Persoon;
import nl.rsvier.icaras.service.relatiebeheer.AdresService;
import nl.rsvier.icaras.service.relatiebeheer.DigitaalAdresService;
import nl.rsvier.icaras.service.relatiebeheer.PersoonService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:icarastestdb-context.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class DatabaseVullen {

	@Autowired
	private PersoonService persoonService;
	@Autowired
	private AdresService adresService;
	@Autowired
	private DigitaalAdresService digitaalAdresService;
	
	@Test
	@Transactional
	public void savePersoon() {
		Persoon persoon1 = TestPersoon.maakTestPersoon1();
		Adres adres1 = TestAdres.maakTestAdres1();
		adresService.addAdresType("woonboot", adres1);
		DigitaalAdres digitaalAdres1 = TestDigitaalAdres.maakDigitaalAdres1();
		digitaalAdresService.addAdresType("email", digitaalAdres1);
		
		persoon1.addAdres(adres1);
		persoon1.addDigitaalAdres(digitaalAdres1);
		
		persoonService.save(persoon1);
		adresService.save(adres1);
		digitaalAdresService.save(digitaalAdres1);
		
		assertNotNull(persoonService.get(persoon1.getId()));
		assertNotNull(adresService.get(adres1.getId()));
		assertNotNull(digitaalAdresService.get(digitaalAdres1.getId()));
	}
}
