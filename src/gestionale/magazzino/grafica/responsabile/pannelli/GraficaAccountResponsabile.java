package gestionale.magazzino.grafica.responsabile.pannelli;
/**
 * Classe che si occupa di visualizzare i dati di un dipendente
 */
import javax.swing.*;

import java.awt.*;

public class GraficaAccountResponsabile {
	
	private JPanel pannello_Account;
	private GridBagConstraints dati_Constraints;
	private LayoutManager layout_Dati;
	private JLabel label_Nome;
	private JLabel label_Cognome;
	private JLabel label_Tipo;
	private JLabel label_Email;
	private JTextField text_Nome;
	private JTextField text_Cognome;
	private JTextField text_Tipo;
	private JTextField text_Email;
	
	/**
	 * Costruttore della classe
	 */
	public GraficaAccountResponsabile()
	{
		
	}
	/**
	 * Inizializzazione delle componenti grafiche
	 */
	public void init()
	{
		pannello_Account = new JPanel();
		layout_Dati = new GridBagLayout();
		dati_Constraints = new GridBagConstraints();
		
		pannello_Account.setLayout(layout_Dati);
		
		label_Nome = new JLabel("Nome");
		label_Cognome = new JLabel("Cognome");
		label_Tipo = new JLabel("Tipo");
		label_Email = new JLabel("Email");
		text_Nome = new JTextField(20);
		text_Nome.setForeground(Color.lightGray);
		text_Nome.setEditable(false);
		text_Cognome = new JTextField(20);
		text_Cognome.setForeground(Color.lightGray);
		text_Cognome.setEditable(false);
		text_Tipo = new JTextField(20);
		text_Tipo.setForeground(Color.lightGray);
		text_Tipo.setEditable(false);
		text_Email = new JTextField(20);
		text_Email.setForeground(Color.lightGray);
		text_Email.setEditable(false);
		
		
		dati_Constraints.fill = GridBagConstraints.HORIZONTAL;
		dati_Constraints.insets = new Insets(20,0,0,0);
		dati_Constraints.gridx = 2;
		dati_Constraints.gridy = 0;
		pannello_Account.add(label_Nome,dati_Constraints);
		dati_Constraints.gridx = 2;
		dati_Constraints.gridy = 1;
		pannello_Account.add(text_Nome,dati_Constraints);
		dati_Constraints.gridx = 2;
		dati_Constraints.gridy = 2;
		pannello_Account.add(label_Cognome,dati_Constraints);
		dati_Constraints.gridx = 2;
		dati_Constraints.gridy = 3;
		pannello_Account.add(text_Cognome,dati_Constraints);
		dati_Constraints.gridx = 2;
		dati_Constraints.gridy = 4;
		pannello_Account.add(label_Tipo,dati_Constraints);
		dati_Constraints.gridx = 2;
		dati_Constraints.gridy = 5;
		pannello_Account.add(text_Tipo,dati_Constraints);
		dati_Constraints.gridx = 2;
		dati_Constraints.gridy = 6;
		pannello_Account.add(label_Email,dati_Constraints);
		dati_Constraints.gridx = 2;
		dati_Constraints.gridy = 7;
		pannello_Account.add(text_Email,dati_Constraints);
	
	}
	
	public JPanel getPannello()
	{
		return this.pannello_Account;
	}
	
	
	public void setNome(String s)
	{
		text_Nome.setText(s);
	}
	
	public void setCognome(String s)
	{
		text_Cognome.setText(s);
	}
	
	public void setTipo(String s)
	{
		text_Tipo.setText(s);
	}
	
	public void setEmail(String s)
	{
		text_Email.setText(s);
	}
}
