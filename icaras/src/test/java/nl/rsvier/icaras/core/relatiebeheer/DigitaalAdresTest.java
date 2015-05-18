package nl.rsvier.icaras.core.relatiebeheer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import nl.rsvier.icaras.core.TestDigitaalAdres;

import org.junit.Before;
import org.junit.Test;

public class DigitaalAdresTest {

	private DigitaalAdres digitaalAdres1a;
	private DigitaalAdres digitaalAdres1b;
	private DigitaalAdres digitaalAdres1c;
	
	private DigitaalAdres digitaalAdres2a;
	private DigitaalAdres digitaalAdres2b;
	
	private DigitaalAdres digitaalAdressNull;
	
	@Before
	public void setUp() {
		digitaalAdres1a = TestDigitaalAdres.maakDigitaalAdres1();
		digitaalAdres1b = new DigitaalAdres();
		digitaalAdres1b.setDigitaalAdresType(digitaalAdres1a.getDigitaalAdresType());
		digitaalAdres1b.setBedrijf(digitaalAdres1a.getBedrijf());
		digitaalAdres1b.setPersoon(digitaalAdres1a.getPersoon());
		digitaalAdres1b.setOmschrijving(digitaalAdres1a.getOmschrijving());
		digitaalAdres1b.setContactvoorkeur(digitaalAdres1a.isContactvoorkeur());
		digitaalAdres1c = digitaalAdres1b;
		
		digitaalAdres2a = TestDigitaalAdres.maakDigitaalAdres2();
		digitaalAdres2b = new DigitaalAdres();
		digitaalAdres2b.setDigitaalAdresType(digitaalAdres2a.getDigitaalAdresType());
		digitaalAdres2b.setBedrijf(digitaalAdres2a.getBedrijf());
		digitaalAdres2b.setPersoon(digitaalAdres2a.getPersoon());
		digitaalAdres2b.setOmschrijving(digitaalAdres2a.getOmschrijving());
		digitaalAdres2b.setContactvoorkeur(digitaalAdres2a.isContactvoorkeur());
	}
	
	@Test
	public void testEquals() {
		assertNotNull(digitaalAdres1a);
		assertNotNull(digitaalAdres1b);
		assertNotNull(digitaalAdres2a);
		assertNotNull(digitaalAdres2b);
		
		//Reflexive: Object must be equal to itself
		assertTrue(digitaalAdres1a.equals(digitaalAdres1a));
		assertTrue(digitaalAdres1a.hashCode() == digitaalAdres1a.hashCode());
		assertTrue(digitaalAdres2a.equals(digitaalAdres2a));
		assertTrue(digitaalAdres2a.hashCode() == digitaalAdres2a.hashCode());
		
		//Symmetric: if a.equals(b) is true then b.equals(a) must be true
		assertTrue(digitaalAdres1a.equals(digitaalAdres1b));
		assertTrue(digitaalAdres1b.equals(digitaalAdres1a));
		assertTrue(digitaalAdres1a.hashCode() == digitaalAdres1b.hashCode());
		assertTrue(digitaalAdres2a.equals(digitaalAdres2b));
		assertTrue(digitaalAdres2b.equals(digitaalAdres2a));
		assertTrue(digitaalAdres2a.hashCode() == digitaalAdres2b.hashCode());
		
		assertFalse(digitaalAdres1a.equals(digitaalAdres2a));
		assertFalse(digitaalAdres2a.equals(digitaalAdres1a));
		assertFalse(digitaalAdres1a.hashCode() == digitaalAdres2a.hashCode());
		
		//Transitive: if a.equals(b) is true and b.equals(c) is true then c.equals(a) must be true
		assertTrue(digitaalAdres1b.equals(digitaalAdres1c));
		assertTrue(digitaalAdres1b.hashCode() == digitaalAdres1c.hashCode());
		assertTrue(digitaalAdres1c.equals(digitaalAdres1a));
		assertTrue(digitaalAdres1c.hashCode() == digitaalAdres1a.hashCode());
		
		//Null comparison: comparing any object to null must be false and not result in NullPointerException
		assertFalse(digitaalAdres1a.equals(null));
		assertFalse(digitaalAdres1a.equals(digitaalAdressNull));
	
		assertFalse(digitaalAdres2a.equals(null));
		assertFalse(digitaalAdres2a.equals(digitaalAdressNull));
		
		//Consistent: multiple invocation of equals() method must result same value until any of properties are modified
		assertTrue(digitaalAdres1a.equals(digitaalAdres1b));
		assertTrue(digitaalAdres1a.equals(digitaalAdres1b));
		assertTrue(digitaalAdres1a.equals(digitaalAdres1b));
		digitaalAdres1b.setContactvoorkeur(!(digitaalAdres1b.isContactvoorkeur()));
		assertFalse(digitaalAdres1a.equals(digitaalAdres1b));
		assertFalse(digitaalAdres1a.hashCode() == digitaalAdres2a.hashCode());
		
	}
}
