package gestionale.magazzino.controllore.responsabile;

import gestionale.magazzino.Dipendente;
import gestionale.magazzino.MyListener;
import gestionale.magazzino.Notifica;
import gestionale.magazzino.grafica.cancelleria.MyModel;
import gestionale.magazzino.grafica.responsabile.finestre.GraficaResponsabile;

import java.util.ArrayList;

public class ControlloreNotifiche {

	private MyModel modelloNotifiche;
	private MyListener listener;
	private ArrayList<Notifica> notifiche;
	
	public ControlloreNotifiche()
	{
		modelloNotifiche = new MyModel();
		listener = new MyListener();
	}
	
	public void initNotifiche()
	{
		int IdNotifica;
		int IdDipNotif;
		String data;
		notifiche = new ArrayList<Notifica>();
		notifiche = gestionale.magazzino.models.Notifica.visualizzaNotificheValide();
		String[] colonne = {"ID","Nome Dipendente","Data","Mostra"};
		MyModel model = new MyModel(notifiche.size(),4,colonne);
		Dipendente dipendente = new Dipendente();
		for(int i = 0;i < notifiche.size(); i++)
		{
			IdNotifica = notifiche.get(i).getIdNotifica();
			IdDipNotif = notifiche.get(i).getIdDipendenteNotificato();
			dipendente = gestionale.magazzino.models.Dipendente.visualizzaDipendente(IdDipNotif);
			String nome = dipendente.getEmail();
			data = notifiche.get(i).getData();
			model.setValueAt(IdNotifica, i, 0);
			model.setValueAt(nome, i, 1);
			model.setValueAt(data, i, 2);
			model.setValueAt(Boolean.FALSE, i, 3);
		}
		modelloNotifiche = model;
	}
	
	public void showNotifiche(GraficaResponsabile grafica_Responsabile)
	{
		grafica_Responsabile.setState(true);
		listener.setTable(grafica_Responsabile.getTableNotifiche());
		grafica_Responsabile.setPannelloSelezionato("notifiche");
	}
	
	public MyModel getNotifiche() {
		return modelloNotifiche;
	}
	
	public void updateNotifiche(GraficaResponsabile grafica_Responsabile,int x)
	{
		grafica_Responsabile.setState(true);
		modelloNotifiche = (MyModel) grafica_Responsabile.getTableNotifiche().getModel();
		if(modelloNotifiche.getRowCount() > 0)
		{
			modelloNotifiche.setValueAt(Boolean.FALSE, x, 3);
		}
		grafica_Responsabile.setPannelloSelezionato("notifiche");
	}
}
