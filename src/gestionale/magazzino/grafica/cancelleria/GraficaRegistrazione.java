package gestionale.magazzino.grafica.cancelleria;
/**
 * Classe che fornisce una finestra grafica per la registrazione di un utente
 */

import gestionale.magazzino.MyListener;

import javax.swing.*;

import java.awt.*;

public class GraficaRegistrazione extends JFrame{
	
	private GraficaLogin grafica_Login;
	private JFrame finestra_Registrazione;
	private Dimension dimensione;
	private int x;
	private int y;
	private JPanel pannello_Registrazione;
	private LayoutManager layout;
	private GridBagConstraints dati_Constraints;
	private JPanel pannello_Dati;
	private JPanel pannello_Bottoni;
	private JLabel label_Email;
	private JLabel label_Errore_Email;
	private JLabel label_Password;
	private JLabel label_Errore_Password;
	private JLabel label_Password2;
	private JLabel label_Errore_Password2;
	private JLabel label_Nome;
	private JLabel label_Errore_Nome;
	private JLabel label_Cognome;
	private JLabel label_Errore_Cognome;
	private JTextField text_Email;
	private JPasswordField pass_Password;
	private JPasswordField pass_Password2;
	private JTextField text_Nome;
	private JTextField text_Cognome;
	private JButton bottone_Invio;
	private JButton bottone_Reset;
	private JButton bottone_Indietro;
	
	/**
	 * Costruttore della classe
	 */
	public GraficaRegistrazione()
	{
		
	}
	
	/**
	 * Inizializzazione delle componenti grafiche
	 */
	public void init()
	{
		finestra_Registrazione = new JFrame("Registrati");
		finestra_Registrazione.setSize(300,400);
		
		dimensione = getToolkit().getScreenSize().getSize();
		x = (int) (dimensione.getWidth() - finestra_Registrazione.getWidth())/2;
		y = (int) (dimensione.getHeight() - finestra_Registrazione.getHeight())/2;
		
		pannello_Registrazione = new JPanel();
		
		
		
		layout = new GridBagLayout();
		dati_Constraints = new GridBagConstraints();
		
		pannello_Dati = new JPanel();
		pannello_Dati.setLayout(layout);
		
		pannello_Bottoni = new JPanel();
		pannello_Bottoni.setLayout(new GridLayout(1,3));
				
		label_Email = new JLabel("Email");
		label_Errore_Email = new JLabel(" ");
		
		label_Password = new JLabel("Password");
		label_Errore_Password = new JLabel(" ");
		
		label_Password2 = new JLabel("Password 2");
		label_Errore_Password2 = new JLabel(" ");
		
		label_Nome = new JLabel("Nome");
		label_Errore_Nome = new JLabel(" ");
		
		label_Cognome = new JLabel("Cognome");
		label_Errore_Cognome = new JLabel(" ");
		
		text_Email = new JTextField(20);
		text_Email.setActionCommand("Email");
		text_Email.addActionListener(new MyListener());
		
		pass_Password = new JPasswordField(20);
		pass_Password.setActionCommand("Password");
		pass_Password.addActionListener(new MyListener());
		
		pass_Password2 = new JPasswordField(20);
		pass_Password.setActionCommand("Password2");
		pass_Password.addActionListener(new MyListener());
		
		text_Nome = new JTextField(20);
		text_Nome.setActionCommand("Nome");
		text_Nome.addActionListener(new MyListener());
		
		text_Cognome = new JTextField(20);
		text_Cognome.setActionCommand("Cognome");
		text_Cognome.addActionListener(new MyListener());
		
		bottone_Invio = new JButton("Invio");
		bottone_Invio.setActionCommand("Invio");
		bottone_Invio.addActionListener(new MyListener());
		
		bottone_Reset = new JButton("Reset");
		bottone_Reset.setActionCommand("Reset");
		bottone_Reset.addActionListener(new MyListener());
		
		bottone_Indietro = new JButton("Indietro");
		bottone_Indietro.setActionCommand("Indietro");
		bottone_Indietro.addActionListener(new MyListener());
		
		dati_Constraints.fill = GridBagConstraints.HORIZONTAL;
		dati_Constraints.weightx = 1.0;
		dati_Constraints.gridx = 0;
		dati_Constraints.gridy = 0;
		pannello_Dati.add(label_Email,dati_Constraints);
		dati_Constraints.gridx = 0;
		dati_Constraints.gridy = 1;
		pannello_Dati.add(text_Email,dati_Constraints);
		dati_Constraints.gridx = 0;
		dati_Constraints.gridy = 2;
		pannello_Dati.add(label_Errore_Email,dati_Constraints);
		
		dati_Constraints.gridx = 0;
		dati_Constraints.gridy = 3;
		pannello_Dati.add(label_Password,dati_Constraints);
		dati_Constraints.gridx = 0;
		dati_Constraints.gridy = 4;
		pannello_Dati.add(pass_Password,dati_Constraints);
		dati_Constraints.gridx = 0;
		dati_Constraints.gridy = 5;
		pannello_Dati.add(label_Errore_Password,dati_Constraints);
		
		dati_Constraints.gridx = 0;
		dati_Constraints.gridy = 6;
		pannello_Dati.add(label_Password2,dati_Constraints);
		dati_Constraints.gridx = 0;
		dati_Constraints.gridy = 7;
		pannello_Dati.add(pass_Password2,dati_Constraints);
		dati_Constraints.gridx = 0;
		dati_Constraints.gridy = 8;
		pannello_Dati.add(label_Errore_Password2,dati_Constraints);
		
		dati_Constraints.gridx = 0;
		dati_Constraints.gridy = 9;
		pannello_Dati.add(label_Nome,dati_Constraints);
		dati_Constraints.gridx = 0;
		dati_Constraints.gridy = 10;
		pannello_Dati.add(text_Nome,dati_Constraints);
		dati_Constraints.gridx = 0;
		dati_Constraints.gridy = 11;
		pannello_Dati.add(label_Errore_Nome,dati_Constraints);
		
		dati_Constraints.gridx = 0;
		dati_Constraints.gridy = 12;
		pannello_Dati.add(label_Cognome,dati_Constraints);
		dati_Constraints.gridx = 0;
		dati_Constraints.gridy = 13;
		pannello_Dati.add(text_Cognome,dati_Constraints);
		dati_Constraints.gridx = 0;
		dati_Constraints.gridy = 14;
		pannello_Dati.add(label_Errore_Cognome,dati_Constraints);
		
		pannello_Bottoni.add(bottone_Invio);
		pannello_Bottoni.add(bottone_Reset);
		pannello_Bottoni.add(bottone_Indietro);
		
		pannello_Registrazione.add(pannello_Dati);
		pannello_Registrazione.add(pannello_Bottoni);
		
		finestra_Registrazione.add("Center",pannello_Registrazione);
		finestra_Registrazione.setSize(300,400);
		finestra_Registrazione.setLocation(x,y);
		finestra_Registrazione.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		finestra_Registrazione.setVisible(true);
	}
	
	public String getEmail()
	{
		return text_Email.getText();
	}
	
	public String getPassword()
	{
		return pass_Password.getText();
	}
	
	public String getPassword2()
	{
		return pass_Password2.getText();
	}
	
	public String getNome()
	{
		return text_Nome.getText();
	}
	
	public String getCognome()
	{
		return text_Cognome.getText();
	}
	
	public void setErroreEmail(String s)
	{
		label_Errore_Email.setForeground(Color.red);
		label_Errore_Email.setText(s);
	}
	public void setErrorePassword(String s)
	{
		label_Errore_Password.setForeground(Color.red);
		label_Errore_Password.setText(s);
	}
	public void setErrorePassword2(String s)
	{
		label_Errore_Password2.setForeground(Color.red);
		label_Errore_Password2.setText(s);
	}
	public void setErroreNome(String s)
	{
		label_Errore_Nome.setForeground(Color.red);
		label_Errore_Nome.setText(s);
	}
	public void setErroreCognome(String s)
	{
		label_Errore_Cognome.setForeground(Color.red);
		label_Errore_Cognome.setText(s);
	}
	/**
	 * Funzione che pulisce la visualizzazione degli errori di inserimento precedenti
	 */
	public void pulisciErrori()
	{
		label_Errore_Email.setText(" ");
		label_Errore_Password.setText(" ");
		label_Errore_Password2.setText(" ");
		label_Errore_Nome.setText(" ");
		label_Errore_Cognome.setText(" ");
	}

	public void pulisci()
	{
		text_Email.setText("");
		pass_Password.setText("");
		pass_Password2.setText("");
		text_Nome.setText("");
		text_Cognome.setText("");
	}
	
	public void disposeF()
	{
		finestra_Registrazione.dispose();
	}
}
