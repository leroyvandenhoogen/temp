package nl.rsvier.icaras.core;

import java.util.GregorianCalendar;

import nl.rsvier.icaras.core.relatiebeheer.Persoonsrol;

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
		persoonsrol.setBegindatum(new GregorianCalendar(((int)(Math.random()*3) + 2012), ((int)(Math.random() *12)), ((int)(Math.random()*28))).getTime());
		
		if(Math.random() > 0.8) 
			persoonsrol.setEinddatum(new GregorianCalendar(((int)(Math.random()*3) + 2012), ((int)(Math.random() *12)), ((int)(Math.random()*28))).getTime());

		return persoonsrol;
	}
}
