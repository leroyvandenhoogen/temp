package nl.rsvier.icaras.core.relatiebeheer;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import nl.rsvier.icaras.core.TestAdres;
import nl.rsvier.icaras.core.TestDigitaalAdres;
import nl.rsvier.icaras.core.TestIdentiteitsbewijs;
import nl.rsvier.icaras.core.TestPersoon;
import nl.rsvier.icaras.core.TestPersoonsrol;

public class PersoonTest {

	private Persoon persoon1a;
	private Persoon persoon1b;
	private Persoon persoon1c;
	
	private Persoon persoon2a;
	private Persoon persoon2b;
	
	private Persoon persoonNull;
	
	@Before
	public void setUp() {
		persoon1a = TestPersoon.maakTestPersoon1();
		persoon1b = new Persoon();
		persoon1b.setVoornaam(persoon1a.getVoornaam());
		persoon1b.setAchternaam(persoon1a.getAchternaam());
		persoon1b.setTussenvoegsel(persoon1a.getTussenvoegsel());
		persoon1b.setGeboortedatum(persoon1a.getGeboortedatum());
		persoon1b.setGeboorteplaats(persoon1a.getGeboorteplaats());
		persoon1b.setGeslacht(persoon1a.getGeslacht());
		persoon1b.setRijbewijs(persoon1a.getRijbewijs());
		persoon1b.setNationaliteit(persoon1a.getNationaliteit());
		persoon1b.setOpmerking(persoon1a.getOpmerking());
		
		persoon1b.setIdentiteitsbewijzen(persoon1a.getIdentiteitsbewijzen());
		persoon1b.setAdressen(persoon1a.getAdressen());
		persoon1b.setDigitaleAdressen(persoon1a.getDigitaleAdressen());
		persoon1b.setPersoonsrollen(persoon1a.getPersoonsrollen());
		persoon1c = persoon1b;
		
		persoon2a = TestPersoon.maakTestPersoon2();
		persoon2b = new Persoon();
		persoon2b.setVoornaam(persoon2a.getVoornaam());
		persoon2b.setAchternaam(persoon2a.getAchternaam());
		persoon2b.setTussenvoegsel(persoon2a.getTussenvoegsel());
		persoon2b.setGeboortedatum(persoon2a.getGeboortedatum());
		persoon2b.setGeboorteplaats(persoon2a.getGeboorteplaats());
		persoon2b.setGeslacht(persoon2a.getGeslacht());
		persoon2b.setRijbewijs(persoon2a.getRijbewijs());
		persoon2b.setNationaliteit(persoon2a.getNationaliteit());
		persoon2b.setOpmerking(persoon2a.getOpmerking());
		
		persoon2b.setIdentiteitsbewijzen(persoon2a.getIdentiteitsbewijzen());
		persoon2b.setAdressen(persoon2a.getAdressen());
		persoon2b.setDigitaleAdressen(persoon2a.getDigitaleAdressen());
		persoon2b.setPersoonsrollen(persoon2a.getPersoonsrollen());
	}
	
	@Test
	public void testEquals() {
		assertNotNull(persoon1a);
		assertNotNull(persoon1b);
		assertNotNull(persoon2a);
		assertNotNull(persoon2b);
		
		//Reflexive: Object must be equal to itself
		assertTrue(persoon1a.equals(persoon1a));
		assertTrue(persoon1a.hashCode() == persoon1a.hashCode());
		assertTrue(persoon2a.equals(persoon2a));
		assertTrue(persoon2a.hashCode() == persoon2a.hashCode());
		
		//Symmetric: if a.equals(b) is true then b.equals(a) must be true
		assertTrue(persoon1a.equals(persoon1b));
		assertTrue(persoon1b.equals(persoon1a));
		assertTrue(persoon1a.hashCode() == persoon1b.hashCode());
		assertTrue(persoon2a.equals(persoon2b));
		assertTrue(persoon2b.equals(persoon2a));
		assertTrue(persoon2a.hashCode() == persoon2b.hashCode());
		
		assertFalse(persoon1a.equals(persoon2a));
		assertFalse(persoon2a.equals(persoon1a));
		assertFalse(persoon1a.hashCode() == persoon2a.hashCode());
		
		//Transitive: if a.equals(b) is true and b.equals(c) is true then c.equals(a) must be true
		assertTrue(persoon1b.equals(persoon1c));
		assertTrue(persoon1b.hashCode() == persoon1c.hashCode());
		assertTrue(persoon1c.equals(persoon1a));
		assertTrue(persoon1c.hashCode() == persoon1a.hashCode());
		
		//Null comparison: comparing any object to null must be false and not result in NullPointerException
		assertFalse(persoon1a.equals(null));
		assertFalse(persoon1a.equals(persoonNull));
	
		assertFalse(persoon2a.equals(null));
		assertFalse(persoon2a.equals(persoonNull));
		
		//Consistent: multiple invocation of equals() method must result same value until any of properties are modified
		assertTrue(persoon1a.equals(persoon1b));
		assertTrue(persoon1a.equals(persoon1b));
		assertTrue(persoon1a.equals(persoon1b));
		persoon1b.setAchternaam("Changed");
		assertFalse(persoon1a.equals(persoon1b));
		assertFalse(persoon1a.hashCode() == persoon2a.hashCode());
		
	}
	
	@Test
	public void testAddIdentiteitsbewijs() {
		Identiteitsbewijs id = TestIdentiteitsbewijs.maakIdentiteitsbewijs1();
		Identiteitsbewijs idNull = null;
		
		assertTrue(persoon1a.getIdentiteitsbewijzen().isEmpty());
		persoon1a.addIdentiteitsbewijs(idNull);
		assertTrue(persoon1a.getIdentiteitsbewijzen().isEmpty());
		
		boolean toegevoegd = persoon1a.addIdentiteitsbewijs(id);
		assertTrue(toegevoegd);
		assertFalse(persoon1a.getIdentiteitsbewijzen().isEmpty());
		assertTrue(persoon1a.getIdentiteitsbewijzen().contains(id));
		
		Persoon testPersoon = null;
		for (Iterator<Identiteitsbewijs> it = persoon1a.getIdentiteitsbewijzen().iterator(); it.hasNext();) {
			Identiteitsbewijs itId = it.next();
			if (itId.equals(id)) {
				testPersoon = itId.getPersoon();
			}
		}
		assertTrue(persoon1a.equals(testPersoon));
	}
	
	@Test
	public void testAddAdress() {
		Adres adres = TestAdres.maakTestAdres1();
		Adres adresNull = null;
		
		assertTrue(persoon1a.getAdressen().isEmpty());
		persoon1a.addAdres(adresNull);
		assertTrue(persoon1a.getAdressen().isEmpty());

		boolean toegevoegd = persoon1a.addAdres(adres);
		assertTrue(toegevoegd);
		assertFalse(persoon1a.getAdressen().isEmpty());
		assertTrue(persoon1a.getAdressen().contains(adres));
		
		Persoon testPersoon = null;
		for (Iterator<Adres> it = persoon1a.getAdressen().iterator(); it.hasNext();) {
			Adres itAdres = it.next();
			if (itAdres.equals(adres)) {
				testPersoon = itAdres.getPersoon();
			}
		}
		assertTrue(persoon1a.equals(testPersoon));
	}
	
	@Test
	public void testAddDigitaalAdres() {
		DigitaalAdres digitaalAdres = TestDigitaalAdres.maakDigitaalAdres1();
		DigitaalAdres digitaalAdresNull = null;
		
		assertTrue(persoon1a.getDigitaleAdressen().isEmpty());
		persoon1a.addDigitaalAdres(digitaalAdresNull);
		assertTrue(persoon1a.getDigitaleAdressen().isEmpty());
		
		boolean toegevoegd = persoon1a.addDigitaalAdres(digitaalAdres);
		assertTrue(toegevoegd);
		assertFalse(persoon1a.getDigitaleAdressen().isEmpty());
		assertTrue(persoon1a.getDigitaleAdressen().contains(digitaalAdres));
		
		Persoon testPersoon = null;
		for (Iterator<DigitaalAdres> it = persoon1a.getDigitaleAdressen().iterator(); it.hasNext();) {
			DigitaalAdres itDigitaalAdres = it.next();
			if (itDigitaalAdres.equals(digitaalAdres)) {
				testPersoon = itDigitaalAdres.getPersoon();
			}
		}
		assertTrue(persoon1a.equals(testPersoon));
	}
	
	@Test
	public void testAddPersoonsrol() {
		Persoonsrol persoonsrol = TestPersoonsrol.maakPersoonsrol1();
		Persoonsrol persoonrolNull = null;
		
		assertTrue(persoon1a.getPersoonsrollen().isEmpty());
		persoon1a.addPersoonsrol(persoonrolNull);
		assertTrue(persoon1a.getPersoonsrollen().isEmpty());
		
		boolean toegevoegd = persoon1a.addPersoonsrol(persoonsrol);
		assertTrue(toegevoegd);
		assertFalse(persoon1a.getPersoonsrollen().isEmpty());
		assertTrue(persoon1a.getPersoonsrollen().contains(persoonsrol));
		
		Persoon testPersoon = null;
		for (Iterator<Persoonsrol> it = persoon1a.getPersoonsrollen().iterator(); it.hasNext();) {
			Persoonsrol itPersoonsrol = it.next();
			if (itPersoonsrol.equals(persoonsrol)) {
				testPersoon = itPersoonsrol.getPersoon();
			}
		}
		assertTrue(persoon1a.equals(testPersoon));
	}
}
