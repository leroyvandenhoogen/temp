package nl.rsvier.icaras.refactor.dao;

import org.springframework.stereotype.Repository;

import nl.rsvier.icaras.dao.GenericDaoHibernate;
import nl.rsvier.icaras.refactor.core.Arbeidsovereenkomst;

@Repository("IArbeidsovereenkomstDao")
public class ArbeidsovereenkomstDaoHibernate extends
		GenericDaoHibernate<Arbeidsovereenkomst> implements
		IArbeidsovereenkomstDao {

	public ArbeidsovereenkomstDaoHibernate() {
		super(Arbeidsovereenkomst.class);
	}
}
