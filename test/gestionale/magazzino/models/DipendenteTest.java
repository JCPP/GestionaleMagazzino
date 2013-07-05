package gestionale.magazzino.models;

import static org.junit.Assert.*;
import gestionale.magazzino.Connettore;
import gestionale.magazzino.models.utils.Utils;
import gestionale.magazzino.utils.RandomString;

import java.util.ArrayList;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test per la classe Dipendente.
 * @author <a href="https://github.com/DavidePastore">Davide Pastore</a>
 *
 */
public class DipendenteTest {
	
	private static gestionale.magazzino.Dipendente dipendente;
	private static ArrayList<gestionale.magazzino.Dipendente> dipendenti;
	private static Connettore connettore;
	private static RandomString randomString;
	
	private int idDipendente;
	private static String nome;
	private static String cognome;
	private static String tipo;
	private static String password;
	private static String email;
	
	private int dimensione;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		nome = "Ping us";
		cognome = "Robotnik";
		tipo = "responsabile";
		password = "ping";
		email = "%s@%s.com";
		
		randomString = new RandomString(10);
		connettore = new Connettore();
		connettore.caricadriver();
		connettore.collegati();
	}
	
	/**
	 * Verifica che l'elemento inserito corrisponda con quello letto successivamente.
	 */
	@Test
	public void testInserisciDipendente() {
		String emailGenerata = String.format(email, randomString.nextString(), randomString.nextString());
		Dipendente.inserisciDipendente(nome, cognome, password, emailGenerata, tipo);
		idDipendente = Utils.lastInsertID();
		
		dipendente = Dipendente.visualizzaDipendente(idDipendente);
		
		assertTrue("inserisciDipendente() non funziona correttamente",
				dipendente.getNome().equals(nome)  &&
				dipendente.getCognome().equals(cognome) &&
				dipendente.getPassword().equals(password) &&
				dipendente.getEmail().equals(emailGenerata) &&
				dipendente.getTipo().equals(tipo) &&
				dipendente.getIdDipendente() == idDipendente
		);
	}

	/**
	 * Verifica che la mail inserita in precedenza sia riscontrata successivamente.
	 */
	@Test
	public void testValidateEmail() {
		String emailGenerata = String.format(email, randomString.nextString(), randomString.nextString());
		Dipendente.inserisciDipendente(nome, cognome, password, emailGenerata, tipo);
		assertTrue("validateEmail() non funziona correttamente", Dipendente.validateEmail(emailGenerata));
	}

	/**
	 * Verifica che la mail e la password inserite siano corrette e ne controlla il contrario.
	 */
	@Test
	public void testValidatePassword() {
		String emailGenerata = String.format(email, randomString.nextString(), randomString.nextString());
		Dipendente.inserisciDipendente(nome, cognome, password, emailGenerata, tipo);
		assertTrue("validatePassword() non funziona correttamente.", Dipendente.validatePassword(emailGenerata, password));
		assertFalse("validatePassword() non funziona correttamente.", Dipendente.validatePassword(emailGenerata, randomString.nextString()));
	}

	/**
	 * Verifica che l'utente inserito sia responsabile.
	 */
	@Test
	public void testValidateResponsabile() {
		String emailGenerata = String.format(email, randomString.nextString(), randomString.nextString());
		Dipendente.inserisciDipendente(nome, cognome, password, emailGenerata, tipo);
		assertTrue("validateResponsabile() non funziona correttamente.", Dipendente.validateResponsabile(emailGenerata, password));
	}

	/**
	 * Verifica che il dipendente venga disattivato.
	 */
	@Test
	public void testDisattivaDipendente() {
		String emailGenerata = String.format(email, randomString.nextString(), randomString.nextString());
		Dipendente.inserisciDipendente(nome, cognome, password, emailGenerata, tipo);
		idDipendente = Utils.lastInsertID();
		
		Dipendente.disattivaDipendente(emailGenerata); //Disattiva il dipendente
		assertFalse("disattivaDipendente() non funziona correttamente.", Dipendente.isActive(emailGenerata));
	}

	/**
	 * Verifica che il dipendente venga attivato.
	 */
	@Test
	public void testAttivaDipendente() {
		String emailGenerata = String.format(email, randomString.nextString(), randomString.nextString());
		Dipendente.inserisciDipendente(nome, cognome, password, emailGenerata, tipo);
		idDipendente = Utils.lastInsertID();
		
		Dipendente.attivaDipendente(emailGenerata); //Disattiva il dipendente
		assertTrue("attivaDipendente() non funziona correttamente.", Dipendente.isActive(emailGenerata));
	}

	/**
	 * Verifica che la dimensione aumenti di uno quando si aggiunge un dipendente.
	 */
	@Test
	public void testVisualizzaDipendenti() {
		String emailGenerata = String.format(email, randomString.nextString(), randomString.nextString());
		dipendenti = Dipendente.visualizzaDipendenti();
		dimensione = dipendenti.size();
		Dipendente.inserisciDipendente(nome, cognome, password, emailGenerata, tipo);
		
		dipendenti = Dipendente.visualizzaDipendenti();
		assertEquals("visualizzaDipendenti() non funziona correttamente", dimensione + 1, dipendenti.size());
	}

	/**
	 * Verifica che un dipendente venga attivato.
	 */
	@Test
	public void testIsActive() {
		String emailGenerata = String.format(email, randomString.nextString(), randomString.nextString());
		Dipendente.inserisciDipendente(nome, cognome, password, emailGenerata, tipo);
		idDipendente = Utils.lastInsertID();
		
		Dipendente.attivaDipendente(emailGenerata); //Disattiva il dipendente
		assertTrue("isActive() non funziona correttamente.", Dipendente.isActive(emailGenerata));
	}

	/**
	 * Verifica che un dipendente venga visualizzato in modo corretto data email e password.
	 */
	@Test
	public void testVisualizzaDipendenteStringString() {
		String emailGenerata = String.format(email, randomString.nextString(), randomString.nextString());
		Dipendente.inserisciDipendente(nome, cognome, password, emailGenerata, tipo);
		idDipendente = Utils.lastInsertID();
		
		dipendente = Dipendente.visualizzaDipendente(emailGenerata, password);
		
		assertTrue("VisualizzaDipendenteStringString() non funziona correttamente",
				dipendente.getNome().equals(nome)  &&
				dipendente.getCognome().equals(cognome) &&
				dipendente.getPassword().equals(password) &&
				dipendente.getEmail().equals(emailGenerata) &&
				dipendente.getTipo().equals(tipo) &&
				dipendente.getIdDipendente() == idDipendente
		);
	}

	/**
	 * Verifica che un dipendente venga visualizzato in modo corretto dato l'id.
	 */
	@Test
	public void testVisualizzaDipendenteInt() {
		String emailGenerata = String.format(email, randomString.nextString(), randomString.nextString());
		Dipendente.inserisciDipendente(nome, cognome, password, emailGenerata, tipo);
		idDipendente = Utils.lastInsertID();
		
		dipendente = Dipendente.visualizzaDipendente(idDipendente);
		
		assertTrue("visualizzaDipendenteInt() non funziona correttamente",
				dipendente.getNome().equals(nome)  &&
				dipendente.getCognome().equals(cognome) &&
				dipendente.getPassword().equals(password) &&
				dipendente.getEmail().equals(emailGenerata) &&
				dipendente.getTipo().equals(tipo) &&
				dipendente.getIdDipendente() == idDipendente
		);
	}

	/**
	 * Verifica che l'elemento inserito venga cancellato.
	 */
	@Test
	public void testCancellaDipendente() {
		String emailGenerata = String.format(email, randomString.nextString(), randomString.nextString());
		Dipendente.inserisciDipendente(nome, cognome, password, emailGenerata, tipo);
		idDipendente = Utils.lastInsertID();
		Dipendente.cancellaDipendente(idDipendente);
		assertNull("cancellaDipendente() non funziona correttamente", Dipendente.visualizzaDipendente(idDipendente));
	}

}
