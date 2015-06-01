package nl.rsvier.icaras.core;

import java.util.GregorianCalendar;

import nl.rsvier.icaras.core.relatiebeheer.Persoon;
import nl.rsvier.icaras.core.relatiebeheer.Persoonsrol;
import nl.rsvier.icaras.core.relatiebeheer.Rol;

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
	
	public static Persoon maakTestContactpersoon() {
		Persoon persoon = new Persoon();
		
		persoon.setVoornaam("Remi");
		persoon.setAchternaam("Boer");
		persoon.setTussenvoegsel("de");
		persoon.setGeboortedatum(new GregorianCalendar(1970, 0, 1).getTime());
		persoon.setGeboorteplaats("Amsterdam");
		persoon.setGeslacht("M");
		persoon.setRijbewijs(true);
		persoon.setNationaliteit("Nederland");
		persoon.setOpmerking("Remi de Boer maakt schuine moppen");
		
		return persoon;
	}
}
