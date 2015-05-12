package nl.rsvier.icaras.refactor.dao;

import org.springframework.stereotype.Repository;

import nl.rsvier.icaras.dao.GenericDaoImpl;
import nl.rsvier.icaras.refactor.core.Arbeidsovereenkomst;

@Repository("IArbeidsovereenkomstDao")
public class ArbeidsovereenkomstDaoHibernate extends
		GenericDaoImpl<Arbeidsovereenkomst> implements
		IArbeidsovereenkomstDao {

	public ArbeidsovereenkomstDaoHibernate() {
		super(Arbeidsovereenkomst.class);
	}
}
