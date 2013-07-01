package graficaCancelleria;
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
	}
	
	public int getColumnCount() {
		return this.columnNames.length;
	}

	public String getColumnName(int column) {
		return this.columnNames[column];
	}

	public int getRowCount() {
		return this.rowData.length;
	}

	public Object getValueAt(int row, int column) {
		 return this.rowData[row][column];
	}
	/**
	 * restituisce la "classe" della colonna
	 * questa funzione permette di visualizzare nella tabella dati non primitivi
	 * come le checkbox.
	 * senza questa funzione infatti si visualizzerebbe solo una stringa
	 */
	public Class getColumnClass(int column) {
		 return (getValueAt(0, column).getClass());
	}

	public void setValueAt(Object value, int row, int column) {
		 this.rowData[row][column] = value;
	}

	public boolean isCellEditable(int row, int column) {
		 return (column != 0);
	}
	/**
	 * funzione che dovrebbe fare l'update di un record della tabella
	 * senza doverla reinizializzare ogni volta
	 *(non funziona.....)
	 */
	public void refresh()
	{
		for(int i = 0;i < row;i++)
		{
			this.setValueAt(Boolean.FALSE, i, 4);
		}
	}

}
