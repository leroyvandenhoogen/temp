package nl.rsvier.icaras.refactor.dao;

import org.springframework.stereotype.Repository;

import nl.rsvier.icaras.dao.GenericDaoImpl;
import nl.rsvier.icaras.refactor.core.OrganisatieRol;

@Repository("IOrganisatieRolDaoHibernate")
public class OrganisatieRolDaoHibernate extends GenericDaoImpl<OrganisatieRol> implements IOrganisatieRolDaoHibernate {

	public OrganisatieRolDaoHibernate() {
		super(OrganisatieRol.class);
	}
}
