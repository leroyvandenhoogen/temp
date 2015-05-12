package nl.rsvier.icaras.dao.relatiebeheer;

import org.springframework.stereotype.Repository;

import nl.rsvier.icaras.core.relatiebeheer.Identiteitsbewijs;
import nl.rsvier.icaras.dao.GenericDaoImpl;

@Repository("IIdentiteitsbewijsDao")
public class IdentiteitsbewijsDaoImpl extends GenericDaoImpl<Identiteitsbewijs> implements IIdentiteitsbewijsDao {

	public IdentiteitsbewijsDaoImpl() {
		super(Identiteitsbewijs.class);
	}

}
