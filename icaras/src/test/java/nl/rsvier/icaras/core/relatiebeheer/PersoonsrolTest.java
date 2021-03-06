package nl.rsvier.icaras.core.relatiebeheer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.GregorianCalendar;

import nl.rsvier.icaras.core.TestPersoonsrol;

import org.junit.Before;
import org.junit.Test;

public class PersoonsrolTest {

	private Persoonsrol persoonsrol1a;
	private Persoonsrol persoonsrol1b;
	private Persoonsrol persoonsrol1c;
	
	private Persoonsrol persoonsrol2a;
	private Persoonsrol persoonsrol2b;
	
	private Persoonsrol persoonsrolNull;
	
	@Before
	public void setUp() {
		persoonsrol1a = TestPersoonsrol.maakPersoonsrol1();
		persoonsrol1b = new Persoonsrol();
		persoonsrol1b.setBedrijf(persoonsrol1a.getBedrijf());
		persoonsrol1b.setEinddatum(persoonsrol1a.getEinddatum());
		persoonsrol1b.setPersoon(persoonsrol1a.getPersoon());
		persoonsrol1b.setRol(persoonsrol1a.getRol());
		persoonsrol1b.setId(persoonsrol1a.getId());
		persoonsrol1c = persoonsrol1b;
		
		persoonsrol2a = TestPersoonsrol.maakPersoonsrol2();
		persoonsrol2b = new Persoonsrol();
		persoonsrol2b.setBedrijf(persoonsrol2a.getBedrijf());
		persoonsrol2b.setEinddatum(persoonsrol2a.getEinddatum());
		persoonsrol2b.setPersoon(persoonsrol2a.getPersoon());
		persoonsrol2b.setRol(persoonsrol2a.getRol());
		persoonsrol2b.setId(persoonsrol2a.getId());

	}
	
	@Test
	public void testEquals() {
		assertNotNull(persoonsrol1a);
		assertNotNull(persoonsrol1b);
		assertNotNull(persoonsrol2a);
		assertNotNull(persoonsrol2b);
		
		//Reflexive: Object must be equal to itself
		assertTrue(persoonsrol1a.equals(persoonsrol1a));
		assertTrue(persoonsrol1a.hashCode() == persoonsrol1a.hashCode());
		assertTrue(persoonsrol2a.equals(persoonsrol2a));
		assertTrue(persoonsrol2a.hashCode() == persoonsrol2a.hashCode());
		
		//Symmetric: if a.equals(b) is true then b.equals(a) must be true
		assertTrue(persoonsrol1a.equals(persoonsrol1b));
		assertTrue(persoonsrol1b.equals(persoonsrol1a));
		assertTrue(persoonsrol1a.hashCode() == persoonsrol1b.hashCode());
		assertTrue(persoonsrol2a.equals(persoonsrol2b));
		assertTrue(persoonsrol2b.equals(persoonsrol2a));
		assertTrue(persoonsrol2a.hashCode() == persoonsrol2b.hashCode());
		
		assertFalse(persoonsrol1a.equals(persoonsrol2a));
		assertFalse(persoonsrol2a.equals(persoonsrol1a));
		assertFalse(persoonsrol1a.hashCode() == persoonsrol2a.hashCode());
		
		//Transitive: if a.equals(b) is true and b.equals(c) is true then c.equals(a) must be true
		assertTrue(persoonsrol1b.equals(persoonsrol1c));
		assertTrue(persoonsrol1b.hashCode() == persoonsrol1c.hashCode());
		assertTrue(persoonsrol1c.equals(persoonsrol1a));
		assertTrue(persoonsrol1c.hashCode() == persoonsrol1a.hashCode());
		
		//Null comparison: comparing any object to null must be false and not result in NullPointerException
		assertFalse(persoonsrol1a.equals(null));
		assertFalse(persoonsrol1a.equals(persoonsrolNull));
	
		assertFalse(persoonsrol2a.equals(null));
		assertFalse(persoonsrol2a.equals(persoonsrolNull));
		
		//Consistent: multiple invocation of equals() method must result same value until any of properties are modified
		assertTrue(persoonsrol1a.equals(persoonsrol1b));
		assertTrue(persoonsrol1a.equals(persoonsrol1b));
		assertTrue(persoonsrol1a.equals(persoonsrol1b));
		persoonsrol1b.setEinddatum(new GregorianCalendar(2020, 1, 1).getTime());
		assertFalse(persoonsrol1a.equals(persoonsrol1b));
		assertFalse(persoonsrol1a.hashCode() == persoonsrol2a.hashCode());
		
	}
}