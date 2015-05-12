package nl.rsvier.icaras.refactor.dao;

import org.springframework.stereotype.Repository;

import nl.rsvier.icaras.dao.GenericDaoImpl;
import nl.rsvier.icaras.refactor.core.PersoonsRol;

@Repository("IPersoonsRolDao")
public class PersoonsRolDaoHibernate extends GenericDaoImpl<PersoonsRol> implements IPersoonsRolDao {

	public PersoonsRolDaoHibernate() {
		super(PersoonsRol.class);
	}
	
}
