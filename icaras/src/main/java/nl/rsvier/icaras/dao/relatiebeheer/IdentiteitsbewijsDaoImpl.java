package nl.rsvier.icaras.dao.relatiebeheer;

import nl.rsvier.icaras.core.relatiebeheer.Identiteitsbewijs;
import nl.rsvier.icaras.core.relatiebeheer.Persoon;
import nl.rsvier.icaras.dao.GenericDaoImpl;

import org.springframework.stereotype.Repository;

@Repository("IIdentiteitsbewijsDao")
public class IdentiteitsbewijsDaoImpl extends GenericDaoImpl<Identiteitsbewijs> implements IIdentiteitsbewijsDao {

	public IdentiteitsbewijsDaoImpl() {
		super(Identiteitsbewijs.class);
	}
	
	public Identiteitsbewijs getById(String id) {
		return getHibernateTemplate().get(Identiteitsbewijs.class, id);
	}
	
	public Identiteitsbewijs getByIdEager(String id) {
		Identiteitsbewijs identiteitsbewijs = getById(id);
		//TODO exception hier?
		if(identiteitsbewijs != null) {
			getHibernateTemplate().initialize(((Persoon)identiteitsbewijs.getPersoon()));
		}
		return identiteitsbewijs;
	}
	
//	@Override
//	public List<Identiteitsbewijs> getAllEager() {
//		List<Identiteitsbewijs> identiteitsbewijsList = getAll();
//		for(Identiteitsbewijs identiteitsbewijs: identiteitsbewijsList) {
//			if(identiteitsbewijs != null) {
//				getHibernateTemplate().initialize(((Persoon)identiteitsbewijs.getPersoon()));
//			}
//		}
//		return identiteitsbewijsList;
//	}
}

