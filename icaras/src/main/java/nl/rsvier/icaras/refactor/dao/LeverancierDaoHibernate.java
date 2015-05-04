package nl.rsvier.icaras.refactor.dao;

import nl.rsvier.icaras.dao.GenericDaoHibernate;
import nl.rsvier.icaras.refactor.core.Leverancier;

import org.springframework.stereotype.Repository;

@Repository("ILeverancierDao")
public class LeverancierDaoHibernate extends GenericDaoHibernate<Leverancier>
		implements ILeverancierDao {

	public LeverancierDaoHibernate() {
		super(Leverancier.class);
	}
}
