package nl.rsvier.icaras.dao.relatiebeheer;

import java.util.List;

import nl.rsvier.icaras.core.relatiebeheer.DigitaalAdres;
import nl.rsvier.icaras.core.relatiebeheer.DigitaalAdresType;
import nl.rsvier.icaras.core.relatiebeheer.Persoonsrol;
import nl.rsvier.icaras.core.relatiebeheer.Rol;
import nl.rsvier.icaras.dao.GenericDaoImpl;

import org.springframework.stereotype.Repository;

@Repository("IRolDao")
public class RolDaoImpl extends GenericDaoImpl<Rol> implements IRolDao {

	public RolDaoImpl() {
		super(Rol.class);
	}

	@Override
	public boolean addRol(String rol, Persoonsrol persoonsrol) {
		List<Rol> rollen = getAll();
		for(Rol r : rollen) {
			if(r.getType().equalsIgnoreCase(rol)) {
				 persoonsrol.setRol(r);
					return true;
				}
			}
		return false;
	}
}
