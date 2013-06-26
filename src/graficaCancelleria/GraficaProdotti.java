package graficaCancelleria;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import java.awt.event.*;
import java.awt.*;

public class GraficaProdotti extends JFrame implements ActionListener,MouseListener {
	
	private GraficaLogin grafica_Login;
	private JFrame finestra_Prodotti;
	private Dimension dimensione;
	private int x;
	private int y;
	private JPanel pannello_Prodotti;
	private JPanel pannello_Opzioni;
	private JButton Button_Account;
	private JButton Button_Catalogo;
	private JButton Button_Carrello;
	private JButton Button_Logout;
	private JButton Button_Chiudi;
	private JTable tabella_Prodotti;
	private JTableHeader tabella_Colonne;
	private JScrollPane scroll_Prodotti;
	private JButton bottone;
	
	public GraficaProdotti()
	{
		init();
		pannello_Opzioni.add(Button_Account);
		pannello_Opzioni.add(Button_Catalogo);
		pannello_Opzioni.add(Button_Carrello);
		pannello_Opzioni.add(Button_Logout);
		pannello_Opzioni.add(Button_Chiudi);
		pannello_Prodotti.add(scroll_Prodotti);
		
		finestra_Prodotti.add("North",pannello_Opzioni);
		finestra_Prodotti.add(pannello_Prodotti);
		
		finestra_Prodotti.setSize(600,500);
		finestra_Prodotti.setLocation(x,y);
		finestra_Prodotti.setBackground(Color.white);
		finestra_Prodotti.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		finestra_Prodotti.setVisible(true);
	}
	
	public void init()
	{
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
	    tabella_Prodotti.addMouseListener(this);
		
		tabella_Colonne = tabella_Prodotti.getTableHeader();
		tabella_Colonne.setReorderingAllowed(false);
		
		scroll_Prodotti = new JScrollPane(tabella_Prodotti);
		
		pannello_Prodotti = new JPanel();
		pannello_Prodotti.setBackground(Color.white);
		
		pannello_Opzioni = new JPanel();
		pannello_Opzioni.setLayout(new GridLayout(1,5));
		
		Button_Account = new JButton("Account");
		Button_Account.setForeground(Color.blue);
		Button_Account.setBackground(Color.white);
		Button_Account.setActionCommand("Account");
		Button_Account.addActionListener(this);
		Button_Catalogo = new JButton("Catalogo");
		Button_Catalogo.setForeground(Color.blue);
		Button_Catalogo.setBackground(Color.white);
		Button_Catalogo.setActionCommand("Catalogo");
		Button_Catalogo.addActionListener(this);
		Button_Carrello = new JButton("Carrello");
		Button_Carrello.setForeground(Color.blue);
		Button_Carrello.setBackground(Color.white);
		Button_Carrello.setActionCommand("Carrello");
		Button_Carrello.addActionListener(this);
		Button_Logout = new JButton("Logout");
		Button_Logout.setForeground(Color.blue);	
		Button_Logout.setBackground(Color.white);
		Button_Logout.setActionCommand("Logout");
		Button_Logout.addActionListener(this);
		Button_Chiudi = new JButton("Chiudi");
		Button_Chiudi.setForeground(Color.blue);
		Button_Chiudi.setBackground(Color.white);
		Button_Chiudi.setActionCommand("Chiudi");
		Button_Chiudi.addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s = e.getActionCommand();
		if(s.equals("Logout"))
		{
			finestra_Prodotti.dispose();
			grafica_Login = new GraficaLogin();
		}
		if(s.equals("Chiudi"))
		{
			finestra_Prodotti.dispose();
		}
	}

	@Override
	public void mouseClicked(MouseEvent evt) {
		// TODO Auto-generated method stub
		int y = tabella_Prodotti.rowAtPoint(evt.getPoint());
		int x = tabella_Prodotti.columnAtPoint(evt.getPoint());
		System.out.println(y+"|"+x);

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
