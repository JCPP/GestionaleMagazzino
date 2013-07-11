package gestionale.magazzino.controllore.dipendente;

import gestionale.magazzino.Acquisto;
import gestionale.magazzino.Dipendente;
import gestionale.magazzino.MyListener;
import gestionale.magazzino.Prodotto;
import gestionale.magazzino.grafica.cancelleria.MyModel;
import gestionale.magazzino.grafica.dipendente.finestre.GraficaDipendente;
import gestionale.magazzino.models.Fondo;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ControlloreCarrello{

	private MyModel modelloCarrello;
	private MyListener listener;
	private ArrayList<Acquisto> carrello;
	private Dipendente dipendente;
	
	public ControlloreCarrello()
	{
		dipendente = new Dipendente();
		modelloCarrello = new MyModel();
		listener = new MyListener();
	}
	
	
	
	public void dispose()
	{
		modelloCarrello = null;
		listener = null;
		carrello = null;
	}
	
	public void setDipendente(Dipendente dip)
	{
		this.dipendente = dip;
	}
	
	/**
	 * riabilita la finestra dipendente in caso fosse stata disabilitata
	 * mostra la tabella del carrello
	 */
	public void showCarrello(GraficaDipendente grafica_Dipendente)
	{
		grafica_Dipendente.setState(true);
		listener.setTable(grafica_Dipendente.getTableCarrello());
		grafica_Dipendente.setPannelloSelezionato("carrello");
	}
	
	/**
	 * reinizializza la finestra del carrello (da ottimizzare)
	 */
	public void updateCarrello(GraficaDipendente grafica_Dipendente,int x)
	{
		grafica_Dipendente.setState(true);
		modelloCarrello = (MyModel) grafica_Dipendente.getTableCarrello().getModel();
		if(modelloCarrello.getRowCount() > 0)
		{
			modelloCarrello.setValueAt(Boolean.FALSE, x, 4);
		}
		grafica_Dipendente.setPannelloSelezionato("carrello");
	}
	
	public MyModel getCarrrello()
	{
		if(modelloCarrello == null){
			System.out.println("Sembra null!");
		}
		
		return modelloCarrello;
	}
	
	public void initCarrello(Dipendente dip)
	{
		int IDA;
		int IDP;
		int QTA;
		int IDF;
		String fondo;
		float spesa;
		Prodotto p = new Prodotto();
		Fondo f = new Fondo();
		carrello = new ArrayList<Acquisto>();
		System.out.println(dip.getIdDipendente());
		System.out.println(dip.getNome());
		carrello = gestionale.magazzino.models.Acquisto.visualizzaAcquistiDaDipendente(dip.getIdDipendente());
		String[] colonne = {"ID","Prodotto","Quantita","Spesa","Seleziona"};
		
		if(carrello.size() > 0)
		{
			MyModel model = new MyModel(carrello.size(),5,colonne);
			for(int i = 0;i < carrello.size(); i++)
			{
				IDA = carrello.get(i).getIdAcquisto();
				IDP = carrello.get(i).getIdProdotto();
				p = gestionale.magazzino.models.Prodotto.visualizzaProdotto(IDP);
				QTA = carrello.get(i).getQta();
				IDF = carrello.get(i).getIdFondo();
				spesa = QTA * p.getPrezzo();
				model.setValueAt(IDA, i, 0);
				model.setValueAt(p.getNome(), i, 1);
				model.setValueAt(QTA, i, 2);
				model.setValueAt(spesa, i, 3);
				model.setValueAt(Boolean.FALSE, i, 4);
				modelloCarrello = model;
			}
		}
		else
		{
			MyModel model = new MyModel(1,5,colonne);
			model.setValueAt(" ", 0, 0);
			model.setValueAt(" ", 0, 1);
			model.setValueAt(" ", 0, 2);
			model.setValueAt(" ", 0, 3);
			model.setValueAt(" ", 0, 4);
			modelloCarrello = model;
		}
		
	}
}
