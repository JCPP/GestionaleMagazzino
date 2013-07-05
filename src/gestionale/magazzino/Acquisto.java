package gestionale.magazzino;

public class Acquisto {
	private int idAcquisto;
	private int idDipendente;
	private String nomeDipendente;
	private int idProdotto;
	private String nomeProdotto;
	private int idFondo;
	private String nomeFondo;
	private int qta;
	private float spesa;
	private String dataAcquisto;
	
	
	public Acquisto(int idAcquisto, String nomeDipendente, String nomeProdotto, String nomeFondo, int qta,
			float spesa, String dataAcquisto) {
		this.idAcquisto = idAcquisto;
		this.nomeDipendente = nomeDipendente;
		this.nomeProdotto = nomeProdotto;
		this.nomeFondo = nomeFondo;
		this.qta = qta;
		this.spesa = spesa;
		this.dataAcquisto = dataAcquisto;
	}

	public Acquisto(int idAcquisto, int idDipendente, int idProdotto, int idFondo, int qta, String dataAcquisto){
		this.idAcquisto = idAcquisto;
		this.idDipendente = idDipendente;
		this.idProdotto = idProdotto;
		this.idFondo = idFondo;
		this.qta = qta;
		this.dataAcquisto = dataAcquisto;
	}
	
	public Acquisto() {
		super();
	}


	/**
	 * @return the idAcquisto
	 */
	public int getIdAcquisto() {
		return idAcquisto;
	}
	
	


	/**
	 * @param idAcquisto the idAcquisto to set
	 */
	public void setIdAcquisto(int idAcquisto) {
		this.idAcquisto = idAcquisto;
	}
	
	public void setIdDipendente(int idDipendente) {
		this.idDipendente = idDipendente;
	}
	
	public void setIdProdotto(int idProdotto)
	{
		this.idProdotto = idProdotto;
	}
	public void setIdFondo(int idFondo)
	{
		this.idFondo = idFondo;
	}


	/**
	 * @return the nomeDipendente
	 */
	public String getNomeDipendente() {
		return nomeDipendente;
	}


	/**
	 * @param nomeDipendente the nomeDipendente to set
	 */
	public void setNomeDipendente(String nomeDipendente) {
		this.nomeDipendente = nomeDipendente;
	}


	/**
	 * @return the nomeProdotto
	 */
	public String getNomeProdotto() {
		return nomeProdotto;
	}


	/**
	 * @param nomeProdotto the nomeProdotto to set
	 */
	public void setNomeProdotto(String nomeProdotto) {
		this.nomeProdotto = nomeProdotto;
	}


	/**
	 * @return the nomeFondo
	 */
	public String getNomeFondo() {
		return nomeFondo;
	}


	/**
	 * @param nomeFondo the nomeFondo to set
	 */
	public void setNomeFondo(String nomeFondo) {
		this.nomeFondo = nomeFondo;
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
	 * @return the spesa
	 */
	public float getSpesa() {
		return spesa;
	}


	/**
	 * @param spesa the spesa to set
	 */
	public void setSpesa(float spesa) {
		this.spesa = spesa;
	}


	/**
	 * @return the dataAcquisto
	 */
	public String getDataAcquisto() {
		return dataAcquisto;
	}


	/**
	 * @param dataAcquisto the dataAcquisto to set
	 */
	public void setDataAcquisto(String dataAcquisto) {
		this.dataAcquisto = dataAcquisto;
	}

	/**
	 * @return the idDipendente
	 */
	public int getIdDipendente() {
		return idDipendente;
	}

	/**
	 * @return the idProdotto
	 */
	public int getIdProdotto() {
		return idProdotto;
	}

	/**
	 * @return the idFondo
	 */
	public int getIdFondo() {
		return idFondo;
	}

}