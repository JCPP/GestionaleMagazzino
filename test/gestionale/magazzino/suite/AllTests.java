package gestionale.magazzino.suite;

import gestionale.magazzino.AllMainTests;
import gestionale.magazzino.models.AllModelsTests;
import gestionale.magazzino.models.utils.UtilsTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


/**
 * Effettua tutti i test.
 * @author <a href="https://github.com/DavidePastore">Davide Pastore</a>
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ 
	AllMainTests.class,
	AllModelsTests.class,
	UtilsTest.class 
})
public class AllTests {

}
