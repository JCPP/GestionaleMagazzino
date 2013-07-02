package gestionale.magazzino;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Effettua tutti i test.
 * @author <a href="https://github.com/DavidePastore">Davide Pastore</a>
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ ControlloreTest.class, EmailValidatorTest.class })
public class AllTests {

}
