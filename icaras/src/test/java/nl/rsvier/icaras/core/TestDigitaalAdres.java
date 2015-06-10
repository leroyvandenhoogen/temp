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
		digitaalAdres.setOmschrijving(""+((int)(Math.random()*999999999)));
		digitaalAdres.setContactvoorkeur(true);
		
		return digitaalAdres;
	}
	
	public static DigitaalAdres maakDigitaalAdres3() {
		DigitaalAdres digitaalAdres = new DigitaalAdres();
		digitaalAdres.setOmschrijving("www.website.com");
		digitaalAdres.setContactvoorkeur(false);
		
		return digitaalAdres;
	}
}
