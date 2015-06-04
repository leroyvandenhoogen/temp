package nl.rsvier.icaras.core;

import java.util.GregorianCalendar;

import nl.rsvier.icaras.core.relatiebeheer.Adres;

public class TestAdres {
	private static String[] plaatsen = {"Groningen", "Amsterdam", "Utrecht", "Den Haag", "Hilversum"};
	private static String[] postcodes = {"1234AB", "3500KA", "2367BE", "9768ZK", "2333KL"};
	private static String[] straten = {"Kerkplein", "Stationsweg", "Dorpstraat", "Hoofdstraat", "Molenweg"};
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
	
	public static Adres maakTestAdres3() {
		Adres adres = new Adres();
		adres.setLand("Nederland");
		adres.setPlaats(plaatsen[((int)(Math.random()*5))]);
		adres.setNummer(((int)(Math.random()*100)));
		adres.setPostcode(postcodes[((int)(Math.random()*5))]);
		adres.setStraat(straten[((int)(Math.random()*5))]);
		adres.setBegindatum(new GregorianCalendar(2013, 0, 1).getTime());
		
		
		return adres;
	}

}
