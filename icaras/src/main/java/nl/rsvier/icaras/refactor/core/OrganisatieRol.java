
package nl.rsvier.icaras.refactor.core;

import javax.persistence.Entity;

@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name = "organisatierol_type", discriminatorType = DiscriminatorType.STRING)
public abstract class OrganisatieRol extends Rol implements IEntity {

	private static final long serialVersionUID = 1L;
	

}
