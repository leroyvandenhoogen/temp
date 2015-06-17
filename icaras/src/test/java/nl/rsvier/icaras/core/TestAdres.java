package nl.rsvier.icaras.core;

import java.util.GregorianCalendar;

import nl.rsvier.icaras.core.relatiebeheer.Adres;

public class TestAdres {
	private static String[] plaatsen = {"Amsterdam", "Rotterdam", "Den Haag", "Utrecht", "Eindhoven", "Tilburg", "Groningen", "Almere", "Breda", "Nijmegen", 
			"Enschede", "Apeldoorn", "Haarlem", "Amersfoort", "Arnhem", "Zaanstad", "'s Hertogenbosch", "Haarlemmermeer", "Zoetermeer", "Zwolle"};
	private static String[] straten = {"Kerkstraat", "Schoolstraat", "Molenstraat", "Dorpsstraat", "Molenweg", "Julianastraat", "Parallelweg", "Nieuwstraat",
			"Wilhelminastraat", "Sportlaan", "Industrieweg", "Beatrixstraat", "Kastanjelaan", "Stationsweg", "Eikenlaan", "Markt", "Prins Bernhardstraat", "Emmastraat", "Beukenlaan", "'s Gravelandseweg"};
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
		adres.setPlaats(plaatsen[((int)(Math.random()*20))]);
		adres.setNummer(((int)(Math.random()*100)));
		adres.setPostcode(""+((int)(Math.random()*9000 + 1000) + ""+ ((char)(Math.random()*26 + 'A'))) + "" + ((char)(Math.random()*26 + 'A')));
		adres.setStraat(straten[((int)(Math.random()*20))]);
		adres.setBegindatum(new GregorianCalendar(2013, 0, 1).getTime());
		
		
		return adres;
	}

}
