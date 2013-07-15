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
	private int quant;
	
	public ControlloProdottoModficato(Dipendente dip)
	{
		modifica_Prodotto = new ModificaProdotto();
		dipendente = dip;
		dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		date = new Date();
		acquisto = new Acquisto();
	}
	
	public void showOrdinato(GraficaDipendente grafica_Dipendente,int x,ControlloreCarrello controlloreCarrello)
	{
		JTable tabella = grafica_Dipendente.getTableCarrello();
		try
		{
		String nome = tabella.getValueAt(x,1).toString();
		int quantita = Integer.parseInt(tabella.getValueAt(x,2).toString());
		quant = quantita;
		float spesa = Float.parseFloat(tabella.getValueAt(x, 3).toString());
		Acquisto acq = new Acquisto();
		acq = controlloreCarrello.getAcquisto(nome);
		modifica_Prodotto.init();
		modifica_Prodotto.setNome(nome);
		modifica_Prodotto.setQta(quantita);
		modifica_Prodotto.setSpesa(spesa);
		modifica_Prodotto.setFondoScelto(acq.getNomeFondo());
		}catch(NumberFormatException e)
		{
			
		}
		
		grafica_Dipendente.setState(false);
	}

	
	public void gotoCarrello(ControlloreCarrello controlloreCarrello,int x,GraficaDipendente grafica_Dipendente)
	{
		modifica_Prodotto.doClose();
		controlloreCarrello.updateCarrello(grafica_Dipendente,x);
	}
	
	public void cancellaOrdine(ControlloreCarrello controlloreCarrello,GraficaDipendente grafica_Dipendente,Dipendente dip,ControlloreCatalogo controlloreCatalogo)
	{
		String nome = modifica_Prodotto.getNome();
		
		int i = JOptionPane.showConfirmDialog(modifica_Prodotto, "Sicuro di voler eliminare il prodotto Ordinato?",null,JOptionPane.YES_NO_OPTION);
		if(i == 0)
		{
			controlloreCarrello.remAcquisto(nome,controlloreCatalogo,grafica_Dipendente);
			controlloreCarrello.initCarrello();
			grafica_Dipendente.updateCarrello(controlloreCarrello.getModelCarrelo());
			modifica_Prodotto.doClose();
		}
	}
	
	public void modifcaOrdine()
	{
		modifica_Prodotto.setModificable();
	}
	
	public void confermaOrdine(ControlloreCatalogo controlloreCatalogo,ControlloreCarrello controlloreCarrello,GraficaDipendente grafica_Dipendente)
	{
		String nome = modifica_Prodotto.getNome();
		int qta = modifica_Prodotto.getQuantita();
		String fondo = modifica_Prodotto.getFondoScelto();
		if(qta > quant)
		{
			qta = -qta;
			qta += quant;
			controlloreCarrello.modOrdine(controlloreCatalogo,grafica_Dipendente,this.modifica_Prodotto,nome,-qta,quant,fondo);
		}
		else
		{
			qta -= quant;
			controlloreCarrello.modOrdine(controlloreCatalogo,grafica_Dipendente,this.modifica_Prodotto,nome,qta,quant,fondo);
		}
	}
	
}
