package nl.rsvier.icaras.core.relatiebeheer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import nl.rsvier.icaras.core.TestIdentiteitsbewijs;
import nl.rsvier.icaras.core.TestPersoon;
import nl.rsvier.icaras.core.TestPersoonsrol;

import org.junit.Before;
import org.junit.Test;

public class IdentiteitsbewijsTest {

	private Identiteitsbewijs identiteitsbewijs1a;
	private Identiteitsbewijs identiteitsbewijs1b;
	private Identiteitsbewijs identiteitsbewijs1c;
	
	private Identiteitsbewijs identiteitsbewijs2a;
	private Identiteitsbewijs identiteitsbewijs2b;
	
	private Identiteitsbewijs adresNull;
	
	@Before
	public void setUp() {
		identiteitsbewijs1a = TestIdentiteitsbewijs.maakIdentiteitsbewijs1();
		identiteitsbewijs1b = new Identiteitsbewijs();
		identiteitsbewijs1b.setNummer(identiteitsbewijs1a.getNummer());
		identiteitsbewijs1b.setVervaldatum(identiteitsbewijs1a.getVervaldatum());
		
		identiteitsbewijs1b.setPersoon(identiteitsbewijs1a.getPersoon());
		identiteitsbewijs1b.setIdentiteitsbewijsType(identiteitsbewijs1a.getIdentiteitsbewijsType());
		identiteitsbewijs1c = identiteitsbewijs1b;
		
		identiteitsbewijs2a = TestIdentiteitsbewijs.maakIdentiteitsbewijs2();
		identiteitsbewijs2b = new Identiteitsbewijs();
		identiteitsbewijs2b.setNummer(identiteitsbewijs2a.getNummer());
		identiteitsbewijs2b.setVervaldatum(identiteitsbewijs2a.getVervaldatum());
		
		identiteitsbewijs2b.setPersoon(identiteitsbewijs2a.getPersoon());
		identiteitsbewijs2b.setIdentiteitsbewijsType(identiteitsbewijs1a.getIdentiteitsbewijsType());

	}
	
	@Test
	public void testEquals() {
		assertNotNull(identiteitsbewijs1a);
		assertNotNull(identiteitsbewijs1b);
		assertNotNull(identiteitsbewijs2a);
		assertNotNull(identiteitsbewijs2b);
		
		//Reflexive: Object must be equal to itself
		assertTrue(identiteitsbewijs1a.equals(identiteitsbewijs1a));
		assertTrue(identiteitsbewijs1a.hashCode() == identiteitsbewijs1a.hashCode());
		assertTrue(identiteitsbewijs2a.equals(identiteitsbewijs2a));
		assertTrue(identiteitsbewijs2a.hashCode() == identiteitsbewijs2a.hashCode());
		
		//Symmetric: if a.equals(b) is true then b.equals(a) must be true
		assertTrue(identiteitsbewijs1a.equals(identiteitsbewijs1b));
		assertTrue(identiteitsbewijs1b.equals(identiteitsbewijs1a));
		assertTrue(identiteitsbewijs1a.hashCode() == identiteitsbewijs1b.hashCode());
		assertTrue(identiteitsbewijs2a.equals(identiteitsbewijs2b));
		assertTrue(identiteitsbewijs2b.equals(identiteitsbewijs2a));
		assertTrue(identiteitsbewijs2a.hashCode() == identiteitsbewijs2b.hashCode());
		
		assertFalse(identiteitsbewijs1a.equals(identiteitsbewijs2a));
		assertFalse(identiteitsbewijs2a.equals(identiteitsbewijs1a));
		assertFalse(identiteitsbewijs1a.hashCode() == identiteitsbewijs2a.hashCode());
		
		//Transitive: if a.equals(b) is true and b.equals(c) is true then c.equals(a) must be true
		assertTrue(identiteitsbewijs1b.equals(identiteitsbewijs1c));
		assertTrue(identiteitsbewijs1b.hashCode() == identiteitsbewijs1c.hashCode());
		assertTrue(identiteitsbewijs1c.equals(identiteitsbewijs1a));
		assertTrue(identiteitsbewijs1c.hashCode() == identiteitsbewijs1a.hashCode());
		
		//Null comparison: comparing any object to null must be false and not result in NullPointerException
		assertFalse(identiteitsbewijs1a.equals(null));
		assertFalse(identiteitsbewijs1a.equals(adresNull));
	
		assertFalse(identiteitsbewijs2a.equals(null));
		assertFalse(identiteitsbewijs2a.equals(adresNull));
		
		//Consistent: multiple invocation of equals() method must result same value until any of properties are modified
		assertTrue(identiteitsbewijs1a.equals(identiteitsbewijs1b));
		assertTrue(identiteitsbewijs1a.equals(identiteitsbewijs1b));
		assertTrue(identiteitsbewijs1a.equals(identiteitsbewijs1b));
		identiteitsbewijs1b.setNummer("Changed");
		assertFalse(identiteitsbewijs1a.equals(identiteitsbewijs1b));
		assertFalse(identiteitsbewijs1a.hashCode() == identiteitsbewijs2a.hashCode());
		
	}
	
	@Test
	public void testSetPersoon() {
		Persoon persoon = TestPersoon.maakTestPersoon1();
		Persoon persoonNull = null;
		
		assertTrue(identiteitsbewijs1a.getPersoon() == null);
		identiteitsbewijs1a.setPersoon(persoonNull);
		assertTrue(identiteitsbewijs1a.getPersoon() == null);
		
		boolean toegevoegd = identiteitsbewijs1a.setPersoon(persoon);
		assertTrue(toegevoegd);
		assertFalse(identiteitsbewijs1a.getPersoon() == null);
		assertTrue(persoon.getIdentiteitsbewijzen().contains(identiteitsbewijs1a));
		
		Persoon testPersoon = null;
		for (Iterator<Identiteitsbewijs> it = persoon.getIdentiteitsbewijzen().iterator(); it.hasNext();) {
			Identiteitsbewijs itId = it.next();
			if (itId.equals(identiteitsbewijs1a)) {
				testPersoon = itId.getPersoon();
			}
		}
		assertTrue(persoon.equals(testPersoon));
		
		//Een verwijzing naar persoon heeft kan je die niet overschrijden
		Persoon persoon2 = TestPersoon.maakTestPersoon2();
		boolean toegevoegd2 = identiteitsbewijs1a.setPersoon(persoon2);
		assertFalse(toegevoegd2);
	}
}

