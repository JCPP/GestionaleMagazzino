package gestionale.magazzino.controllore.Responsabile;

import javax.swing.JTable;

import gestionale.magazzino.Prodotto;
import gestionale.magazzino.grafica.responsabile.finestre.GraficaInsProdotto;
import gestionale.magazzino.grafica.responsabile.finestre.GraficaModificaProdotto;
import gestionale.magazzino.grafica.responsabile.finestre.GraficaResponsabile;

public class ControlloreProdotto {
	
	private GraficaInsProdotto grafica_InsProdotto;
	private GraficaModificaProdotto grafica_ModProdotto;
	private Prodotto prodotto;
	
	public ControlloreProdotto()
	{
		prodotto = new Prodotto();
		grafica_InsProdotto = new GraficaInsProdotto();
		grafica_ModProdotto = new GraficaModificaProdotto();
	}
	
	//Inserimento Prodotto
	
	public void inserisciProdotto(GraficaResponsabile grafica_Responsabile,ControlloreMagazzino controlloreMagazzino)
	{
		String nome = grafica_InsProdotto.getNome();
		int qta = grafica_InsProdotto.getQuantita();
		float prezzo = grafica_InsProdotto.getPrezzo();
		gestionale.magazzino.models.Prodotto.inserisciProdotto(nome, qta, prezzo);
		controlloreMagazzino.initMagazzino();
		grafica_Responsabile.updateMagazzino(controlloreMagazzino.getMagazzino());
		grafica_InsProdotto.doClose();
		
		
	}
	
	public void gotoMagazzino(GraficaResponsabile grafica_Responsabile,ControlloreMagazzino controlloreMagazzino,int x)
	{
		grafica_InsProdotto.disposeF();
		controlloreMagazzino.updateMagazzino(grafica_Responsabile,x);
	}
	
	public void showOption(GraficaResponsabile grafica_Responsabile,ControlloreMagazzino controlloreMagazzino)
	{
		grafica_InsProdotto.init();
		grafica_Responsabile.setState(false);
		controlloreMagazzino.updateMagazzino(grafica_Responsabile,0);
	}
	
	//Modifica Prodotto
	
	public void showModificaProdotto(GraficaResponsabile grafica_Responsabile,int x)
	{
		grafica_Responsabile.setState(false);
		JTable tabella = grafica_Responsabile.getTableProdotti();
		int id = Integer.parseInt(tabella.getValueAt(x,0).toString());
		String nome = tabella.getValueAt(x, 1).toString();
		float prezzo = Float.parseFloat(tabella.getValueAt(x,3).toString());
		int quantita = Integer.parseInt(tabella.getValueAt(x,2).toString());
		prodotto = new Prodotto(id,nome,quantita,prezzo);
		grafica_ModProdotto.init();
		grafica_ModProdotto.setNome(nome);
		grafica_ModProdotto.setQuantita(quantita);
		grafica_ModProdotto.setPrezzo(prezzo);
	}
	
	
	
	public void modificaProdottoResponsabile(GraficaResponsabile grafica_Responsabile,ControlloreMagazzino controlloreMagazzino)
	{
		gestionale.magazzino.models.Prodotto.cancellaProdotto(prodotto.getNome());
		prodotto.setNome(grafica_ModProdotto.getNome());
		prodotto.setQuantità(grafica_ModProdotto.getQuantita());
		prodotto.setPrezzo(grafica_ModProdotto.getPrezzo());
		gestionale.magazzino.models.Prodotto.inserisciProdotto(prodotto.getNome(), prodotto.getQuantità(), prodotto.getPrezzo());
		prodotto = null;
		grafica_ModProdotto.doClose();
		controlloreMagazzino.initMagazzino();
		grafica_Responsabile.updateMagazzino(controlloreMagazzino.getMagazzino());
		controlloreMagazzino.updateMagazzino(grafica_Responsabile,0);
	}
	
	public void rimuoviProdottoResponsabile(GraficaResponsabile grafica_Responsabile,ControlloreMagazzino controlloreMagazzino)
	{
		prodotto.setNome(grafica_ModProdotto.getNome());
		gestionale.magazzino.models.Prodotto.cancellaProdotto(prodotto.getNome());
		prodotto = null;
		grafica_ModProdotto.doClose();
		controlloreMagazzino.initMagazzino();
		grafica_Responsabile.updateMagazzino(controlloreMagazzino.getMagazzino());
		controlloreMagazzino.updateMagazzino(grafica_Responsabile,0);
	}
	
	public void gotoMagazzino2(GraficaResponsabile grafica_Responsabile,ControlloreMagazzino controlloreMagazzino)
	{
		grafica_ModProdotto.doClose();
		controlloreMagazzino.updateMagazzino(grafica_Responsabile,0);
	}
}
