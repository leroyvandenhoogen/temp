package nl.rsvier.icaras.core.relatiebeheer;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Deze klasse is bedoeld om alle Core Tests gezamenlijk te runnen binnen
 * dezelfde JUnit test.
 * 
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({ AdresTest.class, BedrijfTest.class, DigitaalAdresTest.class, IdentiteitsbewijsTest.class,
					PersoonsrolTest.class, PersoonTest.class})

public class CoreTestSuite {

}