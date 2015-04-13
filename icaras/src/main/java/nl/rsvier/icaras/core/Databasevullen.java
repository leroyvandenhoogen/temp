package nl.rsvier.icaras.core;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import nl.rsvier.icaras.core.arbeidsmarkt.Aanbieding;
import nl.rsvier.icaras.core.relatiebeheer.Adres;
import nl.rsvier.icaras.core.relatiebeheer.Bedrijf;
import nl.rsvier.icaras.core.relatiebeheer.Contactpersoon;
import nl.rsvier.icaras.core.relatiebeheer.Email;
import nl.rsvier.icaras.core.relatiebeheer.Facebook;
import nl.rsvier.icaras.core.relatiebeheer.Fax;
import nl.rsvier.icaras.core.relatiebeheer.Kandidaat;
import nl.rsvier.icaras.core.relatiebeheer.LinkedIn;
import nl.rsvier.icaras.core.relatiebeheer.Nfa;
import nl.rsvier.icaras.core.relatiebeheer.Organisatie;
import nl.rsvier.icaras.core.relatiebeheer.Persoon;
import nl.rsvier.icaras.core.relatiebeheer.TelefoonNummer;
import nl.rsvier.icaras.core.relatiebeheer.Twitter;
import nl.rsvier.icaras.core.relatiebeheer.Website;
import nl.rsvier.icaras.core.relatiebeheer.Werknemer;
import nl.rsvier.icaras.service.relatiebeheer.IOrganisatieService;
import nl.rsvier.icaras.service.relatiebeheer.IPersoonService;
import nl.rsvier.icaras.service.relatiebeheer.OrganisatieService;
import nl.rsvier.icaras.service.relatiebeheer.PersoonService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:icarastestdb-context.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class Databasevullen {

		@Autowired
		private IPersoonService persoonService = new PersoonService();
		
		@Autowired
		private IOrganisatieService organisatieService = new OrganisatieService();
		
		@Test
		@Transactional
		public void vulDatabase() throws InvalidBusinessKeyException {
		Adres aBurrow1 = new Adres(true, false, "2022PG", "1",
				"Ottery St. Catchpole", "on the outskirts of Devon");
		Adres aBurrow2 = new Adres(true, false, "2022PG", "1",
				"Ottery St. Catchpole", "on the outskirts of Devon");
		Adres aBurrow3 = new Adres(true, false, "2022PG", "1",
				"Ottery St. Catchpole", "on the outskirts of Devon");

		Adres aHogwarts = new Adres(true, true, "4501MG", "1402", "Edinburgh",
				"");
		Adres aPartyshop = new Adres(false, false, "0199TT", "93", "London",
				"Diagon Alley");

		Persoon harry = new Persoon("Harry", "Potter");
		harry.addAdres(new Adres(true, false, "1340DF", "4", "Little Whinging", "Privet Drive"));
		harry.addRol(new Kandidaat());
		harry.addRol(new Werknemer());

		// //////////////////////

		Nfa harry_twitter = new Twitter();
		harry_twitter.setNfaAdres("@harry");
		harry.addNfa(harry_twitter);

		Nfa harry_website = new Website();
		harry_website.setNfaAdres("http://www.pottermore.com");
		harry.addNfa(harry_website);

		Nfa harry_telefoon = new TelefoonNummer();
		harry_telefoon.setNfaAdres("+31634504345");
		harry.addNfa(harry_telefoon);

		// //////////////////////

		Persoon ron = new Persoon("Ron", "Weasley");
		ron.addAdres(aBurrow1);
		ron.addRol(new Kandidaat());

		Persoon hermione = new Persoon("Hermione", "Granger");

		Organisatie hogwarts = new Organisatie(
				"Hogwarts School of Witchcraft and Wizardry");
		hogwarts.addAdres(aHogwarts);
		hogwarts.addRol(new Bedrijf());
		Organisatie gringotts = new Organisatie("Gringotts Wizarding Bank");
		gringotts.addRol(new Bedrijf());
		Organisatie leakycauldron = new Organisatie("The Leaky Cauldron");
		Organisatie ollivanders = new Organisatie("Ollivanders");
		Organisatie wizardwheezes = new Organisatie("Weasleys' Wizard Wheezes");
		wizardwheezes.addAdres(aPartyshop);
		wizardwheezes.addRol(new Bedrijf());

		Persoon hagrid = new Persoon("Rubeus", "Hagrid");

		Persoon twins_george = new Persoon("George", "Weasley");
		twins_george.addAdres(aBurrow2);

		Persoon twins_fred = new Persoon("Fred", "Weasley");
		twins_fred.addAdres(aBurrow3);

		persoonService.save(harry);
		persoonService.save(twins_fred);
		organisatieService.save(wizardwheezes);
		organisatieService.save(hogwarts);
		persoonService.save(ron);
		organisatieService.save(ollivanders);
		organisatieService.save(gringotts);
		persoonService.save(twins_george);
		organisatieService.save(leakycauldron);
		persoonService.save(hagrid);
		persoonService.save(hermione);

		Persoon profdumbledore = new Persoon("Albert", "Dumbledore");
		persoonService.save(profdumbledore);

		new Aanbieding(harry, hogwarts);
		persoonService.update(harry);
		organisatieService.update(hogwarts);

		new Aanbieding(harry, wizardwheezes);
		persoonService.update(harry);
		organisatieService.update(wizardwheezes);
		
		Persoon leroy = new Persoon("Leroy", "van den", "Hoogen", new GregorianCalendar(1988, GregorianCalendar.JANUARY, 21));
		leroy.addAdres(new Adres(true, false, "1333SN", "7", "Almere", "Singravenstraat"));
		leroy.addRol(new Kandidaat());
		leroy.addRol(new Werknemer());
		leroy.addRol(new Contactpersoon());
		Nfa leroy_telefoon = new TelefoonNummer();
		leroy_telefoon.setNfaAdres("+31612312312");
		leroy.addNfa(leroy_telefoon);
		
		Nfa leroy_email = new Email();
		leroy_email.setNfaAdres("leroy@mail.com");
		leroy.addNfa(leroy_email);
		
		Nfa leroy_facebook = new Facebook();
		leroy_facebook.setNfaAdres("leroyfb");
		leroy.addNfa(leroy_facebook);
		
		Nfa leroy_linkedin = new LinkedIn();
		leroy_linkedin.setNfaAdres("leroylinkedin");
		leroy.addNfa(leroy_linkedin);
		
		Nfa leroy_website = new Website();
		leroy_website.setNfaAdres("www.icaras.nl");
		leroy.addNfa(leroy_website);
		
		Nfa leroy_twitter = new Twitter();
		leroy_twitter.setNfaAdres("@leroytwitter");
		leroy.addNfa(leroy_twitter);
		
		Nfa leroy_fax = new Fax();
		leroy_fax.setNfaAdres("leroyfax");
		leroy.addNfa(leroy_fax);
		
		leroy.setOpmerking("Icaras-dev");
	
		persoonService.save(leroy);
		
		List<Persoon> persoonlijst = new ArrayList<Persoon>();
		persoonlijst.add(harry);
		persoonlijst.add(twins_fred);
		persoonlijst.add(ron);
		persoonlijst.add(twins_george);
		persoonlijst.add(hagrid);
		persoonlijst.add(hermione);
		persoonlijst.add(profdumbledore);
		persoonlijst.add(leroy);
		
		assertTrue(persoonService.getById(1).equals(harry));
		assertNotNull(persoonlijst);
		assertNotNull(persoonlijst.get(0));
		assertNotNull(persoonService.getAllCompleet());
		assertNotNull(persoonService.getById(1));
		assertTrue(persoonService.getAllCompleet().equals(persoonlijst));
		
		List<Persoon> serviceLijst = persoonService.getAllCompleet();
		
//		for(Persoon p:serviceLijst){
//			System.out.println("##### " + p.getVolledigeNaam() + " #####");
//		}
	}
	
}
