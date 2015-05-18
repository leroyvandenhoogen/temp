<<<<<<< HEAD
package nl.rsvier.icaras.dao.relatiebeheer;

import nl.rsvier.icaras.core.relatiebeheer.Identiteitsbewijs;

public interface IIdentiteitsbewijsDao {

	Identiteitsbewijs getById(String id);

	Identiteitsbewijs getByIdEager(String id);

}
=======
package nl.rsvier.icaras.dao.relatiebeheer;

import java.util.List;

import nl.rsvier.icaras.core.relatiebeheer.Identiteitsbewijs;

public interface IIdentiteitsbewijsDao {

	Identiteitsbewijs getById(String id);

	Identiteitsbewijs getByIdEager(String id);

	List<Identiteitsbewijs> getAllEager();

}
>>>>>>> feature/localleroy
