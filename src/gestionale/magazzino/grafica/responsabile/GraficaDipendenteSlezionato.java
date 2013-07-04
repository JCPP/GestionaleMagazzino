package gestionale.magazzino.grafica.responsabile;

import gestionale.magazzino.MyListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class GraficaDipendenteSlezionato extends JFrame{

	private JFrame finestra_DipSel;
	private Dimension dimensione;
	private int x;
	private int y;
	private JPanel pannello_Dipendente;
	private GridBagConstraints dati_Constraints;
	private GridBagConstraints opzioni_Constraints;
	private LayoutManager layout;
	private JPanel pannello_Dati;
	private JPanel pannello_Opzioni;
	private JLabel label_ID;
	private JTextField text_ID;
	private JLabel label_Nome;
	private JTextField text_Nome;
	private JLabel label_Cognome;
	private JTextField text_Cognome;
	private JLabel label_Tipo;
	private JTextField text_Tipo;
	private JLabel label_Stato;
	private JTextField text_Stato;
	private JLabel label_Email;
	private JTextField text_Email;
	private JButton bottone_Modifica;
	private JButton bottone_Annulla;
	private JButton bottone_Rimuovi;
	
	public GraficaDipendenteSlezionato()
	{
		
	}
	
	public void init()
	{
		finestra_DipSel = new JFrame("DipSel");
		finestra_DipSel.setSize(300,400);
		
		dimensione = getToolkit().getScreenSize().getSize();
		x = (int) (dimensione.getWidth() - finestra_DipSel.getWidth())/2;
		y = (int) (dimensione.getHeight() - finestra_DipSel.getHeight())/2;
		
		pannello_Dipendente = new JPanel();
		pannello_Dipendente.setLayout(new BorderLayout());
		
		layout = new GridBagLayout();
		dati_Constraints = new GridBagConstraints();
		opzioni_Constraints = new GridBagConstraints();
		
		pannello_Dati = new JPanel();
		pannello_Dati.setLayout(layout);
		
		pannello_Opzioni = new JPanel();
		pannello_Opzioni.setLayout(layout);
		
		label_ID = new JLabel("ID :");
		text_ID = new JTextField(15);
		text_Nome = new JTextField(15);
		label_Nome = new JLabel("Nome :");
		label_Cognome = new JLabel("Cognome :");
		text_Cognome = new JTextField(15);
		label_Tipo = new JLabel("Tipo :");
		text_Tipo = new JTextField(15);
		label_Email = new JLabel("Email :");
		text_Email = new JTextField(15);
		label_Stato = new JLabel("Stato :");
		text_Stato = new JTextField(15);
		
		bottone_Modifica = new JButton("Modifica Dipendente");
		bottone_Modifica.setActionCommand("Modifica Dipendente Responsabile");
		bottone_Modifica.addActionListener(new MyListener());
		bottone_Annulla = new JButton("Indietro");
		bottone_Annulla.setActionCommand("Annulla Dipendente Responsabile");
		bottone_Annulla.addActionListener(new MyListener());
		bottone_Rimuovi = new JButton("Rimuovi Dipendente");
		bottone_Rimuovi.setActionCommand("Rimuovi Dipendente Responsabile");
		bottone_Rimuovi.addActionListener(new MyListener());
		
		dati_Constraints.fill = GridBagConstraints.HORIZONTAL;
		dati_Constraints.weightx = 1.0;
		dati_Constraints.weighty = 1.0;
		
		dati_Constraints.gridx = 0;
		dati_Constraints.gridy = 0;
		pannello_Dati.add(label_ID,dati_Constraints);
		dati_Constraints.gridx = 1;
		dati_Constraints.gridy = 0;
		pannello_Dati.add(text_ID,dati_Constraints);
		
		dati_Constraints.gridx = 0;
		dati_Constraints.gridy = 1;
		pannello_Dati.add(label_Nome,dati_Constraints);
		dati_Constraints.gridx = 1;
		dati_Constraints.gridy = 1;
		pannello_Dati.add(text_Nome,dati_Constraints);
		
		dati_Constraints.gridx = 0;
		dati_Constraints.gridy = 2;
		pannello_Dati.add(label_Cognome,dati_Constraints);
		dati_Constraints.gridx = 1;
		dati_Constraints.gridy = 2;
		pannello_Dati.add(text_Cognome,dati_Constraints);
		
		dati_Constraints.gridx = 2;
		dati_Constraints.gridy = 0;
		pannello_Dati.add(label_Email,dati_Constraints);
		dati_Constraints.gridx = 3;
		dati_Constraints.gridy = 0;
		pannello_Dati.add(text_Email,dati_Constraints);
		
		dati_Constraints.gridx = 2;
		dati_Constraints.gridy = 1;
		pannello_Dati.add(label_Tipo,dati_Constraints);
		dati_Constraints.gridx = 3;
		dati_Constraints.gridy = 1;
		pannello_Dati.add(text_Tipo,dati_Constraints);
		
		dati_Constraints.gridx = 2;
		dati_Constraints.gridy = 2;
		pannello_Dati.add(label_Stato,dati_Constraints);
		dati_Constraints.gridx = 3;
		dati_Constraints.gridy = 2;
		pannello_Dati.add(text_Stato,dati_Constraints);
	
		
		opzioni_Constraints.fill = GridBagConstraints.HORIZONTAL;
		opzioni_Constraints.weightx = 1.0;
		opzioni_Constraints.weighty = 1.0;
		opzioni_Constraints.gridx = 0;
		opzioni_Constraints.gridy = 0;
		pannello_Opzioni.add(bottone_Modifica,opzioni_Constraints);
		opzioni_Constraints.gridx = 0;
		opzioni_Constraints.gridy = 1;
		pannello_Opzioni.add(bottone_Rimuovi,opzioni_Constraints);
		opzioni_Constraints.gridx = 0;
		opzioni_Constraints.gridy = 2;
		pannello_Opzioni.add(bottone_Annulla,opzioni_Constraints);
		
		pannello_Dipendente.add(pannello_Dati);
		pannello_Dipendente.add("South",pannello_Opzioni);
		
		finestra_DipSel.add(pannello_Dipendente);
		
		finestra_DipSel.addWindowListener(new MyListener());
		finestra_DipSel.setSize(300,400);
		finestra_DipSel.setLocation(x,y);
		finestra_DipSel.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		finestra_DipSel.setVisible(true);
	}
	
	public void disposeF()
	{
		finestra_DipSel.dispose();
	}
	
	public void setId(String i)
	{
		text_ID.setText(i);
	}
	public void setNome(String n)
	{
		text_Nome.setText(n);
	}
	
	public void setCognome(String c)
	{
		text_Cognome.setText(c);
	}
	
	public void setEmail(String e)
	{
		text_Email.setText(e);
	}
	public void setTipo(String t)
	{
		text_Tipo.setText(t);
	}
	
	public void setStato(String s)
	{
		text_Stato.setText(s);
	}
	public String getID()
	{
		return text_ID.getText();
	}
	public String getNome()
	{
		return text_Nome.getText();
	}
	public String getEmail()
	{
		return text_Email.getText();
	}
	public String getCognome()
	{
		return text_Cognome.getText();
	}
	
	public String getTipo()
	{
		return text_Tipo.getText();
	}

	public String getStato()
	{
		return text_Stato.getText();
	}
	public void doClose() {
		finestra_DipSel.dispatchEvent(new WindowEvent(finestra_DipSel, WindowEvent.WINDOW_DEACTIVATED));
		finestra_DipSel.dispatchEvent(new WindowEvent(finestra_DipSel, WindowEvent.WINDOW_CLOSING));
		finestra_DipSel.dispose();
		
	}
}

