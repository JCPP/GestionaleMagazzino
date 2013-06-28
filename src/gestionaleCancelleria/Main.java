package gestionaleCancelleria;

import java.util.concurrent.ExecutionException;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import modelsCancelleria.Dipendente;
import modelsCancelleria.Prodotto;
import graficaCancelleria.*;

public class Main {
	//private static Querist query;
	private static GraficaRegistrazione gr;
	private static GraficaProdotti gp;
	private static GraficaLogin gl;
	private static modelsCancelleria.Dipendente dip;
	private static modelsCancelleria.Prodotto prodotto;

	public static void main(String[] args) 
	{
		gl = new GraficaLogin();
		gp = new GraficaProdotti();
		gr = new GraficaRegistrazione();
		gl.init();
		SwingUtilities.invokeLater(new Runnable()
        {
             
            public void run() 
            {
                SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>()
                {
                	
                	protected Boolean doInBackground() throws Exception 
                	{
                		//dip.cancellaDipendente("mattew");
                		Prodotto.cancellaProdotto("HD");
                		return true;
                	};
  			    
                	protected void process() 
                	{
                	}
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
  		worker.execute();
		}
      });
	}
	
	public void start(String evento)
	{
		System.out.println(evento);
		switch(evento)
		{
		//casi login
			case "Connetti":
				
				
				gl.disposeF();
				gp.init();
				break;
			case "Chiudi":
				gl.disposeF();
				break;
			case "Registrati":
				gl.disposeF();
				gr.init();
				break;
		//casi registrazione
			case "Invio":
				gr.pulisciErrori();
				break;
			case "Reset":
				gr.pulisciErrori();
				gr.pulisci();
				break;
			case "Indietro":
				gr.pulisciErrori();
				gr.disposeF();
				gl.init();
				break;
		//casi barra navigazione
			case "Account":
				break;
			case "Catalogo":
				break;
			case "Carrello":
				break;
			case "Logout":
				gl.init();
				gp.disposeF();
				break;
			//case "Chiudi":
			//	break;
			default:
				break;
		}
	}
}


