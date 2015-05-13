package nl.rsvier.icaras;

import nl.rsvier.icaras.core.relatiebeheer.CoreTestSuite;
import nl.rsvier.icaras.dao.relatiebeheer.DaoTestSuite;
import nl.rsvier.icaras.service.ServiceTestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	CoreTestSuite.class,
	DaoTestSuite.class, 
	ServiceTestSuite.class,
})
public class TestSuiteContainer {

}
