package nl.rsvier.icaras.refactor.dao;

import nl.rsvier.icaras.dao.GenericDaoImpl;
import nl.rsvier.icaras.refactor.core.Vacature;

import org.springframework.stereotype.Repository;

/*
 * Annotatie @Repository zorgt ook voor (aanmelding voor) translatie van
 * exceptions naar Spring
 */
@Repository("IVacatureDao")
public class VacatureDaoHibernate extends GenericDaoImpl<Vacature>
		implements IVacatureDao {

	public VacatureDaoHibernate() {
		super(Vacature.class);
	}

	@Override
	public void delete(Vacature entity) {
		entity.removeAllReferences(); // TODO: SERVICELAAG
		super.delete(entity);
	}

}
