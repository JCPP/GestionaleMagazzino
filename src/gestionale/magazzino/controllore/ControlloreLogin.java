package gestionale.magazzino.controllore;

import gestionale.magazzino.Dipendente;
import gestionale.magazzino.MyListener;
import gestionale.magazzino.controllore.dipendente.ControlloreAccount;
import gestionale.magazzino.controllore.dipendente.ControlloreDipendente;
import gestionale.magazzino.controllore.responsabile.ControlloreResponsabile;
import gestionale.magazzino.grafica.cancelleria.GraficaLogin;
import gestionale.magazzino.grafica.cancelleria.GraficaRegistrazione;
import gestionale.magazzino.grafica.dipendente.finestre.GraficaDipendente;
import gestionale.magazzino.grafica.responsabile.finestre.GraficaResponsabile;

import javax.swing.JOptionPane;

public class ControlloreLogin {
	private GraficaLogin grafica_Login;
	private ControlloreDipendente controlloreDipendente;
	private ControlloreRegistrazione controlloreRegistrazione;
	private ControlloreResponsabile controlloreResponsabile;
	private MyListener listener;
	private Dipendente dip;
	
	public ControlloreLogin(ControlloreDipendente controlloreD,ControlloreRegistrazione controlloreR,ControlloreResponsabile controlloreResp)
	{
		this.controlloreDipendente = controlloreD;
		this.controlloreRegistrazione = controlloreR;
		this.controlloreResponsabile = controlloreResp;
		grafica_Login = new GraficaLogin();
		listener = new MyListener();
		dip = new Dipendente();
	}
	
	public void start()
	{
		grafica_Login.init();
	}
	/**
	 * raccoglie i dati dai campi di login e controlla se l'utente puo effettuare l'accesso interrogando il database.
	 * in caso negativo mostra gli errori commessi dall'utente nel inserire le credenziali
	 * in caso positivo mostra l'avvenuto accesso al sistema e mostra la finestra del catalogo
	 */
	public int isConnected()
	{
		int stato = 0;
		grafica_Login.pulisciErrori();
		String email = grafica_Login.getEmail();
		String password = grafica_Login.getPassword();
		boolean b1 = gestionale.magazzino.models.Dipendente.validateEmail(email);
		boolean b2 = gestionale.magazzino.models.Dipendente.validatePassword(email, password);
		boolean b3 = gestionale.magazzino.models.Dipendente.validateResponsabile(email, password);
		boolean b4 = gestionale.magazzino.models.Dipendente.isActive(email);
		if(b2)
		{
			if(b3)
			{
				if(b4)
				{
					stato = 3;
					dip = new Dipendente();
					dip = gestionale.magazzino.models.Dipendente.visualizzaDipendente(email, password);
					JOptionPane.showMessageDialog(grafica_Login, "Login Effetuato");
					controlloreResponsabile.setDipendente(dip);
					controlloreResponsabile.start();
					listener.setTable(controlloreResponsabile.getTabellaNotifiche());
					grafica_Login.disposeF();
				}
				if(!b4)
				{
					JOptionPane.showMessageDialog(grafica_Login, "Utente Disabilitato");
				}
				
			}
			else
			{
				if(b4)
				{
					stato = 1;
					dip = new Dipendente();
					dip = gestionale.magazzino.models.Dipendente.visualizzaDipendente(email, password);
					JOptionPane.showMessageDialog(grafica_Login, "Login Effetuato");
					controlloreDipendente.setDipendente(dip);
					controlloreDipendente.start();
					listener.setTable(controlloreDipendente.getTabellaProdotti());
					grafica_Login.disposeF();
				}
				if(!b4)
				{
					JOptionPane.showMessageDialog(grafica_Login, "Utente Disabilitato");
				}
				
			}

		}
		else
		{
			stato = 0;
			if(!b1 && !b2)
			{
				grafica_Login.setErroreEmail("Email errata");
				grafica_Login.setErrorePass("Password errata");
			}
			if(!b1)
			{
				grafica_Login.setErroreEmail("Email errata");
			}
			else
			{
				grafica_Login.setErrorePass("Password errata");
			}
		}
		
		return stato;
		
	}
	
	/**
	 * disalloca le componenti grafiche alla disconnessione dell'utente
	 */
	public void disconnect()
	{
		grafica_Login.disposeF();
	}
	
	/**
	 * mostra la finestra grafica di registrazione
	 */
	public void registering()
	{
		controlloreRegistrazione.start();
		grafica_Login.disposeF();
	}
	
	public Dipendente getDipendente()
	{
		return dip;
	}
	
}
