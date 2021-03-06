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
@Table(name = "digitaal_adres_type", catalog = "icaras")
public class DigitaalAdresType implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String type;
//	private Set<DigitaalAdres> digitaleAdressen = new HashSet<DigitaalAdres>(0);

	public DigitaalAdresType() {
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

	@Column(name = "type", nullable = false, length = 45)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "digitaalAdresType")
//	public Set<DigitaalAdres> getDigitaleAdressen() {
//		return this.digitaleAdressen;
//	}
//
//	public void setDigitaleAdressen(Set<DigitaalAdres> digitaleAdressen) {
//		this.digitaleAdressen = digitaleAdressen;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
		
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj == null || !(obj instanceof DigitaalAdresType)) {
			return false;
		} else {
			DigitaalAdresType other = (DigitaalAdresType) obj;
			if (this.getType() != null && !this.getType().equals(other.getType())) {
				return false;
			}
		}
		return true;
	}
}
