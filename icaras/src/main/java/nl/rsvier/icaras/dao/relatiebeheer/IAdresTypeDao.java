package nl.rsvier.icaras.dao.relatiebeheer;

import nl.rsvier.icaras.core.relatiebeheer.Adres;

public interface IAdresTypeDao {

	boolean addAdresType(String adresType, Adres adres);
}
