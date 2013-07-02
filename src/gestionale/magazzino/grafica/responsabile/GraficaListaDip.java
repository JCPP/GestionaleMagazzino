package gestionale.magazzino.grafica.responsabile;

import java.awt.Color;

import gestionale.magazzino.Controllore;
import gestionale.magazzino.MyListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;

public class GraficaListaDip {

	private JPanel pannello_ListaDip;
	private JPanel pannello_Dati;
	private JPanel pannello_Opzioni;
	private JTable tabella_ListaDip;
	private JScrollPane scroll_ListaDip;
	private AbstractTableModel model;
	private Controllore controllore;
	private JButton visualizza;
	private JButton cancella;
	
	public GraficaListaDip()
	{
		
	}
	
	/**
	 * metodo per inizializzare le varie componenti grafiche
	 * vengono caricati i dati dal database in una tabella (da ottimizzare?)
	 */
	public void init()
	{
		System.out.println("Sono nel init");
		controllore = new Controllore();
		
		tabella_ListaDip = new JTable(model);
		tabella_ListaDip.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabella_ListaDip.setAutoCreateRowSorter(true);
	    tabella_ListaDip.setRowHeight( 20 );
	    tabella_ListaDip.addMouseListener(new MyListener());
		
		scroll_ListaDip = new JScrollPane(tabella_ListaDip);
		
		pannello_ListaDip = new JPanel();
		pannello_ListaDip.setBackground(Color.white);

	}

	public JTable getTable()
	{
		return this.tabella_ListaDip;
	}
	
	public void setTable(JTable tabella)
	{
		this.tabella_ListaDip = tabella;	
	}
	public JPanel getPannello()
	{
		return pannello_ListaDip;
	}
	
	public AbstractTableModel getModel()
	{
		return this.model;
	}
	

}


