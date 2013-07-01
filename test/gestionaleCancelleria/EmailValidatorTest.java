package gestionaleCancelleria;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmailValidatorTest {
	
	private EmailValidator emailValidator;
	private String emailFalse[]; //Contiene tutte le email per le quali il risultato sarà false
	private String emailTrue[]; //Contiene tutte le email per le quali il risultato sarà true
	
	@Before
	public void before(){
		emailValidator = new EmailValidator();
		emailFalse = new String[]{
			"", 					//Stringa vuota
			"asd",					//Stringa senza @
			"asd@gmail.comasd@sd",	//Stringa con doppia @
			"asd@sadasd",			//Stringa senza .
			"asd @asdasd.cs"		//Indirizzo con spazio
		};
		
		emailTrue = new String[]{
			"asd@asd.com",			//Indirizzo email normale
			"qwerty1@asd.com"		//Indirizzo email con numero
		};
	}

	@Test
	public void testValidate() {
		for (String email : emailFalse){
			assertFalse("Controllo email errato", emailValidator.validate(email));
		}
		
		for (String email : emailTrue){
			assertTrue("Controllo email errato", emailValidator.validate(email));
		}
	}

}
