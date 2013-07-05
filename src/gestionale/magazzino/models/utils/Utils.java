package gestionale.magazzino.models.utils;

import gestionale.magazzino.Querist;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Query di utilit�.
 * @author <a href="https://github.com/DavidePastore">Davide Pastore</a>
 *
 */
public class Utils {
	
	static Querist que;
	
	/**
	 * Restituisce l'ultimo ID inserito.
	 * @return Restituisce l'ultimo ID inserito.
	 */
	public static int lastInsertID(){
		int id = 0;
		que = new Querist();
		String query = "SELECT last_insert_rowid() as rowid;";
		ResultSet rs = que.eseguiQuery(query);
		try{
			id = rs.getInt("rowid");
		}catch(SQLException e){
			System.out.println("Eccezione: "+e);
		}
		return id;
	}

}