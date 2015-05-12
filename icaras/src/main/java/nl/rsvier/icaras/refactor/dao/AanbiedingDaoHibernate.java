package nl.rsvier.icaras.refactor.dao;

import nl.rsvier.icaras.dao.GenericDaoImpl;
import nl.rsvier.icaras.refactor.core.Aanbieding;

import org.springframework.stereotype.Repository;

/*
 * Annotatie @Repository zorgt ook voor (aanmelding voor) translatie van
 * exceptions naar Spring
 */
@Repository("IAanbiedingDao")
public class AanbiedingDaoHibernate extends GenericDaoImpl<Aanbieding>
		implements IAanbiedingDao {

	public AanbiedingDaoHibernate() {
		super(Aanbieding.class);
	}

	@Override
	public void delete(Aanbieding entity) {
		entity.removeAllReferences();
		super.delete(entity);
	}

}
