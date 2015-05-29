package nl.rsvier.icaras.dao.relatiebeheer;

import java.util.List;

import nl.rsvier.icaras.core.relatiebeheer.DigitaalAdres;
import nl.rsvier.icaras.core.relatiebeheer.DigitaalAdresType;
import nl.rsvier.icaras.dao.GenericDaoImpl;

import org.springframework.stereotype.Repository;

@Repository("IDigitaalAdresTypeDao")
public class DigitaalAdresTypeDaoImpl extends GenericDaoImpl<DigitaalAdresType> implements IDigitaalAdresTypeDao {

	public DigitaalAdresTypeDaoImpl() {
		super(DigitaalAdresType.class);
	}

	public boolean addDigitaalAdresType(String digitaalAdresType, DigitaalAdres digitaalAdres) {
		List<DigitaalAdresType> digitaalAdresTypes = getAll();
		for(DigitaalAdresType dat : digitaalAdresTypes) {
			if(dat.getType().equalsIgnoreCase(digitaalAdresType)) {
				 digitaalAdres.setDigitaalAdresType(dat);
					return true;
				}
			}
		return false;
	}
}
