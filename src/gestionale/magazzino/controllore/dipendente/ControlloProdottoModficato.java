package gestionale.magazzino.controllore.dipendente;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import gestionale.magazzino.Dipendente;
import gestionale.magazzino.Fondo;
import gestionale.magazzino.Prodotto;
import gestionale.magazzino.grafica.dipendente.finestre.GraficaDipendente;
import gestionale.magazzino.grafica.dipendente.finestre.ModificaProdotto;
import gestionale.magazzino.Acquisto;

public class ControlloProdottoModficato {
	
	private Prodotto prodotto;
	private ModificaProdotto modifica_Prodotto;
	private DateFormat dateFormat;
	private Date date;
	private Dipendente dipendente;
	private Acquisto acquisto;
	
	public ControlloProdottoModficato(Dipendente dip)
	{
		modifica_Prodotto = new ModificaProdotto();
		dipendente = dip;
		dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		date = new Date();
		acquisto = new Acquisto();
	}
	
	public void showOrdinato(GraficaDipendente grafica_Dipendente,int x)
	{
		JTable tabella = grafica_Dipendente.getTableCarrello();
		int id = Integer.parseInt(tabella.getValueAt(x,0).toString());
		acquisto = gestionale.magazzino.models.Acquisto.visualizzaAcquisto(id);
		String nome = tabella.getValueAt(x,1).toString();
		int quantita = Integer.parseInt(tabella.getValueAt(x,2).toString());
		float spesa = Float.parseFloat(tabella.getValueAt(x, 3).toString());
		Fondo f = new Fondo();
		modifica_Prodotto.init();
		modifica_Prodotto.setNome(nome);
		modifica_Prodotto.setQta(quantita);
		modifica_Prodotto.setPrezzo(spesa);
		grafica_Dipendente.setState(false);
	}

	
	public void gotoCarrello(ControlloreCarrello controlloreCarrello,int x,GraficaDipendente grafica_Dipendente)
	{
		modifica_Prodotto.doClose();
		controlloreCarrello.updateCarrello(grafica_Dipendente,x);
	}
	
	public void cancellaOrdine(ControlloreCarrello controlloreCarrello,GraficaDipendente grafica_Dipendente,Dipendente dip)
	{
		String nome = modifica_Prodotto.getNome();
		
		int i = JOptionPane.showConfirmDialog(modifica_Prodotto, "Sicuro di voler eliminare il prodotto Ordinato?",null,JOptionPane.YES_NO_OPTION);
		if(i == 0)
		{
			gestionale.magazzino.models.Acquisto.cancellaAcquisto(acquisto.getIdAcquisto());
			controlloreCarrello.initCarrello(dip);
			grafica_Dipendente.updateCarrello(controlloreCarrello.getCarrrello());
			modifica_Prodotto.doClose();
		}
	}
	
	public void modifcaOrdine()
	{
		modifica_Prodotto.setModificable();
	}
	
	public void confermaOrdine()
	{
		
	}
	
}
