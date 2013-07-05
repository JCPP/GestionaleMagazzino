package gestionale.magazzino.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import gestionale.magazzino.Querist;

public class Aggiornamento {
	static Querist que;
	
	/**
	 * La query non vede inserita la data in quanto in fase di progettazione 
	 * del database è stata impostata CURRENT_TIMESTAMP
	 * @param idDipendente id del dipendente
	 * @param idProdotto id del prodotto
	 * @param qta quantità aggiunta
	 */
	static public void inserisciAggiornamento(int idDipendente, int idProdotto, int qta){
		que = new Querist();
		String query = "INSERT INTO Aggiornamento(idDipendente,idProdotto,qta) VALUES"+
				"("+idDipendente+","+idProdotto+","+qta+")";
		que.eseguiQueryUpdate(query);
	}

	/**
	 * Questo metodo visualizza tutti gli aggiornamenti disponibili
	 * @return un arrayList di Aggiornamenti
	 */
	static public ArrayList<gestionale.magazzino.Aggiornamento> visualizzaAggiornamenti(){
		ArrayList<gestionale.magazzino.Aggiornamento> risultato = new ArrayList<gestionale.magazzino.Aggiornamento>();
		que = new Querist();
		String query = "SELECT * " +
					   "FROM Aggiornamento";
		System.out.println(query);
		ResultSet rs = que.eseguiQuery(query);
		try {
			while(rs.next()){
				boolean isValidate = Boolean.parseBoolean(rs.getString("isValidate"));
				gestionale.magazzino.Aggiornamento agg = new gestionale.magazzino.Aggiornamento(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), isValidate);
				risultato.add(agg);
			}
		} catch (SQLException e) {
			gestionale.magazzino.Aggiornamento agg = null;
			risultato.add(agg);
			return risultato;
		}
		return risultato;
	}

	/**
	 * Questo metodo rende valido un aggiornamento invalido
	 * @param idAggiornamento identificativo dell'aggiornamento da validare
	 */
	static public void validateAggiornamento(int idAggiornamento){
		que = new Querist();
		String query = "UPDATE Aggiornamento " +
					   "SET isValidate = 'true' " +
					   "WHERE idAggiornamento = "+idAggiornamento;
		System.out.println(query);
		que.eseguiQueryUpdate(query);
	}

	/**
	 * Questo metodo rende invalido un aggiornamento
	 * @param idAggiornamento identificativo dell'aggiornamento da invalidare
	 */
	static public void invalidateAggiornamento(int idAggiornamento){
		que = new Querist();
		String query = "UPDATE Aggiornamento " +
					   "SET isValidate = 'false' " +
					   "WHERE idAggiornamento = "+idAggiornamento;
		System.out.println(query);
		que.eseguiQueryUpdate(query);
	}

	/**
	 * Questo metodo cancella un aggiornamento dal database
	 * @param idAggiornamento identificativo dell aggiornamento
	 */
	static public void cancellaAggiornamento(int idAggiornamento){
		que = new Querist();
		String query = "DELETE FROM Aggiornamento WHERE idAggiornamento = "+idAggiornamento;
		System.out.println(query);
		que.eseguiQueryUpdate(query);
	}

	/**
	 * Questo metodo restituisce tutti gli Aggiornamenti ancora attivi
	 * @return ritorna un arraylist di Aggiornamenti ancora validi
	 */
	static public ArrayList<gestionale.magazzino.Aggiornamento> visualizzaAggiornamentoValidi(){
		que = new Querist();
		ArrayList<gestionale.magazzino.Aggiornamento> risultato = new ArrayList<gestionale.magazzino.Aggiornamento>();
		String query = "SELECT * " +
					   "FROM Aggiornamento A " +
					   "WHERE A.isValidate = 'true'";
		ResultSet rs = que.eseguiQuery(query);
		try {
			while(rs.next()){
				boolean isValidate = Boolean.parseBoolean(rs.getString("isValidate"));;
				gestionale.magazzino.Aggiornamento agg = new gestionale.magazzino.Aggiornamento(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), isValidate);
				risultato.add(agg);
			}
		} catch (SQLException e) {
			gestionale.magazzino.Aggiornamento agg = null;
			risultato.add(agg);
			return risultato;
		}
		return risultato; 
	}

	/**
	 * Questo metodo restituisce tutti gli Aggiornamenti non attivi
	 * @return ritorna un arraylist di Aggiornamenti non attivi
	 */
	static public ArrayList<gestionale.magazzino.Aggiornamento> visualizzaAggiornamentInvalidi(){
		que = new Querist();
		ArrayList<gestionale.magazzino.Aggiornamento> risultato = new ArrayList<gestionale.magazzino.Aggiornamento>();
		String query = "SELECT * " +
					   "FROM Aggiornamento A " +
					   "WHERE A.isValidate = 'false'";
		ResultSet rs = que.eseguiQuery(query);
		try {
			while(rs.next()){
				boolean isValidate = Boolean.parseBoolean(rs.getString("isValidate"));
				gestionale.magazzino.Aggiornamento agg = new gestionale.magazzino.Aggiornamento(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), isValidate);
				risultato.add(agg);
			}
		} catch (SQLException e) {
			gestionale.magazzino.Aggiornamento agg = null;
			risultato.add(agg);
			return risultato;
		}
		return risultato; 
	}

	/**
	 * Questo metodo restituisce gli IDs di tutti gli aggiornamenti associati ad un dato dipendente
	 * @param idDipendente identificativo del dipendente di cui si vogliono sapere gli aggiornamenti
	 * @return restituisce gli IDs degli aggiornamenti.
	 */
	static public ArrayList<Integer> getIdAggiornamentiDipendente(int idDipendente){
		ArrayList<Integer> risultato = new ArrayList<Integer>();
		que = new Querist();
		String query = "SELECT A.idAggiornamento " +
					   "FROM Aggiornamento A " +
					   "WHERE A.idDipendente = "+idDipendente+ " AND A.isValidate = 'true'";
		System.out.println(query);
		ResultSet rs = que.eseguiQuery(query);
		try {
			while(rs.next()){
				risultato.add(rs.getInt(1));
			}
		} catch (SQLException e) {
			risultato = null;
		}
		return risultato;
	}
	
	/**
	 * Questo metodo visualizza un singolo aggiornamento in base al suo identificativo
	 * @param idAggiornamento identificativo dell'aggiornamento
	 * @return un oggetto Aggiornamento
	 */
	static public gestionale.magazzino.Aggiornamento visualizzaAggiornamento(int idAggiornamento){
		que = new Querist();
		String query = "SELECT * " +
				       "FROM Aggiornamento A " +
				       "WHERE A.idAggiornamento = "+idAggiornamento;
		System.out.println(query);
		ResultSet rs = que.eseguiQuery(query);
		gestionale.magazzino.Aggiornamento agg = null;
		try{
			boolean isValidate = Boolean.parseBoolean(rs.getString("isValidate"));
			agg = new gestionale.magazzino.Aggiornamento(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), isValidate);
		}catch(SQLException e){
		}
		return agg;
		
	}
}
