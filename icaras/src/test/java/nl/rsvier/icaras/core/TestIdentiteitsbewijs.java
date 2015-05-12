package nl.rsvier.icaras.core;

import java.util.GregorianCalendar;

import nl.rsvier.icaras.core.relatiebeheer.Identiteitsbewijs;

public class TestIdentiteitsbewijs {
	
	public static Identiteitsbewijs maakIdentiteitsbewijs1() {
		Identiteitsbewijs identiteitsbewijs = new Identiteitsbewijs();
		identiteitsbewijs.setNummer("14BN1235R");
		identiteitsbewijs.setVervaldatum(new GregorianCalendar(2025, 0, 1).getTime());
				
		return identiteitsbewijs;
	}
	
	public static Identiteitsbewijs maakIdentiteitsbewijs2() {
		Identiteitsbewijs identiteitsbewijs = new Identiteitsbewijs();
		identiteitsbewijs.setNummer("1234567ABC");
		identiteitsbewijs.setVervaldatum(new GregorianCalendar(2019, 11, 5).getTime());
				
		return identiteitsbewijs;
	}
}
