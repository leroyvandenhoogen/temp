package nl.rsvier.icaras.dao.relatiebeheer;

import nl.rsvier.icaras.core.relatiebeheer.Identiteitsbewijs;

public interface IIdentiteitsbewijsTypeDao {

	boolean addIdentiteitsbewijsType(String identiteitsBewijsType, Identiteitsbewijs identiteitsbewijs);

}
