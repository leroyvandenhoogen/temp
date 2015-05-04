package nl.rsvier.icaras.core.relatiebeheer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "adres_digitaal", catalog = "icaras")
public class AdresDigitaal implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private AdresDigitaalType adresDigitaalType;
	private Bedrijf bedrijf;
	private Persoon persoon;
	private String omschrijving;
	private boolean contactvoorkeur;

	public AdresDigitaal() {
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "adres_digitaal_type_id", nullable = false)
	public AdresDigitaalType getAdresDigitaalType() {
		return this.adresDigitaalType;
	}

	public void setAdresDigitaalType(AdresDigitaalType adresDigitaalType) {
		this.adresDigitaalType = adresDigitaalType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bedrijf_id", nullable = false)
	public Bedrijf getBedrijf() {
		return this.bedrijf;
	}

	public void setBedrijf(Bedrijf bedrijf) {
		this.bedrijf = bedrijf;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "persoon_id", nullable = false)
	public Persoon getPersoon() {
		return this.persoon;
	}

	public void setPersoon(Persoon persoon) {
		this.persoon = persoon;
	}

	@Column(name = "omschrijving", nullable = false, length = 100)
	public String getOmschrijving() {
		return this.omschrijving;
	}

	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}

	@Column(name = "contactvoorkeur", nullable = false)
	public boolean isContactvoorkeur() {
		return this.contactvoorkeur;
	}

	public void setContactvoorkeur(boolean contactvoorkeur) {
		this.contactvoorkeur = contactvoorkeur;
	}

}
