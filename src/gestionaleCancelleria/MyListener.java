package gestionaleCancelleria;
/**
 * La classe MyLystener si occupa di catturare tutti gli eventi generati dalle 
 * componenti grafiche (e dal programma in generale)
 * E consigliabile avere un solo listener in quanto si evitano problemi col multithread
 * Inoltre gli eventi vengono poi inviati e gestiti dalla main,sempre per lo stesso problema
 * del multithread
 */
import gestionaleCancelleria.Main;
import graficaCancelleria.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JTable;


public class MyListener implements ActionListener,MouseListener,WindowListener{
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
		m.start(""+x+""+y);
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
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosed(WindowEvent evt) {
		// TODO Auto-generated method stub

	}
	@Override
	public void windowClosing(WindowEvent evt) {
		// TODO Auto-generated method stub
		String s = evt.getSource().toString();
		if(s.contains("Lista Prodotti"))
		{
			m.start("dispose Dipendente");
		}
		if(s.contains("Modifica Prodotto"))
		{
			m.start("Carrello Dipendente");
		}
		if(s.contains("Visualizza Prodotto"))
		{
			m.start("Catalogo Dipendente");
		}
	}
	@Override
	public void windowDeactivated(WindowEvent evt) {
		// TODO Auto-generated method stub
	}
	@Override
	public void windowDeiconified(WindowEvent evt) {
		// TODO Auto-generated method stub
	}
	@Override
	public void windowIconified(WindowEvent evt) {
		// TODO Auto-generated method stub
	}
	@Override
	public void windowOpened(WindowEvent evt) {
		// TODO Auto-generated method stub
	}

}
