package gestionale.magazzino;

import java.sql.Date;

public class Notifica {
	private int idNotifica;
	private int idDipendente;
	private int idDipendenteNotificato;
	private String notifica;
	private String data;
	private boolean isValidate;


	public Notifica(int idNotifica, int idDipendente, int idDipendenteNotificato, String notifica, String dataNotifica, boolean isValidate) {
		this.idNotifica = idNotifica;
		this.idDipendente = idDipendente;
		this.idDipendenteNotificato = idDipendenteNotificato;
		this.notifica = notifica;
		this.data = dataNotifica;
		this.isValidate = isValidate;
	}
	public Notifica() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the idNotifica
	 */
	public int getIdNotifica() {
		return idNotifica;
	}
	/**
	 * @param idNotifica the idNotifica to set
	 */
	public void setIdNotifica(int idNotifica) {
		this.idNotifica = idNotifica;
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
	 * @return the idDipendenteNotificato
	 */
	public int getIdDipendenteNotificato() {
		return idDipendenteNotificato;
	}
	/**
	 * @param idDipendenteNotificato the idDipendenteNotificato to set
	 */
	public void setIdDipendenteNotificato(int idDipendenteNotificato) {
		this.idDipendenteNotificato = idDipendenteNotificato;
	}
	/**
	 * @return the notifica
	 */
	public String getNotifica() {
		return notifica;
	}
	/**
	 * @param notifica the notifica to set
	 */
	public void setNotifica(String notifica) {
		this.notifica = notifica;
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
