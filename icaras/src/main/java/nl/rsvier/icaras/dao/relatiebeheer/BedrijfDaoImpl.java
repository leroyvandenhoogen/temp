package nl.rsvier.icaras.dao.relatiebeheer;

import nl.rsvier.icaras.core.relatiebeheer.Bedrijf;
import nl.rsvier.icaras.dao.GenericDaoImpl;

import org.springframework.stereotype.Repository;

@Repository("IBedrijfDao")
public class BedrijfDaoImpl extends GenericDaoImpl<Bedrijf> implements IBedrijfDao {

	public BedrijfDaoImpl() {
		super(Bedrijf.class);
	}

}
