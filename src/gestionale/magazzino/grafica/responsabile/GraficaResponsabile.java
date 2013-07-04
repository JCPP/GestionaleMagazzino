package gestionale.magazzino.grafica.responsabile;

import gestionale.magazzino.MyListener;
import gestionale.magazzino.grafica.cancelleria.GraficaAccount;
import gestionale.magazzino.grafica.cancelleria.MyModel;

import javax.swing.*;

import java.awt.*;
public class GraficaResponsabile extends JFrame{
	private GraficaNavigatoreResponsabile grafica_Navigazione;
	private GraficaMagazzino grafica_Magazzino;
	private GraficaNotifiche grafica_Notifiche;
	private GraficaListaDip grafica_ListaDip;
	private Dimension dimensione;
	private int x;
	private int y;
	private CardLayout layout_Pannello;
	private JPanel pannello_Selezionato;
	private JPanel pannello_Navigazione;
	private JFrame finestra_Responsabile;
	private GraficaAccount grafica_AccountResponsabile;
	public GraficaResponsabile()
	{
		
	}
	
	public void init()
	{
		grafica_Navigazione = new GraficaNavigatoreResponsabile();
		grafica_Navigazione.init();
		grafica_AccountResponsabile = new GraficaAccount();
		grafica_AccountResponsabile.init();
		grafica_Magazzino = new GraficaMagazzino();
		grafica_Magazzino.init();
		grafica_ListaDip = new GraficaListaDip();
		grafica_ListaDip.init();
		grafica_Notifiche = new GraficaNotifiche();
		grafica_Notifiche.init();
		pannello_Navigazione = new JPanel();
		pannello_Selezionato = new JPanel();
		
		finestra_Responsabile = new JFrame("Gestione Magazzino");
		finestra_Responsabile.setSize(600,500);
		
		dimensione = getToolkit().getScreenSize().getSize();
		x = (int) (dimensione.getWidth() - finestra_Responsabile.getWidth())/2;
		y = (int) (dimensione.getHeight() - finestra_Responsabile.getHeight())/2;
		
		layout_Pannello = new CardLayout();
		pannello_Selezionato.setLayout(layout_Pannello);
		pannello_Selezionato.add(grafica_Notifiche.getPannello(),"notifiche");
		pannello_Selezionato.add(grafica_Magazzino.getPannello(),"magazzino");
		pannello_Selezionato.add(grafica_AccountResponsabile.getPannello(),"account");
		pannello_Selezionato.add(grafica_ListaDip.getPannello(),"listaDip");
		
		layout_Pannello.show(pannello_Selezionato, pannello_Selezionato.getName());
		
		pannello_Navigazione = grafica_Navigazione.getPannello();
		finestra_Responsabile.add("North",pannello_Navigazione);
		finestra_Responsabile.add("Center",pannello_Selezionato);
		finestra_Responsabile.setSize(600,500);
		finestra_Responsabile.setLocation(x,y);
		finestra_Responsabile.setBackground(Color.white);
		finestra_Responsabile.addWindowListener(new MyListener());
		finestra_Responsabile.setVisible(true);
	}
	
	public void disposeF()
	{
		finestra_Responsabile.dispose();
	}
	public void setPannelloSelezionato(String s)
	{
		layout_Pannello.show(pannello_Selezionato, s);
	}
	
	public void setState(boolean b)
	{
		finestra_Responsabile.setEnabled(b);
	}
	
	public void setAccount(String email,String nome,String cognome,String tipo)
	{
		grafica_AccountResponsabile.setEmail(email);
		grafica_AccountResponsabile.setNome(nome);
		grafica_AccountResponsabile.setCognome(cognome);
		grafica_AccountResponsabile.setTipo(tipo);
	}
	
	public JTable getTableProdotti()
	{
		return grafica_Magazzino.getTable();
	}
	
	public void updateMagazzino(MyModel modello)
	{
		grafica_Magazzino.updateModel(modello);
	}
	
	public void updateNotifiche(MyModel modello)
	{
		grafica_Notifiche.updateModel(modello);
	}

	public void updateDipendenti(MyModel modello)
	{
		grafica_ListaDip.updateModel(modello);
	}
	
	public JTable getTableDipendenti(){
		return grafica_ListaDip.getTable();
	}
	public JTable getTableNotifiche() {
		return grafica_Notifiche.getTable();
	}
}
