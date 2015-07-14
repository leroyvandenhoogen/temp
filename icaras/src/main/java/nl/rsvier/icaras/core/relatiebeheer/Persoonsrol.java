package nl.rsvier.icaras.core.relatiebeheer;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "persoonsrol", catalog = "icaras")
public class Persoonsrol implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Rol rol;
	private Bedrijf bedrijf;
	private Persoon persoon;
	private Date begindatum;
	private Date einddatum;
	private String functie;
	private String afdeling;

	public Persoonsrol() {
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
	@JoinColumn(name = "rol_id", nullable = false  /*, insertable = false , updatable = false */)
	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bedrijf_id")
	public Bedrijf getBedrijf() {
		return this.bedrijf;
	}

	public synchronized boolean setBedrijf(Bedrijf bedrijf) {
		boolean isSet = false;
		if(bedrijf != null && this.getBedrijf() == null) {
			this.bedrijf = bedrijf;
			isSet = true;
//			if(!(this.getBedrijf().getDigitaleAdressen().contains(this))) {
//				bedrijf.addPersoonsrol(this);
//			}
		}
		return isSet;
	}
	
	public synchronized void removeBedrijf() {
		this.bedrijf = null;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "persoon_id", nullable = false /*, insertable = false, updatable = false*/)
	public Persoon getPersoon() {
		return this.persoon;
	}

	public synchronized boolean setPersoon(Persoon persoon) {
		boolean isSet = false;
		if(persoon != null && this.getPersoon() == null) {
			this.persoon = persoon;
			isSet = true;
			if(!(this.getPersoon().getPersoonsrollen().contains(this))) {
				persoon.addPersoonsrol(this);
			}
		}
		return isSet;
	}
	
	public synchronized void removePersoon() {
		this.persoon = null;
	}
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE, pattern="dd-MM-yyyy")
	@Column(name = "begindatum", nullable = false, length = 10)
	public Date getBegindatum() {
		return this.begindatum;
	}
	
	public void setBegindatum(Date begindatum) {
		this.begindatum = begindatum;
	}

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE, pattern="dd-MM-yyyy")
	@Column(name = "einddatum", length = 10)
	public Date getEinddatum() {
		return this.einddatum;
	}

	public void setEinddatum(Date einddatum) {
		this.einddatum = einddatum;
	}

	
	@Column(name = "functie", length = 45)
	public String getFunctie() {
		return functie;
	}

	public void setFunctie(String functie) {
		this.functie = functie;
	}
	
	@Column(name = "afdeling", length = 45)
	public String getAfdeling() {
		return afdeling;
	}

	public void setAfdeling(String afdeling) {
		this.afdeling = afdeling;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result	+ ((getBegindatum() == null) ? 0 : getBegindatum().hashCode());
		result = prime * result	+ ((getEinddatum() == null) ? 0 : getEinddatum().hashCode());
		result = prime * result + ((getRol() == null) ? 0 : getRol().hashCode());
		result = prime * result + ((getFunctie() == null) ? 0 : getFunctie().hashCode());
		result = prime * result + ((getAfdeling() == null) ? 0 : getAfdeling().hashCode());

		
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj == null || !(obj instanceof Persoonsrol)) {
			return false;
		} else {
			Persoonsrol other = (Persoonsrol) obj;	
			if (this.getBegindatum() != null && !this.getBegindatum().equals(other.getBegindatum())) {
				return false;
			}

			if (this.getEinddatum() != null && !this.getEinddatum().equals(other.getEinddatum())) {
				return false;
			}
			
			if (this.getRol() != null && !this.getRol().equals(other.getRol())) {
				return false;
			}
			
			if (this.getFunctie() != null && !this.getFunctie().equals(other.getFunctie())) {
				return false;
			}
			
			if (this.getAfdeling() != null && !this.getAfdeling().equals(other.getAfdeling())) {
				return false;
			}
		
		}
		return true;
	}
	
	@Override
	public String toString(){
		return this.getRol().getType();
	}
}
