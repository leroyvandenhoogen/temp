package nl.rsvier.icaras.dao.relatiebeheer;

import java.util.List;

import nl.rsvier.icaras.core.relatiebeheer.Persoon;

public interface IPersoonDao {
	List<Persoon> search(String voornaamAchternaam);

}
