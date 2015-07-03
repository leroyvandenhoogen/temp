package nl.rsvier.icaras.dao.relatiebeheer;

import nl.rsvier.icaras.core.relatiebeheer.BedrijfExpertise;
import nl.rsvier.icaras.dao.GenericDaoImpl;

public class BedrijfExpertiseDaoImpl extends GenericDaoImpl<BedrijfExpertise> implements IBedrijfExpertiseDao {

	public BedrijfExpertiseDaoImpl() {
		super(BedrijfExpertise.class);
	}
}
