package gestionale.magazzino.grafica.dipendente.pannelli;
/**
 * Classe che visualizza i prodotti di un magazzino in una lista,i dati sono reperiti da un database
 */
import gestionale.magazzino.MyListener;
import gestionale.magazzino.controllore.Controllore;
import gestionale.magazzino.controllore.dipendente.ControlloreCatalogo;
import gestionale.magazzino.grafica.cancelleria.MyModel;

import javax.swing.*;


import java.awt.*;

public class GraficaProdotti extends JFrame  {
	
	private JPanel pannello_Prodotti;
	private JTable tabella_Prodotti;
	private JScrollPane scroll_Prodotti;
	private MyModel model;
	private ControlloreCatalogo controllore;
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
		controllore = new ControlloreCatalogo();
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

	public JPanel getPannello()
	{
		return pannello_Prodotti;
	}
	
	public JTable getTable()
	{
		return tabella_Prodotti;
	}
	
	public void updateModel(MyModel modello)
	{
		model = modello;
		tabella_Prodotti.setModel(model);
	}
	
}
