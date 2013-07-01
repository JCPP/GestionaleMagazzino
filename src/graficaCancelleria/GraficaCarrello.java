package graficaCancelleria;
/**
 * Questa classe si occupa di visualizzare il carrello spesa di un dipendente
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

public class GraficaCarrello extends JFrame  {
	
	private JPanel pannello_Carrello;
	private JTable tabella_Carrello;
	private JTableHeader tabella_Colonne;
	private JScrollPane scroll_Carrello;
	private Controllore controllore;
	private AbstractTableModel model;
	/**
	 * Costruttore della classe
	 */
	public GraficaCarrello()
	{
	}
	/**
	 * Inizializzazione delle componenti grafiche
	 */
	public void init()
	{
		//bottone = new Boolean(false);
		controllore = new Controllore();
		controllore.initCarrello();
		model = controllore.getCarrrello();
		tabella_Carrello = new JTable(model);
		tabella_Carrello.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabella_Carrello.setAutoCreateRowSorter(true);
	    tabella_Carrello.setRowHeight( 20 );
	    tabella_Carrello.addMouseListener(new MyListener());
		
		tabella_Colonne = tabella_Carrello.getTableHeader();
		tabella_Colonne.setReorderingAllowed(false);
		
		scroll_Carrello = new JScrollPane(tabella_Carrello);
		
		MyListener m = new MyListener();
		m.setTable(this.getTable());
		
		pannello_Carrello = new JPanel();
		pannello_Carrello.setBackground(Color.white);
		
		pannello_Carrello.add(scroll_Carrello);
		
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
	

}
