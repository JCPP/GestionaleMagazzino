package gestionale.magazzino.grafica.responsabile.finestre;

import gestionale.magazzino.MyListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class GraficaModificaProdotto extends JFrame {

	private JFrame finestra_Modifica;
	private Dimension dimensione;
	private int x;
	private int y;
	private JPanel pannello_Prodotto;
	private GridBagConstraints dati_Constraints;
	private GridBagConstraints opzioni_Constraints;
	private LayoutManager layout;
	private JPanel pannello_Dati;
	private JPanel pannello_Opzioni;
	private JTextField text_Nome;
	private JLabel label_Nome;
	private JLabel label_Prezzo;
	private JTextField text_Prezzo;
	private JLabel label_Quantita;
	private JTextField text_Quantita;
	private JButton bottone_Modifica;
	private JButton bottone_Annulla;
	private JButton bottone_Rimuovi;
	
	public GraficaModificaProdotto()
	{
		
	}
	
	public void init()
	{
		finestra_Modifica = new JFrame("ModProdotto");
		finestra_Modifica.setSize(300,400);
		
		dimensione = getToolkit().getScreenSize().getSize();
		x = (int) (dimensione.getWidth() - finestra_Modifica.getWidth())/2;
		y = (int) (dimensione.getHeight() - finestra_Modifica.getHeight())/2;
		
		pannello_Prodotto = new JPanel();
		pannello_Prodotto.setLayout(new BorderLayout());
		
		layout = new GridBagLayout();
		dati_Constraints = new GridBagConstraints();
		opzioni_Constraints = new GridBagConstraints();
		
		pannello_Dati = new JPanel();
		pannello_Dati.setLayout(layout);
		
		pannello_Opzioni = new JPanel();
		pannello_Opzioni.setLayout(layout);
		
		text_Nome = new JTextField(15);
		label_Nome = new JLabel("Nome");
		label_Prezzo = new JLabel("Prezzo");
		text_Prezzo = new JTextField(15);
		label_Quantita = new JLabel("Quantita");
		text_Quantita = new JTextField(15);
		
		bottone_Modifica = new JButton("Modifica Prodotto");
		bottone_Modifica.setActionCommand("Modifica Prodotto Responsabile");
		bottone_Modifica.addActionListener(new MyListener());
		bottone_Annulla = new JButton("Indietro");
		bottone_Annulla.setActionCommand("Annulla Modifica Responsabile");
		bottone_Annulla.addActionListener(new MyListener());
		bottone_Rimuovi = new JButton("Rimuovi Prodotto");
		bottone_Rimuovi.setActionCommand("Rimuovi Prodotto Responsabile");
		bottone_Rimuovi.addActionListener(new MyListener());
		
		dati_Constraints.fill = GridBagConstraints.HORIZONTAL;
		dati_Constraints.weightx = 1.0;
		dati_Constraints.weighty = 1.0;
		dati_Constraints.gridx = 0;
		dati_Constraints.gridy = 0;
		pannello_Dati.add(label_Nome,dati_Constraints);
		dati_Constraints.gridx = 1;
		dati_Constraints.gridy = 0;
		pannello_Dati.add(text_Nome,dati_Constraints);
		dati_Constraints.gridx = 0;
		dati_Constraints.gridy = 1;
		pannello_Dati.add(label_Prezzo,dati_Constraints);
		dati_Constraints.gridx = 1;
		dati_Constraints.gridy = 1;
		pannello_Dati.add(text_Prezzo,dati_Constraints);
		dati_Constraints.gridx = 0;
		dati_Constraints.gridy = 2;
		pannello_Dati.add(label_Quantita,dati_Constraints);
		dati_Constraints.gridx = 1;
		dati_Constraints.gridy = 2;
		pannello_Dati.add(text_Quantita,dati_Constraints);
	
		
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
		
		pannello_Prodotto.add(pannello_Dati);
		pannello_Prodotto.add("South",pannello_Opzioni);
		
		finestra_Modifica.add(pannello_Prodotto);
		
		finestra_Modifica.addWindowListener(new MyListener());
		finestra_Modifica.setSize(300,400);
		finestra_Modifica.setLocation(x,y);
		finestra_Modifica.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		finestra_Modifica.setResizable(false);
		finestra_Modifica.setVisible(true);
	}
	
	public void disposeF()
	{
		finestra_Modifica.dispose();
	}
	
	public void setNome(String n)
	{
		text_Nome.setText(n);
	}
	
	public void setQuantita(int q)
	{
		text_Quantita.setText(""+q);
	}
	
	public void setPrezzo(float p)
	{
		text_Prezzo.setText(""+p);
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
			JOptionPane.showMessageDialog(this, "Quantita errata");
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
			JOptionPane.showMessageDialog(this, "Quantita errata");
		}
		
		return i;
	}

	public void doClose() {
		finestra_Modifica.dispatchEvent(new WindowEvent(finestra_Modifica, WindowEvent.WINDOW_DEACTIVATED));
		finestra_Modifica.dispatchEvent(new WindowEvent(finestra_Modifica, WindowEvent.WINDOW_CLOSING));
		finestra_Modifica.dispose();
		
	}
}
