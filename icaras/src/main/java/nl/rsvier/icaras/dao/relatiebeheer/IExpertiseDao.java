package nl.rsvier.icaras.dao.relatiebeheer;

import nl.rsvier.icaras.core.relatiebeheer.BedrijfExpertise;

public interface IExpertiseDao {
	
	boolean addExpertise(String expertise, BedrijfExpertise bedrijfExpertise);

}
