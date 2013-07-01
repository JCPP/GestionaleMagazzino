package graficaCancelleria;
/**
 * Classe che visualizza i prodotti di un magazzino in una lista,i dati sono reperiti da un database
 */
import gestionaleCancelleria.Controllore;
import gestionaleCancelleria.MyListener;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import java.awt.event.*;
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
	
	public void setTable(AbstractTableModel modello)
	{
		this.tabella_Prodotti = new JTable(modello);	
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
