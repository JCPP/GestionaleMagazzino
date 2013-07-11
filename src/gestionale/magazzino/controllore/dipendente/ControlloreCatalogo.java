package gestionale.magazzino.controllore.dipendente;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import gestionale.magazzino.MyListener;
import gestionale.magazzino.Prodotto;
import gestionale.magazzino.grafica.cancelleria.MyModel;
import gestionale.magazzino.grafica.dipendente.finestre.GraficaDipendente;

public class ControlloreCatalogo{
	
	//private GraficaDipendente grafica_Dipendente;
	private MyListener listener;
	private MyModel modelloCatalogo;
	private ArrayList<Prodotto> prodotti;
	
	public ControlloreCatalogo()
	{
		listener = new MyListener();
		modelloCatalogo = new MyModel();
	}
	
	/**
	 * riabilita la finestra dipendente in caso fosse stata disabilitata
	 * mostra la tabella del catalogo
	 */
	public void showCatalogo(GraficaDipendente grafica_Dipendente)
	{
		grafica_Dipendente.setState(true);
		listener.setTable(grafica_Dipendente.getTableProdotti());
		grafica_Dipendente.setPannelloSelezionato("prodotti");
	}
	

	/**
	 * inizializza il catalogo prendendo i dati dal database e caricandoni in un modelloCatalogo astratto per una tabella
	 */
	public void initCatalogo()
	{
		int ID;
		String nome;
		int qta;
		float prezzo;
		prodotti = new ArrayList<gestionale.magazzino.Prodotto>();
		prodotti = gestionale.magazzino.models.Prodotto.visualizzaProdotti();
		String[] colonne = {"ID","nome","quantita","prezzo","acquista"};
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
		modelloCatalogo = model;
	}
	
	/**
	 * reinizializza la finestra del catalogo 
	 */
	public void updateCatalogo(GraficaDipendente grafica_Dipendente,int x)
	{
		grafica_Dipendente.setState(true);
		modelloCatalogo = (MyModel) grafica_Dipendente.getTableProdotti().getModel();
		if(modelloCatalogo.getRowCount() > 0)
		{
			modelloCatalogo.setValueAt(Boolean.FALSE, x, 4);
		}
		grafica_Dipendente.setPannelloSelezionato("prodotti");
	}
	
	public MyModel getCatalogo()
	{
		return modelloCatalogo;
	}
	
	public void dispose()
	{
		listener = null;
		modelloCatalogo = null;
		prodotti = null;
	}
}
