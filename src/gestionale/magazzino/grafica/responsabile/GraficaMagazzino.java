package gestionale.magazzino.grafica.responsabile;
/**
 * Classe che visualizza i Magazzino di un magazzino in una lista,i dati sono reperiti da un database
 */
import gestionale.magazzino.Controllore;
import gestionale.magazzino.MyListener;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import java.awt.*;

public class GraficaMagazzino extends JFrame  {
	
	private JPanel pannello_Magazzino;
	private JTable tabella_Magazzino;
	private JScrollPane scroll_Magazzino;
	private AbstractTableModel model;
	private Controllore controllore;
	private JPanel pannello_Dati;
	private JPanel pannello_Opzioni;
	private JButton bottone_Aggiungi;
	/**
	 * Costruttore della classe
	 */
	public GraficaMagazzino()
	{
	}
	/**
	 * metodo per inizializzare le varie componenti grafiche
	 * vengono caricati i dati dal database in una tabella (da ottimizzare?)
	 */
	public void init()
	{
		controllore = new Controllore();
		controllore.initCatalogo();
		model = controllore.getCatalogo();
		tabella_Magazzino = new JTable(model);
		tabella_Magazzino.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabella_Magazzino.setAutoCreateRowSorter(true);
	    tabella_Magazzino.setRowHeight( 20 );
	    tabella_Magazzino.addMouseListener(new MyListener());
		
		scroll_Magazzino = new JScrollPane(tabella_Magazzino);
		
		pannello_Magazzino = new JPanel();
		pannello_Magazzino.setBackground(Color.white);
		pannello_Magazzino.setLayout(new BorderLayout());
		
		pannello_Dati = new JPanel();
		pannello_Dati.setBackground(Color.white);
		
		pannello_Dati.add(scroll_Magazzino);
		
		pannello_Opzioni = new JPanel();
		pannello_Opzioni.setBackground(Color.white);
		
		bottone_Aggiungi = new JButton("Aggiungi");
		bottone_Aggiungi.setActionCommand("Aggiungi Prodotto");
		bottone_Aggiungi.addActionListener(new MyListener());
		
		pannello_Magazzino.add("Center",pannello_Dati);
		pannello_Magazzino.add("East",pannello_Opzioni);
		
	}

	public JTable getTable()
	{
		return this.tabella_Magazzino;
	}
	
	public void setTable(JTable tabella)
	{
		this.tabella_Magazzino = tabella;	
	}
	public JPanel getPannello()
	{
		return this.pannello_Magazzino;
	}
	
	public AbstractTableModel getModel()
	{
		return this.model;
	}
	

}
