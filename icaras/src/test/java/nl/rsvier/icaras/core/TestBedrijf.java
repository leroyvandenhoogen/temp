package nl.rsvier.icaras.core;

import nl.rsvier.icaras.core.relatiebeheer.Bedrijf;

public class TestBedrijf {
	
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
}
