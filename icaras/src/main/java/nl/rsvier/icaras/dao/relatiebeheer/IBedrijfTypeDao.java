package nl.rsvier.icaras.dao.relatiebeheer;

import nl.rsvier.icaras.core.relatiebeheer.Bedrijf;

public interface IBedrijfTypeDao {

	boolean addType(String type, Bedrijf bedrijf);
}
