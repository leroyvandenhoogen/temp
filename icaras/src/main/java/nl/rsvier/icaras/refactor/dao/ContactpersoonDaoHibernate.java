package nl.rsvier.icaras.refactor.dao;

import nl.rsvier.icaras.dao.GenericDaoHibernate;
import nl.rsvier.icaras.refactor.core.Contactpersoon;

import org.springframework.stereotype.Repository;

@Repository("IContactpersoonDao")
public class ContactpersoonDaoHibernate extends
		GenericDaoHibernate<Contactpersoon> implements IContactpersoonDao {

	public ContactpersoonDaoHibernate() {
		super(Contactpersoon.class);
	}

}
