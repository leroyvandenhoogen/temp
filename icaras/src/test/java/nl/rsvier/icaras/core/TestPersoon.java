package nl.rsvier.icaras.core;

import java.util.GregorianCalendar;

import nl.rsvier.icaras.core.relatiebeheer.Persoon;

public class TestPersoon {
	private static String[] jongensnamen = { "Sem", "Lucas", "Milan", "Daan",
			"Jayden", "Tim", "Levi", "Thomas", "Thijs", "Jesse" };
	private static String[] meisjesnamen = {"Sophie", "Julia", "Emma", "Lotte",
			"Eva", "Lisa", "Lieke", "Sanne", "Noa", "Anna"};
	private static String[] achternamen = {"Jong", "Jansen", "Vries", "Berg", "Dijk",
			"Bakker", "Janssen", "Visser", "Smit", "Meier"};
	private static String[] tussenvoegsels = {"", "van", "van de", "van der", "de"};
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
			persoon.setVoornaam(jongensnamen[((int)(Math.random()*10))]);
			persoon.setGeslacht("M");
		}
		else {
			persoon.setVoornaam(meisjesnamen[((int)(Math.random()*10))]);
			persoon.setGeslacht("V");
		}
		persoon.setAchternaam(achternamen[((int)(Math.random()*10))]);
		persoon.setTussenvoegsel(tussenvoegsels[((int)(Math.random()*5))]);
		persoon.setNationaliteit("Nederlands");
		persoon.setGeboorteplaats(plaatsen[((int)(Math.random()*16))]);
		persoon.setGeboortedatum(new GregorianCalendar(((int)(Math.random()*50) + 1960), ((int)(Math.random() *12)), ((int)(Math.random()*28))).getTime());
		boolean rijbewijs = (Math.random() > 0.5) ? true : false;
		persoon.setRijbewijs(rijbewijs);

		return persoon;
	}

}
