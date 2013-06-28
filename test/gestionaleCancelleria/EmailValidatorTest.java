package gestionaleCancelleria;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmailValidatorTest {
	
	private EmailValidator emailValidator;
	private String email;
	
	@Before
	public void before(){
		emailValidator = new EmailValidator();
	}

	@Test
	public void testValidate() {
		email = "";
		assertFalse("Controllo email errato", emailValidator.validate(email));
		
		email = "asd";
		assertFalse("Controllo email errato", emailValidator.validate(email));
	}

}
