package gestionale.magazzino;

public class Aggiornamento {
	private int idAggiornamento;
	private int idDipendete;
	private int idProdotto;
	private int qta;
	private String data;
	private boolean isValidate;
	
	public Aggiornamento(int idAggiornamento, int idDipendete, int idProdotto,
			int qta, String data, boolean isValidate) {
		super();
		this.idAggiornamento = idAggiornamento;
		this.idDipendete = idDipendete;
		this.idProdotto = idProdotto;
		this.qta = qta;
		this.data = data;
		this.isValidate = isValidate;
	}

	public Aggiornamento(int idAggiornamento, String nomeDipendente,
			String nomeProdotto, int qta, String data, boolean isValidate) {
		super();
		this.idAggiornamento = idAggiornamento;
		this.qta = qta;
		this.data = data;
		this.isValidate = isValidate;
	}

	
	
	/**
	 * @return the idAggiornamento
	 */
	public int getIdAggiornamento() {
		return idAggiornamento;
	}

	/**
	 * @param idAggiornamento the idAggiornamento to set
	 */
	public void setIdAggiornamento(int idAggiornamento) {
		this.idAggiornamento = idAggiornamento;
	}

	/**
	 * @return the idDipendete
	 */
	public int getIdDipendete() {
		return idDipendete;
	}

	/**
	 * @param idDipendete the idDipendete to set
	 */
	public void setIdDipendete(int idDipendete) {
		this.idDipendete = idDipendete;
	}

	/**
	 * @return the idProdotto
	 */
	public int getIdProdotto() {
		return idProdotto;
	}

	/**
	 * @param idProdotto the idProdotto to set
	 */
	public void setIdProdotto(int idProdotto) {
		this.idProdotto = idProdotto;
	}

	/**
	 * @return the qta
	 */
	public int getQta() {
		return qta;
	}

	/**
	 * @param qta the qta to set
	 */
	public void setQta(int qta) {
		this.qta = qta;
	}

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * @return the isValidate
	 */
	public boolean isValidate() {
		return isValidate;
	}

	/**
	 * @param isValidate the isValidate to set
	 */
	public void setValidate(boolean isValidate) {
		this.isValidate = isValidate;
	}


}
