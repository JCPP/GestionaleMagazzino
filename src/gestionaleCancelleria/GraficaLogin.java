package gestionaleCancelleria;

import javax.swing.*;

import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.awt.*;

public class GraficaLogin extends JFrame implements ActionListener {
	
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
	private JLabel label_Errore_Id;
	private JLabel label_Id;
	private JLabel label_Errore_Password;
	private JLabel label_Password;
	private JLabel label_Accedi_tmp;
	private JLabel label_Separa;
	private JLabel label_Registrati_tmp;
	private JTextField text_Id;
	private JPasswordField pass_Password;
	private JButton bottone_Connetti;
	private JButton bottone_Annulla;
	
	public GraficaLogin()
	{
		init();
		dati_Constraints.gridx = 2;
		dati_Constraints.gridy = 0;
		pannello_Dati.add(label_Id,dati_Constraints);
		dati_Constraints.fill = GridBagConstraints.HORIZONTAL;
		dati_Constraints.gridx = 2;
		dati_Constraints.gridy = 1;
		pannello_Dati.add(label_Errore_Id,dati_Constraints);
		dati_Constraints.fill = GridBagConstraints.NONE;
		dati_Constraints.gridx = 2;
		dati_Constraints.gridy = 2;
		pannello_Dati.add(text_Id,dati_Constraints);
		dati_Constraints.gridx = 2;
		dati_Constraints.gridy = 4;
		pannello_Dati.add(label_Password,dati_Constraints);
		dati_Constraints.fill = GridBagConstraints.HORIZONTAL;
		dati_Constraints.gridx = 2;
		dati_Constraints.gridy = 5;
		pannello_Dati.add(label_Errore_Password,dati_Constraints);
		dati_Constraints.fill = GridBagConstraints.NONE;
		dati_Constraints.gridx = 2;
		dati_Constraints.gridy = 6;
		pannello_Dati.add(pass_Password,dati_Constraints);
		
		pannello_Bottoni.add(bottone_Connetti);
		pannello_Bottoni.add(bottone_Annulla);
		
		pannello_Login.add(pannello_Dati);
		pannello_Login.add(pannello_Bottoni);
		
		//opzioni_Constraints.fill = GridBagConstraints.HORIZONTAL;
		opzioni_Constraints.anchor = GridBagConstraints.PAGE_END;
		pannello_Opzioni.add(label_Accedi_tmp,opzioni_Constraints);
		pannello_Opzioni.add(label_Separa,opzioni_Constraints);
		pannello_Opzioni.add(label_Registrati_tmp,opzioni_Constraints);
		
		finestra_Login.add("Center",pannello_Login);
		finestra_Login.add("South",pannello_Opzioni);
		finestra_Login.setSize(300,400);
		finestra_Login.setLocation(x, y);
		finestra_Login.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		finestra_Login.setVisible(true);
		
		
	}
	
	public void init()
	{
		finestra_Login = new JFrame("Login");
		finestra_Login.setSize(300,400);
		
		dimensione_Finestra = getToolkit().getScreenSize().getSize();
		x = (int) ((dimensione_Finestra.getWidth() - finestra_Login.getWidth())/2);
		y = (int) ((dimensione_Finestra.getHeight() - finestra_Login.getHeight())/2);
		
		pannello_Login = new JPanel();
		pannello_Login.setLayout(new GridLayout(2,1));
		
		layout = new GridBagLayout();
		dati_Constraints = new GridBagConstraints();
		pannello_Dati = new JPanel();
		pannello_Dati.setLayout(layout);
		
		pannello_Bottoni = new JPanel();
		
		opzioni_Constraints = new GridBagConstraints();
		pannello_Opzioni = new JPanel();
		pannello_Opzioni.setLayout(layout);
		
		label_Errore_Id = new JLabel(" ");
		
		label_Id = new JLabel("ID :");
		
		label_Errore_Password = new JLabel(" ");
		
		label_Password = new JLabel("Password :");
		
		text_Id = new JTextField(20);
		text_Id.setActionCommand("Id");
		text_Id.addActionListener(this);
		
		pass_Password = new JPasswordField(20);
		pass_Password.setActionCommand("Password");
		pass_Password.addActionListener(this);
		
		bottone_Connetti = new JButton("Connetti");
		bottone_Connetti.setActionCommand("Connetti");
		bottone_Connetti.addActionListener(this);
		
		bottone_Annulla = new JButton("Annulla");
		bottone_Annulla.setActionCommand("Annulla");
		bottone_Annulla.addActionListener(this);
		
		label_Accedi_tmp = new JLabel("Accedi");
		label_Accedi_tmp.setForeground(Color.BLUE);
		label_Separa  = new JLabel("|");
		label_Registrati_tmp = new JLabel("Registrati");
		label_Registrati_tmp.setForeground(Color.BLUE);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent evnt) {
		String s;
		s=evnt.getActionCommand();
		if(s.equals("Connetti"))
		{
			controlloCampi();
		}
		if(s.equals("Annulla"))
		{
			finestra_Login.dispose();
		}
	}
	
	public void controlloCampi()
	{
		String i;
		char p[];
		p = new char[12];
		i=getId();
		p=getPassword();
		sendId(i);
		sendPassword(p);
	}
	
	public String getId()
	{
		return text_Id.getText();
	}
	
	public void sendId(String id)
	{
		//funzione per inviare l'id ad un controllore
	}
	
	public char[] getPassword()
	{
		return pass_Password.getPassword();
	}
	
	public void sendPassword(char[] pass)
	{
		//funzione per inviare la password ad un controllore
	}
	public void setErroreId(String s)
	{
		label_Errore_Id.setForeground(Color.red);
		label_Errore_Id.setText(s);
	}
	
	public void setErrorePass(String s)
	{
		label_Errore_Password.setForeground(Color.red);
		label_Errore_Password.setText(s);
	}
}
	

