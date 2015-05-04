package nl.rsvier.icaras.core.relatiebeheer;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "identiteitsbewijs", catalog = "icaras")
public class Identiteitsbewijs implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String nummer;
	private IdentiteitsbewijsType identiteitsbewijsType;
	private Persoon persoon;
	private Date vervaldatum;

	public Identiteitsbewijs() {
	}

	@Id
	@Column(name = "nummer", unique = true, nullable = false, length = 45)
	public String getNummer() {
		return this.nummer;
	}

	public void setNummer(String nummer) {
		this.nummer = nummer;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "identiteitsbewijs_type_id", nullable = false)
	public IdentiteitsbewijsType getIdentiteitsbewijsType() {
		return this.identiteitsbewijsType;
	}

	public void setIdentiteitsbewijsType(
			IdentiteitsbewijsType identiteitsbewijsType) {
		this.identiteitsbewijsType = identiteitsbewijsType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "persoon_id", nullable = false)
	public Persoon getPersoon() {
		return this.persoon;
	}

	public void setPersoon(Persoon persoon) {
		this.persoon = persoon;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "vervaldatum", nullable = false, length = 10)
	public Date getVervaldatum() {
		return this.vervaldatum;
	}

	public void setVervaldatum(Date vervaldatum) {
		this.vervaldatum = vervaldatum;
	}

}
