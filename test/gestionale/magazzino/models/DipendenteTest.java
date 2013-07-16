package gestionale.magazzino.models;

import static org.junit.Assert.*;
import gestionale.magazzino.Connettore;
import gestionale.magazzino.models.utils.Utils;
import gestionale.magazzino.utils.RandomString;

import java.util.ArrayList;

import org.junit.Before;
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
	//private static Connettore connettore;
	private static RandomString randomString;
	
	private int idDipendente;
	private static String nome;
	private static String cognome;
	private static String tipo;
	private static String password;
	private static String email;
	private String emailGenerata;
	
	private int dimensione;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		nome = "Ping us";
		cognome = "Robotnik";
		tipo = "dipendente";
		password = "ping";
		email = "%s@%s.com";
		
		randomString = new RandomString(10);
		Connettore.caricadriver();
		Connettore.collegati();
	}
	
	@Before
	public void setUp() throws Exception {
		emailGenerata = String.format(email, randomString.nextString(), randomString.nextString());
	}
	
	/**
	 * Verifica che l'elemento inserito corrisponda con quello letto successivamente.
	 */
	@Test
	public void testInserisciDipendente() {
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
		Dipendente.inserisciDipendente(nome, cognome, password, emailGenerata, tipo);
		assertTrue("validateEmail() non funziona correttamente", Dipendente.validateEmail(emailGenerata));
	}

	/**
	 * Verifica che la mail e la password inserite siano corrette e ne controlla il contrario.
	 */
	@Test
	public void testValidatePassword() {
		Dipendente.inserisciDipendente(nome, cognome, password, emailGenerata, tipo);
		assertTrue("validatePassword() non funziona correttamente.", Dipendente.validatePassword(emailGenerata, password));
		assertFalse("validatePassword() non funziona correttamente.", Dipendente.validatePassword(emailGenerata, randomString.nextString()));
	}

	/**
	 * Verifica che l'utente inserito sia responsabile.
	 */
	@Test
	public void testValidateResponsabile() {
		Dipendente.inserisciDipendente(nome, cognome, password, emailGenerata, "responsabile");
		assertTrue("validateResponsabile() non funziona correttamente.", Dipendente.validateResponsabile(emailGenerata, password));
	}

	/**
	 * Verifica che il dipendente venga disattivato.
	 */
	@Test
	public void testDisattivaDipendente() {
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
		Dipendente.inserisciDipendente(nome, cognome, password, emailGenerata, tipo);
		idDipendente = Utils.lastInsertID();
		Dipendente.cancellaDipendente(idDipendente);
		assertNull("cancellaDipendente() non funziona correttamente", Dipendente.visualizzaDipendente(idDipendente));
	}
	
	/**
	 * Test method for {@link gestionale.magazzino.models.Dipendente#reindexTable()}.
	 */
	@Test
	public void testReindexTable() {
		fail("Not yet implemented");
	}
	
	/**
	 * Verifica che un dipendente diventi responsabile.
	 */
	@Test
	public void testSetResponsabile() {
		Dipendente.inserisciDipendente(nome, cognome, password, emailGenerata, tipo);
		idDipendente = Utils.lastInsertID();
		Dipendente.setResponsabile(idDipendente);
		dipendente = Dipendente.visualizzaDipendente(idDipendente);
		
		assertTrue("setResponsabile() non funziona correttamente",
				dipendente.getNome().equals(nome)  &&
				dipendente.getCognome().equals(cognome) &&
				dipendente.getPassword().equals(password) &&
				dipendente.getEmail().equals(emailGenerata) &&
				dipendente.getTipo().equals("responsabile") &&
				dipendente.getIdDipendente() == idDipendente
		);
	}
	
	
	/**
	 * Verifica che un responsabile diventi dipendente.
	 */
	@Test
	public void testSetDipendente() {
		Dipendente.inserisciDipendente(nome, cognome, password, emailGenerata, tipo);
		idDipendente = Utils.lastInsertID();
		Dipendente.setDipendente(idDipendente);
		dipendente = Dipendente.visualizzaDipendente(idDipendente);
		
		assertTrue("setDipendente() non funziona correttamente",
				dipendente.getNome().equals(nome)  &&
				dipendente.getCognome().equals(cognome) &&
				dipendente.getPassword().equals(password) &&
				dipendente.getEmail().equals(emailGenerata) &&
				dipendente.getTipo().equals("dipendente") &&
				dipendente.getIdDipendente() == idDipendente
		);
	}
	
	/**
	 * Verifica che l'email venga cambiata.
	 */
	@Test
	public void testCambiaEmail() {
		Dipendente.inserisciDipendente(nome, cognome, password, emailGenerata, tipo);
		idDipendente = Utils.lastInsertID();
		emailGenerata = String.format(email, randomString.nextString(), randomString.nextString());
		
		Dipendente.cambiaEmail(idDipendente, emailGenerata);
		dipendente = Dipendente.visualizzaDipendente(idDipendente);
		
		assertTrue("cambiaEmail() non funziona correttamente",
				dipendente.getNome().equals(nome)  &&
				dipendente.getCognome().equals(cognome) &&
				dipendente.getPassword().equals(password) &&
				dipendente.getEmail().equals(emailGenerata) &&
				dipendente.getTipo().equals(tipo) &&
				dipendente.getIdDipendente() == idDipendente
		);
	}
	
	/**
	 * Verifica che il cognome venga cambiato.
	 */
	@Test
	public void testCambiaCognome() {
		Dipendente.inserisciDipendente(nome, cognome, password, emailGenerata, tipo);
		idDipendente = Utils.lastInsertID();
		cognome = randomString.nextString();
		
		Dipendente.cambiaCognome(idDipendente, cognome);
		dipendente = Dipendente.visualizzaDipendente(idDipendente);
		
		assertTrue("cambiaCognome() non funziona correttamente",
				dipendente.getNome().equals(nome)  &&
				dipendente.getCognome().equals(cognome) &&
				dipendente.getPassword().equals(password) &&
				dipendente.getEmail().equals(emailGenerata) &&
				dipendente.getTipo().equals(tipo) &&
				dipendente.getIdDipendente() == idDipendente
		);
	}
	
	/**
	 * Verifica che il nome venga cambiato.
	 */
	@Test
	public void testCambiaNome() {
		Dipendente.inserisciDipendente(nome, cognome, password, emailGenerata, tipo);
		idDipendente = Utils.lastInsertID();
		nome = randomString.nextString();
		
		Dipendente.cambiaNome(idDipendente, nome);
		dipendente = Dipendente.visualizzaDipendente(idDipendente);
		
		assertTrue("cambiaNome() non funziona correttamente",
				dipendente.getNome().equals(nome)  &&
				dipendente.getCognome().equals(cognome) &&
				dipendente.getPassword().equals(password) &&
				dipendente.getEmail().equals(emailGenerata) &&
				dipendente.getTipo().equals(tipo) &&
				dipendente.getIdDipendente() == idDipendente
		);
	}

}
