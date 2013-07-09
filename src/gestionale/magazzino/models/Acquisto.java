package gestionale.magazzino.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import gestionale.magazzino.Querist;

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
	static public ArrayList<gestionale.magazzino.Acquisto> visualizzaAcquisti(){
		que = new Querist();
		ArrayList<gestionale.magazzino.Acquisto> risultato = new ArrayList<gestionale.magazzino.Acquisto>();
		String query = "SELECT A.idAcquisto, D.nome AS dipendente, P.nome AS prodotto, F.nome AS fondo, A.qta, A.qta * P.prezzoUnita AS spesa, A.dataAcquisto " +
					   "FROM Acquisto A, Prodotto P, Fondo F, Dipendente D " +
					   "WHERE A.idDipendente = D.idDipendente AND " +
					         "A.idProdotto = P.idProdotto AND " +
					         "A.idFondo = F.idFondo";
		System.out.println(query);
		ResultSet rs = que.eseguiQuery(query);
		try {
			while(rs.next()){
				gestionale.magazzino.Acquisto acq = new gestionale.magazzino.Acquisto(rs.getInt("idAcquisto"),rs.getString("dipendente"), rs.getString("prodotto"), rs.getString("fondo"), rs.getInt("qta"), rs.getFloat("spesa"), rs.getString("dataAcquisto"));
				risultato.add(acq);
			}
		} catch (SQLException e) {
			System.out.println("Eccezione: " + e);
			gestionale.magazzino.Acquisto acq = null;
			risultato.add(acq);
			return risultato;
		}
		return risultato;
	}

	
	/**
	 * Questo metodo visualizza tutti gli acquisti di un dipendente
	 * @param idDipendete identificativo del dipendente
	 * @return un arrayList di acquisti
	 */
	public static ArrayList<gestionale.magazzino.Acquisto> visualizzaAcquistiDaDipendente(int idDipendete){
		que = new Querist();
		String query = "SELECT A.idAcquisto, A.idDipendente, A.idProdotto, A.idFondo, A.qta, A.dataAcquisto " +
				       "FROM Acquisto A " +
				       "WHERE A.idDipendente = "+idDipendete;
		ArrayList<gestionale.magazzino.Acquisto> risultato = new ArrayList<gestionale.magazzino.Acquisto>();
		System.out.println(query);
		ResultSet rs = que.eseguiQuery(query);
		try {
			while(rs.next()){
				gestionale.magazzino.Acquisto acq = new gestionale.magazzino.Acquisto(rs.getInt("idAcquisto"),rs.getInt("idDipendente"), rs.getInt("idProdotto"), rs.getInt("idFondo"), rs.getInt("qta"),  rs.getString("dataAcquisto"));
				risultato.add(acq);
			}
		} catch (SQLException e) {
			System.out.println("Eccezione: " + e);
			gestionale.magazzino.Acquisto acq = null;
			risultato.add(acq);
			return risultato;
		}
		return risultato;
	}
	
	
	/**
	 * Questo metodo visualizza un singolo acquisto in base all'id dell'acquisto.
	 * @param idAcquisto id dell'acquisto
	 * @return un oggetto Acquisto
	 */
	public static gestionale.magazzino.Acquisto visualizzaAcquisto(int idAcquisto){
		que = new Querist();
		String query = "SELECT A.idAcquisto, A.idDipendente, A.idProdotto, A.idFondo, A.qta, A.dataAcquisto " +
						" FROM Acquisto A " +
						" WHERE A.idAcquisto='" + idAcquisto + "'";
		System.out.println(query);
		ResultSet rs = que.eseguiQuery(query);
		gestionale.magazzino.Acquisto acq = null;
		try{
			//acq = new gestionale.magazzino.Acquisto(rs.getInt("idAcquisto"),rs.getString("dipendente"), rs.getString("prodotto"), rs.getString("fondo"), rs.getInt("qta"), rs.getFloat("spesa"), rs.getString("dataAcquisto"));
			acq = new gestionale.magazzino.Acquisto(rs.getInt("idAcquisto"), rs.getInt("idDipendente"), rs.getInt("idProdotto"), rs.getInt("idFondo"), rs.getInt("qta"), rs.getString("dataAcquisto"));
		}catch(SQLException e){
			System.out.println("Eccezione: " + e);
		}
		return acq;
		
	}
	
	/**
	 * Questo metodo visualizza un singolo acquisto in base al nome del prodotto.
	 * @param nomeProdotto nome del prodotto
	 * @return un oggetto Acquisto
	 */
	public static gestionale.magazzino.Acquisto visualizzaAcquisto(String nomeProdotto){
		que = new Querist();
		String query = "SELECT A.idAcquisto, D.nome AS dipendente, P.nome AS prodotto, F.nome AS fondo, A.qta,A.qta * P.prezzoUnita AS spesa, A.dataAcquisto " +
						" FROM Acquisto A, Dipendente D, Prodotto P, Fondo F " +
						" WHERE A.idDipendente = D.idDipendente AND P.nome='"+nomeProdotto+"' AND " +
						"A.idProdotto = P.idProdotto AND " +
						"A.idFondo = F.idFondo ";
		/*
		String query = "SELECT A.idAcquisto, A.idDipendente, A.idProdotto, A.idFondo, A.qta, A.dataAcquisto, A.qta * P.prezzoUnita AS spesa " +
				       "FROM Acquisto A, Prodotto P " +
				       "WHERE P.idProdotto = A.idProdotto AND P.nome='"+nomeProdotto+"'";
		System.out.println(query);*/
		ResultSet rs = que.eseguiQuery(query);
		gestionale.magazzino.Acquisto acq = null;
		try{
			acq = new gestionale.magazzino.Acquisto(rs.getInt("idAcquisto"),rs.getString("dipendente"), rs.getString("prodotto"), rs.getString("fondo"), rs.getInt("qta"), rs.getFloat("spesa"), rs.getString("dataAcquisto"));
		}catch(SQLException e){
		}
		return acq;
		
	}
	
	public static void reindexTable(){
		que = new Querist();
		String query = "REINDEX 'Acquisto'";
		que.eseguiQueryUpdate(query);
	}
}
