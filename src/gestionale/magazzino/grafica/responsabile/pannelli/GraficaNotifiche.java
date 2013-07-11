package gestionale.magazzino.grafica.responsabile.pannelli;

import java.awt.Color;

import gestionale.magazzino.MyListener;
import gestionale.magazzino.controllore.Controllore;
import gestionale.magazzino.controllore.responsabile.ControlloreNotifiche;
import gestionale.magazzino.grafica.cancelleria.MyModel;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;

public class GraficaNotifiche {

	private JPanel pannello_Notifiche;
	private JPanel pannello_Dati;
	private JPanel pannello_Opzioni;
	private JTable tabella_Notifiche;
	private JScrollPane scroll_Notifiche;
	private AbstractTableModel model;
	private ControlloreNotifiche controllore;
	private JButton visualizza;
	private JButton cancella;
	
	public GraficaNotifiche()
	{
		
	}
	
	/**
	 * metodo per inizializzare le varie componenti grafiche
	 * vengono caricati i dati dal database in una tabella (da ottimizzare?)
	 */
	public void init()
	{
		controllore = new ControlloreNotifiche();
		controllore.initNotifiche();
		model = controllore.getNotifiche();
		tabella_Notifiche = new JTable(model);
		tabella_Notifiche.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabella_Notifiche.setAutoCreateRowSorter(true);
	    tabella_Notifiche.setRowHeight( 20 );
	    tabella_Notifiche.addMouseListener(new MyListener());
		
		scroll_Notifiche = new JScrollPane(tabella_Notifiche);
		
		pannello_Notifiche = new JPanel();
		pannello_Notifiche.setBackground(Color.white);
		
		pannello_Notifiche.add(scroll_Notifiche);

	}

	public JTable getTable()
	{
		return this.tabella_Notifiche;
	}
	
	public void setTable(JTable tabella)
	{
		this.tabella_Notifiche = tabella;	
	}
	public JPanel getPannello()
	{
		return pannello_Notifiche;
	}
	
	public AbstractTableModel getModel()
	{
		return this.model;
	}
	
	public void updateModel(MyModel modello)
	{
		model = modello;
		tabella_Notifiche.setModel(model);
	}

}

