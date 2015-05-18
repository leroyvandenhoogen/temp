package nl.rsvier.icaras.dao.relatiebeheer;

import nl.rsvier.icaras.core.relatiebeheer.DigitaalAdres;
import nl.rsvier.icaras.dao.GenericDaoImpl;

import org.springframework.stereotype.Repository;

@Repository("IDigitaalAdresDao")
public class DigitaalAdresDaoImpl extends GenericDaoImpl<DigitaalAdres> implements IDigitaalAdresDao {

	public DigitaalAdresDaoImpl() {
		super(DigitaalAdres.class);
	}

}
