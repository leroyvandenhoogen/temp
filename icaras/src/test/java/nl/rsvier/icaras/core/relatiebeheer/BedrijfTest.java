package nl.rsvier.icaras.core.relatiebeheer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import nl.rsvier.icaras.core.TestBedrijf;

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
		
		bedrijf1b.setAdressen(bedrijf1a.getAdressen());
		bedrijf1b.setDigitaleAdressen(bedrijf1a.getDigitaleAdressen());
		bedrijf1b.setPersoonsrollen(bedrijf1a.getPersoonsrollen());
		bedrijf1c = bedrijf1b;
		
		bedrijf2a = TestBedrijf.maakTestBedrijf2();
		bedrijf2b = new Bedrijf();
		bedrijf2b.setNaam(bedrijf2a.getNaam());
		bedrijf2b.setOpmerking(bedrijf2a.getOpmerking());

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
}
