package nl.rsvier.icaras;

import static org.junit.Assert.assertNotNull;

import java.util.GregorianCalendar;

import javax.transaction.Transactional;

import nl.rsvier.icaras.core.TestAdres;
import nl.rsvier.icaras.core.TestBedrijf;
import nl.rsvier.icaras.core.TestDigitaalAdres;
import nl.rsvier.icaras.core.TestPersoon;
import nl.rsvier.icaras.core.TestPersoonsrol;
import nl.rsvier.icaras.core.relatiebeheer.Adres;
import nl.rsvier.icaras.core.relatiebeheer.Bedrijf;
import nl.rsvier.icaras.core.relatiebeheer.DigitaalAdres;
import nl.rsvier.icaras.core.relatiebeheer.Persoon;
import nl.rsvier.icaras.core.relatiebeheer.Persoonsrol;
import nl.rsvier.icaras.service.relatiebeheer.AdresService;
import nl.rsvier.icaras.service.relatiebeheer.BedrijfService;
import nl.rsvier.icaras.service.relatiebeheer.DigitaalAdresService;
import nl.rsvier.icaras.service.relatiebeheer.PersoonService;
import nl.rsvier.icaras.service.relatiebeheer.PersoonsrolService;

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
	@Autowired
	private PersoonsrolService persoonsrolService;
	@Autowired
	private BedrijfService bedrijfserice;
	
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
	
	@Test
	@Transactional
	public void saveContactPersoon() {
		Persoon persoon1 = TestPersoon.maakTestContactpersoon();
		Adres adres1 = TestAdres.maakTestAdres1();
		adresService.addAdresType("woonboot", adres1);
		DigitaalAdres digitaalAdres1 = TestDigitaalAdres.maakDigitaalAdres1();
		digitaalAdresService.addAdresType("email", digitaalAdres1);
		Persoonsrol persoonsrol = TestPersoonsrol.maakPersoonsrol3();
		persoonsrol.setPersoon(persoon1);
		Bedrijf bedrijf1 = TestBedrijf.maakTestBedrijf1();
		bedrijfserice.save(bedrijf1);

		persoon1.addAdres(adres1);
		persoon1.addDigitaalAdres(digitaalAdres1);

		persoonService.save(persoon1);
		adresService.save(adres1);
		digitaalAdresService.save(digitaalAdres1);
		
		persoonsrolService.addRol("contactpersoon", persoonsrol);

		persoonsrol.createId(new GregorianCalendar(2014, 8, 1).getTime());
		
		persoonsrolService.save(persoonsrol);
		assertNotNull(persoonService.get(persoon1.getId()));
		assertNotNull(adresService.get(adres1.getId()));
		assertNotNull(digitaalAdresService.get(digitaalAdres1.getId()));
		
	}
}
