package nl.rsvier.icaras.dao.relatiebeheer;

import nl.rsvier.icaras.core.relatiebeheer.BedrijfExpertise;
import nl.rsvier.icaras.dao.GenericDaoImpl;

import org.springframework.stereotype.Repository;

@Repository("IBedrijfExpertiseDao")
public class BedrijfExpertiseDaoImpl extends GenericDaoImpl<BedrijfExpertise> implements IBedrijfExpertiseDao {

	public BedrijfExpertiseDaoImpl() {
		super(BedrijfExpertise.class);
	}
}
