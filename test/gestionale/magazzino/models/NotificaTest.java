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
 * Test per la classe Notifica.
 * @author <a href="https://github.com/DavidePastore">Davide Pastore</a>
 *
 */
public class NotificaTest {
	
	private static gestionale.magazzino.Notifica notifica;
	private static ArrayList<gestionale.magazzino.Notifica> notifiche;
	private static ArrayList<Integer> idNotifiche;
	private static Connettore connettore;
	private static RandomString randomString;
	
	private int idNotifica;
	private static int idDipendente;
	private static int idDipendenteNotificato;
	private static String stringaNotifica;
	
	private int dimensione;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		randomString = new RandomString(12);
		idDipendente = 1;
		idDipendenteNotificato = 2;
		stringaNotifica = randomString.nextString();
		notifica = new gestionale.magazzino.Notifica();
		notifiche = new ArrayList<gestionale.magazzino.Notifica>();
		idNotifiche = new ArrayList<Integer>();
		
		connettore = new Connettore();
		connettore.caricadriver();
		connettore.collegati();
	}

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Verifica che l'elemento inserito corrisponda con quello letto successivamente.
	 */
	@Test
	public void testInserisciNotifica() {
		Notifica.inserisciNotifica(idDipendente, idDipendenteNotificato, stringaNotifica);
		idNotifica = Utils.lastInsertID();
		notifica = Notifica.visualizzaNotifica(idNotifica);
		assertTrue("inserisciNotifica() non funziona correttamente", 
				notifica.getIdDipendente() == idDipendente &&
				notifica.getIdDipendenteNotificato() == idDipendenteNotificato &&
				notifica.getNotifica().equals(stringaNotifica) &&
				notifica.getIdNotifica() == idNotifica
		);
	}

	/**
	 * Verifica che la dimensione aumenti di uno quando si aggiunge una notifica.
	 */
	@Test
	public void testVisualizzaNotifiche() {
		notifiche = Notifica.visualizzaNotifiche();
		dimensione = notifiche.size();
		
		Notifica.inserisciNotifica(idDipendente, idDipendenteNotificato, stringaNotifica);
		
		notifiche = Notifica.visualizzaNotifiche();
		assertEquals("visualizzaNotifiche() non funziona correttamente", dimensione + 1, notifiche.size());
	}

	/**
	 * Verifica che la notifica inserita venga validata.
	 */
	@Test
	public void testValidateNotifica() {
		Notifica.inserisciNotifica(idDipendente, idDipendenteNotificato, stringaNotifica);
		idNotifica = Utils.lastInsertID();
		Notifica.validateNotifica(idNotifica);
		notifica = Notifica.visualizzaNotifica(idNotifica);
		assertTrue("validateNotifica() non funziona correttamente.", notifica.isValidate());
	}

	/**
	 * Verifica che la notifica inserita venga invalidata.
	 */
	@Test
	public void testInvalidateNotifica() {
		Notifica.inserisciNotifica(idDipendente, idDipendenteNotificato, stringaNotifica);
		idNotifica = Utils.lastInsertID();
		Notifica.invalidateNotifica(idNotifica);
		notifica = Notifica.visualizzaNotifica(idNotifica);
		assertFalse("invalidateNotifica() non funziona correttamente.", notifica.isValidate());
	}

	/**
	 * Verifica che l'elemento inserito venga cancellato.
	 */
	@Test
	public void testCancellaNotifica() {
		Notifica.inserisciNotifica(idDipendente, idDipendenteNotificato, stringaNotifica);
		idNotifica = Utils.lastInsertID();
		Notifica.cancellaNotifica(idNotifica);
		assertNull("cancellaNotifica() non funziona correttamente", Notifica.visualizzaNotifica(idNotifica));
	}

	/**
	 * Verifica che la dimensione aumenti di uno quando si aggiunge una notifica valida.
	 */
	@Test
	public void testVisualizzaNotificheValide() {
		notifiche = Notifica.visualizzaNotificheValide();
		dimensione = notifiche.size();
		
		Notifica.inserisciNotifica(idDipendente, idDipendenteNotificato, stringaNotifica);
		idNotifica = Utils.lastInsertID();
		Notifica.validateNotifica(idNotifica);
		
		notifiche = Notifica.visualizzaNotificheValide();
		assertEquals("visualizzaNotificheValide() non funziona correttamente", dimensione + 1, notifiche.size());
	}

	/**
	 * Verifica che la dimensione aumenti di uno quando si aggiunge una notifica non valida.
	 */
	@Test
	public void testVisualizzaNotificheInvalide() {
		notifiche = Notifica.visualizzaNotificheInvalide();
		dimensione = notifiche.size();
		
		Notifica.inserisciNotifica(idDipendente, idDipendenteNotificato, stringaNotifica);
		idNotifica = Utils.lastInsertID();
		Notifica.invalidateNotifica(idNotifica);
		
		notifiche = Notifica.visualizzaNotificheInvalide();
		assertEquals("visualizzaNotificheInvalide() non funziona correttamente", dimensione + 1, notifiche.size());
	}

	/**
	 * Verifica che la lista degli id delle notifiche invalide aumenti di uno dopo un inserimento.
	 */
	@Test
	public void testGetIdNotificheInvalide() {
		idNotifiche = Notifica.getIdNotificheInvalide();
		dimensione = idNotifiche.size();
		
		Notifica.inserisciNotifica(idDipendente, idDipendenteNotificato, stringaNotifica);
		idNotifica = Utils.lastInsertID();
		Notifica.invalidateNotifica(idNotifica);
		
		idNotifiche = Notifica.getIdNotificheInvalide();
		assertEquals("getIdNotificheInvalide() non funziona correttamente", dimensione + 1, idNotifiche.size());
	}

	/**
	 * Verifica che la lista degli id delle notifiche valide aumenti di uno dopo un inserimento.
	 */
	@Test
	public void testGetIdNotificheValide() {
		idNotifiche = Notifica.getIdNotificheValide();
		dimensione = idNotifiche.size();
		
		Notifica.inserisciNotifica(idDipendente, idDipendenteNotificato, stringaNotifica);
		idNotifica = Utils.lastInsertID();
		Notifica.validateNotifica(idNotifica);
		
		idNotifiche = Notifica.getIdNotificheValide();
		assertEquals("getIdNotificheValide() non funziona correttamente", dimensione + 1, idNotifiche.size());
	}

	/**
	 * Verifica che la lista degli id delle notifiche di un dipendente aumenti di uno dopo un inserimento.
	 */
	@Test
	public void testGetIdNotificheRicevute() {
		idNotifiche = Notifica.getIdNotificheRicevute(idDipendenteNotificato);
		dimensione = idNotifiche.size();
		
		Notifica.inserisciNotifica(idDipendente, idDipendenteNotificato, stringaNotifica);
		idNotifica = Utils.lastInsertID();
		
		idNotifiche = Notifica.getIdNotificheRicevute(idDipendenteNotificato);
		assertEquals("getIdNotificheRicevute() non funziona correttamente", dimensione + 1, idNotifiche.size());
	}

	/**
	 * Verifica che la lista degli id delle notifiche del dipendente notificato aumenti di uno dopo un inserimento.
	 */
	@Test
	public void testGetIdNotificheInviate() {
		idNotifiche = Notifica.getIdNotificheInviate(idDipendente);
		dimensione = idNotifiche.size();
		
		Notifica.inserisciNotifica(idDipendente, idDipendenteNotificato, stringaNotifica);
		idNotifica = Utils.lastInsertID();
		
		idNotifiche = Notifica.getIdNotificheInviate(idDipendente);
		assertEquals("getIdNotificheInviate() non funziona correttamente", dimensione + 1, idNotifiche.size());
	}

	/**
	 * Verifica che un dipendente sia leggibile dopo un inserimento.
	 */
	@Test
	public void testVisualizzaNotifica() {
		Notifica.inserisciNotifica(idDipendente, idDipendenteNotificato, stringaNotifica);
		idNotifica = Utils.lastInsertID();
		notifica = Notifica.visualizzaNotifica(idNotifica);
		assertTrue("inserisciNotifica() non funziona correttamente", 
				notifica.getIdDipendente() == idDipendente &&
				notifica.getIdDipendenteNotificato() == idDipendenteNotificato &&
				notifica.getNotifica().equals(stringaNotifica) &&
				notifica.getIdNotifica() == idNotifica
		);
	}

}
