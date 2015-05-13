package nl.rsvier.icaras.dao.relatiebeheer;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Deze klasse is bedoeld om alle DaoTests gezamenlijk te runnen binnen dezelfde
 * Spring-test. Het opstarten van de ApplicationContext (inclusief het genereren
 * van het databaseschema) hoeft hierdoor maar eenmalig te gebeuren voor alle
 * tests.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({AdresDaoImplTest.class, BedrijfDaoImplTest.class, DigitaalAdresDaoImplTest.class, 
					IdentiteitsbewijsDaoImplTest.class, PersoonDaoImplTest.class})
public class DaoTestSuite {

}
