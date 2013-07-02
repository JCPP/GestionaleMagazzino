package gestionale.magazzino;


/**
 * 
 * @author Matteo Calò
 * Questa classe descrive il dipendente.
 */

public class Dipendente {
	private int idDipendente;
	private String nome;
	private String cognome;
	private String tipo;
	private String password;
	private String email;
	private boolean isActive;


	/**
	 * Il costruttore della classe
	 * @param id_Dipendente Identificativo in DB del dipendente
	 * @param nome Nome del dipendente
	 * @param cognome Cognome del dipendente
	 * @param tipo Descrive se il dipendente è un responsabile di magazzino
	 * @param email L'email del dipendente
	 */
	public Dipendente(int id_Dipendente, String nome, String cognome,
			 String email, String password, String tipo, boolean isActive) {
		super();
		this.idDipendente = id_Dipendente;
		this.nome = nome;
		this.cognome = cognome;
		this.password = password;
		this.tipo = tipo;
		this.email = email;
		this.isActive = isActive;
	}
	public Dipendente(){
		super();
	}
	/**
	 * Metodi Get e Set
	 */

	public int getId_Dipendente() {
		return idDipendente;
	}
	public void setId_Dipendente(int id_Dipendente) {
		this.idDipendente = id_Dipendente;
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
	 * @return the idDipendente
	 */
	public int getIdDipendente() {
		return idDipendente;
	}
	/**
	 * @param idDipendente the idDipendente to set
	 */
	public void setIdDipendente(int idDipendente) {
		this.idDipendente = idDipendente;
	}
	/**
	 * @return the isActive
	 */
	public boolean isActive() {
		return isActive;
	}
	/**
	 * @param isActive the isActive to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	
}


