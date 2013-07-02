package gestionale.magazzino;

import gestionale.magazzino.models.AcquistoTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Effettua tutti i test.
 * @author <a href="https://github.com/DavidePastore">Davide Pastore</a>
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ ControlloreTest.class, EmailValidatorTest.class, AcquistoTest.class })
public class AllTests {

}
