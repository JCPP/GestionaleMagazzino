package gestionale.magazzino.grafica.responsabile;

import gestionale.magazzino.MyListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class GraficaInsProdotto extends JFrame{

	private JFrame finestra_Inserimento;
	private Dimension dimensione;
	private int x;
	private int y;
	private JPanel pannello_Inserimento;
	private LayoutManager layout;
	private GridBagConstraints dati_Constraints;
	private JPanel pannello_Dati;
	private JPanel pannello_Opzioni;
	private JLabel label_Nome;
	private JLabel label_Quantita;
	private JLabel label_Prezzo;
	private JTextField text_Nome;
	private JTextField text_Quantita;
	private JTextField text_Prezzo;
	private JButton bottone_Inserisci;
	private JButton bottone_Annulla;
	
	public GraficaInsProdotto()
	{
		
	}
	
	public void init()
	{
		finestra_Inserimento = new JFrame("Inserisci Prodotto");
		finestra_Inserimento.setSize(300,400);
		
		dimensione = getToolkit().getScreenSize().getSize();
		x = (int) (dimensione.getWidth() - finestra_Inserimento.getWidth())/2;
		y = (int) (dimensione.getHeight() - finestra_Inserimento.getHeight())/2;
		
		pannello_Inserimento = new JPanel();
		pannello_Inserimento.setLayout(new BorderLayout());
		
		layout = new GridBagLayout();
		dati_Constraints = new GridBagConstraints();
		
		pannello_Dati = new JPanel();
		pannello_Dati.setLayout(layout);
		
		label_Nome = new JLabel("Nome :");
		label_Quantita = new JLabel ("Quantita :");
		label_Prezzo = new JLabel("Prezzo :");
		
		text_Nome = new JTextField(15);
		text_Quantita = new JTextField(15);
		text_Prezzo = new JTextField(15);
		
		pannello_Opzioni = new JPanel();
		pannello_Opzioni.setLayout(new GridLayout(2,1));
		
		bottone_Inserisci = new JButton("Inserisci");
		bottone_Inserisci.setActionCommand("Inserisci Prodotto");
		bottone_Inserisci.addActionListener(new MyListener());
		
		bottone_Annulla = new JButton("Annulla");
		bottone_Annulla.setActionCommand("Annulla Inserimento");
		bottone_Annulla.addActionListener(new MyListener());
		
		dati_Constraints.insets = new Insets(50,0,0,0);
		dati_Constraints.fill = dati_Constraints.HORIZONTAL;
		dati_Constraints.weightx = 1.0;
		dati_Constraints.gridx = 0;
		dati_Constraints.gridy = 0;
		pannello_Dati.add(label_Nome,dati_Constraints);
		dati_Constraints.gridx = 1;
		dati_Constraints.gridy = 0;
		pannello_Dati.add(text_Nome,dati_Constraints);
		dati_Constraints.gridx = 0;
		dati_Constraints.gridy = 1;
		pannello_Dati.add(label_Quantita,dati_Constraints);
		dati_Constraints.gridx = 1;
		dati_Constraints.gridy = 1;
		pannello_Dati.add(text_Quantita,dati_Constraints);
		dati_Constraints.gridx = 0;
		dati_Constraints.gridy = 2;
		pannello_Dati.add(label_Prezzo,dati_Constraints);
		dati_Constraints.gridx = 1;
		dati_Constraints.gridy = 2;
		pannello_Dati.add(text_Prezzo,dati_Constraints);
		
		pannello_Opzioni.add(bottone_Inserisci);
		pannello_Opzioni.add(bottone_Annulla);
		
		
		pannello_Inserimento.add("Center",pannello_Dati);
		pannello_Inserimento.add("South",pannello_Opzioni);
		
		finestra_Inserimento.add(pannello_Inserimento);
		finestra_Inserimento.setSize(300,400);
		finestra_Inserimento.setLocation(x,y);
		finestra_Inserimento.addWindowListener(new MyListener());
		finestra_Inserimento.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		finestra_Inserimento.setVisible(true);
		
	}
	
	public void disposeF()
	{
		finestra_Inserimento.dispose();
	}
	public String getNome()
	{
		return text_Nome.getText();
	}
	
	public int getQuantita()
	{
		int i = 0;
		
		try
		{
			i = Integer.parseInt(text_Quantita.getText());
		}catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog(this,"Quantita errata");
		}
		
		return i;
	}
	
	public float getPrezzo()
	{
		float i = 0;
		try
		{
			i = Float.parseFloat(text_Prezzo.getText());
		}catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog(this,"Prezzo non valido");
		}
		
		return i;
	}
	
	public void doClose()
	{
		finestra_Inserimento.dispatchEvent(new WindowEvent(finestra_Inserimento, WindowEvent.WINDOW_DEACTIVATED));
		finestra_Inserimento.dispatchEvent(new WindowEvent(finestra_Inserimento, WindowEvent.WINDOW_CLOSING));
		finestra_Inserimento.dispose();
	}
	
}
