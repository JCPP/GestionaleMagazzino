package gestionale.magazzino.models;

import static org.junit.Assert.*;

import gestionale.magazzino.Connettore;

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
		//statement.getGeneratedKeys();
		
		ArrayList<gestionale.magazzino.Acquisto> acquisti = Acquisto.visualizzaAcquistiDipendente(idDipendente); //Leggo l'elenco degli acquisti
		for(int i = 0; i < acquisti.size(); i++){
			gestionale.magazzino.Acquisto acquisto = acquisti.get(i);
			//if(acquisto.getNomeDipendente() == dipendente.getNome() && acquisto.getNomeFondo() && acquisto.getQta() == 120)
		}
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
