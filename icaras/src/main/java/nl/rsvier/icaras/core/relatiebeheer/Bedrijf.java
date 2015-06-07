package nl.rsvier.icaras.core.relatiebeheer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bedrijf", catalog = "icaras")
public class Bedrijf implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String naam;
	private String kvkNummer;
	private String opmerking;
	private List<DigitaalAdres> digitaleAdressen = new ArrayList<DigitaalAdres>(0);
	private List<Adres> adressen = new ArrayList<Adres>(0);
	private List<Persoonsrol> persoonsrollen = new ArrayList<Persoonsrol>(0);

	public Bedrijf() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "naam", nullable = false, length = 45)
	public String getNaam() {
		return this.naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}
	
	@Column(name = "kvknummer", length = 12)
	public String getKvkNummer() {
		return kvkNummer;
	}

	public void setKvkNummer(String kvkNummer) {
		this.kvkNummer = kvkNummer;
	}

	@Column(name = "opmerking", length = 250)
	public String getOpmerking() {
		return opmerking;
	}

	public void setOpmerking(String opmerking) {
		this.opmerking = opmerking;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bedrijf")
	public List<DigitaalAdres> getDigitaleAdressen() {
		return this.digitaleAdressen;
	}

	public void setDigitaleAdressen(List<DigitaalAdres> digitaleAdressen) {
		if(digitaleAdressen != null && !(this.digitaleAdressen.contains(digitaleAdressen)))
		this.digitaleAdressen = digitaleAdressen;
	}

	public synchronized boolean addDigitaalAdres(DigitaalAdres digitaalAdres) {
		boolean toegevoegd = false;
		if (digitaalAdres != null) {
			toegevoegd = this.getDigitaleAdressen().add(digitaalAdres);
			digitaalAdres.setBedrijf(this);
		}
		return toegevoegd;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bedrijf")
	public List<Adres> getAdressen() {
		return this.adressen;
	}

	public void setAdressen(List<Adres> adressen) {
		if(adressen != null && !(this.adressen.contains(adressen)))
		this.adressen = adressen;
	}
	
	public synchronized boolean addAdres(Adres adres) {
		boolean toegevoegd = false;
		if(adressen != null && !(this.adressen.contains(adres))) {
			toegevoegd = this.getAdressen().add(adres);
			adres.setBedrijf(this);
		}
		return toegevoegd;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bedrijf")
	public List<Persoonsrol> getPersoonsrollen() {
		
		return this.persoonsrollen;
	}

	public void setPersoonsrollen(List<Persoonsrol> persoonsrollen) {
		if(persoonsrollen != null && !(this.persoonsrollen.contains(persoonsrollen))) 
		this.persoonsrollen = persoonsrollen;
	}
	
	public synchronized boolean addPersoonsrol(Persoonsrol persoonsrol) {
		boolean toegevoegd = false;
		if (persoonsrol != null) {
			toegevoegd = this.getPersoonsrollen().add(persoonsrol);
			persoonsrol.setBedrijf(this);			
		}
		return toegevoegd;
	}
	
	//Opmerking wordt niet meegenomen in de hashcode of equals methode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getNaam() == null) ? 0 : getNaam().hashCode());
		result = prime * result + ((getKvkNummer() == null) ? 0 : getKvkNummer().hashCode());
		return result;
	}

	//Opmerking wordt niet meegenomen in de hashcode of equals methode
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj == null || !(obj instanceof Bedrijf)) {
			return false;
		} else {
			Bedrijf other = (Bedrijf) obj;	
			if (this.getKvkNummer() != null && !this.getKvkNummer().equals(other.getKvkNummer())) {
				return false;
			}
			
			if (this.getNaam() != null && !this.getNaam().equals(other.getNaam())) {
				return false;
			}
		}
		return true;
	}
}
