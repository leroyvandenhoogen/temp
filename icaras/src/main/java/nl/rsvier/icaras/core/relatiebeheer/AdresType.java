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
@Table(name = "adres_type", catalog = "icaras")
public class AdresType implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String type;
	private Set<Adres> adressen = new HashSet<Adres>(0);

	public AdresType() {
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "adresType")
	public Set<Adres> getAdreses() {
		return this.adressen;
	}

	public void setAdreses(Set<Adres> adressen) {
		this.adressen = adressen;
	}

}
