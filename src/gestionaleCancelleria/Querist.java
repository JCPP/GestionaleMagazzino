package gestionaleCancelleria;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;



public class Querist {
	private static Connection conn;
	private static Connettore connettore;

public Querist(){
		super();
	}

/**
 * @param query rappresenta la query che gli passiamo
 * @return ResultSet, l'insieme di record risultati della query al database
 */
public void eseguiQueryUpdate(String query){
	connettore = new Connettore();
	try{
		connettore.caricadriver();
		connettore.collegati();
		System.out.println("Sono qui: "+query);
		Statement stat = conn.createStatement();
		System.out.println("Sono buono:" +query);
		stat.executeUpdate(query);

		conn.close();
		stat.close();
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
	connettore = new Connettore();
	try{
		connettore.caricadriver();
		connettore.collegati();
		Statement stat = conn.createStatement();
		rs = stat.executeQuery(query);
	}catch(SQLException e){
		System.out.println("Errore no. " + e.getErrorCode() + " : " + e.getMessage());
	}
	return rs;

}
}