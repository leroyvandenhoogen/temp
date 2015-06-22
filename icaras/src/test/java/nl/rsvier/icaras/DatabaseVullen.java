package nl.rsvier.icaras;

import static org.junit.Assert.assertNotNull;

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
	private BedrijfService bedrijfService;
	
	private String[] rollen = {"cursist", "kandidaat", "stagiair", "werknemer", "prive", "contactpersoon"};
//	@Test
//	@Transactional
//	public void savePersoon() {
//		Persoon persoon1 = TestPersoon.maakTestPersoon1();
//		Adres adres1 = TestAdres.maakTestAdres1();
//		adresService.addAdresType("woonboot", adres1);
//		DigitaalAdres digitaalAdres1 = TestDigitaalAdres.maakDigitaalAdres1();
//		DigitaalAdres digitaalAdres2 = TestDigitaalAdres.maakDigitaalAdres2();
//		digitaalAdresService.addAdresType("email", digitaalAdres1);
//		digitaalAdresService.addAdresType("telefoonnummer", digitaalAdres2);
//		Persoonsrol persoonsrol1 = TestPersoonsrol.maakPersoonsrol1();
//		Persoonsrol persoonsrol2 = TestPersoonsrol.maakPersoonsrol2();
//		persoonsrolService.addRol("cursist", persoonsrol1);
//		persoonsrolService.addRol("kandidaat", persoonsrol2);
//
//		
//		persoon1.addAdres(adres1);
//		persoon1.addDigitaalAdres(digitaalAdres1);
//		persoon1.addDigitaalAdres(digitaalAdres2);
//		persoon1.addPersoonsrol(persoonsrol1);
//		persoon1.addPersoonsrol(persoonsrol2);
//		
//		persoonService.save(persoon1);
//		adresService.save(adres1);
//		digitaalAdresService.save(digitaalAdres1);
//		digitaalAdresService.save(digitaalAdres2);
//
//		persoonsrolService.save(persoonsrol1);
//		persoonsrolService.save(persoonsrol2);
//		
//		assertNotNull(persoonService.get(persoon1.getId()));
//		assertNotNull(adresService.get(adres1.getId()));
//		assertNotNull(digitaalAdresService.get(digitaalAdres1.getId()));
//	}
	
	@Test
	@Transactional
	public void savePersonen() {
		for(int i = 0; i < 9000; i++){
			savePersoon2();
		}
		
	}

	@Transactional
	public synchronized void savePersoon2() {
		Persoon persoon = TestPersoon.maakTestContactpersoon();
		DigitaalAdres digitaalAdres1 = TestDigitaalAdres.maakDigitaalAdres1();
		DigitaalAdres digitaalAdres2 = TestDigitaalAdres.maakDigitaalAdres2();
		DigitaalAdres digitaalAdres3 = TestDigitaalAdres.maakDigitaalAdres3();
		digitaalAdresService.addAdresType("email", digitaalAdres1);
		digitaalAdresService.addAdresType("telefoonnummer", digitaalAdres2);
		digitaalAdresService.addAdresType("website", digitaalAdres3);
		persoon.addDigitaalAdres(digitaalAdres1);
		persoon.addDigitaalAdres(digitaalAdres2);
		persoon.addDigitaalAdres(digitaalAdres3);
		persoonService.save(persoon);
		digitaalAdresService.save(digitaalAdres1);
		digitaalAdresService.save(digitaalAdres2);
		digitaalAdresService.save(digitaalAdres3);
		Persoonsrol persoonsrol = TestPersoonsrol.maakPersoonsrol3();
		persoonsrol.setPersoon(persoon);
		int i = ((int)(Math.random()*10));

		Adres adres = TestAdres.maakTestAdres3();
		Adres adres2 = TestAdres.maakTestAdres3();
		
		if (i < 5) {
			persoonsrolService.addRol(rollen[i], persoonsrol);
			adresService.addAdresType("huis", adres);
			adresService.addAdresType("post", adres2);
			persoon.addAdres(adres);
			persoon.addAdres(adres2);
			adres.setPersoon(persoon);
			adres2.setPersoon(persoon);
			adresService.save(adres);
			adresService.save(adres2);
		}
		else {
			persoonsrolService.addRol(rollen[5], persoonsrol);
			adresService.addAdresType("bezoek", adres);
			Bedrijf bedrijf = TestBedrijf.maakTestBedrijf3();
			bedrijf.addAdres(adres);
			adres.setBedrijf(bedrijf);
			persoonsrol.setBedrijf(bedrijf);
			adresService.save(adres);
			bedrijfService.save(bedrijf);
		}
		persoonsrolService.save(persoonsrol);
		
		assertNotNull(persoonService.get(persoon.getId()));
		assertNotNull(adresService.get(adres.getId()));
		assertNotNull(digitaalAdresService.get(digitaalAdres1.getId()));
	}
}
