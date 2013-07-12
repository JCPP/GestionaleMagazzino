package gestionale.magazzino.grafica.dipendente.pannelli;
/**
 * Questa classe si occupa di visualizzare il carrello spesa di un dipendente
 */
import gestionale.magazzino.Dipendente;
import gestionale.magazzino.MyListener;
import gestionale.magazzino.controllore.Controllore;
import gestionale.magazzino.controllore.dipendente.ControlloreCarrello;
import gestionale.magazzino.grafica.cancelleria.MyModel;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;

import java.awt.*;

public class GraficaCarrello extends JFrame  {
	
	private JPanel pannello_Carrello;
	private JPanel pannello_Dati;
	private JPanel pannello_Opzioni;
	private JTable tabella_Carrello;
	private JTableHeader tabella_Colonne;
	private JScrollPane scroll_Carrello;
	private ControlloreCarrello controllore;
	private MyModel model;
	private Dipendente dipendente;
	private JButton bottone_Invia;
	/**
	 * Costruttore della classe
	 */
	public GraficaCarrello(Dipendente dip)
	{
		dipendente = new Dipendente();
		dipendente = dip;
	}
	/**
	 * Inizializzazione delle componenti grafiche
	 */
	public void init()
	{
		controllore = new ControlloreCarrello();
		controllore.initCarrello();
		model = controllore.getModelCarrelo();
		tabella_Carrello = new JTable(model);
		tabella_Carrello.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabella_Carrello.setAutoCreateRowSorter(true);
	    tabella_Carrello.setRowHeight( 20 );
	    tabella_Carrello.addMouseListener(new MyListener());
		
	    pannello_Dati = new JPanel();
	    pannello_Opzioni = new JPanel();
	    
		tabella_Colonne = tabella_Carrello.getTableHeader();
		tabella_Colonne.setReorderingAllowed(false);
		
		scroll_Carrello = new JScrollPane(tabella_Carrello);
		
		bottone_Invia = new JButton("Acquista");
		bottone_Invia.setActionCommand("acquista carrello");
		bottone_Invia.addActionListener(new MyListener());
		
		pannello_Carrello = new JPanel();
		pannello_Carrello.setLayout(new BorderLayout());
		pannello_Carrello.setBackground(Color.white);
		
		
		pannello_Opzioni.add(bottone_Invia);
		pannello_Dati.add(scroll_Carrello);
		pannello_Carrello.add("Center",pannello_Dati);
		pannello_Carrello.add("East",pannello_Opzioni);
		
	}

	public JTable getTable()
	{
		return this.tabella_Carrello;
	}
	
	public void setTable(JTable tabella)
	{
		this.tabella_Carrello = tabella;
	}
	
	public JPanel getPannello()
	{
		return pannello_Carrello;
	}
	
	public void setDipendente(Dipendente dip)
	{
		dipendente = dip;
	}
	
	public void updateModel(MyModel modello) {
		model = modello;
		tabella_Carrello.setModel(model);
	}
	

}
