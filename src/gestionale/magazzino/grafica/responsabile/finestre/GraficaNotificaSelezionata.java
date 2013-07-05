package gestionale.magazzino.grafica.responsabile.finestre;

import gestionale.magazzino.MyListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class GraficaNotificaSelezionata extends JFrame {
	
	private JFrame finestra_Selezionata;
	private Dimension dimensione;
	private int x;
	private int y;
	private JPanel pannello_Dati;
	private JPanel pannello_Opzioni;
	private JTextArea text_Notifica;
	private JLabel label_Notifica;
	private JLabel label_Data;
	private JButton bottone_Indietro;
	private JButton bottone_Cancella;
	
	public GraficaNotificaSelezionata()
	{
		
	}
	
	public void init()
	{
		finestra_Selezionata = new JFrame("Notifica Selezionata");
		finestra_Selezionata.setSize(300,400);
		
		dimensione = getToolkit().getScreenSize().getSize();
		x = (int) (dimensione.getWidth() - finestra_Selezionata.getWidth())/2;
		y = (int) (dimensione.getHeight() - finestra_Selezionata.getHeight())/2;
		
		pannello_Dati = new JPanel();
		pannello_Dati.setLayout(new GridLayout(3,1));
		
		text_Notifica = new JTextArea();
		text_Notifica.setEditable(false);
		
		label_Notifica = new JLabel("Testo :");
		label_Data = new JLabel("");
		
		pannello_Opzioni = new JPanel();
		pannello_Opzioni.setLayout(new GridLayout(2,1));
		bottone_Indietro = new JButton("Indietro");
		bottone_Indietro.setActionCommand("Indietro Notifiche");
		bottone_Indietro.addActionListener(new MyListener());
		bottone_Cancella = new JButton ("Elimina");
		bottone_Cancella.setActionCommand("Elimina Notifiche");
		bottone_Cancella.addActionListener(new MyListener());
		
		pannello_Opzioni.add(bottone_Cancella);
		pannello_Opzioni.add(bottone_Indietro);
		
		pannello_Dati.add(label_Notifica);
		pannello_Dati.add(text_Notifica);
		
		finestra_Selezionata.add("North",label_Data);
		finestra_Selezionata.add("Center",pannello_Dati);
		finestra_Selezionata.add("South",pannello_Opzioni);
		finestra_Selezionata.setSize(300,400);
		finestra_Selezionata.setLocation(x,y);
		finestra_Selezionata.addWindowListener(new MyListener());
		finestra_Selezionata.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		finestra_Selezionata.setResizable(false);
		finestra_Selezionata.setVisible(true);
	}
	
	public void setTesto(String testo)
	{
		text_Notifica.append(testo);
	}
	
	public void setData(String data)
	{
		label_Data.setText(data);
	}
	
	public void doClose()
	{
		finestra_Selezionata.dispatchEvent(new WindowEvent(finestra_Selezionata, WindowEvent.WINDOW_DEACTIVATED));
		finestra_Selezionata.dispatchEvent(new WindowEvent(finestra_Selezionata, WindowEvent.WINDOW_CLOSING));
		finestra_Selezionata.dispose();
	}
	

}
