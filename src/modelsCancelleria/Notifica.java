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
		String query = "INSERT INTO Notifica(idDipendente,idDipendenteNotificato,notifica) VALUES"+
				"("+idDipendente+","+idDipendenteNotificato+",'"+notifica+"')";
		que.eseguiQueryUpdate(query);
	}
}
