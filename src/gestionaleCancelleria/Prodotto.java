package gestionaleCancelleria;

/**
 * @author Matteo Calò
 * Questa classe descrive il prodotto di cancelleria
 *
 */
public class Prodotto {
	private int Id_Prodotto;
	private String nome;
	private String quantità;
	private float prezzo;
	
	
	/**
	 * @param id_Prodotto Identificativo del prodotto
	 * @param nome Nome del prodotto
	 * @param quantità Quantità del prodotto
	 * @param prezzo Prezzo del prodotto unitario
	 */
	public Prodotto(int id_Prodotto, String nome, String quantità, float prezzo) {
		super();
		Id_Prodotto = id_Prodotto;
		this.nome = nome;
		this.quantità = quantità;
		this.prezzo = prezzo;
	}


	
	/**
	 * Metodi Get e Set
	 */
	public int getId_Prodotto() {
		return Id_Prodotto;
	}


	public void setId_Prodotto(int id_Prodotto) {
		Id_Prodotto = id_Prodotto;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getQuantità() {
		return quantità;
	}


	public void setQuantità(String quantità) {
		this.quantità = quantità;
	}


	public float getPrezzo() {
		return prezzo;
	}


	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	
	
}
