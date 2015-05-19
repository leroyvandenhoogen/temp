package nl.rsvier.icaras.core.relatiebeheer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import nl.rsvier.icaras.core.TestAdres;
import nl.rsvier.icaras.core.TestBedrijf;
import nl.rsvier.icaras.core.TestDigitaalAdres;
import nl.rsvier.icaras.core.TestIdentiteitsbewijs;
import nl.rsvier.icaras.core.TestPersoonsrol;

import org.junit.Before;
import org.junit.Test;

public class BedrijfTest {

	private Bedrijf bedrijf1a;
	private Bedrijf bedrijf1b;
	private Bedrijf bedrijf1c;
	
	private Bedrijf bedrijf2a;
	private Bedrijf bedrijf2b;
	
	private Bedrijf bedrijfNull;
	
	@Before
	public void setUp() {
		bedrijf1a = TestBedrijf.maakTestBedrijf1();
		bedrijf1b = new Bedrijf();
		bedrijf1b.setNaam(bedrijf1a.getNaam());
		bedrijf1b.setOpmerking(bedrijf1a.getOpmerking());
		bedrijf1b.setKvkNummer(bedrijf1a.getKvkNummer());
		
		bedrijf1b.setAdressen(bedrijf1a.getAdressen());
		bedrijf1b.setDigitaleAdressen(bedrijf1a.getDigitaleAdressen());
		bedrijf1b.setPersoonsrollen(bedrijf1a.getPersoonsrollen());
		bedrijf1c = bedrijf1b;
		
		bedrijf2a = TestBedrijf.maakTestBedrijf2();
		bedrijf2b = new Bedrijf();
		bedrijf2b.setNaam(bedrijf2a.getNaam());
		bedrijf2b.setOpmerking(bedrijf2a.getOpmerking());
		bedrijf2b.setKvkNummer(bedrijf2a.getKvkNummer());

		bedrijf2b.setAdressen(bedrijf2a.getAdressen());
		bedrijf2b.setDigitaleAdressen(bedrijf2a.getDigitaleAdressen());
		bedrijf2b.setPersoonsrollen(bedrijf2a.getPersoonsrollen());
	}
	
	@Test
	public void testEquals() {
		assertNotNull(bedrijf1a);
		assertNotNull(bedrijf1b);
		assertNotNull(bedrijf2a);
		assertNotNull(bedrijf2b);
		
		//Reflexive: Object must be equal to itself
		assertTrue(bedrijf1a.equals(bedrijf1a));
		assertTrue(bedrijf1a.hashCode() == bedrijf1a.hashCode());
		assertTrue(bedrijf2a.equals(bedrijf2a));
		assertTrue(bedrijf2a.hashCode() == bedrijf2a.hashCode());
		
		//Symmetric: if a.equals(b) is true then b.equals(a) must be true
		assertTrue(bedrijf1a.equals(bedrijf1b));
		assertTrue(bedrijf1b.equals(bedrijf1a));
		assertTrue(bedrijf1a.hashCode() == bedrijf1b.hashCode());
		assertTrue(bedrijf2a.equals(bedrijf2b));
		assertTrue(bedrijf2b.equals(bedrijf2a));
		assertTrue(bedrijf2a.hashCode() == bedrijf2b.hashCode());
		
		assertFalse(bedrijf1a.equals(bedrijf2a));
		assertFalse(bedrijf2a.equals(bedrijf1a));
		assertFalse(bedrijf1a.hashCode() == bedrijf2a.hashCode());
		
		//Transitive: if a.equals(b) is true and b.equals(c) is true then c.equals(a) must be true
		assertTrue(bedrijf1b.equals(bedrijf1c));
		assertTrue(bedrijf1b.hashCode() == bedrijf1c.hashCode());
		assertTrue(bedrijf1c.equals(bedrijf1a));
		assertTrue(bedrijf1c.hashCode() == bedrijf1a.hashCode());
		
		//Null comparison: comparing any object to null must be false and not result in NullPointerException
		assertFalse(bedrijf1a.equals(null));
		assertFalse(bedrijf1a.equals(bedrijfNull));
	
		assertFalse(bedrijf2a.equals(null));
		assertFalse(bedrijf2a.equals(bedrijfNull));
		
		//Consistent: multiple invocation of equals() method must result same value until any of properties are modified
		assertTrue(bedrijf1a.equals(bedrijf1b));
		assertTrue(bedrijf1a.equals(bedrijf1b));
		assertTrue(bedrijf1a.equals(bedrijf1b));
		bedrijf1b.setNaam("Changed");
		assertFalse(bedrijf1a.equals(bedrijf1b));
		assertFalse(bedrijf1a.hashCode() == bedrijf2a.hashCode());
		
	}
	
	@Test
	public void testAddAdress() {
		Adres adres = TestAdres.maakTestAdres1();
		Adres adresNull = null;
		
		assertTrue(bedrijf1a.getAdressen().isEmpty());
		bedrijf1a.addAdres(adresNull);
		assertTrue(bedrijf1a.getAdressen().isEmpty());

		boolean toegevoegd = bedrijf1a.addAdres(adres);
		assertTrue(toegevoegd);
		assertFalse(bedrijf1a.getAdressen().isEmpty());
		assertTrue(bedrijf1a.getAdressen().contains(adres));
		
		Bedrijf testBedrijf = null;
		for (Iterator<Adres> it = bedrijf1a.getAdressen().iterator(); it.hasNext();) {
			Adres itAdres = it.next();
			if (itAdres.equals(adres)) {
				testBedrijf = itAdres.getBedrijf();
			}
		}
		assertTrue(bedrijf1a.equals(testBedrijf));
	}
	
	@Test
	public void testAddDigitaalAdres() {
		DigitaalAdres digitaalAdres = TestDigitaalAdres.maakDigitaalAdres1();
		DigitaalAdres digitaalAdresNull = null;
		
		assertTrue(bedrijf1a.getDigitaleAdressen().isEmpty());
		bedrijf1a.addDigitaalAdres(digitaalAdresNull);
		assertTrue(bedrijf1a.getDigitaleAdressen().isEmpty());
		
		boolean toegevoegd = bedrijf1a.addDigitaalAdres(digitaalAdres);
		assertTrue(toegevoegd);
		assertFalse(bedrijf1a.getDigitaleAdressen().isEmpty());
		assertTrue(bedrijf1a.getDigitaleAdressen().contains(digitaalAdres));
		
		Bedrijf testBedrijf = null;
		for (Iterator<DigitaalAdres> it = bedrijf1a.getDigitaleAdressen().iterator(); it.hasNext();) {
			DigitaalAdres itDigitaalAdres = it.next();
			if (itDigitaalAdres.equals(digitaalAdres)) {
				testBedrijf = itDigitaalAdres.getBedrijf();
			}
		}
		assertTrue(bedrijf1a.equals(testBedrijf));
	}
	
	@Test
	public void testAddPersoonsrol() {
		Persoonsrol persoonsrol = TestPersoonsrol.maakPersoonsrol1();
		Persoonsrol persoonrolNull = null;
		
		assertTrue(bedrijf1a.getPersoonsrollen().isEmpty());
		bedrijf1a.addPersoonsrol(persoonrolNull);
		assertTrue(bedrijf1a.getPersoonsrollen().isEmpty());
		
		boolean toegevoegd = bedrijf1a.addPersoonsrol(persoonsrol);
		assertTrue(toegevoegd);
		assertFalse(bedrijf1a.getPersoonsrollen().isEmpty());
		assertTrue(bedrijf1a.getPersoonsrollen().contains(persoonsrol));
		
		Bedrijf testBedrijf = null;
		for (Iterator<Persoonsrol> it = bedrijf1a.getPersoonsrollen().iterator(); it.hasNext();) {
			Persoonsrol itPersoonsrol = it.next();
			if (itPersoonsrol.equals(persoonsrol)) {
				testBedrijf = itPersoonsrol.getBedrijf();
			}
		}
		assertTrue(bedrijf1a.equals(testBedrijf));
	}
}
