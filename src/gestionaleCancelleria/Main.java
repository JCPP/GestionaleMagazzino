package gestionaleCancelleria;

import java.util.concurrent.ExecutionException;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import graficaCancelleria.*;

public class Main {
	//private static Querist query;
	private static GraficaRegistrazione gr;
	private static GraficaProdotti gp;
	private static GraficaLogin gl;
	private static Controllore controllore;
	private static Querist que;

	public static void main(String[] args) 
	{
		gl = new GraficaLogin();
		gp = new GraficaProdotti();
		gr = new GraficaRegistrazione();
		que = new Querist();
		controllore = new Controllore();
		gl.init();
		System.out.println(que.validateResponsabile("mattew", "emmeci92@gmail.com"));
		SwingUtilities.invokeLater(new Runnable()
        {
             
            public void run() 
            {
                SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>()
                {
                	
                	protected Boolean doInBackground() throws Exception 
                	{
                		
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


