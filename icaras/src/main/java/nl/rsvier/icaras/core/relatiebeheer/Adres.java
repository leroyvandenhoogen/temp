package nl.rsvier.icaras.core.relatiebeheer;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "adres", catalog = "icaras")
public class Adres implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Bedrijf bedrijf;
	private Persoon persoon;
	private AdresType adresType;
	private String straat;
	private int nummer;
	private String toevoegsel;
	private String postcode;
	private String plaats;
	private String land;
	private Date begindatum;
	private Date einddatum;

	public Adres() {
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
	@JoinColumn(name = "bedrijf_id")
	public Bedrijf getBedrijf() {
		return this.bedrijf;
	}

	public void setBedrijf(Bedrijf bedrijf) {
		this.bedrijf = bedrijf;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "persoon_id")
	public Persoon getPersoon() {
		return this.persoon;
	}

	public void setPersoon(Persoon persoon) {
		this.persoon = persoon;
	}

//	@ManyToOne(fetch = FetchType.LAZY)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "adres_type_id", nullable = false/*, updatable=false, insertable=false*/)
	public AdresType getAdresType() {
		return this.adresType;
	}

	public void setAdresType(AdresType adresType) {
		this.adresType = adresType;
	}

	@Column(name = "straat", nullable = false, length = 45)
	public String getStraat() {
		return this.straat;
	}

	public void setStraat(String straat) {
		this.straat = straat;
	}

	@Column(name = "nummer", nullable = false, length = 5)
	public int getNummer() {
		return this.nummer;
	}

	public void setNummer(int nummer) {
		this.nummer = nummer;
	}

	@Column(name = "toevoegsel", length = 45)
	public String getToevoegsel() {
		return this.toevoegsel;
	}

	public void setToevoegsel(String toevoegsel) {
		this.toevoegsel = toevoegsel;
	}

	@Column(name = "postcode", nullable = false, length = 45)
	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	@Column(name = "plaats", nullable = false, length = 45)
	public String getPlaats() {
		return this.plaats;
	}

	public void setPlaats(String plaats) {
		this.plaats = plaats;
	}

	@Column(name = "land", nullable = false, length = 45)
	public String getLand() {
		return this.land;
	}

	public void setLand(String land) {
		this.land = land;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "begindatum", nullable = false, length = 10)
	public Date getBegindatum() {
		return this.begindatum;
	}

	public void setBegindatum(Date begindatum) {
		this.begindatum = begindatum;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "einddatum", length = 10)
	public Date getEinddatum() {
		return this.einddatum;
	}

	public void setEinddatum(Date einddatum) {
		this.einddatum = einddatum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getAdresType() == null) ? 0 : getAdresType().hashCode());
		result = prime * result	+ ((getBegindatum() == null) ? 0 : getBegindatum().hashCode());
		result = prime * result	+ ((getEinddatum() == null) ? 0 : getEinddatum().hashCode());
		result = prime * result + ((getLand() == null) ? 0 : getLand().hashCode());
		result = prime * result + getNummer();
		result = prime * result + ((getPlaats() == null) ? 0 : getPlaats().hashCode());
		result = prime * result	+ ((getPostcode() == null) ? 0 : getPostcode().hashCode());
		result = prime * result + ((getStraat() == null) ? 0 : getStraat().hashCode());
		result = prime * result	+ ((getToevoegsel() == null) ? 0 : getToevoegsel().hashCode());
		
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj == null || !(obj instanceof Adres)) {
			return false;
		} else {
			Adres other = (Adres) obj;
			if (this.getAdresType() != null && !this.getAdresType().equals(other.getAdresType())) {
				return false;
			}
			
			if (this.getBegindatum() != null && !this.getBegindatum().equals(other.getBegindatum())) {
				return false;
			}
			
			if (this.getEinddatum() != null && !this.getEinddatum().equals(other.getEinddatum())) {
				return false;
			}

			if (this.getLand() != null && !this.getLand().equals(other.getLand())) {
				return false;
			}
			
			if (this.getNummer() != other.nummer) {
				return false;
			}
			
			if (this.getPlaats() != null && !this.getPlaats().equals(other.getPlaats())) {
				return false;
			}
			
			if (this.getPostcode() != null && !this.getPostcode().equals(other.getPostcode())) {
				return false;
			}
	
			if (this.getStraat() != null && !this.getStraat().equals(other.getStraat())) {
				return false;
			}
	
			if (this.getToevoegsel() != null && !this.getToevoegsel().equals(other.getToevoegsel())) {
				return false;
			}
		}
		return true;
	}
}
