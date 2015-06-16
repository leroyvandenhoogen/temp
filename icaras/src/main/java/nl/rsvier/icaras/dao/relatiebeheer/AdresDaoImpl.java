package nl.rsvier.icaras.dao.relatiebeheer;

import nl.rsvier.icaras.core.relatiebeheer.Adres;
import nl.rsvier.icaras.dao.GenericDaoImpl;

import org.springframework.stereotype.Repository;

@Repository("IAdresDao")
public class AdresDaoImpl extends GenericDaoImpl<Adres> implements IAdresDao {

	public AdresDaoImpl() {
		super(Adres.class);
	}
}
