package nl.rsvier.icaras.refactor.dao;

import org.springframework.stereotype.Repository;

import nl.rsvier.icaras.dao.GenericDaoHibernate;
import nl.rsvier.icaras.refactor.core.Kandidaat;

@Repository("IKandidaatDao")
public class KandidaatDaoHibernate extends GenericDaoHibernate<Kandidaat> implements IKandidaatDao {
	
	public KandidaatDaoHibernate() {
		super(Kandidaat.class);
	}
}
