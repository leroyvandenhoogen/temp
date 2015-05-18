package nl.rsvier.icaras.core;

import nl.rsvier.icaras.core.relatiebeheer.DigitaalAdres;

public class TestDigitaalAdres {
	
	public static DigitaalAdres maakDigitaalAdres1() {
		DigitaalAdres digitaalAdres = new DigitaalAdres();
		digitaalAdres.setOmschrijving("something@something.nl");
		digitaalAdres.setContactvoorkeur(false);
		
		return digitaalAdres;
	}
	
	public static DigitaalAdres maakDigitaalAdres2() {
		DigitaalAdres digitaalAdres = new DigitaalAdres();
		digitaalAdres.setOmschrijving("+31123456");
		digitaalAdres.setContactvoorkeur(true);
		
		return digitaalAdres;
	}
}
