package graficaCancelleria;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

public class GraficaDipendente extends JFrame {
	
	private GraficaAccount grafica_Account;
	private GraficaProdotti grafica_Prodotti;
	private GraficaCarrello grafica_Carrello;
	private GraficaNavigatoreDipendenti grafica_Navigazione;
	private JFrame finestra_Dipendente;
	private Dimension dimensione;
	private int x;
	private int y;
	private CardLayout layout_Pannello;
	private JPanel pannello_Selezionato;
	private JPanel pannello_Navigazione;
	private Graphics offscreen;
	
	public GraficaDipendente()
	{
		
	}
	
	public void init()
	{
		grafica_Account = new GraficaAccount();
		grafica_Account.init();
		grafica_Prodotti = new GraficaProdotti();
		grafica_Prodotti.init();
		grafica_Carrello = new GraficaCarrello();
		grafica_Carrello.init();
		grafica_Navigazione = new GraficaNavigatoreDipendenti();
		grafica_Navigazione.init();
		
		pannello_Navigazione = new JPanel();
		pannello_Selezionato = new JPanel();
		
		finestra_Dipendente = new JFrame("Lista Prodotti");
		finestra_Dipendente.setSize(600,500);
		
		dimensione = getToolkit().getScreenSize().getSize();
		x = (int) (dimensione.getWidth() - finestra_Dipendente.getWidth())/2;
		y = (int) (dimensione.getHeight() - finestra_Dipendente.getHeight())/2;
		
		layout_Pannello = new CardLayout();
		pannello_Selezionato.setLayout(layout_Pannello);
		pannello_Selezionato.add(grafica_Prodotti.getPannello(),"prodotti");
		pannello_Selezionato.add(grafica_Account.getPannello(),"account");
		pannello_Selezionato.add(grafica_Carrello.getPannello(),"carrello");
		
		layout_Pannello.show(pannello_Selezionato, pannello_Selezionato.getName());
		
		pannello_Navigazione = grafica_Navigazione.getPannello();
		finestra_Dipendente.add("North",pannello_Navigazione);
		finestra_Dipendente.add("Center",pannello_Selezionato);
		finestra_Dipendente.setSize(600,500);
		finestra_Dipendente.setLocation(x,y);
		finestra_Dipendente.setBackground(Color.white);
		finestra_Dipendente.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		finestra_Dipendente.setVisible(true);
	}
	
	public void disposeF()
	{
		finestra_Dipendente.dispose();
	}
	
	///////////////////////////////////////////////////////////////////
	public void setPannelloSelezionato(String s)
	{
		if(s.equals("prodotti"))
		{
			pannello_Selezionato.remove(grafica_Prodotti.getPannello());
			grafica_Prodotti.init();
			pannello_Selezionato.add(grafica_Prodotti.getPannello(),"prodotti");
		}
		layout_Pannello.show(pannello_Selezionato, s);
	}
	
	public void setDisable()
	{
		finestra_Dipendente.setEnabled(false);
	}
		
}
