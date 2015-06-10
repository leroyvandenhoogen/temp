package nl.rsvier.icaras.dao.relatiebeheer;

import java.util.List;

import nl.rsvier.icaras.core.relatiebeheer.Adres;
import nl.rsvier.icaras.core.relatiebeheer.AdresType;
import nl.rsvier.icaras.dao.GenericDaoImpl;

import org.springframework.stereotype.Repository;

@Repository("IAdresTypeDao")
public class AdresTypeDaoImpl extends GenericDaoImpl<AdresType> implements IAdresTypeDao {

	public AdresTypeDaoImpl() {
		super(AdresType.class);
	}

	public boolean addAdresType(String adresType, Adres adres) {
		List<AdresType> adresTypes = getAll();
		for(AdresType at : adresTypes) {
			if(at.getType().equalsIgnoreCase(adresType)) {
				 adres.setAdresType(at);
					return true;
				}
			}
		return false;
	}
}
