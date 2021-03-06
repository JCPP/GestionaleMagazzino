package gestionale.magazzino.grafica.dipendente.finestre;
/**
 * Classe che crea una finestra grafica per consetire all'utente di modificare un
 * prodotto prenotato
 */
import gestionale.magazzino.Fondo;
import gestionale.magazzino.MyListener;

import javax.swing.*;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

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
	private JLabel label_Nome;
	private JLabel label_Nomep;
	private JLabel label_Quantita;
	private JTextField text_Quantita;
	private JLabel label_Fondo;
	private JTextField text_Fondo;
	private JLabel spesa;
	private JTextField text_Spesa;
	private JComboBox combo_Fondi;
	private JButton bottone_Modifica;
	private JButton bottone_Chiudi;
	private JButton bottone_Rimuovi;
	private ArrayList<Fondo> fondi;
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
		
		label_Nome = new JLabel("Nome");
		label_Nomep = new JLabel(" ");
		label_Quantita = new JLabel("Quantita :");
		text_Quantita = new JTextField(15);
		text_Quantita.setEditable(false);
		label_Fondo = new JLabel("Fondo Scelto");
		text_Fondo = new JTextField(15);
		text_Fondo.setEditable(false);
		spesa = new JLabel("Totale Spesa");
		text_Spesa = new JTextField(15);
		text_Spesa.setEditable(false);
		
		fondi = new ArrayList<Fondo>();
		fondi = gestionale.magazzino.models.Fondo.visualizzaFondi();
		combo_Fondi = new JComboBox<String>();
		int i = 0;
		while(i < fondi.size())
		{
			combo_Fondi.addItem(fondi.get(i).getNome());
			i++;
		}
		combo_Fondi.setActionCommand("Fondi");
		combo_Fondi.addActionListener(new MyListener());
		
		
		bottone_Modifica = new JButton("Modifica Prodotto");
		bottone_Modifica.setActionCommand("Modifica Ordine");
		bottone_Modifica.addActionListener(new MyListener());
		bottone_Chiudi = new JButton("Chiudi");
		bottone_Chiudi.setActionCommand("Chiudi Prodotto");
		bottone_Chiudi.addActionListener(new MyListener());
		bottone_Rimuovi = new JButton("Cancella Ordine");
		bottone_Rimuovi.setActionCommand("Rimuovi Prodotto");
		bottone_Rimuovi.addActionListener(new MyListener());
		
		dati_Constraints.fill = dati_Constraints.HORIZONTAL;
		dati_Constraints.weightx = 1;
		dati_Constraints.insets = new Insets(50,0,0,0);
		dati_Constraints.gridx = 0;
		dati_Constraints.gridy = 0;
		pannello_Dati.add(label_Nome,dati_Constraints);
		dati_Constraints.gridx = 1;
		dati_Constraints.gridy = 0;
		pannello_Dati.add(label_Nomep,dati_Constraints);
		dati_Constraints.gridx = 0;
		dati_Constraints.gridy = 1;
		pannello_Dati.add(label_Quantita,dati_Constraints);
		dati_Constraints.gridx = 1;
		dati_Constraints.gridy = 1;
		pannello_Dati.add(text_Quantita,dati_Constraints);
		dati_Constraints.gridx = 0;
		dati_Constraints.gridy = 2;
		pannello_Dati.add(spesa,dati_Constraints);
		dati_Constraints.gridx = 1;
		dati_Constraints.gridy = 2;
		pannello_Dati.add(text_Spesa,dati_Constraints);
		dati_Constraints.gridx = 0;
		dati_Constraints.gridy = 3;
		pannello_Dati.add(label_Fondo,dati_Constraints);
		dati_Constraints.gridx = 1;
		dati_Constraints.gridy = 3;
		pannello_Dati.add(text_Fondo,dati_Constraints);
		
		opzioni_Constraints.fill = GridBagConstraints.HORIZONTAL;
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
		finestra_Prodotto.setResizable(false);
		finestra_Prodotto.setVisible(true);
			
	}
	
	public void disposeF()
	{
		finestra_Prodotto.dispose();
	}
	public void buttonChangeState()
	{
		this.bottone_Modifica.setText("Conferma");
		this.bottone_Modifica.setActionCommand("Conferma Prodotto");
	}
	
	public void buttonDefaultState()
	{
		this.bottone_Modifica.setText("Modifica Prodotto");
		this.bottone_Modifica.setActionCommand("Modifica Ordine");
	}
	
	public void setModificable()
	{
		buttonChangeState();
		this.text_Quantita.setEditable(true);
		this.pannello_Dati.remove(text_Fondo);
		this.pannello_Dati.add(combo_Fondi, dati_Constraints, -1);
	}
	
	public void setQta(int q)
	{
		text_Quantita.setText(""+q);
	}
	
	public void setFondoScelto(String s)
	{
		text_Fondo.setText(s);
	}
	
	public void setNome(String n)
	{
		label_Nomep.setText(n);
	}
	
	
	public String getNome()
	{
		return label_Nomep.getText();
	}
	
	public int getQuantita()
	{
		int x = 0;
		try
		{
			x = Integer.parseInt(text_Quantita.getText());
		}catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog(this, "Quantita inserita non valida");
			return -1;
		}
		
		return x;
	}
	
	public float getSpesa()
	{
		return Float.parseFloat(text_Spesa.getText());
	}
	
	public void doClose()
	{
		finestra_Prodotto.dispatchEvent(new WindowEvent(finestra_Prodotto, WindowEvent.WINDOW_DEACTIVATED));
		finestra_Prodotto.dispatchEvent(new WindowEvent(finestra_Prodotto, WindowEvent.WINDOW_CLOSING));
		finestra_Prodotto.dispose();
	}
	
	public String getFondoScelto()
	{
		return combo_Fondi.getSelectedItem().toString();
	}
	
	public void setFondo(int n)
	{
		combo_Fondi.setSelectedIndex(n);
	}
	public void setSpesa(float s) {
		this.text_Spesa.setText(""+s);
		
	}
	
}