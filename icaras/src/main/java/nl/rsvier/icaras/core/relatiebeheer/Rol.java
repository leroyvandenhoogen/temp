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
@Table(name = "rol", catalog = "icaras")
public class Rol implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Set<Persoonsrol> persoonsrollen = new HashSet<Persoonsrol>(0);

	public Rol() {
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rol")
	public Set<Persoonsrol> getPersoonsrols() {
		return this.persoonsrollen;
	}

	public void setPersoonsrols(Set<Persoonsrol> persoonsrollen) {
		this.persoonsrollen = persoonsrollen;
	}

}
