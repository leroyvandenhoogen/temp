package nl.rsvier.icaras.core;

import nl.rsvier.icaras.refactor.core.AanbiedingTest;
import nl.rsvier.icaras.refactor.core.AdresTest;
import nl.rsvier.icaras.refactor.core.BedrijfTest;
import nl.rsvier.icaras.refactor.core.ContactpersoonTest;
import nl.rsvier.icaras.refactor.core.CorrespondentieAdresTest;
import nl.rsvier.icaras.refactor.core.LeverancierTest;
import nl.rsvier.icaras.refactor.core.NfaTest;
import nl.rsvier.icaras.refactor.core.OrganisatieTest;
import nl.rsvier.icaras.refactor.core.PersoonKandidaatCVGeneratorTest;
import nl.rsvier.icaras.refactor.core.RelatiebeheerVerbindingsklassenTest;
import nl.rsvier.icaras.refactor.core.VacatureTest;

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
@Suite.SuiteClasses({ AdresTest.class, NfaTest.class,
		CorrespondentieAdresTest.class,

		PersoonKandidaatCVGeneratorTest.class,
		RelatiebeheerVerbindingsklassenTest.class,

		OrganisatieTest.class,
		// wordt door RelatiebeheerVerbindingsklassenTest gedekt.
		// BedrijfTest.class,
		LeverancierTest.class,
		ContactpersoonTest.class, LeverancierTest.class,

		AanbiedingTest.class, VacatureTest.class, })
public class CoreTestSuite {

}