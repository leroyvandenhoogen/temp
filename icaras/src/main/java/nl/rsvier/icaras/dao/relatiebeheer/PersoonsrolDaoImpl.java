package nl.rsvier.icaras.dao.relatiebeheer;

import nl.rsvier.icaras.core.relatiebeheer.Persoonsrol;
import nl.rsvier.icaras.core.relatiebeheer.PersoonsrolId;
import nl.rsvier.icaras.dao.GenericDaoImpl;

import org.springframework.stereotype.Repository;

@Repository("IPersoonsrolDao")
public class PersoonsrolDaoImpl extends GenericDaoImpl<Persoonsrol> implements IPersoonsrolDao {

	public PersoonsrolDaoImpl() {
		super(Persoonsrol.class);
	}
	
	public Persoonsrol getById(PersoonsrolId id) {
		 return (Persoonsrol)getHibernateTemplate().get(Persoonsrol.class, id);
	}
}
