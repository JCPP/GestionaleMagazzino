package graficaCancelleria;

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
	private JTableHeader tabella_Colonne;
	private JScrollPane scroll_Prodotti;
	private Boolean bottone;
	
	public GraficaProdotti()
	{
	}
	
	public void init()
	{
		//bottone = new Boolean(false);
	
		AbstractTableModel model = new AbstractTableModel()
		  {
			//public TableCellRenderer getCellRenderer( int row, int column ) {
          //    return new MyCellRender();
          //}
			Object rowData[][] = {{"01","nome","2","3",Boolean.FALSE}};
					
			String columnNames[] = { "ID","Nome","Quantita","Prezzo", "Boolean" };

			public int getColumnCount() {
				return columnNames.length;
			}

			public String getColumnName(int column) {
				return columnNames[column];
			}

			public int getRowCount() {
				return rowData.length;
			}

			public Object getValueAt(int row, int column) {
				 return rowData[row][column];
			}

			public Class getColumnClass(int column) {
				 return (getValueAt(0, column).getClass());
			}

			public void setValueAt(Object value, int row, int column) {
				 rowData[row][column] = value;
			}

			public boolean isCellEditable(int row, int column) {
				 return (column != 0);
			}
		};
		
		tabella_Prodotti = new JTable(model);
		tabella_Prodotti.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabella_Prodotti.setAutoCreateRowSorter(true);
	    tabella_Prodotti.setRowHeight( 20 );
	    tabella_Prodotti.addMouseListener(new MyListener());
		
		tabella_Colonne = tabella_Prodotti.getTableHeader();
		tabella_Colonne.setReorderingAllowed(false);
		
		scroll_Prodotti = new JScrollPane(tabella_Prodotti);
		
		MyListener m = new MyListener();
		m.setTable(this.getTable());
		
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
	

}
