package gestionaleCancelleria;


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


}