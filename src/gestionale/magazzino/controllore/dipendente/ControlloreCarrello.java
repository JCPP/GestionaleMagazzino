package gestionale.magazzino.controllore.dipendente;

import gestionale.magazzino.Acquisto;
import gestionale.magazzino.Dipendente;
import gestionale.magazzino.MyListener;
import gestionale.magazzino.Prodotto;
import gestionale.magazzino.grafica.cancelleria.MyModel;
import gestionale.magazzino.grafica.dipendente.finestre.GraficaDipendente;
import gestionale.magazzino.grafica.dipendente.finestre.ModificaProdotto;
import gestionale.magazzino.models.Fondo;

import java.util.ArrayList;

import javax.swing.JOptionPane;
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
		carrello = new ArrayList<Acquisto>();
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
	
	public MyModel getModelCarrelo()
	{
		if(modelloCarrello == null){
			System.out.println("Sembra null!");
		}
		
		return modelloCarrello;
	}
	
	public ArrayList<Acquisto> getCarrello()
	{
		return carrello;
	}
	
	public void addAcquisto(Acquisto acq)
	{
		carrello.add(acq);
	}
	
	public void remAcquisto(String n)
	{
		for(int i = 0; i < carrello.size(); i++)
		{
			if(n.equals(carrello.get(i).getNomeProdotto()))
			{
				carrello.remove(i);
			}
		}
		System.out.println(carrello.size());
	}
	
	public Acquisto getAcquisto(String n)
	{
		Acquisto acq = new Acquisto();
		if(carrello.size() > 0 )
		{
			for(int i = 0; i < carrello.size(); i++)
			{
				acq = carrello.get(i);
				if(n.equals(acq.getNomeProdotto()))
				{
					i += carrello.size();
				}
			}
		}
		
		return acq;
	}
	
	public void flusCarrello(GraficaDipendente grafica_Dipendente)
	{
		int j = JOptionPane.showConfirmDialog(grafica_Dipendente,"Si stanno per acquistare " +
												"tutti gli oggetti presenti nel carrello sicuri di" +
												"voler continuare?",null,JOptionPane.YES_NO_OPTION);
		if(j == 0)
		{
			Acquisto acq = new Acquisto();
			if(carrello.size() > 0)
			{
				for(int i = 0; i < carrello.size(); i++)
				{
					acq = carrello.get(i);
					gestionale.magazzino.models.Acquisto.inserisciAcquisto(
							acq.getIdDipendente(), acq.getIdProdotto(), acq.getIdFondo(),acq.getQta());
				}
			}
			carrello.clear();
			this.initCarrello();
			grafica_Dipendente.updateCarrello(this.getModelCarrelo());
		}
	}
	
	public void modOrdine(ControlloreCatalogo controlloreCatalogo,GraficaDipendente grafica_Dipendente,ModificaProdotto modifica_Prodotto,String n,int q,int quant,String f)
	{
		
		for(int i = 0; i < carrello.size(); i++)
		{
			if(n.equals(carrello.get(i).getNomeProdotto()))
			{
				Acquisto acq = new Acquisto();
				acq = carrello.get(i);
				Prodotto p = new Prodotto();
				p = gestionale.magazzino.models.Prodotto.visualizzaProdotto(carrello.get(i).getIdProdotto());
				gestionale.magazzino.Fondo fon = new gestionale.magazzino.Fondo();
				fon = gestionale.magazzino.models.Fondo.visualizzaFondo(f);
				gestionale.magazzino.models.Fondo.cancellaFondo(f);
				fon.setImporto(fon.getImporto() -(Math.abs(q)*p.getPrezzo()));
				gestionale.magazzino.models.Fondo.inserisciFondo(f, fon.getImporto());
				acq.setSpesa(Math.abs(q)*p.getPrezzo());
				acq.setQta(quant+q);
				acq.setIdFondo(fon.getId_Fondo());
				gestionale.magazzino.models.Prodotto.modificaQuantitaProdotto(n, -q);
				carrello.set(i, acq);
				this.initCarrello();
				controlloreCatalogo.initCatalogo();
				grafica_Dipendente.updateCarrello(this.getModelCarrelo());
				grafica_Dipendente.updateCatalogo(controlloreCatalogo.getCatalogo());
				modifica_Prodotto.doClose();
			}
		}
		
		JOptionPane.showMessageDialog(grafica_Dipendente, "Modificati attributi del prodotto");
	}
	
	public void initCarrello()
	{
		int IDP;
		int QTA;
		int IDF;
		float spesa;
		Prodotto p = new Prodotto();
		String[] colonne = {"ID","Prodotto","Quantita","Spesa","Seleziona"};
		
		if(carrello.size() > 0)
		{
			MyModel model = new MyModel(carrello.size(),5,colonne);
			for(int i = 0;i < carrello.size(); i++)
			{
				IDP = carrello.get(i).getIdProdotto();
				p = gestionale.magazzino.models.Prodotto.visualizzaProdotto(IDP);
				QTA = carrello.get(i).getQta();
				IDF = carrello.get(i).getIdFondo();
				spesa = QTA * p.getPrezzo();
				model.setValueAt(i+1, i, 0);
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



	public Boolean controlloCarrello(GraficaDipendente grafica_Dipendente) {
		boolean b = true;
		if(carrello.size() > 0)
		{
			int i = JOptionPane.showConfirmDialog(grafica_Dipendente, "Sono presenti elementi nel carrello,siete sicuri di voler chiudere il programma?",null,JOptionPane.YES_NO_OPTION);
			if(i == 1)
			{
				b = false;
			}
		}
		return b;
	}
}
