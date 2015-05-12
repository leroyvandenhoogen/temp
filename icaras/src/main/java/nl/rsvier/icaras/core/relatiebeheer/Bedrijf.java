package nl.rsvier.icaras.core.relatiebeheer;

import java.util.HashSet;
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
	private String opmerking;
	private Set<DigitaalAdres> digitaleAdressen = new HashSet<DigitaalAdres>(0);
	private Set<Adres> adressen = new HashSet<Adres>(0);
	private Set<Persoonsrol> persoonsrollen = new HashSet<Persoonsrol>(0);

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
	
	@Column(name = "opmerking", length = 250)
	public String getOpmerking() {
		return opmerking;
	}

	public void setOpmerking(String opmerking) {
		this.opmerking = opmerking;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bedrijf")
	public Set<DigitaalAdres> getDigitaleAdressen() {
		return this.digitaleAdressen;
	}

	public void setDigitaleAdressen(Set<DigitaalAdres> digitaleAdressen) {
		this.digitaleAdressen = digitaleAdressen;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bedrijf")
	public Set<Adres> getAdressen() {
		return this.adressen;
	}

	public void setAdressen(Set<Adres> adressen) {
		this.adressen = adressen;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bedrijf")
	public Set<Persoonsrol> getPersoonsrollen() {
		return this.persoonsrollen;
	}

	public void setPersoonsrollen(Set<Persoonsrol> persoonsrollen) {
		this.persoonsrollen = persoonsrollen;
	}
	
	//Opmerking wordt niet meegenomen in de hashcode of equals methode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result	+ ((getAdressen() == null) ? 0 : getAdressen().hashCode());
		result = prime * result + ((getDigitaleAdressen() == null) ? 0 : getDigitaleAdressen().hashCode());
		result = prime * result + ((getNaam() == null) ? 0 : getNaam().hashCode());
		result = prime * result	+ ((getPersoonsrollen() == null) ? 0 : getPersoonsrollen().hashCode());
		
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
			if (this.getAdressen() != null && !this.getAdressen().equals(other.getAdressen())) {
				return false;
			}
			
			if (this.getDigitaleAdressen() != null && !this.getDigitaleAdressen().equals(other.getDigitaleAdressen())) {
				return false;
			}
			
			if (this.getNaam() != null && !this.getNaam().equals(other.getNaam())) {
				return false;
			}
			
			if (this.getPersoonsrollen() != null && !this.getPersoonsrollen().equals(other.getPersoonsrollen())) {
				return false;
			}
		}
		return true;
	}
}
