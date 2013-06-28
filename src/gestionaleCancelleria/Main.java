package gestionaleCancelleria;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import modelsCancelleria.Prodotto;
import modelsCancelleria.Dipendente;
import graficaCancelleria.*;

public class Main {
	//private static Querist query;
	private static GraficaRegistrazione gr;
	private static GraficaProdotti gp;
	private static GraficaLogin gl;
	private static GraficaAccount ga;
	private static GraficaDipendente gd;
	private static VisualizzaProdotto vp;
	private static Connettore conn;
	private static ModificaProdotto mp;
	private static int a;

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
    			vp = new VisualizzaProdotto();
    			mp = new ModificaProdotto();
    			conn = new Connettore();
    			a = 1;
            	gl.init();

                SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>()
                {
                	
                	protected Boolean doInBackground() throws Exception 
                	{
                		conn.caricadriver();
                		conn.collegati();
                		//Prodotto.modificaPrezzoProdotto("Lettore Floppy Disk", (float) 13.00);
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
		if(evento.endsWith("4") && a == 1)
		{
			evento.getChars(0, (evento.length())-1, c, 0);
			System.out.println(c);
			vp.init();
			gd.setDisable();
		}
		if(evento.endsWith("4") && a == 2)
		{
			evento.getChars(0, (evento.length())-1, c, 0);
			System.out.println(c);
			mp.init();
			gd.setDisable();
		}
		switch(evento)
		{
		//casi login
			case "Connetti":
				a = 1;
				gl.pulisciErrori();
				String email = gl.getEmail();
				String password = gl.getPassword();
				boolean b = Dipendente.validateEmail(email);
				boolean b1 = Dipendente.validatePassword(email, password);
				if(b1)
				{
					gd.init();
					gl.disposeF();
				}
				else
				{
					if(!b && !b1)
					{
						gl.setErroreEmail("Email errata");
						gl.setErrorePass("Password errata");
					}
					if(!b)
					{
						gl.setErroreEmail("Email errata");
					}
					else
					{
						gl.setErrorePass("Password errata");
					}
				}
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
				String Remail = gr.getEmail();
				String Rpassword = gr.getPassword();
				String password2 = gr.getPassword2();
				String nome = gr.getNome();
				String cognome = gr.getCognome(); 
				
				modelsCancelleria.Dipendente.inserisciDipendente(nome, cognome, Rpassword, Remail, "false");
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
				a = 1;
				gd.setPannelloSelezionato("prodotti");
				break;
			case "Carrello":
				a = 2;
				gd.setPannelloSelezionato("carrello");
				break;
			case "Logout":
				gl.init();
				gd.disposeF();
				break;
			case "Exit":
				gd.disposeF();
				break;
			//casi carrello
			case "Modifica Prodotto":
				mp.buttonChangeState();
				mp.setModificable();
				break;
			default:
				break;
		}
	}
}



