package nl.rsvier.icaras.core;

import java.util.GregorianCalendar;

import nl.rsvier.icaras.core.relatiebeheer.Adres;

public class TestAdres {
	
	public static Adres maakTestAdres1() {
		Adres adres = new Adres();
		
		adres.setStraat("Teststraat");
		adres.setNummer(1337);
		adres.setPostcode("1337CS");
		adres.setPlaats("La Mere");
		adres.setLand("Nederland");
		adres.setBegindatum(new GregorianCalendar(2014, 4, 6).getTime());
		
		adres.setEinddatum(new GregorianCalendar(2015, 4, 6).getTime());
		adres.setToevoegsel("A");
		return adres;
	}
	
	public static Adres maakTestAdres2() {
		Adres adres = new Adres();
		
		adres.setStraat("Meistraat");
		adres.setNummer(666);
		adres.setPostcode("1338AB");
		adres.setPlaats("Amsterdam");
		adres.setLand("Nederland");
		adres.setBegindatum(new GregorianCalendar(2013, 0, 1).getTime());
		return adres;
	}

}
