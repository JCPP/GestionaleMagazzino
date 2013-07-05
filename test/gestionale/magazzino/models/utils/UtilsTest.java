package gestionale.magazzino.models.utils;

import static org.junit.Assert.*;
import gestionale.magazzino.Connettore;
import gestionale.magazzino.models.Acquisto;
import gestionale.magazzino.models.utils.Utils;

import org.junit.Before;
import org.junit.Test;

public class UtilsTest {
	
	private int idAcquisto;
	private int idDipendente;
	private int idProdotto;
	private int idFondo;
	private int qta;
	//private Connettore connettore;
	private gestionale.magazzino.Acquisto acquisto;
	
	@Before
	public void setUp() throws Exception {
		idDipendente = 2;
		idProdotto = 2;
		idFondo = 1;
		qta = 120;
		//connettore = new Connettore();
		Connettore.caricadriver();
		Connettore.collegati();
	}

	@Test
	public void testLastInsertID() {
		Acquisto.inserisciAcquisto(idDipendente, idProdotto, idFondo, qta); //Inserisco l'acquisto
		idAcquisto = Utils.lastInsertID();
		//System.out.println("IDAcquisto: " + idAcquisto);
		acquisto = Acquisto.visualizzaAcquisto(idAcquisto);
		assertTrue("lastInsertID() non funziona correttamente", 
				acquisto.getIdAcquisto() == idAcquisto &&
				acquisto.getIdDipendente() == idDipendente &&
				acquisto.getIdProdotto() == idProdotto &&
				acquisto.getIdFondo() == idFondo &&
				acquisto.getQta() == qta
		);
	}

}
