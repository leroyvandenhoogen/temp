package nl.rsvier.icaras.refactor.core;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("Fax")
public class Fax extends Nfa {

	private static final long serialVersionUID = 1L;

	public Fax() {
		super(NfaSoort.FAX);
	}

}
