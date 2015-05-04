package nl.rsvier.icaras.refactor.core;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Website")
public class Website extends Nfa {

	private static final long serialVersionUID = 1L;

	public Website() {
		super(NfaSoort.WEBSITE);
	}

}
