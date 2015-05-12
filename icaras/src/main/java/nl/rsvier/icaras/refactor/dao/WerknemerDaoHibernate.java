package nl.rsvier.icaras.refactor.dao;

import org.springframework.stereotype.Repository;

import nl.rsvier.icaras.dao.GenericDaoImpl;
import nl.rsvier.icaras.refactor.core.Werknemer;

@Repository("IWerknemerDao")
public class WerknemerDaoHibernate extends GenericDaoImpl<Werknemer> implements IWerknemerDao {

	public WerknemerDaoHibernate() {
		super(Werknemer.class);
	}
}
