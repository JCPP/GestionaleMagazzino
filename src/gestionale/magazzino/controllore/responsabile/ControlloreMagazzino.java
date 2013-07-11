package gestionale.magazzino.controllore.responsabile;

import java.util.ArrayList;

import gestionale.magazzino.MyListener;
import gestionale.magazzino.Prodotto;
import gestionale.magazzino.grafica.cancelleria.MyModel;
import gestionale.magazzino.grafica.responsabile.finestre.GraficaResponsabile;

public class ControlloreMagazzino {

	private MyModel modelloMagazzino;
	private MyListener listener;
	private ArrayList<Prodotto> prodotti;
	
	public ControlloreMagazzino()
	{
		modelloMagazzino = new MyModel();
		listener = new MyListener();
	}
	
	public void showMagazzino(GraficaResponsabile grafica_Responsabile)
	{
		grafica_Responsabile.setState(true);
		listener.setTable(grafica_Responsabile.getTableProdotti());
		grafica_Responsabile.setPannelloSelezionato("magazzino");
	}
	
	public void updateMagazzino(GraficaResponsabile grafica_Responsabile,int x)
	{
		grafica_Responsabile.setState(true);
		modelloMagazzino = (MyModel) grafica_Responsabile.getTableProdotti().getModel();
		if(modelloMagazzino.getRowCount() > 0)
		{
			modelloMagazzino.setValueAt(Boolean.FALSE, x, 4);
		}
		grafica_Responsabile.setPannelloSelezionato("magazzino");
	}
	
	public void initMagazzino()
	{
		int ID;
		String nome;
		int qta;
		float prezzo;
		prodotti = new ArrayList<gestionale.magazzino.Prodotto>();
		prodotti = gestionale.magazzino.models.Prodotto.visualizzaProdotti();
		String[] colonne = {"ID","Nome","Quantita","Prezzo","Modifica"};
		MyModel model = new MyModel(prodotti.size(),5,colonne);
		for(int i = 0;i < prodotti.size(); i++)
		{
			ID = prodotti.get(i).getId_Prodotto();
			nome = prodotti.get(i).getNome();
			qta = prodotti.get(i).getQuantità();
			prezzo = prodotti.get(i).getPrezzo();
			model.setValueAt(ID, i, 0);
			model.setValueAt(nome, i, 1);
			model.setValueAt(qta, i, 2);
			model.setValueAt(prezzo, i, 3);
			model.setValueAt(Boolean.FALSE, i, 4);
		}
		modelloMagazzino = model;
	}
	
	public MyModel getMagazzino()
	{
		return modelloMagazzino;
	}
	
	
}
