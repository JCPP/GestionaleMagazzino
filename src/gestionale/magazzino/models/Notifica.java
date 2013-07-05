package gestionale.magazzino.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import gestionale.magazzino.Querist;

public class Notifica {
	static Querist que;
	
	/**
	 * La query non vede inserita la data in quanto in fase di progettazione 
	 * del database è stata impostata CURRENT_TIMESTAMP
	 * @param idNotifica id della notifica
	 * @param idDipendente id del dipendente responsabile
	 * @param idDipendenteNotificato id del dipendente notificato
	 * @param notifica il testo della notifica
	 */
	static public void inserisciNotifica(int idDipendente, int idDipendenteNotificato, String notifica){
		que = new Querist();
		String query = "INSERT INTO Notifica(idDipendente,idDipendenteNotificato,notifica) VALUES"+
				"("+idDipendente+","+idDipendenteNotificato+",'"+notifica+"')";
		que.eseguiQueryUpdate(query);
	}
	
	/**
	 * Questo metodo restituisce tutti le notifiche attive in database
	 * @return ritorna un arraylist di notifiche, in caso di errore un null
	 */
	static public ArrayList<gestionale.magazzino.Notifica> visualizzaNotifiche(){
		que = new Querist();
		ArrayList<gestionale.magazzino.Notifica> risultato = new ArrayList<gestionale.magazzino.Notifica>();
		String query = "SELECT * FROM Notifica";
		ResultSet rs = que.eseguiQuery(query);
		try {
			while(rs.next()){
				boolean isValidate = Boolean.parseBoolean(rs.getString("isValidate"));
				gestionale.magazzino.Notifica notifica = new gestionale.magazzino.Notifica(rs.getInt("idNotifica"),rs.getInt("idDipendente"), rs.getInt("idDipendenteNotificato"), rs.getString("notifica"), rs.getString("dataNotifica"), isValidate);
				risultato.add(notifica);
			}
		} catch (SQLException e) {
			gestionale.magazzino.Notifica notifica = null;
			risultato.add(notifica);
			return risultato;
		}
		return risultato; 
	}

	/**
	 * Questo metodo rende valida una notifica invalida
	 * @param idNotifica identificativo della notifica da convalidare
	 */
	static public void validateNotifica(int idNotifica){
		que = new Querist();
		String query = "UPDATE Notifica " +
					   "SET isValidate = 'true' " +
					   "WHERE idNotifica = "+idNotifica;
		System.out.println(query);
		que.eseguiQueryUpdate(query);
	}
	
	/**
	 * Questo metodo rende invalida una notifica valida
	 * @param idNotifica identificativo della notifica da invalidare
	 */
	static public void invalidateNotifica(int idNotifica){
		que = new Querist();
		String query = "UPDATE Notifica " +
					   "SET isValidate = 'false' " +
					   "WHERE idNotifica = "+idNotifica;
		System.out.println(query);
		que.eseguiQueryUpdate(query);
	}
	
	/**
	 * Questo metodo cancella una notifica dal database
	 * @param idNotifica identificativo della notifica
	 */
	static public void cancellaNotifica(int idNotifica){
		que = new Querist();
		String query = "DELETE FROM Notifica WHERE idNotifica = "+idNotifica;
		System.out.println(query);
		que.eseguiQueryUpdate(query);
	}

	/**
	 * Questo metodo restituisce tutte le notifiche ancora attive
	 * @return ritorna un arraylist di notifiche ancora valide
	 */
	static public ArrayList<gestionale.magazzino.Notifica> visualizzaNotificheValide(){
		que = new Querist();
		ArrayList<gestionale.magazzino.Notifica> risultato = new ArrayList<gestionale.magazzino.Notifica>();
		String query = "SELECT * " +
					   "FROM Notifica N " +
					   "WHERE N.isValidate = 'true'";
		ResultSet rs = que.eseguiQuery(query);
		try {
			while(rs.next()){
				boolean isValidate = Boolean.parseBoolean(rs.getString("isValidate"));
				gestionale.magazzino.Notifica notifica = new gestionale.magazzino.Notifica(rs.getInt("idNotifica"),rs.getInt("idDipendente"), rs.getInt("idDipendenteNotificato"), rs.getString("notifica"), rs.getString("dataNotifica"), isValidate);
				risultato.add(notifica);
			}
		} catch (SQLException e) {
			gestionale.magazzino.Notifica notifica = null;
			risultato.add(notifica);
			return risultato;
		}
		return risultato; 
	}

	/**
	 * Questo metodo restituisce tutte le notifiche inattive
	 * @return ritorna un arraylist di notifiche non più valide
	 */
	static public ArrayList<gestionale.magazzino.Notifica> visualizzaNotificheInvalide(){
		que = new Querist();
		ArrayList<gestionale.magazzino.Notifica> risultato = new ArrayList<gestionale.magazzino.Notifica>();
		String query = "SELECT * " +
					   "FROM Notifica N " +
					   "WHERE N.isValidate = 'false'";
		ResultSet rs = que.eseguiQuery(query);
		try {
			while(rs.next()){
				boolean isValidate = Boolean.parseBoolean(rs.getString("isValidate"));
				gestionale.magazzino.Notifica notifica = new gestionale.magazzino.Notifica(rs.getInt("idNotifica"),rs.getInt("idDipendente"), rs.getInt("idDipendenteNotificato"), rs.getString("notifica"), rs.getString("dataNotifica"), isValidate);
				risultato.add(notifica);
			}
		} catch (SQLException e) {
			gestionale.magazzino.Notifica notifica = null;
			risultato.add(notifica);
			return risultato;
		}
		return risultato; 
	}

	/**
	 * Questo metodo restituisce gli IDs di tutte le notifiche inattive
	 * @return ritorna un arraylist di IDs notifiche non più valide
	 */
	static public ArrayList<Integer> getIdNotificheInvalide(){
		que = new Querist();
		ArrayList<Integer> risultato = new ArrayList<Integer>();
		String query = "SELECT N.idNotifica " +
					   "FROM Notifica N " +
					   "WHERE N.isValidate = 'false'";
		ResultSet rs = que.eseguiQuery(query);
		try {
			while(rs.next()){
				risultato.add(rs.getInt("idNotifica"));
			}
		} catch (SQLException e) {
		}
		return risultato; 
	}
	
	/**
	 * Questo metodo restituisce gli IDs di tutte le notifiche valide
	 * @return ritorna un arraylist di IDs notifiche valide
	 */
	static public ArrayList<Integer> getIdNotificheValide(){
		que = new Querist();
		ArrayList<Integer> risultato = new ArrayList<Integer>();
		String query = "SELECT N.idNotifica " +
					   "FROM Notifica N " +
					   "WHERE N.isValidate = 'true'";
		ResultSet rs = que.eseguiQuery(query);
		try {
			while(rs.next()){
				risultato.add(rs.getInt("idNotifica"));
			}
		} catch (SQLException e) {
		}
		return risultato; 
	}

	/**
	 * Questo metodo restituisce gli IDs di tutte le notifiche ricevute da un dato dipendente
	 * @param idDipendenteNotificato identificativo del dipendente di cui si vogliono sapere le notifiche
	 * @return restituisce gli IDs delle notifiche.
	 */
	static public ArrayList<Integer> getIdNotificheRicevute(int idDipendenteNotificato){
		ArrayList<Integer> risultato = new ArrayList<Integer>();
		que = new Querist();
		String query = "SELECT N.idNotifica " +
					   "FROM Notifica N " +
					   "WHERE N.idDipendenteNotificato = "+idDipendenteNotificato;
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
	 * Questo metodo restituisce gli IDs di tutte le notifiche inviate da un dato dipendente
	 * @param idDipendenteNotificato identificativo del dipendente di cui si vogliono sapere le notifiche
	 * @return restituisce gli IDs delle notifiche.
	 */
	static public ArrayList<Integer> getIdNotificheInviate(int idResponsabile){
		ArrayList<Integer> risultato = new ArrayList<Integer>();
		que = new Querist();
		String query = "SELECT N.idNotifica " +
					   "FROM Notifica N " +
					   "WHERE N.idDipendente = "+idResponsabile;
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
	
	static public gestionale.magazzino.Notifica visualizzaNotifica(int idNotifica){
		que = new Querist();
		gestionale.magazzino.Notifica notifica = null;
		String query = "SELECT * " +
					   "FROM Notifica N " +
					   "WHERE N.idNotifica = "+idNotifica;
		ResultSet rs = que.eseguiQuery(query);
		try {
			while(rs.next()){
				boolean isValidate = Boolean.parseBoolean(rs.getString("isValidate"));
				notifica = new gestionale.magazzino.Notifica(rs.getInt("idNotifica"),rs.getInt("idDipendente"), rs.getInt("idDipendenteNotificato"), rs.getString("notifica"), rs.getString("dataNotifica"), isValidate);
			}
		} catch (SQLException e) {
			notifica = null;
			return notifica;
		}
		return notifica; 
	}
}