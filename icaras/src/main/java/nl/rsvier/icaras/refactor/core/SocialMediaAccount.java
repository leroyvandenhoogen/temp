package nl.rsvier.icaras.refactor.core;

public abstract class SocialMediaAccount extends Nfa {

	private static final long serialVersionUID = 1L;

	public SocialMediaAccount(NfaSoort nfaSoort) {
		super(nfaSoort);
	}

	public abstract void post(String message);//illustratiemethode
		
	
}