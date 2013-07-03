package gestionale.magazzino.models;

import static org.junit.Assert.*;

import gestionale.magazzino.Connettore;
import gestionale.magazzino.models.utils.Utils;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.sqlite.SQLite;

/**
 * Test per la classe Acquisto.
 * @author <a href="https://github.com/DavidePastore">Davide Pastore</a>
 *
 */
public class AcquistoTest {
	
	private int idDipendente;
	private int idProdotto;
	private int idFondo;
	private int qta;
	private int idAcquisto;
	private Connettore connettore;
	
	@Before
	public void setUp() throws Exception {
		idDipendente = 3;
		idProdotto = 2;
		idFondo = 1;
		qta = 120;
		connettore = new Connettore();
		connettore.caricadriver();
		connettore.collegati();
	}

	@Test
	public void testInserisciAcquisto() {
		Acquisto.inserisciAcquisto(idDipendente, idProdotto, idFondo, qta); //Inserisco l'acquisto
		idAcquisto = Utils.lastInsertID();
		gestionale.magazzino.Acquisto acquisto = Acquisto.visualizzaAcquisto(idAcquisto);
		
		//Controllare che gli id siano settati come abbiamo fatto
		//acquisto.get
		fail("Not yet implemented");
	}

	@Test
	public void testCancellaAcquisto() {
		fail("Not yet implemented");
	}

	@Test
	public void testVisualizzaAcquisti() {
		fail("Not yet implemented");
	}

	@Test
	public void testVisualizzaAcquistiDipendente() {
		fail("Not yet implemented");
	}

}
