package gestionale.magazzino.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import gestionale.magazzino.Connettore;
import gestionale.magazzino.Querist;

public class Fondo {
	static Querist que;

	/**
	 * Questo metodo inserisce un nuovo fondo nel database
	 * @param nome nome del fondo
	 * @param fondoDisponibile l'importo ancora disponibile per il fondo
	 */
	static public void inserisciFondo(String nome, float fondoDisponibile){
		que = new Querist();
		String query = "INSERT INTO Fondo(nome,fondoDisponibile) VALUES"+
				"('"+nome+"',"+fondoDisponibile+")";
		que.eseguiQueryUpdate(query);
		}

	/**
	 * Questo metodo restituisce i nomi dei fondi presenti nel database aventi un fondo disponibile maggiore di 0
	 * @return Il ritorno è un arraylist di stringhe contenenti i risultati, in caso di errore ritorna l'arraylist con il messaggio di errore
	 */
	static public ArrayList<String> visualizzaFondi (){
		que = new Querist();
		String query = "SELECT F.Nome" +
					   "FROM magazzino.fondo F" +
					   "HAVING F.fondoDisponibile > 0";
		ResultSet rs = que.eseguiQuery(query);
		ArrayList<String> risultato = new ArrayList<String>();
		
		try {
			while(rs.next()){
				risultato.add(rs.getString("nome"));
			}
		} catch (SQLException e) {
			risultato.add(e.getMessage());
			return risultato;
		}
		return risultato; 
	}

}
