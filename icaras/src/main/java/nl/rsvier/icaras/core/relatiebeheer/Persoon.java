package nl.rsvier.icaras.core.relatiebeheer;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "persoon", catalog = "icaras")
public class Persoon implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String voornaam;
	private String achternaam;
	private String tussenvoegsel;
	private Date geboortedatum;
	private String geboorteplaats;
	private String geslacht;
	private Boolean rijbewijs;
	private String nationaliteit;
	private Set<Identiteitsbewijs> identiteitsbewijzen = new HashSet<Identiteitsbewijs>(0);
	private Set<Adres> adressen = new HashSet<Adres>(0);
	private Set<AdresDigitaal> digitaleAdressen = new HashSet<AdresDigitaal>(0);
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "persoon")
	public Set<Identiteitsbewijs> getIdentiteitsbewijses() {
		return this.identiteitsbewijzen;
	}

	public void setIdentiteitsbewijses(Set<Identiteitsbewijs> identiteitsbewijzen) {
		this.identiteitsbewijzen = identiteitsbewijzen;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "persoon")
	public Set<Adres> getAdreses() {
		return this.adressen;
	}

	public void setAdreses(Set<Adres> adressen) {
		this.adressen = adressen;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "persoon")
	public Set<AdresDigitaal> getAdresDigitaals() {
		return this.digitaleAdressen;
	}

	public void setAdresDigitaals(Set<AdresDigitaal> digitaleAdressen) {
		this.digitaleAdressen = digitaleAdressen;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "persoon")
	public Set<Persoonsrol> getPersoonsrols() {
		return this.persoonsrollen;
	}

	public void setPersoonsrols(Set<Persoonsrol> persoonsrollen) {
		this.persoonsrollen = persoonsrollen;
	}

}
