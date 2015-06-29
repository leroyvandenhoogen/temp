package nl.rsvier.icaras.core.relatiebeheer;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "identiteitsbewijs_type", catalog = "icaras")
public class IdentiteitsbewijsType implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String type;

	public IdentiteitsbewijsType() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	@SuppressWarnings("unused")
	private void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "type", nullable = false, length = 45)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

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
		} else if (obj == null || !(obj instanceof IdentiteitsbewijsType)) {
			return false;
		} else {
			IdentiteitsbewijsType other = (IdentiteitsbewijsType) obj;
			if (this.getType() != null && !this.getType().equals(other.getType())) {
				return false;
			}
		}
		return true;
	}
}
