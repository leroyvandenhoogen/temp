package nl.rsvier.icaras.dao.relatiebeheer;

import java.util.List;

import nl.rsvier.icaras.core.relatiebeheer.BedrijfExpertise;
import nl.rsvier.icaras.core.relatiebeheer.Expertise;
import nl.rsvier.icaras.dao.GenericDaoImpl;

public class ExpertiseDaoImpl extends GenericDaoImpl<Expertise> implements IExpertiseDao {
	
	public ExpertiseDaoImpl() {
		super(Expertise.class);
	}

	@Override
	public boolean addExpertise(String expertise,
			BedrijfExpertise bedrijfExpertise) {
		List<Expertise> expertises = getAll();
		for(Expertise e: expertises) {
			if(e.getType().equalsIgnoreCase(expertise)) {
				bedrijfExpertise.setExpertise(e);
				return true;
			}
		}
		return false;
	}

}
