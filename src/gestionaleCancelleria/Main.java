package gestionaleCancelleria;

import java.util.concurrent.ExecutionException;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import modelsCancelleria.*;
import graficaCancelleria.*;

public class Main {
	//private static Querist query;
	private static GraficaRegistrazione gr;
	private static GraficaProdotti gp;
	private static GraficaLogin gl;
	private static GraficaAccount ga;
	private static GraficaDipendente gd;
	private static VisualizzaProdotto vp;
	private static modelsCancelleria.Dipendente dip;
	private static modelsCancelleria.Prodotto prodotto;

	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Runnable()
        {
             
            public void run() 
            {
            	gl = new GraficaLogin();
    			gp = new GraficaProdotti();
    			gr = new GraficaRegistrazione();
    			gd = new GraficaDipendente();
    			ga = new GraficaAccount();
    			dip = new modelsCancelleria.Dipendente();
    			vp = new VisualizzaProdotto();
            	gl.init();
                SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>()
                {
                	
                	protected Boolean doInBackground() throws Exception 
                	{
                		//dip.cancellaDipendente("mattew");
                		//Prodotto.cancellaProdotto("HD");
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
	
	@SuppressWarnings("deprecation")
	public void start(String evento)
	{
		System.out.println(evento);
		char[] c = new char[1000];
		int x;
		if(evento.equals("202"))
		{
			gd.disposeF();
			gd.init();
		}
		if(evento.endsWith("4"))
		{
			evento.getChars(0, (evento.length())-1, c, 0);
			System.out.println(c);
			vp.init();
			gd.setDisable();
		}
		switch(evento)
		{
		//casi login
			case "Connetti":
				gl.disposeF();
				gd.init();
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
				gd.setPannelloSelezionato("account");
				break;
			case "Catalogo":
				gd.setPannelloSelezionato("prodotti");
				break;
			case "Carrello":
				gd.setPannelloSelezionato("carrello");
				break;
			case "Logout":
				gl.init();
				gd.disposeF();
				break;
			case "Exit":
				gd.disposeF();
				break;
			default:
				break;
		}
	}
}



