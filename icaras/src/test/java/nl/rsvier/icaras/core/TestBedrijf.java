package nl.rsvier.icaras.core;

import nl.rsvier.icaras.core.relatiebeheer.Bedrijf;

public class TestBedrijf {
	private static String[] bedrijven = {"Google", "Facebook", "Adobe", "Salesforce", "Qualcomm"};
	private static String[] opmerkingen = {"Heeft potentie", "In het verleden zaken met gedaan", 
			"Slechte ervaringen mee", "Nog te benaderen" , ""};
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
		bedrijf.setNaam(bedrijven[(int)(Math.random()*5)]);
		bedrijf.setKvkNummer("" + ((int)(Math.random()*999999999)));
		bedrijf.setOpmerking(opmerkingen[((int)(Math.random()*5))]);
		return bedrijf;
	}
}
