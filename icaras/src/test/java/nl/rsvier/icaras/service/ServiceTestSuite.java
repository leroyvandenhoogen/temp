package nl.rsvier.icaras.service;

import nl.rsvier.icaras.refactor.service.PersoonOrganisatieServiceTest;
import nl.rsvier.icaras.refactor.service.RelatieAdresNfaTest;
import nl.rsvier.icaras.refactor.service.RelatieServiceTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Deze klasse is bedoeld om alle Core Tests gezamenlijk te runnen binnen
 * dezelfde JUnit test.
 * 
 * @author Gerben
 * @author Gordon
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	RelatieAdresNfaTest.class, 
	RelatieServiceTest.class,
	PersoonOrganisatieServiceTest.class
})
public class ServiceTestSuite {

}