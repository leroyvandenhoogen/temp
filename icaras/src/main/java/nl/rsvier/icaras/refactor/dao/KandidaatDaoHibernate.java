package nl.rsvier.icaras.refactor.dao;

import org.springframework.stereotype.Repository;

import nl.rsvier.icaras.dao.GenericDaoImpl;
import nl.rsvier.icaras.refactor.core.Kandidaat;

@Repository("IKandidaatDao")
public class KandidaatDaoHibernate extends GenericDaoImpl<Kandidaat> implements IKandidaatDao {
	
	public KandidaatDaoHibernate() {
		super(Kandidaat.class);
	}
}
