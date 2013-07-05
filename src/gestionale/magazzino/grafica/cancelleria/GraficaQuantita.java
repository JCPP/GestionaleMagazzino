package gestionale.magazzino.grafica.cancelleria;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GraficaQuantita extends JFrame implements ActionListener{
	
	private JFrame finestra_Quantita;
	private Dimension dimensione;
	private int x;
	private int y;
	private JPanel pannello_Quantita;
	private GridBagConstraints dati_Constraints;
	private JPanel pannello_Dati;
	private JPanel pannello_Bottoni;
	private JLabel label_Quantita;
	private JLabel label_Errore_Quantita;
	private JTextField text_Quantita;
	private JButton bottone_Inserisci;
	private JButton bottone_Annulla;
	/**
	 * Costruttore della classe
	 */
	public GraficaQuantita()
	{
		init();
		dati_Constraints.gridx = 2;
		dati_Constraints.gridy = 0;
		pannello_Dati.add(label_Quantita,dati_Constraints);
		dati_Constraints.gridx = 2;
		dati_Constraints.gridy = 1;
		pannello_Dati.add(text_Quantita,dati_Constraints);
		dati_Constraints.gridx = 2;
		dati_Constraints.gridy = 2;
		pannello_Dati.add(label_Errore_Quantita,dati_Constraints);
		
		pannello_Bottoni.add(bottone_Inserisci);
		pannello_Bottoni.add(bottone_Annulla);
		
		pannello_Quantita.add(pannello_Dati);
		pannello_Quantita.add(pannello_Bottoni);
		
		finestra_Quantita.add(pannello_Quantita);
		finestra_Quantita.setSize(300,200);
		finestra_Quantita.setLocation(x,y);
		finestra_Quantita.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		finestra_Quantita.setResizable(false);
		finestra_Quantita.setVisible(true);
	}
	/**
	 * Inizializzazione delle componenti grafiche
	 */
	public void init()
	{
		finestra_Quantita = new JFrame("Quantita");
		finestra_Quantita.setSize(300,200);
		dimensione = getToolkit().getScreenSize().getSize();
		x = (int) (dimensione.getWidth() - finestra_Quantita.getWidth())/2;
		y = (int) (dimensione.getHeight() - finestra_Quantita.getHeight())/2;
		
		pannello_Quantita = new JPanel();
		pannello_Quantita.setLayout(new GridLayout(2,1));
		
		pannello_Dati = new JPanel();
		pannello_Dati.setLayout(new GridBagLayout());
		dati_Constraints = new GridBagConstraints();
		
		pannello_Bottoni = new JPanel();
		
		label_Quantita = new JLabel("Inserisci Quantita' :");
		label_Errore_Quantita = new JLabel("  ");
		
		text_Quantita = new JTextField(20);
		text_Quantita.setActionCommand("Quantita");
		text_Quantita.addActionListener(this);
		
		bottone_Inserisci = new JButton("Inserisci");
		bottone_Inserisci.setActionCommand("Inserisci");
		bottone_Inserisci.addActionListener(this);
		
		bottone_Annulla = new JButton("Annulla");
		bottone_Annulla.setActionCommand("Annulla");
		bottone_Annulla.addActionListener(this);
		
	}
	/**
	 * Funzione dell'interfaccia ActionListener per la gestione degli eventi
	 */
	@Override
	public void actionPerformed(ActionEvent evnt) {
		String s;
		s = evnt.getActionCommand();
		if(s.equals("Inserisci"))
		{
			pulisciErrore();
			// passaggio di parametri da confrontare con il DB
		}
		if(s.equals("Annulla"))
		{
			finestra_Quantita.dispose();
		}
		
	}
	
	public int getQuantita()
	{
		int i;
		
		i = Integer.parseInt(text_Quantita.getText());
		
		return i;
	}
	
	public void setErroreQuantita(String s)
	{
		label_Errore_Quantita.setForeground(Color.red);
		label_Errore_Quantita.setText(s);
	}
	/**
	 * Funzione che pulisce la visualizzazione dell' errore di inserimento precedente
	 */
	public void pulisciErrore()
	{
		label_Errore_Quantita.setText(" ");
	}

}
