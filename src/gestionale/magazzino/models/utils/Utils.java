package gestionale.magazzino.models.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import gestionale.magazzino.Querist;

/**
 * Query di utilità.
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
		que = new Querist();
		String query = "SELECT last_insert_rowid();";
		ResultSet rs = que.eseguiQuery(query);
		int id=0;
		try{
			id = rs.getInt("ID");
		}catch(SQLException e){
		}
		return id;
	}

}
