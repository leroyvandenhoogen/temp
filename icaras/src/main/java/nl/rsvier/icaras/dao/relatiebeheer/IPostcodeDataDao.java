package nl.rsvier.icaras.dao.relatiebeheer;

import nl.rsvier.icaras.core.relatiebeheer.Adres;

public interface IPostcodeDataDao {

	public Adres zoekAdres(String postcode);
}
