
package nl.rsvier.icaras.core.relatiebeheer;

import javax.persistence.Entity;

import nl.rsvier.icaras.core.IEntity;

@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name = "persoonsrol_type", discriminatorType = DiscriminatorType.STRING)
public abstract class PersoonsRol extends Rol implements IEntity {

	private static final long serialVersionUID = 1L;
	

}
