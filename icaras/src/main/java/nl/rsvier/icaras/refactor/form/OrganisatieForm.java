package nl.rsvier.icaras.refactor.form;

import nl.rsvier.icaras.refactor.core.Organisatie;

import org.hibernate.validator.constraints.Length;

public class OrganisatieForm {

	private int id;

	@Length(min = 2, max = 100, message = "Vul de naam van de organisatie in")
	private String naam;

	public OrganisatieForm() {

	}

	public OrganisatieForm(Organisatie organisatie) {
		this.setId(organisatie.getId());
		this.setNaam(organisatie.getNaam());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaam() {
		return this.naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

}
