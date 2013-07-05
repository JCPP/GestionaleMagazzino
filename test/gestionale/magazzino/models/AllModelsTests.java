package gestionale.magazzino.models;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	AcquistoTest.class,
	AggiornamentoTest.class,
	DipendenteTest.class,
	FondoTest.class,
	NotificaTest.class,
	ProdottoTest.class
})
public class AllModelsTests {

}
