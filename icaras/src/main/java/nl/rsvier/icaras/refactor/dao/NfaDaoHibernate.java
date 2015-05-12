package nl.rsvier.icaras.refactor.dao;

import nl.rsvier.icaras.dao.GenericDaoImpl;
import nl.rsvier.icaras.refactor.core.Nfa;

import org.springframework.stereotype.Repository;
@Repository("INfaDao")
public class NfaDaoHibernate extends GenericDaoImpl<Nfa> implements INfaDao {

	public NfaDaoHibernate() {
		super(Nfa.class);
	}	
}
