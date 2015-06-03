package nl.rsvier.icaras.core.relatiebeheer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import nl.rsvier.icaras.core.TestAdres;
import nl.rsvier.icaras.core.TestBedrijf;
import nl.rsvier.icaras.core.TestPersoon;

import org.junit.Before;
import org.junit.Test;

public class AdresTest {

	private Adres adres1a;
	private Adres adres1b;
	private Adres adres1c;
	
	private Adres adres2a;
	private Adres adres2b;
	
	private Adres adresNull;
	
	@Before
	public void setUp() {
		adres1a = TestAdres.maakTestAdres1();
		adres1b = new Adres();
		adres1b.setStraat(adres1a.getStraat());
		adres1b.setNummer(adres1a.getNummer());
		adres1b.setPostcode(adres1a.getPostcode());
		adres1b.setPlaats(adres1a.getPlaats());
		adres1b.setLand(adres1a.getLand());
		adres1b.setBegindatum(adres1a.getBegindatum());
		adres1b.setEinddatum(adres1a.getEinddatum());
		adres1b.setToevoegsel(adres1a.getToevoegsel());
		
		adres1b.setAdresType(adres1a.getAdresType());
		adres1b.setBedrijf(adres1a.getBedrijf());
		adres1b.setPersoon(adres1a.getPersoon());
		adres1c = adres1b;
		
		adres2a = TestAdres.maakTestAdres2();
		adres2b = new Adres();
		adres2b.setStraat(adres2a.getStraat());
		adres2b.setNummer(adres2a.getNummer());
		adres2b.setPostcode(adres2a.getPostcode());
		adres2b.setPlaats(adres2a.getPlaats());
		adres2b.setLand(adres2a.getLand());
		adres2b.setBegindatum(adres2a.getBegindatum());
		adres2b.setEinddatum(adres2a.getEinddatum());
		adres2b.setToevoegsel(adres2a.getToevoegsel());
		
		adres2b.setAdresType(adres2a.getAdresType());
		adres2b.setBedrijf(adres2a.getBedrijf());
		adres2b.setPersoon(adres2a.getPersoon());
		
		adres2b.setBegindatum(adres2a.getBegindatum());

	}
	
	@Test
	public void testEquals() {
		assertNotNull(adres1a);
		assertNotNull(adres1b);
		assertNotNull(adres2a);
		assertNotNull(adres2b);
		
		//Reflexive: Object must be equal to itself
		assertTrue(adres1a.equals(adres1a));
		assertTrue(adres1a.hashCode() == adres1a.hashCode());
		assertTrue(adres2a.equals(adres2a));
		assertTrue(adres2a.hashCode() == adres2a.hashCode());
		
		//Symmetric: if a.equals(b) is true then b.equals(a) must be true
		assertTrue(adres1a.equals(adres1b));
		assertTrue(adres1b.equals(adres1a));
		assertTrue(adres1a.hashCode() == adres1b.hashCode());
		assertTrue(adres2a.equals(adres2b));
		assertTrue(adres2b.equals(adres2a));
		assertTrue(adres2a.hashCode() == adres2b.hashCode());
		
		assertFalse(adres1a.equals(adres2a));
		assertFalse(adres2a.equals(adres1a));
		assertFalse(adres1a.hashCode() == adres2a.hashCode());
		
		//Transitive: if a.equals(b) is true and b.equals(c) is true then c.equals(a) must be true
		assertTrue(adres1b.equals(adres1c));
		assertTrue(adres1b.hashCode() == adres1c.hashCode());
		assertTrue(adres1c.equals(adres1a));
		assertTrue(adres1c.hashCode() == adres1a.hashCode());
		
		//Null comparison: comparing any object to null must be false and not result in NullPointerException
		assertFalse(adres1a.equals(null));
		assertFalse(adres1a.equals(adresNull));
	
		assertFalse(adres2a.equals(null));
		assertFalse(adres2a.equals(adresNull));
		
		//Consistent: multiple invocation of equals() method must result same value until any of properties are modified
		assertTrue(adres1a.equals(adres1b));
		assertTrue(adres1a.equals(adres1b));
		assertTrue(adres1a.equals(adres1b));
		adres1b.setStraat("Changed");
		assertFalse(adres1a.equals(adres1b));
		assertFalse(adres1a.hashCode() == adres2a.hashCode());
		
	}
	
	@Test
	public void testSetPersoon() {
		Persoon persoon = TestPersoon.maakTestPersoon1();
		Persoon persoonNull = null;
		
		assertTrue(adres1a.getPersoon() == null);
		adres1a.setPersoon(persoonNull);
		assertTrue(adres1a.getPersoon() == null);
		
		boolean toegevoegd = adres1a.setPersoon(persoon);
		assertTrue(toegevoegd);
		assertFalse(adres1a.getPersoon() == null);
//		assertTrue(persoon.getAdressen().contains(adres1a));
		
		Persoon testPersoon = null;
		for (Iterator<Adres> it = persoon.getAdressen().iterator(); it.hasNext();) {
			Adres itAdres = it.next();
			if (itAdres.equals(adres1a)) {
				testPersoon = itAdres.getPersoon();
			}
		}
//		assertTrue(persoon.equals(testPersoon));
		
		//Een verwijzing naar persoon heeft kan je die niet overschrijden
		Persoon persoon2 = TestPersoon.maakTestPersoon2();
		boolean toegevoegd2 = adres1a.setPersoon(persoon2);
		assertFalse(toegevoegd2);
	}
	@Test
	public void testSetBedrijf() {
		Bedrijf bedrijf = TestBedrijf.maakTestBedrijf1();
		Bedrijf bedrijfNull = null;
		
		assertTrue(adres1a.getBedrijf() == null);
		adres1a.setBedrijf(bedrijfNull);
		assertTrue(adres1a.getBedrijf() == null);
		
		boolean toegevoegd = adres1a.setBedrijf(bedrijf);
		assertTrue(toegevoegd);
		assertFalse(adres1a.getBedrijf() == null);
		assertTrue(bedrijf.getAdressen().contains(adres1a));
		
		Bedrijf testBedrijf = null;
		for (Iterator<Adres> it = bedrijf.getAdressen().iterator(); it.hasNext();) {
			Adres itAdres = it.next();
			if (itAdres.equals(adres1a)) {
				testBedrijf = itAdres.getBedrijf();
			}
		}
		assertTrue(bedrijf.equals(testBedrijf));
		
		//Een verwijzing naar persoon heeft kan je die niet overschrijden
		Bedrijf bedrijf2 = TestBedrijf.maakTestBedrijf2();
		boolean toegevoegd2 = adres1a.setBedrijf(bedrijf2);
		assertFalse(toegevoegd2);
	}
}

