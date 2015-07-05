package nl.rsvier.icaras.util.relatiebeheer;

import java.util.List;

import nl.rsvier.icaras.core.relatiebeheer.AdresType;
import nl.rsvier.icaras.core.relatiebeheer.BedrijfExpertise;
import nl.rsvier.icaras.core.relatiebeheer.BedrijfType;
import nl.rsvier.icaras.core.relatiebeheer.DigitaalAdresType;

public class OnderhoudDTO {

	private List<AdresType> adresTypes;
	private List<DigitaalAdresType> digitaalAdresTypes;
	private List<BedrijfExpertise> bedrijfExpertises;
	private List<BedrijfType> bedrijfTypes;
	private String input;
	
	public List<AdresType> getAdresTypes() {
		return adresTypes;
	}
	public void setAdresTypes(List<AdresType> adresTypes) {
		this.adresTypes = adresTypes;
	}
	public List<DigitaalAdresType> getDigitaalAdresTypes() {
		return digitaalAdresTypes;
	}
	public void setDigitaalAdresTypes(List<DigitaalAdresType> digitaalAdresTypes) {
		this.digitaalAdresTypes = digitaalAdresTypes;
	}
	public List<BedrijfExpertise> getBedrijfExpertises() {
		return bedrijfExpertises;
	}
	public void setBedrijfExpertises(List<BedrijfExpertise> bedrijfExpertises) {
		this.bedrijfExpertises = bedrijfExpertises;
	}
	public List<BedrijfType> getBedrijfTypes() {
		return bedrijfTypes;
	}
	public void setBedrijfTypes(List<BedrijfType> bedrijfTypes) {
		this.bedrijfTypes = bedrijfTypes;
	}
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	
	
	
}
