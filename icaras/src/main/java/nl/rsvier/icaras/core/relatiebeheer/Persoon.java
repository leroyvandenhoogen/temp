package nl.rsvier.icaras.core.relatiebeheer;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "persoon", catalog = "icaras")
public class Persoon implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String voornaam;
	private String achternaam;
	private String tussenvoegsel = "";
	private Date geboortedatum;
	private String geboorteplaats;
	private String geslacht;
	private Boolean rijbewijs;
	private String nationaliteit;
	private String opmerking;
	private Set<Identiteitsbewijs> identiteitsbewijzen = new HashSet<Identiteitsbewijs>(0);
	private Set<Adres> adressen = new HashSet<Adres>(0);
	private Set<DigitaalAdres> digitaleAdressen = new HashSet<DigitaalAdres>(0);
	private Set<Persoonsrol> persoonsrollen = new HashSet<Persoonsrol>(0);

	public Persoon() {
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

	@Column(name = "voornaam", nullable = false, length = 45)
	public String getVoornaam() {
		return this.voornaam;
	}

	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	@Column(name = "achternaam", nullable = false, length = 45)
	public String getAchternaam() {
		return this.achternaam;
	}

	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}

	@Column(name = "tussenvoegsel", length = 45)
	public String getTussenvoegsel() {
		return this.tussenvoegsel;
	}

	public void setTussenvoegsel(String tussenvoegsel) {
		this.tussenvoegsel = tussenvoegsel;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "geboortedatum", length = 10)
	public Date getGeboortedatum() {
		return this.geboortedatum;
	}

	public void setGeboortedatum(Date geboortedatum) {
		this.geboortedatum = geboortedatum;
	}

	@Column(name = "geboorteplaats", length = 45)
	public String getGeboorteplaats() {
		return this.geboorteplaats;
	}

	public void setGeboorteplaats(String geboorteplaats) {
		this.geboorteplaats = geboorteplaats;
	}

	@Column(name = "geslacht", nullable = false, length = 1)
	public String getGeslacht() {
		return this.geslacht;
	}

	public void setGeslacht(String geslacht) {
		this.geslacht = geslacht;
	}

	@Column(name = "rijbewijs")
	public Boolean getRijbewijs() {
		return this.rijbewijs;
	}

	public void setRijbewijs(Boolean rijbewijs) {
		this.rijbewijs = rijbewijs;
	}

	@Column(name = "nationaliteit", length = 45)
	public String getNationaliteit() {
		return this.nationaliteit;
	}

	public void setNationaliteit(String nationaliteit) {
		this.nationaliteit = nationaliteit;
	}

	@Column(name = "opmerking", length = 250)
	public String getOpmerking() {
		return opmerking;
	}

	public void setOpmerking(String opmerking) {
		this.opmerking = opmerking;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "persoon", cascade = CascadeType.ALL)
	public Set<Identiteitsbewijs> getIdentiteitsbewijzen() {
		return this.identiteitsbewijzen;
	}

	public void setIdentiteitsbewijzen(Set<Identiteitsbewijs> identiteitsbewijzen) {
		this.identiteitsbewijzen = identiteitsbewijzen;
	}
	
	public synchronized boolean addIdentiteitsbewijs(Identiteitsbewijs identiteitsbewijs) {
		boolean toegevoegd = false;
		if(identiteitsbewijs != null) {
			toegevoegd = this.getIdentiteitsbewijzen().add(identiteitsbewijs);
			identiteitsbewijs.setPersoon(this);
		}
		return toegevoegd;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "persoon", cascade = CascadeType.ALL)
	public Set<Adres> getAdressen() {
		return this.adressen;
	}

	public void setAdressen(Set<Adres> adressen) {
		if(adressen != null && !(this.adressen.contains(adressen)))
		this.adressen = adressen;
	}
	
	public synchronized boolean addAdres(Adres adres) {
		boolean toegevoegd = false;
		if (adres != null) {
			toegevoegd = this.getAdressen().add(adres);
			adres.setPersoon(this);
		}
		return toegevoegd;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "persoon", cascade = CascadeType.ALL)
	public Set<DigitaalAdres> getDigitaleAdressen() {
		return this.digitaleAdressen;
	}

	public void setDigitaleAdressen(Set<DigitaalAdres> digitaleAdressen) {
		if(digitaleAdressen != null && !(this.digitaleAdressen.contains(digitaleAdressen)))
		this.digitaleAdressen = digitaleAdressen;
	}
	
	public synchronized boolean addDigitaalAdres(DigitaalAdres digitaalAdres) {
		boolean toegevoegd = false;
		if (digitaalAdres != null) {
			toegevoegd = this.getDigitaleAdressen().add(digitaalAdres);
			digitaalAdres.setPersoon(this);
		}
		return toegevoegd;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "persoon", cascade = CascadeType.ALL)
	public Set<Persoonsrol> getPersoonsrollen() {
		return this.persoonsrollen;
	}

	public void setPersoonsrollen(Set<Persoonsrol> persoonsrollen) {
		if(persoonsrollen != null && !(this.persoonsrollen.contains(persoonsrollen))) { 
			this.persoonsrollen = persoonsrollen;
		}
	}
	
	public synchronized boolean addPersoonsrol(Persoonsrol persoonsrol) {
		boolean toegevoegd = false;
		if (persoonsrol != null) {
			toegevoegd = this.getPersoonsrollen().add(persoonsrol);
			persoonsrol.setPersoon(this);			
		}
		return toegevoegd;
	}
	
	public boolean hasRol(String rol) {
		return this.getRolByType(rol) != null;
	}
	
	public Rol getRolByType(String rol) {
		Rol returnRol = null;
		if(this.persoonsrollen != null && !this.persoonsrollen.isEmpty()) {
			for(Persoonsrol r : persoonsrollen) {
				if(r.getRol() != null && r.getRol().getType().equalsIgnoreCase(rol)) {
					returnRol = r.getRol();
				}
			}
		}
		return returnRol;
	}
	
	public String printRollen() {
		String returnRollen = null;
		if(this.persoonsrollen != null && !this.persoonsrollen.isEmpty()) {
			for(Persoonsrol r : persoonsrollen) {
				returnRollen += " " + r.getRol().getType();
			}
		}
		return returnRollen;
	}
	
		
	//Opmerking wordt niet meegenomen in de hashcode of equals methode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result	+ ((getAchternaam() == null) ? 0 : getAchternaam().hashCode());
		result = prime * result	+ ((getGeboortedatum() == null) ? 0 : getGeboortedatum().hashCode());
		result = prime * result	+ ((getGeboorteplaats() == null) ? 0 : getGeboorteplaats().hashCode());
		result = prime * result	+ ((getGeslacht() == null) ? 0 : getGeslacht().hashCode());
		result = prime * result	+ ((getNationaliteit() == null) ? 0 : getNationaliteit().hashCode());
		result = prime * result	+ ((getTussenvoegsel() == null) ? 0 : getTussenvoegsel().hashCode());
		result = prime * result	+ ((getVoornaam() == null) ? 0 : getVoornaam().hashCode());
		result = prime * result + ((getRijbewijs() == null) ? 0 : getRijbewijs().toString().hashCode());
		
		return result;
	}

	//Opmerking wordt niet meegenomen in de hashcode of equals methode
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj == null || !(obj instanceof Persoon)) {
			return false;
		} else {
			Persoon other = (Persoon) obj;
			if (this.getAchternaam() != null && !this.getAchternaam().equals(other.getAchternaam())) {
				return false;
			}
	
			if (this.getGeboortedatum() != null && !this.getGeboortedatum().equals(other.getGeboortedatum())) {
				return false;
			}
	
			if (this.getGeboorteplaats() != null && !this.getGeboorteplaats().equals(other.getGeboorteplaats())) {
				return false;
			}

			if (this.getGeslacht() != null && !this.getGeslacht().equals(other.getGeslacht())) {
				return false;
			}
	
			if (this.getNationaliteit() != null && !this.getNationaliteit().equals(other.getNationaliteit())) {
				return false;
			}
	
			if (this.getRijbewijs() !=  null && !this.getRijbewijs().equals(other.getRijbewijs())) {
				return false;
			}
		
			if (this.getTussenvoegsel() != null && !this.getTussenvoegsel().equals(other.getTussenvoegsel())) {
				return false;
			}
			
			if (this.getVoornaam() != null && !this.getVoornaam().equals(other.getVoornaam())) {
				return false;
			}
		}
		return true;
	}

	@Transient
	public String getVolledigeNaam() {
		return this.getVoornaam() + " " + this.getTussenvoegsel()
				+ (this.getTussenvoegsel() != "" ? " " : "")
				+ this.getAchternaam();
	}

	@Override
	public String toString() {
		return this.getVolledigeNaam();
	}
}

