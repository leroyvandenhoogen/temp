package nl.rsvier.icaras.core;

import java.util.GregorianCalendar;

import nl.rsvier.icaras.core.relatiebeheer.Persoon;

public class TestPersoon {
	private static String[] jongensnamen = { "Sem", "Lucas", "Milan", "Daan",
			"Jayden", "Tim", "Levi", "Thomas", "Thijs", "Jesse", "Luuk", "Stijn", "Ruben", "Lars", "Finn", "Bram", "Julian", "Mees", "Sven", "Max" };
	private static String[] meisjesnamen = {"Sophie", "Julia", "Emma", "Lotte",
			"Eva", "Lisa", "Lieke", "Sanne", "Noa", "Anna", "Isa", "Fleur", "Lynn", "Tess", "Sara", "Roos", "Anne", "Maud", "Jasmijn", "Femke"};
	private static String[] achternamen = {"Jong", "Jansen", "Vries", "Berg", "Dijk",
			"Bakker", "Janssen", "Visser", "Smit", "Meier", "Boer", "Mulder", "Groot", "Bos", "Vos", "Peters", "Hendriks", "Leeuwen", "Dekker", "Brouwer"};
	private static String[] tussenvoegsels = {"", "van", "van de", "van der", "de", "'t", "de van der", "l'", "uijt te de", "voor in 't"};
	private static String[] plaatsen = {"Leeuwarden", "Groningen", "Assen", "Arnhem", "Lelystad", "Zwolle", "Utrecht",
        "Haarlem", "Den Haag", "Middelburg", "Den Bosch", "Maastricht", "Hilversum", "Amersfoort", "Driebergen", "Leiden"};

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
		if (Math.random() > 0.5) {
			if(Math.random() < 0.7) { 
			persoon.setVoornaam(jongensnamen[((int)(Math.random()*20))]);
			}
			else { 
				persoon.setVoornaam(jongensnamen[((int)(Math.random()*20))] + " " + jongensnamen[((int)(Math.random()*20))]);
			}
			persoon.setGeslacht("M");
		}
		else {
			if(Math.random() < 0.7) { 
				persoon.setVoornaam(meisjesnamen[((int)(Math.random()*20))]);
			}
			else {
				persoon.setVoornaam(meisjesnamen[((int)(Math.random()*20))] + " " + meisjesnamen[((int)(Math.random()*20))]);
			}
			persoon.setVoornaam(meisjesnamen[((int)(Math.random()*20))]);
			persoon.setGeslacht("V");
		}
		if(Math.random() < 0.7) {
		persoon.setAchternaam(achternamen[((int)(Math.random()*20))]);
		}
		else {
			persoon.setAchternaam(achternamen[((int)(Math.random()*20))]  + " " + achternamen[((int)(Math.random()*20))]);
		}
		persoon.setTussenvoegsel(tussenvoegsels[((int)(Math.random()*10))]);
		persoon.setNationaliteit("Nederlands");
		persoon.setGeboorteplaats(plaatsen[((int)(Math.random()*16))]);
		persoon.setGeboortedatum(new GregorianCalendar(((int)(Math.random()*50) + 1960), ((int)(Math.random() *12)), ((int)(Math.random()*28))).getTime());
		boolean rijbewijs = (Math.random() > 0.5) ? true : false;
		persoon.setRijbewijs(rijbewijs);

		return persoon;
	}

}
