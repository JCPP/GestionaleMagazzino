package gestionaleCancelleria;

import java.sql.ResultSet;

/**
 * 
 * @author Matteo Calò
 * Questa classe descrive il dipendente.
 */

public class Dipendente {
	private int id_Dipendente;
	private String nome;
	private String cognome;
	private String tipo;
	private String password;
	private String email;
	
	
	/**
	 * Il costruttore della classe
	 * @param id_Dipendente Identificativo in DB del dipendente
	 * @param nome Nome del dipendente
	 * @param cognome Cognome del dipendente
	 * @param tipo Descrive se il dipendente è un responsabile di magazzino
	 * @param email L'email del dipendente
	 */
	public Dipendente(int id_Dipendente, String nome, String cognome,
			String tipo, String password, String email) {
		super();
		this.id_Dipendente = id_Dipendente;
		this.nome = nome;
		this.cognome = cognome;
		this.password = password;
		this.tipo = tipo;
		this.email = email;
	}

	/**
	 * Metodi Get e Set
	 */

	public int getId_Dipendente() {
		return id_Dipendente;
	}
	public void setId_Dipendente(int id_Dipendente) {
		this.id_Dipendente = id_Dipendente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getTip() {
		return tipo;
	}
	public void setTipo(String tipo_dipendente) {
		this.tipo = tipo_dipendente;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Questo metodo aggiunge il Dipendente al Database,
	 * da usare a seguito di un form con relativi controlli preposti
	 */
	public void addMeDB(){
		String query = "INSERT INTO magazzino.dipendente (idDipendente,nome,cognome,email,password,tipo)"+
						"VALUES ("+id_Dipendente+","+nome+","+cognome+","+email+","+password+","+tipo+")";
		Connettore conn = new Connettore();
		conn.caricadriver();
		conn.collegati();
		conn.eseguiQuery(query);
	}
	
	
	

	
	
	
	
	
}
