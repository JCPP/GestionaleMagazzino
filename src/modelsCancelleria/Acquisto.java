package modelsCancelleria;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import gestionaleCancelleria.Querist;

public class Acquisto {
	static Querist que;
	
	/**
	 * La query non vede inserita la data in quanto in fase di progettazione 
	 * del database è stata impostata CURRENT_TIMESTAMP
	 * @param idDipendente
	 * @param idProdotto
	 * @param idFondo
	 * @param qta quantità del prodotto comprata
	 */
	static public void inserisciAcquisto(int idDipendente, int idProdotto, int idFondo, int qta){
		que = new Querist();
		String query = "INSERT INTO Acquisto(idDipendente,idProdotto,idFondo,qta) VALUES"+
				"("+idDipendente+","+idProdotto+","+idFondo+","+qta+")";
		que.eseguiQueryUpdate(query);
	}
}
