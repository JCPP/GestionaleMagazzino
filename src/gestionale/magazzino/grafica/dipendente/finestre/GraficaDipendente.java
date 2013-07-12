package gestionale.magazzino.grafica.dipendente.finestre;
/**
 * Questa classe si occupa di gestire la grafica per un dipendente
 * fornendogli un menu di navigazione
 */
import gestionale.magazzino.Dipendente;
import gestionale.magazzino.MyListener;
import gestionale.magazzino.grafica.cancelleria.MyModel;
import gestionale.magazzino.grafica.dipendente.pannelli.GraficaAccount;
import gestionale.magazzino.grafica.dipendente.pannelli.GraficaCarrello;
import gestionale.magazzino.grafica.dipendente.pannelli.GraficaNavigatoreDipendenti;
import gestionale.magazzino.grafica.dipendente.pannelli.GraficaProdotti;

import javax.swing.*;


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
	private Dipendente dipendente;
	/**
	 * Costruttore della classe
	 */
	public GraficaDipendente()
	{
	}
	/**
	 * inizializzazione delle componenti grafiche e visualizzazione della finestra
	 */
	public void init(Dipendente dipendente)
	{
		grafica_Account = new GraficaAccount();
		grafica_Account.init();
		grafica_Prodotti = new GraficaProdotti();
		grafica_Prodotti.init();
		grafica_Carrello = new GraficaCarrello(dipendente);
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
		finestra_Dipendente.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		finestra_Dipendente.addWindowListener(new MyListener());
		finestra_Dipendente.setResizable(false);
		finestra_Dipendente.setVisible(true);
	}
	
	public void disposeF()
	{
		finestra_Dipendente.dispose();
	}

	public void setPannelloSelezionato(String s)
	{
		layout_Pannello.show(pannello_Selezionato, s);
	}
	
	public void setState(boolean b)
	{
		finestra_Dipendente.setEnabled(b);
	}

	public void setAccount(String email,String nome,String cognome,String tipo)
	{
		grafica_Account.setEmail(email);
		grafica_Account.setNome(nome);
		grafica_Account.setCognome(cognome);
		grafica_Account.setTipo(tipo);
	}
	
	public void setDipendente(Dipendente dipendente)
	{
		grafica_Carrello.setDipendente(dipendente);
	}
	public JTable getTableCarrello()
	{
		return grafica_Carrello.getTable();
	}
	
	public JTable getTableProdotti()
	{
		return grafica_Prodotti.getTable();
	}
	
	public void updateCarrello(MyModel modello)
	{
		grafica_Carrello.updateModel(modello);
	}
	
	public void updateCatalogo(MyModel modello)
	{
		grafica_Prodotti.updateModel(modello);
	}
}
