package gestionale.magazzino;

import java.util.concurrent.ExecutionException;

import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class Main {
	
	private static Connettore conn;
	private static int a;
	private static Controllore controllo;
	private static int z;

	public static void main(String[] args) 
	{
		/**
		 * Metodo per gestire il multithreading nelle finestre swing
		 */
		SwingUtilities.invokeLater(new Runnable()
        {
             /**
              * thread principale
              */
            public void run() 
            {
            	
    			conn = new Connettore();
    			a = 1;
    			z = 0;
    			conn.caricadriver();
        		conn.collegati();
        		controllo = new Controllore();
        		/**
        		 * Overridding del metodo worker,qui vengono eseguiti i thread secondari
        		 */
                SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>()
                {
                	/**
                	 * thread che vengono eseguiti in background;
                	 * istruzioni o funzioni che richiedono elaborazioni complesse e di grandi dimensioni devono essere eseguite in questa funzione (esempio: operazioni con vettori dinami e/o file e/o connessioni internet)
                	 * (bisogna usare all'interno thread.sleep() per evitare che il programma continui la sua esecuzione prima che tutte le operazioni necessarie siano effettuate
                	 */
                	protected Boolean doInBackground() throws Exception 
                	{
                		
            			controllo.start();
                		return true;
                	};
  			        
                	/**
                	 * simile alla funzione doInBackground ma meno performante,potrebbe causare il freeze del programma
                	 * i risultati elaborati in questa funzione devono poi essere gestiti in un altra (non ricordo il nome xD,comunque provando in passato,non funzionava bene il passaggio di parametri tra queste due funzioni,i risultati non venivano elaborati)
                	 */
                	protected void process() 
                	{
                	}
                	/**
                	 * funzione che viene chiamata alla fine dei cicli presenti in doInBackground (in questo caso,appena il programma parte in quanto non ci sono cicli di controllo di vita del programma (da ottimizzare))
                	 * in genere in questa funzione si fa il rilascio di tutte le risorse o il salvataggio di dati prima che il programma venga terminato
                	 */
                	protected void done() 
                	{
  	              		
                		boolean status;
                		try {
                			
                			status = get();
                		} catch (InterruptedException e) {
                		} catch (ExecutionException e) {
                		}catch(NullPointerException awt){
                        }
                		
                	}
  				   
                };
                /**
                 * worker.execute() fa partire il metodo worker presente in run()
                 * puo essere richiamato per far rieseguire il metodo worker e le funzioni al suo interno
                 */
  		worker.execute();
		}
      });
	}
	
	/**
	 *  metodo per la gestione degli eventi
	 *  l'attributo a viene utilizzato per controllare quale delle due tabelle l'utente sta attualmente visualizzando(catalogo,controllo)
	 * @param evento
	 */
	public void start(String evento)
	{
		System.out.println(evento);
		// controlli legati al WindowListener
		/**
		 * aggiorna la visuale del carrello dopo che un oggetto è stato selezionato (da ottimizzare)
		 */
		if(evento.equals("Carrello Dipendente"))
		{
			controllo.updateCarrello(z);
		}
		/**
		 * aggiorna la visuale del catalogo dopo che un oggetto è stato selezionato (da ottimizzare)
		 */
		if(evento.equals("Catalogo Dipendente"))
		{
			controllo.updateCatalogo(z);
		}
		/**
		 * chiude la finestra graficaDipendente (windowListener non funzionava....)
		 */
		if(evento.equals("dispose Dipendente"))
		{
			controllo.disposeDipendente();
		}
		
		if(evento.equals("Magazzino Responsabile"))
		{
			controllo.updateMagazzino(z);
		}
		if(evento.equals("dispose Responsabile"))
		{
			controllo.disposeResp();
		}
		if(evento.equals("Modifica Prodotto"))
		{
			controllo.updateMagazzino(z);
		}
		if(evento.equals("Notifiche Responsabile"))
		{
			controllo.updateNotifiche(z);
		}
		if(evento.equals("Lista"))
		{
			controllo.updateDipendenti(z);
		}
		//controlli legati alle tabelle
		/**
		 * se a == 4 siamo nella lista dipendenti
		 */
		
		if(evento.endsWith("3") && a == 4)
		{
			String s = evento;
			int x = 0;
			x = Integer.parseInt(s.substring(0, s.length()-1));
			z = x;
			controllo.showDipendente(x);
		}	
		/**
		 * se a == 3 siamo nelle notifiche
		 */
		if(evento.endsWith("3") && a == 3)
		{
			String s = evento;
			int x = 0;
			x = Integer.parseInt(s.substring(0, s.length()-1));
			z = x;
			controllo.showNotifica(x);
		}
		/**
		 * se a == 2 siamo nel magazzino
		 */
		if(evento.endsWith("4") && a == 2)
		{
			String s = evento;
			int x = 0;
			x = Integer.parseInt(s.substring(0, s.length()-1));
			z = x;
			controllo.showModificaProdotto(x);
		}
		/**
		 * se a == 1 siamo nel catalogo
		 * invia la riga selezionata al controllore che mostra il prodotto corrispondente
		 */
		if(evento.endsWith("4") && a == 1)
		{
			String s = evento;
			int x = 0;
			x = Integer.parseInt(s.substring(0, s.length()-1));
			z = x;
			controllo.showProdotto(x);
			
		}
		/**
		 * se a == 0 siamo nel carrello
		 * invia la riga selezionata al controllo che mostra l'ordine corrispondente
		 */
		if(evento.endsWith("4") && a == 0)
		{
			String s = evento;
			int x = 0;
			x = Integer.parseInt(s.substring(0, s.length()-1));
			z = x;
			controllo.showOrdinato(x);
		}
		
		//Controlli legati agli eventi dei bottoni
		switch(evento)
		{
		//casi login
			case "Connetti":
				a = controllo.isConnected();
				break;
			case "Password":
				a = controllo.isConnected();
				break;
			case "Chiudi":
				controllo.disconnect();
				break;
			case "Registrati":
				controllo.registering();
				break;
		//casi registrazione
			case "Indietro":
				controllo.logging();
				break;
			case "Reset":
				controllo.resetRegistrazione();
				break;
			case "Invio":
				controllo.registered();
				break;
			//casi dipendente
			case "Account":
				controllo.showAccount();
				break;
			case "Catalogo":
				a = 1;
				controllo.showCatalogo();
				break;
			case "Carrello":
				a = 0;
				controllo.showCarrello();
				break;
			case "Logout":
				controllo.doLogout();
				break;
			case "Exit":
				controllo.disposeDipendente();
				break;
				//casi responsabile
			case "Account Responsabile":
				controllo.showAccountResp();
				break;
			case "Catalogo Responsabile":
				a = 2;
				controllo.showMagazzino();
				break;
			case "Aggiungi Prodotto":
				a = 2;
				controllo.showOption();
				break;
			case "Notifiche Responsabile":
				a = 3;
				controllo.showNotifiche();
				break;
			case "Lista Dipendenti":
				a = 4;
				controllo.showListaDip();
				break;
			case "Logout Responsabile":
				controllo.logoutResp();
				break;
			case "Exit Responsabile":
				controllo.disposeResp();
				break;
			//casi ordina prodotto
			case "Ordina":
				controllo.controlloOrdine(z);
				break;
			case "Annulla":
				controllo.gotoCatalogo(z);
				break;
			//casi magazzino
			case "Inserisci Prodotto":
				controllo.inserisciProdotto();
				break;
			case "Annulla Inserimento":
				controllo.gotoMagazzino(0);
				break;
			case "Modifica Prodotto Responsabile":
				controllo.modificaProdottoResponsabile();
				break;
			case "Rimuovi Prodotto Responsabile":
				controllo.rimuoviProdottoResponsabile();
				break;
			case "Annulla Modifica Responsabile":
				controllo.gotoMagazzino2();
				break;
			//casi notifiche
			case "Elimina Notifiche":
				controllo.eliminaNotifica();
				break;
			case "Indietro Notifiche":
				controllo.gotoNotifiche(z);
				break;
			//metodi lista dipendenti
			case "Modifica Dipendente Responsabile":
				controllo.modificaDipendenteResp();
				break;
			case "Rimuovi Dipendente Responsabile":
				controllo.rimuoviDipendenteResp();
				break;
			case "Annulla Dipendente Responsabile":
				controllo.gotoDipendenti();
				break;
			default:
				break;

		}
	}
	
}



