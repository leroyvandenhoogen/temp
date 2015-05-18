package nl.rsvier.icaras.dao.relatiebeheer;

import org.springframework.stereotype.Repository;

import nl.rsvier.icaras.core.relatiebeheer.Persoonsrol;
import nl.rsvier.icaras.dao.GenericDaoImpl;

@Repository("IPersoonsrolDao")
public class PersoonsrolDaoImpl extends GenericDaoImpl<Persoonsrol> implements IPersoonsrolDao {

	public PersoonsrolDaoImpl() {
		super(Persoonsrol.class);
	}

}
