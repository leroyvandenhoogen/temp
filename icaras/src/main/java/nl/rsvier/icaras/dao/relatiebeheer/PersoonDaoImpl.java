package nl.rsvier.icaras.dao.relatiebeheer;

import org.springframework.stereotype.Repository;

import nl.rsvier.icaras.core.relatiebeheer.Persoon;
import nl.rsvier.icaras.dao.GenericDaoImpl;

@Repository("IPersoonDao")
public class PersoonDaoImpl extends GenericDaoImpl<Persoon> implements IPersoonDao {

	public PersoonDaoImpl() {
		super(Persoon.class);
	}
	
}
