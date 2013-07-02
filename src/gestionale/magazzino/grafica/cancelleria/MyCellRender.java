package gestionale.magazzino.grafica.cancelleria;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

public class MyCellRender extends JPanel implements TableCellRenderer {
	private JButton bottone;
	
    public Component getTableCellRendererComponent(
            final JTable table, Object value,
            boolean isSelected, boolean hasFocus,
            int row, int column) {
    		if(column < 4) {
    			this.add( new JLabel( value.toString()  ) );
    			
    		}
    		else
    		{
    			bottone = new JButton("O");
    			bottone.setFont(new Font("monospaced",Font.PLAIN,7));
    			bottone.setSize(10, 10);
    			this.add(bottone);
    		}
    		return this;
}
}
