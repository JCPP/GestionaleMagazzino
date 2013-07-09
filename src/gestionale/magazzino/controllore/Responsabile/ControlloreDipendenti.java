package gestionale.magazzino.controllore.Responsabile;

import java.util.ArrayList;

import gestionale.magazzino.Dipendente;
import gestionale.magazzino.MyListener;
import gestionale.magazzino.grafica.cancelleria.MyModel;
import gestionale.magazzino.grafica.responsabile.finestre.GraficaResponsabile;

public class ControlloreDipendenti {

	private MyModel modelloDipendenti;
	private MyListener listener;
	private ArrayList<Dipendente> dipendenti;
	
	public ControlloreDipendenti()
	{
		modelloDipendenti = new MyModel();
		listener = new MyListener();
	}
	public void updateDipendenti(GraficaResponsabile grafica_Responsabile,int x)
	{
		grafica_Responsabile.setState(true);
		modelloDipendenti = (MyModel) grafica_Responsabile.getTableDipendenti().getModel();
		if(modelloDipendenti.getRowCount() > 0)
		{
			modelloDipendenti.setValueAt(Boolean.FALSE, x, 4);
		}
		grafica_Responsabile.setPannelloSelezionato("listaDip");
	}
	
	public MyModel getListaDip()
	{
		return modelloDipendenti;
	}
	
	public void initListaDip() {
		int idDipendente;
		String tipo;
		String email;
		boolean isActive;
		dipendenti = new ArrayList<gestionale.magazzino.Dipendente>();
		dipendenti = gestionale.magazzino.models.Dipendente.visualizzaDipendenti();
		String[] colonne = {"ID","Tipo","Email","Stato","Seleziona"};
		MyModel model = new MyModel(dipendenti.size(),5,colonne);
		for(int i = 0;i < dipendenti.size(); i++)
		{
			idDipendente = dipendenti.get(i).getIdDipendente();
			tipo = dipendenti.get(i).getTipo();
			email = dipendenti.get(i).getEmail();
			isActive = dipendenti.get(i).isActive();
			model.setValueAt(idDipendente, i, 0);
			model.setValueAt(""+tipo, i, 1);
			model.setValueAt(email, i, 2);
			model.setValueAt(isActive, i, 3);
			model.setValueAt(Boolean.FALSE, i, 4);
		}
		
		modelloDipendenti = model;
	}
	
	public void showListaDip(GraficaResponsabile grafica_Responsabile)
	{
		grafica_Responsabile.setState(true);
		listener.setTable(grafica_Responsabile.getTableDipendenti());
		grafica_Responsabile.setPannelloSelezionato("listaDip");
	}
}
