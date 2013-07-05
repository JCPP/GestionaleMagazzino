package gestionale.magazzino.models;

import static org.junit.Assert.*;
import gestionale.magazzino.Connettore;
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
	private static Connettore connettore;
	private static RandomString randomString;
	
	private int idNotifica;
	private static int idDipendente;
	private static int idDipendenteNotificato;
	private static String stringaNotifica;
	private static String data;
	private static boolean isValidate;
	
	private int dimensione;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		idDipendente = 1;
		idDipendenteNotificato = 2;
		stringaNotifica = new RandomString(10).nextString();
		data = "2013-12-21 18:32:51";
		isValidate = false;
		notifica = new gestionale.magazzino.Notifica();
		notifiche = new ArrayList<gestionale.magazzino.Notifica>();
		
		connettore = new Connettore();
		connettore.caricadriver();
		connettore.collegati();
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testInserisciNotifica() {
		fail("Not yet implemented");
	}

	@Test
	public void testVisualizzaNotifiche() {
		fail("Not yet implemented");
	}

	@Test
	public void testValidateNotifica() {
		fail("Not yet implemented");
	}

	@Test
	public void testInvalidateNotifica() {
		fail("Not yet implemented");
	}

	@Test
	public void testCancellaNotifica() {
		fail("Not yet implemented");
	}

	@Test
	public void testVisualizzaNotificheValide() {
		fail("Not yet implemented");
	}

	@Test
	public void testVisualizzaNotificheInvalide() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetIdNotificheInvalide() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetIdNotificheValide() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetIdNotificheRicevute() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetIdNotificheInviate() {
		fail("Not yet implemented");
	}

	@Test
	public void testVisualizzaNotifica() {
		fail("Not yet implemented");
	}

}
