package gestionale.magazzino.controllore;

import gestionale.magazzino.grafica.cancelleria.GraficaLogin;
import gestionale.magazzino.grafica.cancelleria.GraficaRegistrazione;

import javax.swing.JOptionPane;

public class ControlloreRegistrazione {

	private Controllore controllore;
	private GraficaRegistrazione grafica_Registrazione;
	public ControlloreRegistrazione()
	{
		controllore = new Controllore();
		grafica_Registrazione = new GraficaRegistrazione();
	}
	
	/**
	 * mostra la finestra grafica di login dopo che l'utente si è registrato 
	 */
	public void start()
	{
		grafica_Registrazione.init();
	}
	public void dispose()
	{
		grafica_Registrazione.disposeF();
	}
	
	/**
	 * pulisce i campi della finestra di registrazione e gli eventuali errori
	 */
	public void resetRegistrazione()
	{
		grafica_Registrazione.pulisciErrori();
		grafica_Registrazione.pulisci();
	}
	
	/**
	 * controlla se i campi inseriti dall'utente al momento della registrazione sono corretti.
	 * in caso negativo mostra quali campi sono errati
	 * in caso positivo invia i dati al database e notifica l'utente dell'avvenuta registrazione
	 */
	public boolean registered()
	{
		grafica_Registrazione.pulisciErrori();
		boolean b = false;
		String nome = grafica_Registrazione.getNome();
		String cognome = grafica_Registrazione.getCognome();
		String email = grafica_Registrazione.getEmail();
		String password = grafica_Registrazione.getPassword();
		String password2 = grafica_Registrazione.getPassword2();
		b = controllore.validateSintassiEmail(email);
		if(b)
		{
			b = controllore.checkPassword(password, password2);
			if(!b)
			{
				grafica_Registrazione.setErrorePassword2("Le password non coincidono");
				b = false;
			}
			if(nome.isEmpty())
			{
				grafica_Registrazione.setErroreNome("Nome non valido");
				b = false;
			}
			if(cognome.isEmpty())
			{
				grafica_Registrazione.setErroreCognome("Cognome non valid");
				b = false;
			}
			if(b)
			{
				b = gestionale.magazzino.models.Dipendente.validateEmail(email);
				if(!b)
				{
					this.isRegistered(nome,cognome,password,email);
					JOptionPane.showMessageDialog(grafica_Registrazione, "Registrazione effetuata");
					grafica_Registrazione.disposeF();
					b = true;
					
				}
				else
				{
					b = false;
					grafica_Registrazione.setErroreEmail("Email gia presente nell'archivio");
				}
			}
		}
		else 
		{
			b = false;
			grafica_Registrazione.setErroreEmail("Email non valida");
			b = controllore.checkPassword(password, password2);
			if(!b)
			{
				grafica_Registrazione.setErrorePassword2("Le password non coincidono");
				b = false;
			}
			if(nome.isEmpty())
			{
				grafica_Registrazione.setErroreNome("Nome non valido");
				b = false;
			}
			if(cognome.isEmpty())
			{
				grafica_Registrazione.setErroreCognome("Cognome non valid");
				b = false;
			}
		}	
		
		return b;
		
	}
	
	/**
	 * controlla se l'utente puo effettuare la registrazione oppure se è gia registrato al sistema
	 * 
	 * @param nome
	 * @param cognome
	 * @param password
	 * @param email
	 */
	public void isRegistered(String nome,String cognome,String password,String email)
	{
		String tipo = "dipendente";
		gestionale.magazzino.models.Dipendente.inserisciDipendente(nome, cognome, password, email, tipo);
	}
	
}
