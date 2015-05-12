package nl.rsvier.icaras.refactor.dao;

import nl.rsvier.icaras.dao.GenericDaoImpl;
import nl.rsvier.icaras.refactor.core.Leverancier;

import org.springframework.stereotype.Repository;

@Repository("ILeverancierDao")
public class LeverancierDaoHibernate extends GenericDaoImpl<Leverancier>
		implements ILeverancierDao {

	public LeverancierDaoHibernate() {
		super(Leverancier.class);
	}
}
