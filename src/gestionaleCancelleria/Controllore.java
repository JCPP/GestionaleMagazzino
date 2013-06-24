package gestionaleCancelleria;



public class Controllore {
	private Dipendente dipend;
	private Prodotto prod;
	private Fondo fondo;
	private int qtaRichiesta;
	
	public Controllore() {
		super();
	}

	
	public Dipendente getDipend() {
		return dipend;
	}

	public void setDipend(Dipendente dipend) {
		this.dipend = dipend;
	}

	public Prodotto getProd() {
		return prod;
	}

	public void setProd(Prodotto prod) {
		this.prod = prod;
	}

	public Fondo getFondo() {
		return fondo;
	}

	public void setFondo(Fondo fondo) {
		this.fondo = fondo;
	}

	
	/** 
	 * @return il numero dell'errore, in modo d poterlo gestire singolarmente
	 * @return 1 se la password è vuota
	 * @return 2 se la password è maggiore di 12
	 * @return 3 se le password non sono uguali
	 */
	public int checkPassword(String pass, String pass2){
		int noErr = 0;
		if(pass.isEmpty()){
			noErr = 1;
		}else if(pass.length() >12){
			noErr = 2;
		}else if(!(pass == pass2)){
			noErr = 3;
		}
		
		return noErr;
	}
	
	/**
	 * 
	 * @param email l'email da prendere in esame
	 * @return true o false in base alla validità della formattazione
	 */
	public boolean validateEmail(String email){
		EmailValidator ev = new EmailValidator();
		boolean emailValida = ev.validate(email);
		
		return emailValida;
	}

	
}
