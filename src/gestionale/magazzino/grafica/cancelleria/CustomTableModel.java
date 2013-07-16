/**
 * 
 */
package gestionale.magazzino.grafica.cancelleria;

import javax.swing.table.DefaultTableModel;

/**
 * @author <a reef="https://github.com/DavidePastore">DavidePastore</a>
 *
 */
public class CustomTableModel extends DefaultTableModel {

	/**
	 * @param colonne
	 * @param i
	 */
	public CustomTableModel(String[] colonne, int i) {
		super(colonne, i);
	}

	/**
	 * 
	 */
	public CustomTableModel() {
		super();
	}
	
	
	public Class<?> getColumnClass(int columnIndex) {
		//System.out.println("Column index: " + columnIndex);
		if (columnIndex + 1 == getColumnCount()){
			return Boolean.class;
		}
		else{
			return super.getColumnClass(columnIndex);
		}
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
