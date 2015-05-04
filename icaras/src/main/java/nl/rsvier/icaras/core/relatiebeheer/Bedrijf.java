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
	private Set<AdresDigitaal> digitaleAdressen = new HashSet<AdresDigitaal>(0);
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bedrijf")
	public Set<AdresDigitaal> getAdresDigitaals() {
		return this.digitaleAdressen;
	}

	public void setAdresDigitaals(Set<AdresDigitaal> digitaleAdressen) {
		this.digitaleAdressen = digitaleAdressen;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bedrijf")
	public Set<Adres> getAdreses() {
		return this.adressen;
	}

	public void setAdreses(Set<Adres> adressen) {
		this.adressen = adressen;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bedrijf")
	public Set<Persoonsrol> getPersoonsrols() {
		return this.persoonsrollen;
	}

	public void setPersoonsrols(Set<Persoonsrol> persoonsrollen) {
		this.persoonsrollen = persoonsrollen;
	}

}
