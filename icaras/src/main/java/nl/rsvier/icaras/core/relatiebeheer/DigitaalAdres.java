package nl.rsvier.icaras.core.relatiebeheer;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "digitaal_adres", catalog = "icaras")
public class DigitaalAdres implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private DigitaalAdresType digitaalAdresType;
	private Bedrijf bedrijf;
	private Persoon persoon;
	private String omschrijving;
	private boolean contactvoorkeur;

	public DigitaalAdres() {
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "digitaal_adres_type_id", nullable = false)
	public DigitaalAdresType getDigitaalAdresType() {
		return this.digitaalAdresType;
	}

	public void setDigitaalAdresType(DigitaalAdresType digitaalAdresType) {
		this.digitaalAdresType = digitaalAdresType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bedrijf_id", nullable = false)
	public Bedrijf getBedrijf() {
		return this.bedrijf;
	}

	public synchronized boolean setBedrijf(Bedrijf bedrijf) {
		boolean isSet = false;
		if(bedrijf != null && this.getBedrijf() == null) {
			this.bedrijf = bedrijf;
			isSet = true;
			if(!(this.getBedrijf().getDigitaleAdressen().contains(this))) {
				bedrijf.addDigitaalAdres(this);
			}
		}
		return isSet;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "persoon_id", nullable = false)
	public Persoon getPersoon() {
		return this.persoon;
	}

	public synchronized boolean setPersoon(Persoon persoon) {
		boolean isSet = false;
		if(persoon != null && this.getPersoon() == null) {
			this.persoon = persoon;
			isSet = true;
			if(!(this.getPersoon().getDigitaleAdressen().contains(this))) {
				persoon.addDigitaalAdres(this);
			}
		}
		return isSet;
	}
	
	public synchronized void removePersoon() {
		this.persoon = null;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isContactvoorkeur() ? 1231 : 1237);
		result = prime * result	+ ((getDigitaalAdresType() == null) ? 0 : getDigitaalAdresType().hashCode());
		result = prime * result	+ ((getOmschrijving() == null) ? 0 : getOmschrijving().hashCode());
		
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj == null || !(obj instanceof DigitaalAdres)) {
			return false;
		} else {
			DigitaalAdres other = (DigitaalAdres) obj;
			
			if (this.isContactvoorkeur() != other.isContactvoorkeur()) {
				return false;
			}
			
			if (this.getDigitaalAdresType() != null && !this.getDigitaalAdresType().equals(other.getDigitaalAdresType())) {
				return false;
			}
			
			if (this.getOmschrijving() != null && !this.getOmschrijving().equals(other.getOmschrijving())) {
				return false;
			}
		}
		return true;
	}
}
