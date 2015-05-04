package nl.rsvier.icaras.dao;

import nl.rsvier.icaras.refactor.dao.AanbiedingDaoHibernateTest;
import nl.rsvier.icaras.refactor.dao.AdresDaoHibernateTest;
import nl.rsvier.icaras.refactor.dao.NfaDaoHibernateTest;
import nl.rsvier.icaras.refactor.dao.OrganisatieDaoHibernateTest;
import nl.rsvier.icaras.refactor.dao.OrganisatieRolDaoHibernateTest;
import nl.rsvier.icaras.refactor.dao.PersoonsRolDaoHibernateTest;
import nl.rsvier.icaras.refactor.dao.RelatieDaoHibernateTest;
import nl.rsvier.icaras.refactor.dao.TestDaoAdapterTest;
import nl.rsvier.icaras.refactor.dao.VacatureDaoHibernateTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Deze klasse is bedoeld om alle DaoTests gezamenlijk te runnen binnen dezelfde
 * Spring-test. Het opstarten van de ApplicationContext (inclusief het genereren
 * van het databaseschema) hoeft hierdoor maar eenmalig te gebeuren voor alle
 * tests.
 * 
 * @author Gerben
 * @author Gordon
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	AdresDaoHibernateTest.class, 
	NfaDaoHibernateTest.class,

	OrganisatieDaoHibernateTest.class, 
	RelatieDaoHibernateTest.class, 
	
	PersoonsRolDaoHibernateTest.class,
	OrganisatieRolDaoHibernateTest.class,
	
	AanbiedingDaoHibernateTest.class, 
	VacatureDaoHibernateTest.class, 
	
	TestDaoAdapterTest.class
})
public class DaoTestSuite {

}
