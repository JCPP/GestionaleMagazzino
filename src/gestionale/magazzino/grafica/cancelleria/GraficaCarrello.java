package gestionale.magazzino.grafica.cancelleria;
/**
 * Questa classe si occupa di visualizzare il carrello spesa di un dipendente
 */
import gestionale.magazzino.Controllore;
import gestionale.magazzino.MyListener;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;

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
