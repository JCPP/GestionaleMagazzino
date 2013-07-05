package gestionale.magazzino.models;

import static org.junit.Assert.*;

import java.util.ArrayList;

import gestionale.magazzino.Connettore;
import gestionale.magazzino.models.utils.Utils;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test per la classe Aggiornamento.
 * @author <a href="https://github.com/DavidePastore">Davide Pastore</a>
 *
 */
public class AggiornamentoTest {
	
	private static gestionale.magazzino.Aggiornamento aggiornamento;
	private static ArrayList<gestionale.magazzino.Aggiornamento> aggiornamenti;
	private static ArrayList<Integer> idAggiornamenti; 
	private static Connettore connettore;
	
	private static int idAggiornamento;
	private static int idDipendente;
	private static int idProdotto;
	private static int qta;
	
	private int dimensione;

	@BeforeClass
	public static void setUp() throws Exception {
		idDipendente = 3;
		idProdotto = 2;
		qta = 120;
		aggiornamenti = new ArrayList<gestionale.magazzino.Aggiornamento>();
		idAggiornamenti = new ArrayList<Integer>();
		connettore = new Connettore();
		connettore.caricadriver();
		connettore.collegati();
	}

	/**
	 * Verifica che l'elemento inserito corrisponda con quello letto successivamente.
	 */
	@Test
	public void testInserisciAggiornamento() {
		Aggiornamento.inserisciAggiornamento(idDipendente, idProdotto, qta); //Inserisce l'aggiornamento
		idAggiornamento = Utils.lastInsertID();
		aggiornamento = Aggiornamento.visualizzaAggiornamento(idAggiornamento);
		assertTrue("inserisciAggiornamento() non funziona correttamente", 
				aggiornamento.getIdAggiornamento() == idAggiornamento &&
				aggiornamento.getIdDipendete() == idDipendente &&
				aggiornamento.getIdProdotto() == idProdotto &&
				aggiornamento.getQta() == qta
		);
	}

	/**
	 * Verifica che la dimensione aumenti di uno quando si aggiunge un aggiornamento.
	 */
	@Test
	public void testVisualizzaAggiornamenti() {
		aggiornamenti = Aggiornamento.visualizzaAggiornamenti();
		dimensione = aggiornamenti.size();
		Aggiornamento.inserisciAggiornamento(idDipendente, idProdotto, qta); //Inserisce l'aggiornamento
		
		aggiornamenti = Aggiornamento.visualizzaAggiornamenti();
		assertEquals("visualizzaAggiornamenti() non funziona correttamente", dimensione + 1, aggiornamenti.size());
	}

	/**
	 * Verifica che un aggiornamento venga validato dopo averlo modificato.
	 */
	@Test
	public void testValidateAggiornamento() {
		Aggiornamento.inserisciAggiornamento(idDipendente, idProdotto, qta); //Inserisce l'aggiornamento
		idAggiornamento = Utils.lastInsertID();
		
		Aggiornamento.validateAggiornamento(idAggiornamento); //Valida l'aggiornamento
		
		aggiornamento = Aggiornamento.visualizzaAggiornamento(idAggiornamento);
		assertTrue("validateAggiornamento() non funziona correttamente", aggiornamento.isValidate());
	}

	/**
	 * Verifica che un aggiornamento venga invalidato dopo averlo modificato.
	 */
	@Test
	public void testInvalidateAggiornamento() {
		Aggiornamento.inserisciAggiornamento(idDipendente, idProdotto, qta); //Inserisce l'aggiornamento
		idAggiornamento = Utils.lastInsertID();
		
		Aggiornamento.invalidateAggiornamento(idAggiornamento); //Valida l'aggiornamento
		
		aggiornamento = Aggiornamento.visualizzaAggiornamento(idAggiornamento);
		assertFalse("invalidateAggiornamento() non funziona correttamente", aggiornamento.isValidate());
	}

	/**
	 * Verifica che l'elemento inserito venga cancellato.
	 */
	@Test
	public void testCancellaAggiornamento() {
		Aggiornamento.inserisciAggiornamento(idDipendente, idProdotto, qta); //Inserisce l'aggiornamento
		idAggiornamento = Utils.lastInsertID();
		Aggiornamento.cancellaAggiornamento(idAggiornamento);
		assertNull("cancellaAggiornamento() non funziona correttamente", Aggiornamento.visualizzaAggiornamento(idAggiornamento));
	}

	/**
	 * Verifica che l'elemento inserito si sommi agli elementi validi.
	 */
	@Test
	public void testVisualizzaAggiornamentoValidi() {
		aggiornamenti = Aggiornamento.visualizzaAggiornamenti();
		dimensione = aggiornamenti.size();
		
		Aggiornamento.inserisciAggiornamento(idDipendente, idProdotto, qta); //Inserisce l'aggiornamento
		idAggiornamento = Utils.lastInsertID();
		
		Aggiornamento.validateAggiornamento(idAggiornamento); //Valida l'aggiornamento
		
		aggiornamenti = Aggiornamento.visualizzaAggiornamenti();
		assertEquals("visualizzaAggiornamentiValidi() non funziona correttamente", dimensione + 1, aggiornamenti.size());
	}

	/**
	 * Verifica che l'elemento inserito si sommi agli elementi invalidi.
	 */
	@Test
	public void testVisualizzaAggiornamentInvalidi() {
		aggiornamenti = Aggiornamento.visualizzaAggiornamenti();
		dimensione = aggiornamenti.size();
		
		Aggiornamento.inserisciAggiornamento(idDipendente, idProdotto, qta); //Inserisce l'aggiornamento
		idAggiornamento = Utils.lastInsertID();
		
		Aggiornamento.invalidateAggiornamento(idAggiornamento); //Valida l'aggiornamento
		
		aggiornamenti = Aggiornamento.visualizzaAggiornamenti();
		assertEquals("visualizzaAggiornamentiValidi() non funziona correttamente", dimensione + 1, aggiornamenti.size());
	}

	/**
	 * Verifica che la lista di tutti gli aggiornamenti dei dipendenti aumenti di uno dopo un inserimento.
	 */
	@Test
	public void testGetIdAggiornamentiDipendente() {
		idAggiornamenti = Aggiornamento.getIdAggiornamentiDipendente(idDipendente);
		dimensione = idAggiornamenti.size();
		
		Aggiornamento.inserisciAggiornamento(idDipendente, idProdotto, qta); //Inserisce l'aggiornamento
		
		idAggiornamenti = Aggiornamento.getIdAggiornamentiDipendente(idDipendente);
		assertEquals("getIdAggiornamentiDipendente() non funziona correttamente", dimensione + 1, idAggiornamenti.size());
	}

	/**
	 * Verifica che un aggiornamento sia leggibile dopo un inserimento.
	 */
	@Test
	public void testVisualizzaAggiornamento() {
		Aggiornamento.inserisciAggiornamento(idDipendente, idProdotto, qta); //Inserisce l'aggiornamento
		idAggiornamento = Utils.lastInsertID();
		aggiornamento = Aggiornamento.visualizzaAggiornamento(idAggiornamento);
		assertTrue("inserisciAggiornamento() non funziona correttamente", 
				aggiornamento.getIdAggiornamento() == idAggiornamento &&
				aggiornamento.getIdDipendete() == idDipendente &&
				aggiornamento.getIdProdotto() == idProdotto &&
				aggiornamento.getQta() == qta
		);
	}

}
