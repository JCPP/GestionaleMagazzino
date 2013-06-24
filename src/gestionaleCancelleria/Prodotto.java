package gestionaleCancelleria;

/**
 * @author Matteo Calò
 * Questa classe descrive il prodotto di cancelleria
 *
 */
public class Prodotto {
	private int idProdotto;
	private String nome;
	private String qta;
	private float prezzo;
	
	
	/**
	 * @param id_Prodotto Identificativo del prodotto
	 * @param nome Nome del prodotto
	 * @param quantità Quantità del prodotto
	 * @param prezzo Prezzo del prodotto unitario
	 */
	public Prodotto(int id_Prodotto, String nome, String quantità, float prezzo) {
		super();
		idProdotto = id_Prodotto;
		this.nome = nome;
		this.qta = quantità;
		this.prezzo = prezzo;
	}


	
	/**
	 * Metodi Get e Set
	 */
	public int getId_Prodotto() {
		return idProdotto;
	}


	public void setId_Prodotto(int id_Prodotto) {
		idProdotto = id_Prodotto;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getQuantità() {
		return qta;
	}


	public void setQuantità(String quantità) {
		this.qta = quantità;
	}


	public float getPrezzo() {
		return prezzo;
	}


	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	
	
}
