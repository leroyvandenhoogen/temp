package nl.rsvier.icaras.refactor.core;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Telefoonnummer")
public class TelefoonNummer extends Nfa {

	private static final long serialVersionUID = 1L;

	public TelefoonNummer() {
		super(NfaSoort.TELEFOONNUMMER);
	}

}
