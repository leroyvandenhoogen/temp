package nl.rsvier.icaras.core;

import java.util.GregorianCalendar;
import java.util.HashSet;
import nl.rsvier.icaras.core.relatiebeheer.Identiteitsbewijs;
import nl.rsvier.icaras.core.relatiebeheer.Persoon;

public class TestPersoon {
	
	public static Persoon maakTestPersoon1() {
		Persoon persoon = new Persoon();
		
		persoon.setVoornaam("Sjaak");
		persoon.setAchternaam("Trekhaak");
		persoon.setTussenvoegsel("von");
		persoon.setGeboortedatum(new GregorianCalendar(1990, 0, 1).getTime());
		persoon.setGeboorteplaats("Amsterdam");
		persoon.setGeslacht("M");
		persoon.setRijbewijs(true);
		persoon.setNationaliteit("Nederland");
		persoon.setOpmerking("Sjaak von Trekhaak is een fictioneel karakter");
		return persoon;
	}
	
	public static Persoon maakTestPersoon2() {
		Persoon persoon = new Persoon();
		
		persoon.setVoornaam("Koos");
		persoon.setAchternaam("Kansloos");
		persoon.setGeslacht("M");
		return persoon;
	}
}
