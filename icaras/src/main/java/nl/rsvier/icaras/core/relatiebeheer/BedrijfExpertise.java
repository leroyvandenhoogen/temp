package nl.rsvier.icaras.core.relatiebeheer;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bedrijf_expertise", catalog = "icaras")
public class BedrijfExpertise implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Expertise expertise;
	private Bedrijf bedrijf;
	
	public BedrijfExpertise() {
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId(){
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "expertise_id", nullable = false)
	public Expertise getExpertise() {
		return expertise;
	}

	public void setExpertise(Expertise expertise) {
		this.expertise = expertise;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bedrijf_id", nullable = false)
	public Bedrijf getBedrijf() {
		return bedrijf;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result	+ ((getExpertise() == null) ? 0 : getExpertise().hashCode());
		
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj == null || !(obj instanceof BedrijfExpertise)) {
			return false;
		} else {
			BedrijfExpertise other = (BedrijfExpertise) obj;

			if (this.getExpertise() != null && !this.getExpertise().equals(other.getExpertise())) {
				return false;
			}

		}
		return true;
	}
}
