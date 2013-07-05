package gestionale.magazzino.grafica.responsabile.pannelli;


import java.awt.Color;

import gestionale.magazzino.Controllore;
import gestionale.magazzino.MyListener;
import gestionale.magazzino.grafica.cancelleria.MyModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;

public class GraficaListaDip {

	private JPanel pannello_ListaDip;
	private JTable tabella_ListaDip;
	private JScrollPane scroll_ListaDip;
	private AbstractTableModel model;
	private Controllore controllore;

	
	public GraficaListaDip()
	{
		
	}
	
	/**
	 * metodo per inizializzare le varie componenti grafiche
	 * vengono caricati i dati dal database in una tabella (da ottimizzare?)
	 */
	public void init()
	{

		controllore = new Controllore();
		controllore.initListaDip();
		model = controllore.getListaDip();
		tabella_ListaDip = new JTable(model);
		tabella_ListaDip.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabella_ListaDip.setAutoCreateRowSorter(true);
	    tabella_ListaDip.setRowHeight( 20 );
	    tabella_ListaDip.addMouseListener(new MyListener());
		
		scroll_ListaDip = new JScrollPane(tabella_ListaDip);
		
		pannello_ListaDip = new JPanel();
		pannello_ListaDip.setBackground(Color.white);
		pannello_ListaDip.add(scroll_ListaDip);

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

	public void updateModel(MyModel modello) {
		model = modello;
		tabella_ListaDip.setModel(model);
	}
	

}


