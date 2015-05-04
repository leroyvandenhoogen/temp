package nl.rsvier.icaras.refactor.dao;

import org.springframework.stereotype.Repository;

import nl.rsvier.icaras.dao.GenericDaoHibernate;
import nl.rsvier.icaras.refactor.core.OrganisatieRol;

@Repository("IOrganisatieRolDaoHibernate")
public class OrganisatieRolDaoHibernate extends GenericDaoHibernate<OrganisatieRol> implements IOrganisatieRolDaoHibernate {

	public OrganisatieRolDaoHibernate() {
		super(OrganisatieRol.class);
	}
}
