package nl.rsvier.icaras.core;

import java.util.GregorianCalendar;

import nl.rsvier.icaras.core.relatiebeheer.Persoonsrol;
import nl.rsvier.icaras.core.relatiebeheer.Rol;

public class TestPersoonsrol {
	
	public static Persoonsrol maakPersoonsrol1() {
		Persoonsrol persoonsrol = new Persoonsrol();
		persoonsrol.setBegindatum(new GregorianCalendar(2015, 0, 1).getTime());
		persoonsrol.setEinddatum(new GregorianCalendar(2016, 0, 1).getTime());
		
		return persoonsrol;
	}
	
	public static Persoonsrol maakPersoonsrol2() {
		Persoonsrol persoonsrol = new Persoonsrol();
		persoonsrol.setBegindatum(new GregorianCalendar(2014, 10, 11).getTime());
		persoonsrol.setEinddatum(new GregorianCalendar(2015, 0, 1).getTime());
		
		return persoonsrol;
	}
	
	public static Persoonsrol maakPersoonsrol3() {
		Persoonsrol persoonsrol = new Persoonsrol();
		persoonsrol.setBegindatum(new GregorianCalendar(2014, 10, 10).getTime());
		persoonsrol.setEinddatum(new GregorianCalendar(2015, 0, 1).getTime());
		
		return persoonsrol;
	}
}
