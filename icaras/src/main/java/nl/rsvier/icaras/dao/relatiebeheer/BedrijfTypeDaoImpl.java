package nl.rsvier.icaras.dao.relatiebeheer;

import java.util.List;

import nl.rsvier.icaras.core.relatiebeheer.Bedrijf;
import nl.rsvier.icaras.core.relatiebeheer.BedrijfType;
import nl.rsvier.icaras.dao.GenericDaoImpl;

import org.springframework.stereotype.Repository;

@Repository("IBedrijfTypeDao")
public class BedrijfTypeDaoImpl extends GenericDaoImpl<BedrijfType> implements
		IBedrijfTypeDao {

	public BedrijfTypeDaoImpl() {
		super(BedrijfType.class);
	}

	@Override
	public boolean addType(String type, Bedrijf bedrijf) {
		List<BedrijfType> types = getAll();
		for (BedrijfType t : types) {
			if (t.getType().equalsIgnoreCase(type)) {
				bedrijf.setBedrijfType(t);
				return true;
			}
		}
		return false;
	}

}
