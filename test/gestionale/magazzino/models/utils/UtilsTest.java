package gestionale.magazzino.models.utils;

import static org.junit.Assert.*;
import gestionale.magazzino.Connettore;
import gestionale.magazzino.models.Acquisto;
import gestionale.magazzino.models.utils.Utils;

import org.junit.Before;
import org.junit.Test;

public class UtilsTest {
	
	private int idDipendente;
	private int idProdotto;
	private int idFondo;
	private int qta;
	private Connettore connettore;
	
	@Before
	public void setUp() throws Exception {
		idDipendente = 2;
		idProdotto = 2;
		idFondo = 1;
		qta = 120;
		connettore = new Connettore();
		connettore.caricadriver();
		connettore.collegati();
	}

	@Test
	public void testLastInsertID() {
		Acquisto.inserisciAcquisto(idDipendente, idProdotto, idFondo, qta); //Inserisco l'acquisto
		System.out.println("ID: " + Utils.lastInsertID());
		fail("Metodo non ancora completamente testato.");
	}

}
