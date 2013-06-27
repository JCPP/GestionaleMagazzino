package graficaCancelleria;

import gestionaleCancelleria.MyListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import java.awt.event.*;
import java.awt.*;

public class GraficaProdotti extends JFrame {
	
	private GraficaNavigazione grafica_Navigazione;
	private GraficaLogin grafica_Login;
	private JFrame finestra_Prodotti;
	private Dimension dimensione;
	private int x;
	private int y;
	private JPanel pannello_Prodotti;
	private JTable tabella_Prodotti;
	private JTableHeader tabella_Colonne;
	private JScrollPane scroll_Prodotti;
	private JButton bottone;
	
	public GraficaProdotti()
	{
	}
	
	public void init()
	{
		grafica_Navigazione = new GraficaNavigazione();
		grafica_Navigazione.init();
		
		finestra_Prodotti = new JFrame("Lista Prodotti");
		finestra_Prodotti.setSize(600,500);
		
		dimensione = getToolkit().getScreenSize().getSize();
		x = (int) (dimensione.getWidth() - finestra_Prodotti.getWidth())/2;
		y = (int) (dimensione.getHeight() - finestra_Prodotti.getHeight())/2;
		
		bottone = new JButton("O");
		
		/*
		String[] nomeColonne = {};
		Object[][] dati = {
					{}
				};
		*/
		
		
		/////////////////////////////////////////////////////////////////////////////////
		
		final String[] nomeColonne = {"ID","Nome","Quantita","Prezzo","Acquista"};
		final Object[][] dati = {
				{"01","Ciao",2,3,new JCheckBox()},
				{"01","Ciao",2,3,""},
				{"01","Ciao",2,3,""},
				{"01","Ciao",2,3,""},
				{"01","Ciao",2,3,""},
				{"01","Ciao",2,3,""},
				{"01","Ciao",2,3,""},
				{"01","Ciao",2,3,""},
				{"01","Ciao",2,3,""},
				{"01","Ciao",2,3,""},
				{"01","Ciao",2,3,""},
				{"01","Ciao",2,3,""},
				{"01","Ciao",2,3,""},
				{"01","Ciao",2,3,""},
				{"01","Ciao",2,3,""},
				{"01","Ciao",2,3,""},
				{"01","Ciao",2,3,""},
				{"01","Ciao",2,3,""},
				{"01","Ciao",2,3,""},
				{"01","Ciao",2,3,""},
				{"01","Ciao",2,3,""},
				{"01","Ciao",2,3,""},
				{"01","Ciao",2,3,""},
				{"01","Ciao",2,3,""},
				{"01","Ciao",2,3,""},
				{"01","Ciao",2,3,""},
				{"01","Ciao",2,3,""},
				{"01","Ciao",2,3,""},
					
					
		};
		
		///////////////////////////////////////////////////////////////////////////////////

		TableModel model = new DefaultTableModel(dati, nomeColonne)
		  {
			public TableCellRenderer getCellRenderer( int row, int column ) {
                return new MyCellRender();
            }
			
		    public boolean isCellEditable(int row, int column)
		    {
		      return false;//This causes all cells to be not editable
		    }
		    
		    public int getColumnCount() {
	            return nomeColonne.length;
	        }

	        public int getRowCount() {
	            return dati.length;
	        }

	        public String getColumnName(int col) {
	            return nomeColonne[col];
	        }

	        public Object getValueAt(int row, int col) {
	            return dati[row][col];
	        }
	        
	        public Class getColumnClass(int c) {
	            return getValueAt(0, c).getClass();
	        }
	        
		  };

		//tabella_Prodotti = new JTable(model);
		//tabella_Prodotti.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//tabella_Prodotti.setAutoCreateRowSorter(true);
		
		  tabella_Prodotti = new JTable( model ) { 
	            public TableCellRenderer getCellRenderer( int row, int column ) {
	                return new MyCellRender();
	            }
	         };
	    tabella_Prodotti.setRowHeight( 28 );
	    tabella_Prodotti.addMouseListener(new MyListener());
		
		tabella_Colonne = tabella_Prodotti.getTableHeader();
		tabella_Colonne.setReorderingAllowed(false);
		
		scroll_Prodotti = new JScrollPane(tabella_Prodotti);
		
		MyListener m = new MyListener();
		m.setTable(this.getTable());
		
		pannello_Prodotti = new JPanel();
		pannello_Prodotti.setBackground(Color.white);
		
		pannello_Prodotti.add(scroll_Prodotti);
		
		finestra_Prodotti.add("North",grafica_Navigazione.getPannello());
		finestra_Prodotti.add(pannello_Prodotti);
		
		finestra_Prodotti.setSize(600,500);
		finestra_Prodotti.setLocation(x,y);
		finestra_Prodotti.setBackground(Color.white);
		finestra_Prodotti.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		finestra_Prodotti.setVisible(true);
		
	}

	public JTable getTable()
	{
		return this.tabella_Prodotti;
	}
	
	public void disposeF()
	{
		finestra_Prodotti.dispose();
	}

}
