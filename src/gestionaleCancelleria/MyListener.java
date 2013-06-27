package gestionaleCancelleria;

import gestionaleCancelleria.Main;
import graficaCancelleria.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;


public class MyListener implements ActionListener,MouseListener{
	private Main m = new Main();
	private static JTable table = new JTable();
	
	public void setTable(JTable tabella)
	{
		table = tabella;
	}
	public MyListener()
	{

	}
	
	@Override
	public void mouseClicked(MouseEvent me) {
		// TODO Auto-generated method stub
		int x = table.rowAtPoint(me.getPoint());
		int y = table.columnAtPoint(me.getPoint());
		m.start(""+x+"|"+y);
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


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s = e.getActionCommand();
		m.start(s);
	}

}
