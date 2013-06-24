package gestionaleCancelleria;

/**
 * @author Matteo Calò
 * Questa classe descrive il fondo di investimenti
 */
public class Fondo {
	private int idFondo;
	private String nome;
	private double importo;
	
	/**
	 * @param id_Fondo Identificativo del fondo
	 * @param nome Nome del fondo
	 * @param importo Importo disponibile sul fondo in quel momento
	 */
	public Fondo(int id_Fondo, String nome, double importo) {
		super();
		idFondo = id_Fondo;
		this.nome = nome;
		this.importo = importo;
	}

	

	/**
	 * Metodi Get e Set
	 */
	public int getId_Fondo() {
		return idFondo;
	}

	public void setId_Fondo(int id_Fondo) {
		idFondo = id_Fondo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getImporto() {
		return importo;
	}

	public void setImporto(double importo) {
		this.importo = importo;
	}
	
	
}
