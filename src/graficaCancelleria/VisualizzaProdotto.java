package graficaCancelleria;
/**
 * Classe che crea una finestra grafica per consentire all'utente di effettuare un ordine
 */
import gestionaleCancelleria.MyListener;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

public class VisualizzaProdotto extends JFrame{
	
	private JFrame finestra_Prodotto;
	private Dimension dimensione;
	private int x;
	private int y;
	private JPanel pannello_Prodotto;
	private JPanel pannello_Dati;
	private JPanel pannello_Opzioni;
	private JLabel label_ID;
	private JLabel label_IDp;
	private JLabel label_Nome;
	private JLabel label_Nomep;
	private JLabel label_Quantita;
	private JLabel label_Quantitap;
	private JLabel label_Prezzo;
	private JLabel label_Prezzop;
	private JLabel label_ins;
	private JTextField text_Quantita;
	private JLabel label_sc;
	private JComboBox combo_Fondi;
	private JButton bottone_Ordina;
	private JButton bottone_Annulla;
	
	/**
	 * Costruttore della classe
	 */
	public VisualizzaProdotto()
	{
		
	}
	
	/**
	 * Inizializzazione delle componenti grafiche e visualizzazione della finestra
	 */
	public void init()
	{
		finestra_Prodotto = new JFrame("Visualizza Prodotto");
		finestra_Prodotto.setSize(300,400);
		
		dimensione = getToolkit().getScreenSize().getSize();
		x = (int) (dimensione.getWidth() - finestra_Prodotto.getWidth())/2;
		y = (int) (dimensione.getHeight() - finestra_Prodotto.getHeight())/2;
		
		pannello_Prodotto = new JPanel();
		pannello_Prodotto.setLayout(new GridLayout(2,1));
		
		pannello_Dati = new JPanel();
		pannello_Dati.setLayout(new GridLayout(4,2));
		
		pannello_Opzioni = new JPanel();
		pannello_Opzioni.setLayout(new GridLayout(6,1));
		
		label_ID = new JLabel("ID");
		label_Nome = new JLabel("Nome");
		label_Quantita = new JLabel("Quantita");
		label_Prezzo = new JLabel("Prezzo");
		
		label_IDp = new JLabel("thisID");
		label_Nomep = new JLabel("thisNome");
		label_Quantitap = new JLabel("thisQuantita");
		label_Prezzop = new JLabel("thisPrezzo");
		
		label_ins = new JLabel("Inserisci Quantita");
		
		text_Quantita = new JTextField(10);
		text_Quantita.setActionCommand("quant");
		text_Quantita.addActionListener(new MyListener());
		
		label_sc = new JLabel("Scegli Fondo");
		
		combo_Fondi = new JComboBox<String>();
		
		bottone_Ordina = new JButton("Ordina");
		bottone_Ordina.setActionCommand("Ordina");
		bottone_Ordina.addActionListener(new MyListener());
		
		bottone_Annulla = new JButton("Annulla");
		bottone_Annulla.setActionCommand("Annulla");
		bottone_Annulla.addActionListener(new MyListener());
		
		pannello_Dati.add(label_ID);
		pannello_Dati.add(label_IDp);
		pannello_Dati.add(label_Nome);
		pannello_Dati.add(label_Nomep);
		pannello_Dati.add(label_Quantita);
		pannello_Dati.add(label_Quantitap);
		pannello_Dati.add(label_Prezzo);
		pannello_Dati.add(label_Prezzop);

		pannello_Opzioni.add(label_ins);
		pannello_Opzioni.add(text_Quantita);
		pannello_Opzioni.add(label_sc);
		pannello_Opzioni.add(combo_Fondi);
		pannello_Opzioni.add(bottone_Ordina);
		pannello_Opzioni.add(bottone_Annulla);
		
		pannello_Prodotto.add(pannello_Dati);
		pannello_Prodotto.add(pannello_Opzioni);
		
		finestra_Prodotto.add(pannello_Prodotto);
		
		finestra_Prodotto.addWindowListener(new MyListener());
		finestra_Prodotto.setSize(300,400);
		finestra_Prodotto.setLocation(x,y);
		finestra_Prodotto.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		finestra_Prodotto.setVisible(true);
		
	}
	
	public void setIDProdotto(String s)
	{
		label_IDp.setText(s);
	}
	
	public void setNomeProdotto(String s)
	{
		label_Nomep.setText(s);
	}
	
	public void setQuantitaProdotto(String s)
	{
		label_Quantitap.setText(s);
	}
	
	public void setPrezzoProdotto(String s)
	{
		label_Prezzop.setText(s);
	}
	
	public void setFondi(ArrayList<String> s)
	{
		int i = 0;
		while(s.isEmpty())
		{
			combo_Fondi.addItem(s.remove(i));
			combo_Fondi.setActionCommand(""+combo_Fondi.getItemAt(i));
			i++;
		}
		combo_Fondi.addActionListener(new MyListener());
	}
	
	public int getQuantita()
	{
		int x = Integer.parseInt(text_Quantita.getText());
		return x;
	}
	
	
	
}
