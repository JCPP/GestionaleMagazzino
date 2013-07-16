package gestionale.magazzino;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connettore {
	/**
	 * Creare un oggetto Connection, fondamentale per applicazioni SQL. 
	 * Il mio consiglio è quello di dichiararlo public e static in modo tale che tutti i metodi
	 * che andrete a creare potranno usufruire delle sue potenzialità.
	 */
	public static Connection conn;
	public static Statement stat;
	
	private static boolean driverCaricati = false;
	private static boolean collegamentoEffettuato = false;
	
	/**
	 * Classe non istanziabile.
	 */
	private Connettore() {
	}
	
	
	/**
	 * Ora dobbiamo caricare il driver JDBC strumento utilissimo in quanto 
	 * traduce le operazioni java in sql e si connette con il database.
	 */
	public static void caricadriver() {
		if(!driverCaricati){
			try {  
				Class.forName("org.sqlite.JDBC");
				driverCaricati = true;
			} catch(ClassNotFoundException e) {
				System.out.println(e.getMessage());
				System.out.println("Driver SQL non trovato");
				System.exit(1);
			}
		}
	}
	
	/**
	 * Metodo che istaura la connessione al database già creato
	 */
	public static void collegati(){
		if(!collegamentoEffettuato){
			try {
				conn = DriverManager.getConnection("jdbc:sqlite:./database/magazzino.sqlite");
				stat = conn.createStatement();
				collegamentoEffettuato = true;
			} catch(SQLException e) {
				System.out.println(e.getMessage());
				System.out.println("Collegamento non riuscito");
				System.exit(1);
			}
		}
	}

}

