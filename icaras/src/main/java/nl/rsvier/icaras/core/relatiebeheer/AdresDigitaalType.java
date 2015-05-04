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
@Table(name = "adres_digitaal_type", catalog = "icaras")
public class AdresDigitaalType implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String type;
	private Set<AdresDigitaal> digitaleAdressen = new HashSet<AdresDigitaal>(0);

	public AdresDigitaalType() {
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "adresDigitaalType")
	public Set<AdresDigitaal> getAdresDigitaals() {
		return this.digitaleAdressen;
	}

	public void setAdresDigitaals(Set<AdresDigitaal> digitaleAdressen) {
		this.digitaleAdressen = digitaleAdressen;
	}

}
