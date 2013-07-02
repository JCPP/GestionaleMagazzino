package gestionale.magazzino.grafica.cancelleria;
/**
 * Classe che crea una finestra grafica per consetire all'utente di modificare un
 * prodotto prenotato
 */
import gestionale.magazzino.MyListener;

import javax.swing.*;

import java.awt.*;

public class ModificaProdotto extends JFrame {
	private JFrame finestra_Prodotto;
	private Dimension dimensione;
	private int x;
	private int y;
	private JPanel pannello_Prodotto;
	private GridBagConstraints dati_Constraints;
	private GridBagConstraints opzioni_Constraints;
	private LayoutManager layout;
	private JPanel pannello_Dati;
	private JPanel pannello_Opzioni;
	private JLabel label_ID;
	private JLabel label_IDp;
	private JLabel label_Nome;
	private JLabel label_Nomep;
	private JLabel label_Quantita;
	private JTextField text_Quantita;
	private JLabel label_Fondo;
	private JTextField text_Fondo;
	private JComboBox combo_Fondi;
	private JButton bottone_Modifica;
	private JButton bottone_Chiudi;
	private JButton bottone_Rimuovi;
	/**
	 * Costruttore della classe
	 */
	public ModificaProdotto()
	{
		
	}
	/**
	 * Inizializzazione delle componenti grafiche
	 */
	public void init()
	{
		finestra_Prodotto = new JFrame("Modifica Prodotto");
		finestra_Prodotto.setSize(300,400);
		
		dimensione = getToolkit().getScreenSize().getSize();
		x = (int) (dimensione.getWidth() - finestra_Prodotto.getWidth())/2;
		y = (int) (dimensione.getHeight() - finestra_Prodotto.getHeight())/2;
		
		pannello_Prodotto = new JPanel();
		pannello_Prodotto.setLayout(new BorderLayout());
		
		layout = new GridBagLayout();
		dati_Constraints = new GridBagConstraints();
		opzioni_Constraints = new GridBagConstraints();
		
		pannello_Dati = new JPanel();
		pannello_Dati.setLayout(layout);
		
		pannello_Opzioni = new JPanel();
		pannello_Opzioni.setLayout(layout);
		
		label_ID = new JLabel("ID");
		label_IDp = new JLabel(" I");
		label_Nome = new JLabel("Nome");
		label_Nomep = new JLabel(" N");
		label_Quantita = new JLabel("Quantita");
		text_Quantita = new JTextField(5);
		text_Quantita.setEditable(false);
		label_Fondo = new JLabel("Fondo Scelto");
		text_Fondo = new JTextField(5);
		text_Fondo.setEditable(false);
		combo_Fondi = new JComboBox();
		
		
		
		bottone_Modifica = new JButton("Modifica Prodotto");
		bottone_Modifica.setActionCommand("Modifica Prodotto");
		bottone_Modifica.addActionListener(new MyListener());
		bottone_Chiudi = new JButton("Chiudi");
		bottone_Chiudi.setActionCommand("Chiudi Prodotto");
		bottone_Chiudi.addActionListener(new MyListener());
		bottone_Rimuovi = new JButton("Cancella Ordine");
		bottone_Rimuovi.setActionCommand("Rimuovi Prodotto");
		bottone_Rimuovi.addActionListener(new MyListener());
		
		dati_Constraints.fill = dati_Constraints.HORIZONTAL;
		dati_Constraints.weightx = 1.0;
		dati_Constraints.weighty = 1.0;
		dati_Constraints.gridx = 0;
		dati_Constraints.gridy = 0;
		pannello_Dati.add(label_ID,dati_Constraints);
		dati_Constraints.gridx = 1;
		dati_Constraints.gridy = 0;
		pannello_Dati.add(label_IDp,dati_Constraints);
		dati_Constraints.gridx = 0;
		dati_Constraints.gridy = 1;
		pannello_Dati.add(label_Nome,dati_Constraints);
		dati_Constraints.gridx = 1;
		dati_Constraints.gridy = 1;
		pannello_Dati.add(label_Nomep,dati_Constraints);
		dati_Constraints.gridx = 0;
		dati_Constraints.gridy = 2;
		pannello_Dati.add(label_Quantita,dati_Constraints);
		dati_Constraints.gridx = 1;
		dati_Constraints.gridy = 2;
		pannello_Dati.add(text_Quantita,dati_Constraints);
		dati_Constraints.gridx = 0;
		dati_Constraints.gridy = 3;
		pannello_Dati.add(label_Fondo,dati_Constraints);
		dati_Constraints.gridx = 1;
		dati_Constraints.gridy = 3;
		pannello_Dati.add(text_Fondo,dati_Constraints);
		
		opzioni_Constraints.fill = dati_Constraints.HORIZONTAL;
		opzioni_Constraints.weightx = 1.0;
		opzioni_Constraints.weighty = 1.0;
		opzioni_Constraints.gridx = 0;
		opzioni_Constraints.gridy = 0;
		pannello_Opzioni.add(bottone_Modifica,opzioni_Constraints);
		opzioni_Constraints.gridx = 0;
		opzioni_Constraints.gridy = 1;
		pannello_Opzioni.add(bottone_Chiudi,opzioni_Constraints);
		opzioni_Constraints.gridx = 0;
		opzioni_Constraints.gridy = 2;
		pannello_Opzioni.add(bottone_Rimuovi,opzioni_Constraints);
		
		pannello_Prodotto.add(pannello_Dati);
		pannello_Prodotto.add("South",pannello_Opzioni);
		
		finestra_Prodotto.add(pannello_Prodotto);
		
		finestra_Prodotto.addWindowListener(new MyListener());
		finestra_Prodotto.setSize(300,400);
		finestra_Prodotto.setLocation(x,y);
		finestra_Prodotto.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		finestra_Prodotto.setVisible(true);
			
	}
	
	public void buttonChangeState()
	{
		this.bottone_Modifica.setText("Conferma");
		this.bottone_Modifica.setActionCommand("Conferma Prodotto");
	}
	
	public void buttonDefaultState()
	{
		this.bottone_Modifica.setText("Modifica Prodotto");
		this.bottone_Modifica.setActionCommand("Modifica Prodotto");
	}
	
	public void setModificable()
	{
		this.text_Quantita.setEditable(true);
		this.pannello_Dati.remove(text_Fondo);
		this.pannello_Dati.add(combo_Fondi, dati_Constraints, -1);
	}

}