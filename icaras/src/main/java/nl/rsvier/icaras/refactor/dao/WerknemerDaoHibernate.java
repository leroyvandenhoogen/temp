package nl.rsvier.icaras.refactor.dao;

import org.springframework.stereotype.Repository;

import nl.rsvier.icaras.dao.GenericDaoHibernate;
import nl.rsvier.icaras.refactor.core.Werknemer;

@Repository("IWerknemerDao")
public class WerknemerDaoHibernate extends GenericDaoHibernate<Werknemer> implements IWerknemerDao {

	public WerknemerDaoHibernate() {
		super(Werknemer.class);
	}
}
