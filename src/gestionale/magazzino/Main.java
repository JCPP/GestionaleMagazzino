package gestionale.magazzino;

import java.util.concurrent.ExecutionException;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class Main {
	
	private static Connettore conn;
	private static int a;
	private static Controllore controllo;

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
			controllo.updateCarrello();
		}
		/**
		 * aggiorna la visuale del catalogo dopo che un oggetto è stato selezionato (da ottimizzare)
		 */
		if(evento.equals("Catalogo Dipendente"))
		{
			controllo.updateCatalogo();
		}
		/**
		 * chiude la finestra graficaDipendente (windowListener non funzionava....)
		 */
		if(evento.equals("dispose Dipendente"))
		{
			controllo.disposeDipendente();
		}
		
		//controlli legati alle tabelle
		/**
		 *  il vettore c serve a contenere la stringa che indica la riga scelta dalla tabella
		 */
		char[] c = new char[1000];
		/**
		 * se a == 1 siamo nel catalogo
		 * invia la riga selezionata al controllore che mostra il prodotto corrispondente
		 */
		if(evento.endsWith("4") && a == 1)
		{
			evento.getChars(0, (evento.length())-1, c, 0);
			System.out.println(c);
			int x = 0;
			for(int i = 0; i < (evento.length()-1);i++)
			{
				x = (int) c[i];
			}
			controllo.showProdotto(x);
			
		}
		/**
		 * se a == 0 siamo nel carrello
		 * invia la riga selezionata al controllo che mostra l'ordine corrispondente
		 */
		if(evento.endsWith("4") && a == 0)
		{
			evento.getChars(0, (evento.length())-1, c, 0);
			System.out.println(c);
			int x = 0;
			for(int i = 0; i < (evento.length()-1);i++)
			{
				x = (int) c[i];
			}
			controllo.showOrdinato(x);
		}
		
		//Controlli legati agli eventi dei bottoni
		switch(evento)
		{
		//casi login
			case "Connetti":
				a = 1;
				controllo.isConnected();
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
			default:
				break;
		}
	}
}



