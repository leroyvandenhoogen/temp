package nl.rsvier.icaras.core;

import nl.rsvier.icaras.core.relatiebeheer.DigitaalAdresTest;
import nl.rsvier.icaras.core.relatiebeheer.IdentiteitsbewijsTest;
import nl.rsvier.icaras.core.relatiebeheer.PersoonTest;
import nl.rsvier.icaras.core.relatiebeheer.PersoonsrolTest;
import nl.rsvier.icaras.refactor.core.AdresTest;
import nl.rsvier.icaras.refactor.core.BedrijfTest;
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