package graficaCancelleria;

import gestionaleCancelleria.MyListener;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraficaNavigatoreDipendenti extends JFrame {
	
	private JPanel pannello_Opzioni;
	private JButton Button_Account;
	private JButton Button_Catalogo;
	private JButton Button_Carrello;
	private JButton Button_Logout;
	private JButton Button_Chiudi;
	
	public GraficaNavigatoreDipendenti()
	{
		
	}
	
	public void init()
	{
		pannello_Opzioni = new JPanel();
		pannello_Opzioni.setLayout(new GridLayout(1,5));
		
		Button_Account = new JButton("Account");
		Button_Account.setForeground(Color.blue);
		Button_Account.setBackground(Color.white);
		Button_Account.setActionCommand("Account");
		Button_Account.addActionListener(new MyListener());
		Button_Catalogo = new JButton("Catalogo");
		Button_Catalogo.setForeground(Color.blue);
		Button_Catalogo.setBackground(Color.white);
		Button_Catalogo.setActionCommand("Catalogo");
		Button_Catalogo.addActionListener(new MyListener());
		Button_Carrello = new JButton("Carrello");
		Button_Carrello.setForeground(Color.blue);
		Button_Carrello.setBackground(Color.white);
		Button_Carrello.setActionCommand("Carrello");
		Button_Carrello.addActionListener(new MyListener());
		Button_Logout = new JButton("Logout");
		Button_Logout.setForeground(Color.blue);	
		Button_Logout.setBackground(Color.white);
		Button_Logout.setActionCommand("Logout");
		Button_Logout.addActionListener(new MyListener());
		Button_Chiudi = new JButton("Chiudi");
		Button_Chiudi.setForeground(Color.blue);
		Button_Chiudi.setBackground(Color.white);
		Button_Chiudi.setActionCommand("Exit");
		Button_Chiudi.addActionListener(new MyListener());
		
		pannello_Opzioni.add(Button_Account);
		pannello_Opzioni.add(Button_Catalogo);
		pannello_Opzioni.add(Button_Carrello);
		pannello_Opzioni.add(Button_Logout);
		pannello_Opzioni.add(Button_Chiudi);
	}
	
	public JPanel getPannello(){
		
		return this.pannello_Opzioni;
	}
	
}
