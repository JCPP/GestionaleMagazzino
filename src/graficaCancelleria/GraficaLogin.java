package graficaCancelleria;


import javax.swing.*;

import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.awt.*;

public class GraficaLogin extends JFrame implements ActionListener {
	
	private GraficaRegistrazione grafica_Registrazione;
	private JFrame finestra_Login;
	private Dimension dimensione_Finestra;
	private int x;
	private int y;
	private LayoutManager layout;
	private GridBagConstraints dati_Constraints;
	private GridBagConstraints opzioni_Constraints;
	private JPanel pannello_Login;
	private JPanel pannello_Dati;
	private JPanel pannello_Bottoni;
	private JPanel pannello_Opzioni;
	private JLabel label_Errore_Email;
	private JLabel label_Email;
	private JLabel label_Errore_Password;
	private JLabel label_Password;
	private JTextField text_Email;
	private JPasswordField pass_Password;
	private JButton bottone_Connetti;
	private JButton bottone_Annulla;
	private JButton bottone_Registrati;
	
	/**
	 * Costruttore della classe
	 */
	public GraficaLogin()
	{
		init();
		dati_Constraints.gridx = 2;
		dati_Constraints.gridy = 0;
		pannello_Dati.add(label_Email,dati_Constraints);
		dati_Constraints.fill = GridBagConstraints.HORIZONTAL;
		dati_Constraints.gridx = 2;
		dati_Constraints.gridy = 1;
		pannello_Dati.add(text_Email,dati_Constraints);
		dati_Constraints.fill = GridBagConstraints.NONE;
		dati_Constraints.gridx = 2;
		dati_Constraints.gridy = 2;
		pannello_Dati.add(label_Errore_Email,dati_Constraints);
		dati_Constraints.gridx = 2;
		dati_Constraints.gridy = 4;
		pannello_Dati.add(label_Password,dati_Constraints);
		dati_Constraints.fill = GridBagConstraints.HORIZONTAL;
		dati_Constraints.gridx = 2;
		dati_Constraints.gridy = 5;
		pannello_Dati.add(pass_Password,dati_Constraints);
		dati_Constraints.fill = GridBagConstraints.NONE;
		dati_Constraints.gridx = 2;
		dati_Constraints.gridy = 6;
		pannello_Dati.add(label_Errore_Password,dati_Constraints);
		
		pannello_Bottoni.add(bottone_Connetti);
		pannello_Bottoni.add(bottone_Annulla);
		
		pannello_Opzioni.add(bottone_Registrati,opzioni_Constraints);
		
		pannello_Login.add(pannello_Dati);
		pannello_Login.add(pannello_Bottoni);
		pannello_Login.add(pannello_Opzioni);
		
		finestra_Login.add(pannello_Login);
		finestra_Login.setSize(300,400);
		finestra_Login.setLocation(x, y);
		finestra_Login.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		finestra_Login.setVisible(true);
		
		
	}
	
	/**
	 * Inizializzazione delle componenti grafiche
	 */
	public void init()
	{
		finestra_Login = new JFrame("Accedi");
		finestra_Login.setSize(300,400);
		
		dimensione_Finestra = getToolkit().getScreenSize().getSize();
		x = (int) (dimensione_Finestra.getWidth() - finestra_Login.getWidth())/2;
		y = (int) (dimensione_Finestra.getHeight() - finestra_Login.getHeight())/2;
		
		pannello_Login = new JPanel();
		pannello_Login.setLayout(new GridLayout(3,1));
		
		layout = new GridBagLayout();
		dati_Constraints = new GridBagConstraints();
		pannello_Dati = new JPanel();
		pannello_Dati.setLayout(layout);
		
		pannello_Bottoni = new JPanel();
		
		opzioni_Constraints = new GridBagConstraints();
		pannello_Opzioni = new JPanel();
		pannello_Opzioni.setLayout(layout);
		
		label_Errore_Email = new JLabel(" ");
		
		label_Email = new JLabel("Email :");
		
		label_Errore_Password = new JLabel(" ");
		
		label_Password = new JLabel("Password :");
		
		text_Email = new JTextField(20);
		text_Email.setActionCommand("Email");
		text_Email.addActionListener(this);
		
		pass_Password = new JPasswordField(20);
		pass_Password.setActionCommand("Password");
		pass_Password.addActionListener(this);
		
		bottone_Connetti = new JButton("Connetti");
		bottone_Connetti.setActionCommand("Connetti");
		bottone_Connetti.addActionListener(this);
		
		bottone_Annulla = new JButton(" Chiudi ");
		bottone_Annulla.setActionCommand("Chiudi");
		bottone_Annulla.addActionListener(this);
		
		bottone_Registrati = new JButton("Registrati");
		bottone_Registrati.setActionCommand("Registrati");
		bottone_Registrati.addActionListener(this);
		
		
	}
	/**
	 * Funzione dell'interfaccia ActionListener per la gestione degli eventi
	 */
	@Override
	public void actionPerformed(ActionEvent evnt) {
		String s;
		s=evnt.getActionCommand();
		if(s.equals("Connetti"))
		{
			pulisciErrori();
			controlloCampi();
			//passaggio di parametri da confrontare con il DB
		}
		if(s.equals("Chiudi"))
		{
			pulisciErrori();
			finestra_Login.dispose();
		}
		if(s.equals("Registrati"))
		{
			pulisciErrori();
			finestra_Login.dispose();
			grafica_Registrazione = new GraficaRegistrazione();
		}
	}
	
	/**
	 * Funzione che legge l'Email e la password inserite dall'utente
	 */
	public void controlloCampi()
	{
		String i;
		char p[];
		p = new char[12];
		i=getEmail();
		p=getPassword();
	}

	public String getEmail()
	{
		return text_Email.getText();
	}

	public char[] getPassword()
	{
		return pass_Password.getPassword();
	}
	
	public void setErroreEmail(String s)
	{
		label_Errore_Email.setForeground(Color.red);
		label_Errore_Email.setText(s);
	}
	
	public void setErrorePass(String s)
	{
		label_Errore_Password.setForeground(Color.red);
		label_Errore_Password.setText(s);
	}
	
	/**
	 * Funzione che pulisce la visualizzazione degli errori di inserimento precedenti
	 */
	public void pulisciErrori()
	{
		label_Errore_Email.setText(" ");
		label_Errore_Password.setText(" ");
	}
}
	

