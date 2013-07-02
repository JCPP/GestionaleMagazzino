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
				gestionale.magazzino.Notifica notifica = new gestionale.magazzino.Notifica(rs.getInt("idNotifica"),rs.getInt("idDipendente"), rs.getInt("idDipendenteNotificato"), rs.getString("notifica"), rs.getString("dataNotifica"));
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
	 * Questo metodo cancella una notifica dal database
	 * @param idNotifica identificativo della notifica
	 */
	static public void cancellaNotifica(int idNotifica){
		que = new Querist();
		String query = "DELETE FROM Notifica WHERE idNotifica = "+idNotifica;
		System.out.println(query);
		que.eseguiQueryUpdate(query);
	}

}
