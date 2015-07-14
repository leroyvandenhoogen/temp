package nl.rsvier.icaras.core.relatiebeheer;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "postcode", catalog = "icaras")
public class PostcodeData implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String postcode;
	private Integer minnumber;
	private Integer maxnumber;
	private String straat;
	private String stad;
	private String gemeente;
	private String provincie;
	private Double lat;
	private Double lon;
	
	public PostcodeData() {
		
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name= "id", nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name= "postcode", nullable = false, length = 7)
	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	@Column(name = "minnumber", nullable = false, length = 10)
	public Integer getMinnumber() {
		return minnumber;
	}

	public void setMinnumber(Integer minnumber) {
		this.minnumber = minnumber;
	}
	
	@Column(name = "maxnumber", nullable = false, length = 10)
	public Integer getMaxnumber() {
		return maxnumber;
	}

	public void setMaxnumber(Integer maxnumber) {
		this.maxnumber = maxnumber;
	}

	@Column(name = "street", nullable = false, length = 100)
	public String getStraat() {
		return straat;
	}

	public void setStraat(String straat) {
		this.straat = straat;
	}

	@Column(name = "city", nullable = false, length = 100)
	public String getStad() {
		return stad;
	}

	public void setStad(String stad) {
		this.stad = stad;
	}

	@Column(name = "municipality", length = 100)
	public String getGemeente() {
		return gemeente;
	}

	public void setGemeente(String gemeente) {
		this.gemeente = gemeente;
	}

	@Column(name = "province")
	public String getProvincie() {
		return provincie;
	}

	public void setProvincie(String provincie) {
		this.provincie = provincie;
	}

	@Column(name = "lat")
	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	@Column(name = "lon")
	public Double getLon() {
		return lon;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}

	@Override
	public String toString() {
		return "PostcodeData [postcode=" + postcode + ", straat=" + straat
				+ ", stad=" + stad + ", provincie=" + provincie + "]";
	}

	
	
	
}
