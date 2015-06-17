package nl.rsvier.icaras.core;

import nl.rsvier.icaras.core.relatiebeheer.Bedrijf;

public class TestBedrijf {
	private static String[] bedrijven = { "Google", "Facebook", "Adobe",
			"Salesforce", "Qualcomm", "Microsoft", "Apple", "IBM", "Capgemini",
			"Cisco", "Afas", "Chipsoft", "Woodwing", "Accenture", "Oracle",
			"Ziggo", "Avanade", "ASP4all", "Sogeti", "Tele2" };
	private static String[] opmerkingen = { "Heeft potentie",
			"In het verleden zaken mee gedaan", "Slechte ervaringen mee",
			"Nog te benaderen", "Bellen!", "Nieuw", "Goede ervaringen mee",
			"Staat afspraak", "Komt volgende week langs" };

	public static Bedrijf maakTestBedrijf1() {
		Bedrijf bedrijf = new Bedrijf();
		bedrijf.setNaam("Best bedrijf BV");
		bedrijf.setOpmerking("Het beste bedrijf");
		bedrijf.setKvkNummer("123456789012");

		return bedrijf;
	}

	public static Bedrijf maakTestBedrijf2() {
		Bedrijf bedrijf = new Bedrijf();
		bedrijf.setNaam("Op een na beste bedrijf BV");

		return bedrijf;
	}

	public static Bedrijf maakTestBedrijf3() {
		Bedrijf bedrijf = new Bedrijf();
		bedrijf.setNaam(bedrijven[(int) (Math.random() * 20)]);
		bedrijf.setKvkNummer("" + ((int) (Math.random() * 999999999)));
		int i = (int) (Math.random() * 30);
		if (i < 9)
			bedrijf.setOpmerking(opmerkingen[i]);
		return bedrijf;
	}
}
