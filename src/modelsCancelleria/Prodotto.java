package modelsCancelleria;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import gestionaleCancelleria.Querist;

public class Prodotto {
	static Querist que;
	
	/**
	 * 
	 * @param nome nome del prodotto
	 * @param qta quantità del prodotto
	 * @param prezzoUnita prezzo unitario del prodotto
	 */
	static public void inserisciProdotto(String nome, int qta, float prezzoUnita){
		que = new Querist();
		String query = "INSERT INTO Prodotto(nome,qta,prezzoUnita) VALUES"+
						"('"+nome+"',"+qta+","+prezzoUnita+")";
		que.eseguiQueryUpdate(query);
		}

	/**
	 * Questo metodo restituisce tutti i prodotti in database
	 * @return ritorna un arraylist di prodotti, in caso di errore un null
	 */
	static public ArrayList<gestionaleCancelleria.Prodotto> visualizzaProdotti(){
		que = new Querist();
		ArrayList<gestionaleCancelleria.Prodotto> risultato = new ArrayList<gestionaleCancelleria.Prodotto>();
		String query = "SELECT * FROM Prodotto";
		ResultSet rs = que.eseguiQuery(query);
		try {
			while(rs.next()){
				gestionaleCancelleria.Prodotto pr = new gestionaleCancelleria.Prodotto(rs.getInt("idProdotto"),rs.getString("nome"), rs.getInt("qta"), rs.getFloat("prezzoUnita"));
				risultato.add(pr);
			}
		} catch (SQLException e) {
			gestionaleCancelleria.Prodotto pr = null;
			risultato.add(pr);
			return risultato;
		}
		return risultato; 
	}

}
