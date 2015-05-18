package nl.rsvier.icaras.core.relatiebeheer;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "persoonsrol", catalog = "icaras")
public class Persoonsrol implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private PersoonsrolId id;
	private Rol rol;
	private Bedrijf bedrijf;
	private Persoon persoon;
	private Date einddatum;

	public Persoonsrol() {
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "persoonId", column = @Column(name = "persoon_id", nullable = false)),
			@AttributeOverride(name = "rolId", column = @Column(name = "rol_id", nullable = false)),
			@AttributeOverride(name = "begindatum", column = @Column(name = "begindatum", nullable = false, length = 10)) })
	public PersoonsrolId getId() {
		return this.id;
	}

	public void setId(PersoonsrolId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "rol_id", nullable = false, insertable = false, updatable = false)
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

	public void setBedrijf(Bedrijf bedrijf) {
		this.bedrijf = bedrijf;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "persoon_id", nullable = false, insertable = false, updatable = false)
	public Persoon getPersoon() {
		return this.persoon;
	}

	public void setPersoon(Persoon persoon) {
		this.persoon = persoon;
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
		result = prime * result	+ ((getEinddatum() == null) ? 0 : getEinddatum().hashCode());
		result = prime * result + ((getRol() == null) ? 0 : getRol().hashCode());
		//Composite key Id
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		
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
			if (this.getEinddatum() != null && !this.getEinddatum().equals(other.getEinddatum())) {
				return false;
			}
			
			if (this.getRol() != null && !this.getRol().equals(other.getRol())) {
				return false;
			}
			
			if (this.getId().getPersoonId() !=(other.getId().getPersoonId())) {
				return false;
			}
			
			if (this.getId().getRolId() !=(other.getId().getRolId())) {
				return false;
			}
			
			if (this.getId().getBegindatum() !=(other.getId().getBegindatum())) {
				return false;
			}
			
		}
		return true;
	}
}
