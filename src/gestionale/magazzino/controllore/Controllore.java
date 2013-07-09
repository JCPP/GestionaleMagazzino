package gestionale.magazzino.controllore;

import gestionale.magazzino.EmailValidator;
import gestionale.magazzino.grafica.cancelleria.GraficaLogin;
import gestionale.magazzino.grafica.cancelleria.GraficaRegistrazione;
import gestionale.magazzino.grafica.cancelleria.MyModel;
import gestionale.magazzino.grafica.dipendente.finestre.GraficaDipendente;
import gestionale.magazzino.grafica.dipendente.finestre.ModificaProdotto;
import gestionale.magazzino.grafica.dipendente.finestre.VisualizzaProdotto;
import gestionale.magazzino.grafica.dipendente.pannelli.GraficaAccount;
import gestionale.magazzino.grafica.dipendente.pannelli.GraficaCarrello;
import gestionale.magazzino.grafica.dipendente.pannelli.GraficaProdotti;
import gestionale.magazzino.grafica.responsabile.finestre.GraficaDipendenteSlezionato;
import gestionale.magazzino.grafica.responsabile.finestre.GraficaInsProdotto;
import gestionale.magazzino.grafica.responsabile.finestre.GraficaModificaProdotto;
import gestionale.magazzino.grafica.responsabile.finestre.GraficaNotificaSelezionata;
import gestionale.magazzino.grafica.responsabile.finestre.GraficaResponsabile;
import gestionale.magazzino.grafica.responsabile.pannelli.GraficaAccountResponsabile;
import gestionale.magazzino.grafica.responsabile.pannelli.GraficaMagazzino;

import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class Controllore {
	
	
	
	/** 
	 * Controlla campo vuoto, lunghezza e uguaglianza con la seconda password in fase di registrazione
	 * @return il numero dell'errore, in modo d poterlo gestire singolarmente
	 * @return 1 se la password è vuota
	 * @return 2 se la password è maggiore di 12
	 * @return 3 se le password non sono uguali
	 */
	public boolean checkPassword(String pass, String pass2){
		int noErr = 0;
		boolean b = false;
		if(pass.isEmpty()){
			noErr = 1;
			b = false;
		}else if(pass.length() >12){
			noErr = 2;
			b = false;
		}else if(!pass.equals(pass2)){
			noErr = 3;
			b = false;
		}else if(pass.equals(pass2)){
			b = true;
		}
		
		return b;
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
