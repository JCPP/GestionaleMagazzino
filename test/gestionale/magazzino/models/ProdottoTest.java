/**
 * 
 */
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
 * Test per la classe Prodotto.
 * @author <a reef="https://github.com/DavidePastore">DavidePastore</a>
 *
 */
public class ProdottoTest {
	
	private static gestionale.magazzino.Prodotto prodotto;
	private static ArrayList<gestionale.magazzino.Prodotto> prodotti;
	//private static Connettore connettore;
	private static RandomString randomString;
	
	private static String nome;
	private static int qta;
	private static float prezzoUnita;
	private int idProdotto;
	
	private int dimensione;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		qta = 32;
		prezzoUnita = 32.23f;
		randomString = new RandomString(15);
		
		Connettore.caricadriver();
		Connettore.collegati();
	}
	
	/**
	 * Setup prima di ogni test in modo da avere nomi dinamici.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		nome = randomString.nextString();
	}

	/**
	 * Test method for {@link gestionale.magazzino.models.Prodotto#inserisciProdotto(java.lang.String, int, float)}.
	 * Verifica che l'elemento inserito corrisponda con quello letto successivamente.
	 */
	@Test
	public void testInserisciProdotto() {
		Prodotto.inserisciProdotto(nome, qta, prezzoUnita);
		idProdotto = Utils.lastInsertID();
		
		prodotto = Prodotto.visualizzaProdotto(idProdotto);
		
		assertTrue("inserisciProdotto() non funziona correttamente",
				prodotto.getId_Prodotto() == idProdotto  &&
				prodotto.getNome().equals(nome) &&
				prodotto.getPrezzo() == prezzoUnita &&
				prodotto.getQuantità() == qta
		);
	}

	/**
	 * Test method for {@link gestionale.magazzino.models.Prodotto#cancellaProdotto(java.lang.String)}.
	 * Verifica che l'elemento inserito venga cancellato.
	 */
	@Test
	public void testCancellaProdotto() {
		Prodotto.inserisciProdotto(nome, qta, prezzoUnita);
		idProdotto = Utils.lastInsertID();
		Prodotto.cancellaProdotto(nome);
		assertNull("cancellaProdotto() non funziona correttamente", Prodotto.visualizzaProdotto(idProdotto));
	}

	/**
	 * Test method for {@link gestionale.magazzino.models.Prodotto#visualizzaProdotti()}.
	 * Verifica che la dimensione aumenti di uno quando si aggiunge un prodotto.
	 */
	@Test
	public void testVisualizzaProdotti() {
		prodotti = Prodotto.visualizzaProdotti();
		dimensione = prodotti.size();
		
		Prodotto.inserisciProdotto(nome, qta, prezzoUnita);
		
		prodotti = Prodotto.visualizzaProdotti();
		assertEquals("visualizzaProdotti() non funziona correttamente", dimensione + 1, prodotti.size());
	}

	/**
	 * Test method for {@link gestionale.magazzino.models.Prodotto#modificaQuantitaProdotto(java.lang.String, int)}.
	 * Verifica che la quantità di un prodotto cambi quando lo si fa.
	 */
	@Test
	public void testModificaQuantitaProdotto() {
		int nuovaQta = qta + 2;
		Prodotto.inserisciProdotto(nome, qta, prezzoUnita);
		
		idProdotto = Utils.lastInsertID();
		Prodotto.modificaQuantitaProdotto(nome, nuovaQta);
		prodotto = Prodotto.visualizzaProdotto(idProdotto);
		assertEquals("modificaQuantitaProdotto() non funziona correttamente", nuovaQta + qta, prodotto.getQuantità());
	}

	/**
	 * Test method for {@link gestionale.magazzino.models.Prodotto#modificaPrezzoProdotto(java.lang.String, float)}.
	 * Verifica che il prezzo di un prodotto cambi quando lo si fa.
	 */
	@Test
	public void testModificaPrezzoProdotto() {
		float nuovoPrezzo = prezzoUnita + 2;
		Prodotto.inserisciProdotto(nome, qta, prezzoUnita);
		
		idProdotto = Utils.lastInsertID();
		Prodotto.modificaPrezzoProdotto(nome, nuovoPrezzo);
		prodotto = Prodotto.visualizzaProdotto(idProdotto);
		assertEquals("modificaPrezzoProdotto() non funziona correttamente", 0, Double.compare(prodotto.getPrezzo(), nuovoPrezzo));
	}

	/**
	 * Test method for {@link gestionale.magazzino.models.Prodotto#visualizzaProdotto(int)}.
	 * Verifica che un prodotto sia leggibile dopo un inserimento.
	 */
	@Test
	public void testVisualizzaProdotto() {
		Prodotto.inserisciProdotto(nome, qta, prezzoUnita);
		idProdotto = Utils.lastInsertID();
		
		prodotto = Prodotto.visualizzaProdotto(idProdotto);
		
		assertTrue("inserisciProdotto() non funziona correttamente",
				prodotto.getId_Prodotto() == idProdotto  &&
				prodotto.getNome().equals(nome) &&
				prodotto.getPrezzo() == prezzoUnita &&
				prodotto.getQuantità() == qta
		);
	}

}
