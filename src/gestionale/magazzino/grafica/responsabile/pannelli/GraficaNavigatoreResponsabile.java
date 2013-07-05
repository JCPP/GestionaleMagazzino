package gestionale.magazzino.grafica.responsabile.pannelli;

import gestionale.magazzino.MyListener;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GraficaNavigatoreResponsabile{
	
	private JPanel pannello_Opzioni;
	private JButton Button_Account;
	private JButton Button_Catalogo;
	private JButton Button_Notifiche;
	private JButton Button_Lista;
	private JButton Button_Logout;
	private JButton Button_Chiudi;
	
	public GraficaNavigatoreResponsabile()
	{}
	
	public void init()
	{
		pannello_Opzioni = new JPanel();
		pannello_Opzioni.setLayout(new GridLayout(1,5));
		
		Button_Account = new JButton("Account");
		Button_Account.setForeground(Color.blue);
		Button_Account.setBackground(Color.white);
		Button_Account.setActionCommand("Account Responsabile");
		Button_Account.addActionListener(new MyListener());
		Button_Catalogo = new JButton("Catalogo");
		Button_Catalogo.setForeground(Color.blue);
		Button_Catalogo.setBackground(Color.white);
		Button_Catalogo.setActionCommand("Catalogo Responsabile");
		Button_Catalogo.addActionListener(new MyListener());
		Button_Notifiche = new JButton("Notifiche");
		Button_Notifiche.setForeground(Color.blue);
		Button_Notifiche.setBackground(Color.white);
		Button_Notifiche.setActionCommand("Notifiche Responsabile");
		Button_Notifiche.addActionListener(new MyListener());
		Button_Lista = new JButton("Lista Dipendenti");
		Button_Lista.setForeground(Color.blue);
		Button_Lista.setBackground(Color.white);
		Button_Lista.setActionCommand("Lista Dipendenti");
		Button_Lista.addActionListener(new MyListener());
		Button_Logout = new JButton("Logout");
		Button_Logout.setForeground(Color.blue);	
		Button_Logout.setBackground(Color.white);
		Button_Logout.setActionCommand("Logout Responsabile");
		Button_Logout.addActionListener(new MyListener());
		Button_Chiudi = new JButton("Chiudi");
		Button_Chiudi.setForeground(Color.blue);
		Button_Chiudi.setBackground(Color.white);
		Button_Chiudi.setActionCommand("Exit Responsabile");
		Button_Chiudi.addActionListener(new MyListener());
		
		pannello_Opzioni.add(Button_Account);
		pannello_Opzioni.add(Button_Catalogo);
		pannello_Opzioni.add(Button_Notifiche);
		pannello_Opzioni.add(Button_Lista);
		pannello_Opzioni.add(Button_Logout);
		pannello_Opzioni.add(Button_Chiudi);
	}
	
	public JPanel getPannello(){
		
		return this.pannello_Opzioni;
	}
	


}


