package nl.rsvier.icaras.refactor.core;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Email")
public class Email extends Nfa {

	private static final long serialVersionUID = 1L;

	public Email() {
		super(NfaSoort.EMAIL);
	}

}
