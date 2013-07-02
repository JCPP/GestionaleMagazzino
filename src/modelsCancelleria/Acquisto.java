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
	
	/**
	 * Questo metodo cancella dal database un acquisto fatto
	 * @param idAcquisto identificativo dell'acquisto
	 */
	static public void cancellaAcquisto (int idAcquisto){
		que = new Querist();
		String query = "DELETE FROM Acquisto WHERE idAcquisto = "+idAcquisto;
		que.eseguiQueryUpdate(query);
	}

	/**
	 * Questo metodo visualizza tutti gli acquisti dei dipendenti
	 * @return un arrayList di acquisti
	 */
	static public ArrayList<gestionaleCancelleria.Acquisto> visualizzaAcquisti(){
		que = new Querist();
		ArrayList<gestionaleCancelleria.Acquisto> risultato = new ArrayList<gestionaleCancelleria.Acquisto>();
		String query = "SELECT A.idAcquisto, D.nome AS dipendente, P.nome AS prodotto, F.nome AS fondo, A.qta, A.qta * P.prezzoUnita AS spesa, A.dataAcquisto " +
					   "FROM Acquisto A, Prodotto P, Fondo F, Dipendente D";
		System.out.println(query);
		ResultSet rs = que.eseguiQuery(query);
		try {
			while(rs.next()){
				gestionaleCancelleria.Acquisto acq = new gestionaleCancelleria.Acquisto(rs.getInt("idAcquisto"),rs.getString("dipendente"), rs.getString("prodotto"), rs.getString("fondo"), rs.getInt("qta"), rs.getFloat("spesa"), rs.getString("dataAcquisto"));
				risultato.add(acq);
			}
		} catch (SQLException e) {
			gestionaleCancelleria.Acquisto acq = null;
			risultato.add(acq);
			return risultato;
		}
		return risultato;
	}

	static public ArrayList<gestionaleCancelleria.Acquisto> visualizzaAcquistiDipendente(int idDipendente){
		que = new Querist();
		ArrayList<gestionaleCancelleria.Acquisto> risultato = new ArrayList<gestionaleCancelleria.Acquisto>();
		String query = "SELECT A.idAcquisto, D.nome AS dipendente, P.nome AS prodotto, F.nome AS fondo, A.qta,A.qta * P.prezzoUnita AS spesa, A.dataAcquisto " +
				" FROM Acquisto A, Dipendente D, Prodotto P, Fondo F " +
				" WHERE A.idDipendente = '"+idDipendente+"' AND " +
				"A.idProdotto = P.idProdotto AND " +
				"A.idFondo = F.idFondo ";
		System.out.println(query);
		ResultSet rs = que.eseguiQuery(query);
		try {
			while(rs.next()){
				gestionaleCancelleria.Acquisto acq = new gestionaleCancelleria.Acquisto(rs.getInt("idAcquisto"),rs.getString("dipendente"), rs.getString("prodotto"), rs.getString("fondo"), rs.getInt("qta"), rs.getFloat("spesa"), rs.getString("dataAcquisto"));
				risultato.add(acq);
			}
		} catch (SQLException e) {
			gestionaleCancelleria.Acquisto acq = null;
			risultato.add(acq);
			return risultato;
		}
		return risultato;
	}
}
