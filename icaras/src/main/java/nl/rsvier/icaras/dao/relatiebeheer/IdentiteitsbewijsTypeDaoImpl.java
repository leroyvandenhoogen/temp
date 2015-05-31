package nl.rsvier.icaras.dao.relatiebeheer;

import java.util.List;

import org.springframework.stereotype.Repository;

import nl.rsvier.icaras.core.relatiebeheer.DigitaalAdres;
import nl.rsvier.icaras.core.relatiebeheer.DigitaalAdresType;
import nl.rsvier.icaras.core.relatiebeheer.Identiteitsbewijs;
import nl.rsvier.icaras.core.relatiebeheer.IdentiteitsbewijsType;
import nl.rsvier.icaras.dao.GenericDaoImpl;

@Repository("IIdentiteitsbewijsTypeDao")
public class IdentiteitsbewijsTypeDaoImpl extends GenericDaoImpl<IdentiteitsbewijsType> implements IIdentiteitsbewijsTypeDao {

	public IdentiteitsbewijsTypeDaoImpl() {
		super(IdentiteitsbewijsType.class);
	}

	public boolean addIdentiteitsbewijsType(String identiteitsBewijsType, Identiteitsbewijs identiteitsbewijs) {
		List<IdentiteitsbewijsType> identiteitsbewijsTypes = getAll();
		for(IdentiteitsbewijsType idtype : identiteitsbewijsTypes) {
			if(idtype.getType().equalsIgnoreCase(identiteitsBewijsType)) {
				 identiteitsbewijs.setIdentiteitsbewijsType(idtype);
					return true;
				}
			}
		return false;
	}
}
