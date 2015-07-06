package nl.rsvier.icaras;

import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import nl.rsvier.icaras.core.TestAdres;
import nl.rsvier.icaras.core.TestBedrijf;
import nl.rsvier.icaras.core.TestDigitaalAdres;
import nl.rsvier.icaras.core.TestPersoon;
import nl.rsvier.icaras.core.TestPersoonsrol;
import nl.rsvier.icaras.core.relatiebeheer.Adres;
import nl.rsvier.icaras.core.relatiebeheer.Bedrijf;
import nl.rsvier.icaras.core.relatiebeheer.BedrijfExpertise;
import nl.rsvier.icaras.core.relatiebeheer.BedrijfType;
import nl.rsvier.icaras.core.relatiebeheer.DigitaalAdres;
import nl.rsvier.icaras.core.relatiebeheer.Expertise;
import nl.rsvier.icaras.core.relatiebeheer.Persoon;
import nl.rsvier.icaras.core.relatiebeheer.Persoonsrol;
import nl.rsvier.icaras.core.relatiebeheer.Rol;
import nl.rsvier.icaras.service.relatiebeheer.AdresService;
import nl.rsvier.icaras.service.relatiebeheer.BedrijfExpertiseService;
import nl.rsvier.icaras.service.relatiebeheer.BedrijfService;
import nl.rsvier.icaras.service.relatiebeheer.BedrijfTypeService;
import nl.rsvier.icaras.service.relatiebeheer.DigitaalAdresService;
import nl.rsvier.icaras.service.relatiebeheer.ExpertiseService;
import nl.rsvier.icaras.service.relatiebeheer.PersoonService;
import nl.rsvier.icaras.service.relatiebeheer.PersoonsrolService;
import nl.rsvier.icaras.service.relatiebeheer.RolService;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:icarastestdb-context.xml" })
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
	@Autowired
	private RolService rolService;
	@Autowired
	private BedrijfTypeService bedrijfTypeService;
	@Autowired
	private ExpertiseService expertiseService;
	@Autowired
	private BedrijfExpertiseService bedrijfExpertiseService;

	private List<Rol> rollen;
	private List<BedrijfType> bedrijfTypes;
	private List<Expertise> bedrijfExpertises;
	
	private int rollenSize;
	private int bedrijfTypesSize;
	private int bedrijfExpertisesSize;
	
	
	
//		{ "cursist", "kandidaat", "stagiair",
//			"werknemer", "prive", "contactpersoon" };

	// @Test
	// @Transactional
	// public void savePersoon() {
	// Persoon persoon1 = TestPersoon.maakTestPersoon1();
	// Adres adres1 = TestAdres.maakTestAdres1();
	// adresService.addAdresType("woonboot", adres1);
	// DigitaalAdres digitaalAdres1 = TestDigitaalAdres.maakDigitaalAdres1();
	// DigitaalAdres digitaalAdres2 = TestDigitaalAdres.maakDigitaalAdres2();
	// digitaalAdresService.addAdresType("email", digitaalAdres1);
	// digitaalAdresService.addAdresType("telefoonnummer", digitaalAdres2);
	// Persoonsrol persoonsrol1 = TestPersoonsrol.maakPersoonsrol1();
	// Persoonsrol persoonsrol2 = TestPersoonsrol.maakPersoonsrol2();
	// persoonsrolService.addRol("cursist", persoonsrol1);
	// persoonsrolService.addRol("kandidaat", persoonsrol2);
	//
	//
	// persoon1.addAdres(adres1);
	// persoon1.addDigitaalAdres(digitaalAdres1);
	// persoon1.addDigitaalAdres(digitaalAdres2);
	// persoon1.addPersoonsrol(persoonsrol1);
	// persoon1.addPersoonsrol(persoonsrol2);
	//
	// persoonService.save(persoon1);
	// adresService.save(adres1);
	// digitaalAdresService.save(digitaalAdres1);
	// digitaalAdresService.save(digitaalAdres2);
	//
	// persoonsrolService.save(persoonsrol1);
	// persoonsrolService.save(persoonsrol2);
	//
	// assertNotNull(persoonService.get(persoon1.getId()));
	// assertNotNull(adresService.get(adres1.getId()));
	// assertNotNull(digitaalAdresService.get(digitaalAdres1.getId()));
	// }

	@Before
	@Transactional
	public void setUp() {
		rollen = rolService.getAllTypes();
		bedrijfTypes = bedrijfTypeService.getAllTypes();
		bedrijfExpertises = expertiseService.getAllTypes();
		rollenSize = rollen.size();
		bedrijfTypesSize = bedrijfTypes.size();
		bedrijfExpertisesSize = bedrijfExpertises.size();
	}
	
	@Test
	@Transactional
	public void savePersonen() {
		for (int i = 0; i < 1000; i++) {
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

		int i = ((int) (Math.random() * 20));

		Adres adres = TestAdres.maakTestAdres3();

		if (i < 5) {
			Persoonsrol persoonsrol = TestPersoonsrol.maakPersoonsrol3();
			persoonsrol.setPersoon(persoon);
			persoonsrol.setRol(rollen.get(i));
			adresService.addAdresType("post", adres);
			persoon.addAdres(adres);
			adres.setPersoon(persoon);
			adresService.save(adres);
			persoonsrolService.save(persoonsrol);
		} else if (i >= 5 && i < 15) {
			adresService.addAdresType("post", adres);
			persoon.addAdres(adres);
			adres.setPersoon(persoon);
			adresService.save(adres);
		} else {
			Persoonsrol persoonsrol = TestPersoonsrol.maakPersoonsrol3();
			BedrijfExpertise bedrijfExpertise = new BedrijfExpertise();
			Bedrijf bedrijf = TestBedrijf.maakTestBedrijf3();
			
			
			
			Random r = new Random();
			char randomLetter = (char)(r.nextInt(26) + 'a');
			
			persoonsrol.setAfdeling("" + ((int) (Math.random() * 11)) + randomLetter);
			persoonsrol.setFunctie("functie " + ((int) (Math.random() * 11)) + randomLetter);
			persoonsrol.setPersoon(persoon);
			persoonsrol.setRol(rollen.get(5));
			adresService.addAdresType("bezoek", adres);
			
			bedrijf.setBedrijfType(bedrijfTypes.get(((int) (Math.random() * bedrijfTypesSize))));
			bedrijfExpertise.setExpertise(bedrijfExpertises.get(((int) (Math.random() * bedrijfExpertisesSize))));
		
			bedrijf.addBedrijfExpertise(bedrijfExpertise);
			bedrijf.addAdres(adres);
			adres.setBedrijf(bedrijf);
			persoonsrol.setBedrijf(bedrijf);
			bedrijfExpertise.setBedrijf(bedrijf);
			adresService.save(adres);
			bedrijfService.save(bedrijf);
			bedrijfExpertiseService.save(bedrijfExpertise);
			persoonsrolService.save(persoonsrol);
		}

	}
}
