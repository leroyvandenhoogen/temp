package nl.rsvier.icaras.util.relatiebeheer;

import java.util.List;

import nl.rsvier.icaras.core.relatiebeheer.Adres;
import nl.rsvier.icaras.core.relatiebeheer.AdresType;
import nl.rsvier.icaras.core.relatiebeheer.DigitaalAdres;
import nl.rsvier.icaras.core.relatiebeheer.DigitaalAdresType;
import nl.rsvier.icaras.core.relatiebeheer.Persoon;
import nl.rsvier.icaras.core.relatiebeheer.Persoonsrol;

public class PersoonDTO {
	private Persoon persoon;
	private Adres adres;
	private List<AdresType> adresTypes;
	private Persoonsrol persoonsrol;
	private List<DigitaalAdresType> digitaalAdresTypes;
	private DigitaalAdres dAdres1;
	private DigitaalAdres dAdres2;
	
	public Persoon getPersoon() {
		return persoon;
	}
	public void setPersoon(Persoon persoon) {
		this.persoon = persoon;
	}
	public Adres getAdres() {
		return adres;
	}
	public void setAdres(Adres adres) {
		this.adres = adres;
	}
	public List<AdresType> getAdresTypes() {
		return adresTypes;
	}
	public void setAdresTypes(List<AdresType> adresTypes) {
		this.adresTypes = adresTypes;
	}
	public Persoonsrol getPersoonsrol() {
		return persoonsrol;
	}
	public void setPersoonsrol(Persoonsrol persoonsrol) {
		this.persoonsrol = persoonsrol;
	}
	public List<DigitaalAdresType> getDigitaalAdresTypes() {
		return digitaalAdresTypes;
	}
	public void setDigitaalAdresTypes(List<DigitaalAdresType> digitaalAdresTypes) {
		this.digitaalAdresTypes = digitaalAdresTypes;
	}
	public DigitaalAdres getdAdres1() {
		return dAdres1;
	}
	public void setdAdres1(DigitaalAdres dAdres1) {
		this.dAdres1 = dAdres1;
	}
	public DigitaalAdres getdAdres2() {
		return dAdres2;
	}
	public void setdAdres2(DigitaalAdres dAdres2) {
		this.dAdres2 = dAdres2;
	}
	
}
