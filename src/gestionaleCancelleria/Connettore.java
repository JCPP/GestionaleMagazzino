package gestionaleCancelleria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connettore {
	/**
	 * Creare un oggetto Connection, fondamentale per applicazioni SQL. 
	 * Il mio consiglio è quello di dichiararlo public e static in modo tale che tutti i metodi
	 * che andrete a creare potranno usufruire delle sue potenzialità.
	 */
	public static Connection conn;
	public Connettore() {
		super();
	}

	
	
	/**
	 * Ora dobbiamo caricare il driver JDBC strumento utilissimo in quanto 
	 * traduce le operazioni java in sql e si connette con il database.
	 */
	public void caricadriver() {
		try {  
			Class.forName("org.sqlite.JDBC"); }
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
			System.out.println("Driver SQL non trovato");
			System.exit(1); }
	}
	
	/**
	 * Metodo che istaura la connessione al database già creato
	 */
	public void collegati(){
		try { conn = DriverManager.getConnection("jdbc:sqlite:./database/magazzino.sqlite"); }
		catch(SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Collegamento non riuscito");
			System.exit(1);
		}
	}

}

