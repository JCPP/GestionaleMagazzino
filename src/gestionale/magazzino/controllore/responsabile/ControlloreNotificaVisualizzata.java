package gestionale.magazzino.controllore.responsabile;

import gestionale.magazzino.Notifica;
import gestionale.magazzino.grafica.responsabile.finestre.GraficaNotificaSelezionata;
import gestionale.magazzino.grafica.responsabile.finestre.GraficaResponsabile;

import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ControlloreNotificaVisualizzata {
	private Notifica notifica;
	private GraficaNotificaSelezionata grafica_NotSelezionata;
	
	public ControlloreNotificaVisualizzata()
	{
		grafica_NotSelezionata = new GraficaNotificaSelezionata();
		notifica = new Notifica();
	}
	public void showNotifica(GraficaResponsabile grafica_Responsabile,int x) 
	{
		grafica_Responsabile.setState(false);
		JTable tabella = grafica_Responsabile.getTableNotifiche();
		int idNotifica = (int) tabella.getValueAt(x, 0);
		notifica = new Notifica();
		notifica = gestionale.magazzino.models.Notifica.visualizzaNotifica(idNotifica);
		notifica = new Notifica(notifica.getIdNotifica(),notifica.getIdDipendente(),notifica.getIdDipendenteNotificato(),notifica.getNotifica(),notifica.getData(),true);
		grafica_NotSelezionata.init();
		grafica_NotSelezionata.setTesto(notifica.getNotifica());
		grafica_NotSelezionata.setData(notifica.getData());
		
	}
	
	public void gotoNotifiche(ControlloreNotifiche controlloreNotifiche,GraficaResponsabile grafica_Responsabile,int x)
	{
		grafica_NotSelezionata.doClose();
		controlloreNotifiche.updateNotifiche(grafica_Responsabile,0);
	}
	
	public void eliminaNotifica(GraficaResponsabile grafica_Responsabile,ControlloreNotifiche controlloreNotifiche) 
	{
		int i =JOptionPane.showConfirmDialog(grafica_NotSelezionata,"Cancellare notifica?",null,JOptionPane.YES_NO_OPTION);
		if(i == 0)
		{
			gestionale.magazzino.models.Notifica.cancellaNotifica(notifica.getIdNotifica());
			notifica = null;
			grafica_NotSelezionata.doClose();
			controlloreNotifiche.initNotifiche();
			grafica_Responsabile.updateNotifiche(controlloreNotifiche.getNotifiche());
			controlloreNotifiche.updateNotifiche(grafica_Responsabile,0);
		}
		
	}
}
