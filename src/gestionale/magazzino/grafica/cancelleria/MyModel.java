package gestionale.magazzino.grafica.cancelleria;
/**
 * La classe MyModel si occupa di creare un modello astratto personalizzato per una JTable
 * In questo modo possiamo creare un modello unico per tutte le tabelle del programma
 * ed evitare errori causati da dati nulli
 */
import javax.swing.table.AbstractTableModel;

public class MyModel extends AbstractTableModel{
	protected int row;
	protected int column;
	protected Object[][] rowData;
	protected String[] columnNames;
	/**
	 * Costruttore della classe,inizializza la tabella
	 * @param r
	 * @param c
	 * @param nomeColonne
	 */
	public MyModel(int r,int c,String[] nomeColonne)
	{
		row = r;
		column = c;
		rowData = new Object[r][c];
		columnNames = nomeColonne;
	}

	public MyModel() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	@Override
	public int getColumnCount() {
		return this.columnNames.length;
		
	}

	@Override
	public String getColumnName(int column) {
		return this.columnNames[column];
	}

	@Override
	public int getRowCount() {
		return this.rowData.length;
	}

	@Override
	public Object getValueAt(int row, int column) {
		 return this.rowData[row][column];
	}
	/**
	 * restituisce la "classe" della colonna
	 * questa funzione permette di visualizzare nella tabella dati non primitivi
	 * come le checkbox.
	 * senza questa funzione infatti si visualizzerebbe solo una stringa
	 */
	@Override
	public Class getColumnClass(int column) {
		 return (getValueAt(0, column).getClass());
	}

	@Override
	public void setValueAt(Object value, int row, int column) {
		 this.rowData[row][column] = value;
		 //fireTableCellUpdated(row,column);
	}

	@Override
	public boolean isCellEditable(int row, int col) {
		//System.out.println("Colonne: "+col);
		int i = getColumnCount();
		String s = this.getValueAt(0, 0).toString();
		if(s.equals(" "))
		{
			return false;
		}
		System.out.println("Colonne: "+i);
		if(i == 4)
		{
			switch(col)
			{
				case 0:
				case 1:
				case 2:
					return false;
				default:
					return true;
			}			
		}
		if(i == 5)
		{
			switch (col) {
        		case 0:
        		case 1:
        		case 2:
        		case 3:
        			return false;
        		default:
        			return true;
        			}
		}
		
		return false;
		
	}

}



