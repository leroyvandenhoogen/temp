package nl.rsvier.icaras.dao.relatiebeheer;

import org.springframework.stereotype.Repository;

import nl.rsvier.icaras.core.relatiebeheer.Identiteitsbewijs;
import nl.rsvier.icaras.core.relatiebeheer.Persoon;
import nl.rsvier.icaras.dao.GenericDaoImpl;

@Repository("IIdentiteitsbewijsDao")
public class IdentiteitsbewijsDaoImpl extends GenericDaoImpl<Identiteitsbewijs> implements IIdentiteitsbewijsDao {

	public IdentiteitsbewijsDaoImpl() {
		super(Identiteitsbewijs.class);
	}
	
	@Override
	public Identiteitsbewijs getById(String id) {
		return getHibernateTemplate().get(Identiteitsbewijs.class, id);
	}
	
	@Override
	public Identiteitsbewijs getByIdEager(String id) {
		Identiteitsbewijs identiteitsbewijs = getById(id);
		getHibernateTemplate().initialize(((Persoon)identiteitsbewijs.getPersoon()));
		
		return identiteitsbewijs;
	}
}
