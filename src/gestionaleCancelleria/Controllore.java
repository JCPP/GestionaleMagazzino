package gestionaleCancelleria;

import modelsCancelleria.Dipendente;

public class Controllore {
	
	
	
	/** 
	 * Controlla campo vuoto, lunghezza e uguaglianza con la seconda password in fase di registrazione
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
	 * Controlla la validità sintattica della email
	 * @param email l'email da prendere in esame
	 * @return true o false in base alla validità della formattazione
	 */
	public boolean validateSintassiEmail(String email){
		EmailValidator ev = new EmailValidator();
		boolean emailValida = ev.validate(email);
		
		return emailValida;
	}

	
}
