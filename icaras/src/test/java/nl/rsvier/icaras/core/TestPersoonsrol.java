package nl.rsvier.icaras.core;

import java.util.GregorianCalendar;

import nl.rsvier.icaras.core.relatiebeheer.Persoonsrol;

public class TestPersoonsrol {
	
	public static Persoonsrol maakPersoonsrol1() {
		Persoonsrol persoonsrol = new Persoonsrol();
		persoonsrol.setEinddatum(new GregorianCalendar(2016, 0, 1).getTime());
		
		return persoonsrol;
	}
	
	public static Persoonsrol maakPersoonsrol2() {
		Persoonsrol persoonsrol = new Persoonsrol();
		persoonsrol.setEinddatum(new GregorianCalendar(2015, 0, 1).getTime());
		
		return persoonsrol;
	}
}
