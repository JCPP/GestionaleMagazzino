package gestionaleCancelleria;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Querist {
	
public Querist(){
		super();
	}

/**
 * 
 * @param nome nome del dipendente
 * @param cognome cognome del dipendente
 * @param pass password del dipendente
 * @param email email del dipendente
 * @param tipo tipo del dipendente
 */
public void inserisciDipendente(String nome, String cognome, String pass, String email, String tipo){
	Connettore conn = new Connettore();
	String query = "INSERT INTO TABLE magazzino.dipendente(,nome,cognome,email,password,tipo)"+
			"(,"+nome+","+cognome+","+pass+","+email+","+tipo+")";
	conn.caricadriver();
	conn.collegati();
	conn.eseguiQuery(query);

}

/**
 * 
 * @param nome nome del prodotto
 * @param qta quantità del prodotto
 * @param prezzoUnita prezzo unitario del prodotto
 */
public void inserisciProdotto(String nome, int qta, float prezzoUnita){
	Connettore conn = new Connettore();
	String query = "INSERT INTO TABLE magazzino.prodotto(,nome,qta,prezzoUnita)"+
			"(,"+nome+","+qta+","+prezzoUnita+")";
	conn.caricadriver();
	conn.collegati();
	conn.eseguiQuery(query);
}

/**
 * 
 * @param nome nome del fondo
 * @param fondoDisponibile l'importo ancora disponibile per il fondo
 */
public void inserisciFondo(String nome, float fondoDisponibile){
	Connettore conn = new Connettore();
	String query = "INSERT INTO TABLE magazzino.fondo(,nome,fondoDisponibile)"+
			"(,"+nome+","+fondoDisponibile+")";
	conn.caricadriver();
	conn.collegati();
	conn.eseguiQuery(query);
}

/**
 * La query non vede inserita la data in quanto in fase di progettazione 
 * del database è stata impostata CURRENT_TIMESTAMP
 * @param idDipendente
 * @param idProdotto
 * @param idFondo
 * @param qta quantità del prodotto comprata
 */
public void inserisciAcquisto(int idDipendente, int idProdotto, int idFondo, int qta){
	Connettore conn = new Connettore();
	String query = "INSERT INTO TABLE magazzino.acquisto(,idDipendente,idProdotto,idFondo,qta,)"+
			"(,"+idDipendente+","+idProdotto+","+idFondo+","+qta+",)";
	conn.caricadriver();
	conn.collegati();
	conn.eseguiQuery(query);
}

/**
 * La query non vede inserita la data in quanto in fase di progettazione 
 * del database è stata impostata CURRENT_TIMESTAMP
 * @param idDipendente id del dipendente
 * @param idProdotto id del prodotto
 * @param qta quantità aggiunta
 */
public void inserisciAggiornamento(int idDipendente, int idProdotto, int qta){
	Connettore conn = new Connettore();
	String query = "INSERT INTO TABLE magazzino.aggiornamento(,idDipendente,idProdotto,qta,)"+
			"(,"+idDipendente+","+idProdotto+","+qta+",)";
	conn.caricadriver();
	conn.collegati();
	conn.eseguiQuery(query);
}

/**
 * La query non vede inserita la data in quanto in fase di progettazione 
 * del database è stata impostata CURRENT_TIMESTAMP
 * @param idNotifica id della notifica
 * @param idDipendente id del dipendente responsabile
 * @param idDipendenteNotificato id del dipendente notificato
 * @param notifica il testo della notifica
 */
public void inserisciNotifica(int idNotifica, int idDipendente, int idDipendenteNotificato, String notifica){
	Connettore conn = new Connettore();
	String query = "INSERT INTO TABLE magazzino.notifica(,idDipendente,idDipendenteNotificato,notifica,)"+
			"(,"+idDipendente+","+idDipendenteNotificato+","+notifica+",)";
	conn.caricadriver();
	conn.collegati();
	conn.eseguiQuery(query);
}

/**
 * Questo metodo restituisce i nomi dei fondi presenti nel database aventi un fondo disponibile maggiore di 0
 * @return Il ritorno è un arraylist di stringhe contenenti i risultati, in caso di errore ritorna l'arraylist con il messaggio di errore
 */
public ArrayList<String> visualizzaFondi (){
	Connettore conn = new Connettore();
	String query = "SELECT F.Nome" +
				   "FROM magazzino.fondo F" +
				   "HAVING F.fondoDisponibile > 0";
	conn.caricadriver();
	conn.collegati();
	ResultSet rs = conn.eseguiQuery(query);
	ArrayList<String> risultato = new ArrayList<String>();
	
	try {
		while(rs.next()){
			risultato.add(rs.getString("nome"));
		}
	} catch (SQLException e) {
		risultato.add(e.getMessage());
		return risultato;
	}
	return risultato; 
}

/**
 * Questo metodo restituisce tutti i prodotti in database
 * @return ritorna un arraylist di prodotti, in caso di errore un null
 */
public ArrayList<Prodotto> visualizzaProdotto(){
	ArrayList<Prodotto> risultato = new ArrayList<Prodotto>();
	Connettore conn = new Connettore();
	String query = "SELECT = *" +
				   "FROM magazzino.prodotto P";
	conn.caricadriver();
	conn.collegati();
	ResultSet rs = conn.eseguiQuery(query);
	
	try {
		Prodotto pr;
		while(rs.next()){
			pr = new Prodotto(rs.getInt("idProdotto"),rs.getString("nome"), rs.getInt("qta"), rs.getFloat("prezzoUnita"));
			risultato.add(pr);
		}
	} catch (SQLException e) {
		Prodotto pr = null;
		risultato.add(pr);
		return risultato;
	}
	return risultato; 
}

/**
 * Il metodo verifica le occorrenze dell'email fornita, per essere valida le occorrenze non devono essere presenti
 * @param email l'email da confrontare
 * @return ritorna una boolean coerente con la validita della email inserita
 */
public boolean validateEmail (String email){
	Connettore conn = new Connettore();
	boolean valida = false;
	String query = "SELECT COUNT(D.email) AS occorrenze" +
				   "FROM magazzino.dipendente D" +
				   "WHERE D.email = "+email;
	conn.caricadriver();
	conn.collegati();
	ResultSet rs = conn.eseguiQuery(query);
	int risultato = 0;

	try {
		while(rs.next()){
			risultato = rs.getInt("occorrenze");
			if(risultato == 0){
				valida = true;
			} 		
		}
	} catch (SQLException e) {
		valida = false;
	}
	return valida;
}

/**
 * Questo metodo verifica la validita della password associata ad un email.
 * @param email l'email da confrontare in combinazione con la password
 * @param password la password da confrontare in combinazione con l'email
 * @return true o false in base alla validità della password associata all'email
 */
public boolean validatePassword (String email, String password){
	Connettore conn = new Connettore();
	boolean valida = false;
	String query = "SELECT COUNT(D.email) AS occorrenze" +
				   "FROM magazzino.dipendente D" +
				   "WHERE D.email = "+email+" AND D.password = "+ password;
	conn.caricadriver();
	conn.collegati();
	ResultSet rs = conn.eseguiQuery(query);
	int risultato = 0;

	try {
		while(rs.next()){
			risultato = rs.getInt("occorrenze");
			if(risultato == 1){
				valida = true;
			} 		
		}
	} catch (SQLException e) {
		valida = false;
	}
	return valida;
}


}