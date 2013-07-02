package gestionale.magazzino.grafica.cancelleria;
/**
 * Classe che visualizza i prodotti di un magazzino in una lista,i dati sono reperiti da un database
 */
import gestionale.magazzino.Controllore;
import gestionale.magazzino.MyListener;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import java.awt.*;

public class GraficaProdotti extends JFrame  {
	
	private JPanel pannello_Prodotti;
	private JTable tabella_Prodotti;
	private JScrollPane scroll_Prodotti;
	private AbstractTableModel model;
	private Controllore controllore;
	/**
	 * Costruttore della classe
	 */
	public GraficaProdotti()
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
		tabella_Prodotti = new JTable(model);
		tabella_Prodotti.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabella_Prodotti.setAutoCreateRowSorter(true);
	    tabella_Prodotti.setRowHeight( 20 );
	    tabella_Prodotti.addMouseListener(new MyListener());
		
		scroll_Prodotti = new JScrollPane(tabella_Prodotti);
		
		pannello_Prodotti = new JPanel();
		pannello_Prodotti.setBackground(Color.white);
		
		pannello_Prodotti.add(scroll_Prodotti);
		
	}

	public JTable getTable()
	{
		return this.tabella_Prodotti;
	}
	
	public void setTable(JTable tabella)
	{
		this.tabella_Prodotti = tabella;	
	}
	public JPanel getPannello()
	{
		return pannello_Prodotti;
	}
	
	public AbstractTableModel getModel()
	{
		return this.model;
	}
	

}
