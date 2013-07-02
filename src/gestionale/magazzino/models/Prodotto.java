package gestionale.magazzino.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import gestionale.magazzino.Querist;

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
	 * Questo metodo cancella un prodotto in base al nome
	 * @param nome nome del prodotto da cancellare
	 */
	static public void cancellaProdotto(String nome){
		que = new Querist();
		String query = "DELETE " +
				       "FROM Prodotto " +
				       "WHERE Prodotto.nome = '"+nome+"'";
		System.out.println(query);
		que.eseguiQueryUpdate(query);
	}

	/**
	 * Questo metodo restituisce tutti i prodotti in database
	 * @return ritorna un arraylist di prodotti, in caso di errore un null
	 */
	static public ArrayList<gestionale.magazzino.Prodotto> visualizzaProdotti(){
		que = new Querist();
		ArrayList<gestionale.magazzino.Prodotto> risultato = new ArrayList<gestionale.magazzino.Prodotto>();
		String query = "SELECT * FROM Prodotto";
		ResultSet rs = que.eseguiQuery(query);
		try {
			while(rs.next()){
				gestionale.magazzino.Prodotto pr = new gestionale.magazzino.Prodotto(rs.getInt("idProdotto"),rs.getString("nome"), rs.getInt("qta"), rs.getFloat("prezzoUnita"));
				risultato.add(pr);
			}
		} catch (SQLException e) {
			gestionale.magazzino.Prodotto pr = null;
			risultato.add(pr);
			return risultato;
		}
		return risultato; 
	}
	
	/**
	 * Questo metodo modifica la quantità del prodotto nel database
	 * @param nome il nome del prodotto di cui si vuole modificare la quantità
	 * @param qta quantità da aggiungere
	 */
	static public void modificaQuantitaProdotto (String nome, int qta){
		que = new Querist();
		int vecchiaQta = 0;
		String query = "SELECT P.qta AS vecchiaQta " +
				"FROM Prodotto P " +
				"WHERE P.nome = '"+nome+"'";
		System.out.println(query);
		ResultSet rs = que.eseguiQuery(query);
		try {
			vecchiaQta = rs.getInt("vecchiaQta");
		} catch (SQLException e) {
			System.out.println(e.getMessage()); 
		}
		int nuovaQta = vecchiaQta + qta;
		
		String query1 = "UPDATE Prodotto " +
				"SET qta = "+nuovaQta+" " +
				"WHERE nome = '"+nome+"'";
		System.out.println(query1);
		que.eseguiQueryUpdate(query1);
	}

	static public void modificaPrezzoProdotto (String nome, float prezzo){
		que = new Querist();
		
		String query1 = "UPDATE Prodotto " +
				"SET prezzoUnita = "+prezzo+" " +
				"WHERE nome = '"+nome+"'";
		System.out.println(query1);
		que.eseguiQueryUpdate(query1);
	}
}
