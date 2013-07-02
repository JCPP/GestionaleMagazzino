package gestionale.magazzino;

import static org.junit.Assert.*;
import gestionale.magazzino.Controllore;

import org.junit.Before;
import org.junit.Test;

/**
 * Test per la classe Controllore.
 * @author <a href="https://github.com/DavidePastore">Davide Pastore</a>
 *
 */
public class ControlloreTest {
	
	private String password;
	private Controllore controllore;

	@Before
	public void setUp() throws Exception {
		controllore = new Controllore();
	}

	@Test
	public void testCheckPassword() {
		//Errati
		assertFalse("Controllo passsword errato", controllore.checkPassword("", "")); //Password vuota
		assertFalse("Controllo passsword errato", controllore.checkPassword("1234", "")); //Password diverse
		assertFalse("Controllo passsword errato", controllore.checkPassword("abcdefghilmnopq", "abcdefghilmnopq")); //Password più grande di 12 caratteri
	
		//Corretti
		assertTrue("Controllo passsword esatta", controllore.checkPassword(" ", " "));
		assertTrue("Controllo passsword esatta", controllore.checkPassword("----asd---", "----asd---"));
	}

}
