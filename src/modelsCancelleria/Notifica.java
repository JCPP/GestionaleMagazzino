package modelsCancelleria;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import gestionaleCancelleria.Querist;

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
	static public ArrayList<gestionaleCancelleria.Notifica> visualizzaNotifiche(){
		que = new Querist();
		ArrayList<gestionaleCancelleria.Notifica> risultato = new ArrayList<gestionaleCancelleria.Notifica>();
		String query = "SELECT * FROM Notifica";
		ResultSet rs = que.eseguiQuery(query);
		try {
			while(rs.next()){
				gestionaleCancelleria.Notifica notifica = new gestionaleCancelleria.Notifica(rs.getInt("idNotifica"),rs.getInt("idDipendente"), rs.getInt("idDipendenteNotificato"), rs.getString("notifica"), rs.getString("dataNotifica"));
				risultato.add(notifica);
			}
		} catch (SQLException e) {
			gestionaleCancelleria.Notifica notifica = null;
			risultato.add(notifica);
			return risultato;
		}
		return risultato; 
	}
}
