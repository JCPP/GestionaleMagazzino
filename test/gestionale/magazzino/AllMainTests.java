package gestionale.magazzino;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	ControlloreTest.class,
	EmailValidatorTest.class
})
public class AllMainTests {

}
