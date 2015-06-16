package nl.rsvier.icaras.dao.relatiebeheer;

import java.util.List;

import nl.rsvier.icaras.core.relatiebeheer.Bedrijf;

public interface IBedrijfDao {
	List<Bedrijf> search(String naam);

}
