package gestionale.magazzino.suite;

import gestionale.magazzino.ControlloreTest;
import gestionale.magazzino.EmailValidatorTest;
import gestionale.magazzino.models.AcquistoTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.sun.org.apache.xml.internal.serializer.utils.Utils;

/**
 * Effettua tutti i test.
 * @author <a href="https://github.com/DavidePastore">Davide Pastore</a>
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ 
	ControlloreTest.class,
	EmailValidatorTest.class,
	AcquistoTest.class,
	Utils.class 
})
public class AllTests {

}
