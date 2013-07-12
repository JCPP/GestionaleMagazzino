package gestionale.magazzino;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;



public class Querist {
	private static Connection conn;
	//private static Connettore connettore;

public Querist(){
		super();
	}

/**
 * @param query rappresenta la query che gli passiamo
 * @return ResultSet, l'insieme di record risultati della query al database
 */
public void eseguiQueryUpdate(String query){
	//connettore = new Connettore();
	try{
		Connettore.stat.executeUpdate(query);
		Connettore.stat.close();
	}catch(SQLException e){
		System.out.println("Errore no. " + e.getErrorCode() + " : " + e.getMessage());
	}
}
/**
 * @param query rappresenta la query che gli passiamo
 * @return ResultSet, l'insieme di record risultati della query al database
 */
public ResultSet eseguiQuery(String query){
	ResultSet rs = null;
	try{
		rs = Connettore.stat.executeQuery(query);
	}catch(SQLException e){
		System.out.println("Errore no. " + e.getErrorCode() + " : " + e.getMessage());
	}
	return rs;

}
}