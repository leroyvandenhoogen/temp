package nl.rsvier.icaras.refactor.core;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("Facebook")
public class Facebook extends SocialMediaAccount {

	private static final long serialVersionUID = 1L;

	public Facebook() {
		super(NfaSoort.FACEBOOK);
	}

	@Override
	public void post(String message) {
		// TODO Auto-generated method stub
		
	}

}
