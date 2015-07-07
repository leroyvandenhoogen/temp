package nl.rsvier.icaras.util.relatiebeheer;

import java.util.List;

import nl.rsvier.icaras.core.relatiebeheer.Adres;
import nl.rsvier.icaras.core.relatiebeheer.AdresType;
import nl.rsvier.icaras.core.relatiebeheer.DigitaalAdres;
import nl.rsvier.icaras.core.relatiebeheer.DigitaalAdresType;
import nl.rsvier.icaras.core.relatiebeheer.Persoon;
import nl.rsvier.icaras.core.relatiebeheer.Persoonsrol;
import nl.rsvier.icaras.core.relatiebeheer.Rol;

public class PersoonDTO {
	private Persoon persoon;
	private Adres adres;
	private List<Adres> adressen;
	private List<AdresType> adresTypes;
	private List<DigitaalAdresType> digitaalAdresTypes;
	private List<Rol> rollen;
	private Persoonsrol persoonsrol;
	private List<Persoonsrol> persoonsrollen;
	private DigitaalAdres digitaalAdres1;
	private DigitaalAdres digitaalAdres2;
	private List<DigitaalAdres> digitaleAdressen;
	
	public PersoonDTO getPersoonDTO() {
		return this;
	}
	
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
	public List<DigitaalAdresType> getDigitaalAdresTypes() {
		return digitaalAdresTypes;
	}
	public void setDigitaalAdresTypes(List<DigitaalAdresType> digitaalAdresTypes) {
		this.digitaalAdresTypes = digitaalAdresTypes;
	}
	public List<Rol> getRollen() {
		return rollen;
	}
	public void setRollen(List<Rol> rollen) {
		this.rollen = rollen;
	}
	public Persoonsrol getPersoonsrol() {
		return persoonsrol;
	}
	public void setPersoonsrol(Persoonsrol persoonsrol) {
		this.persoonsrol = persoonsrol;
	}
	public DigitaalAdres getDigitaalAdres1() {
		return digitaalAdres1;
	}
	public void setDigitaalAdres1(DigitaalAdres dAdres1) {
		this.digitaalAdres1 = dAdres1;
	}
	public DigitaalAdres getDigitaalAdres2() {
		return digitaalAdres2;
	}
	public void setDigitaalAdres2(DigitaalAdres dAdres2) {
		this.digitaalAdres2 = dAdres2;
	}
	public List<Adres> getAdressen() {
		return adressen;
	}
	public void setAdressen(List<Adres> adressen) {
		this.adressen = adressen;
	}
	public List<Persoonsrol> getPersoonsrollen() {
		return persoonsrollen;
	}
	public void setPersoonsrollen(List<Persoonsrol> persoonsrollen) {
		this.persoonsrollen = persoonsrollen;
	}
	public List<DigitaalAdres> getDigitaleAdressen() {
		return digitaleAdressen;
	}
	public void setDigitaleAdressen(List<DigitaalAdres> dAdressen) {
		this.digitaleAdressen = dAdressen;
	}
}
