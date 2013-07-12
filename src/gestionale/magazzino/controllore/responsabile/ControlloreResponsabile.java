package gestionale.magazzino.controllore.responsabile;

import javax.swing.JTable;

import gestionale.magazzino.Dipendente;
import gestionale.magazzino.grafica.cancelleria.MyModel;
import gestionale.magazzino.grafica.responsabile.finestre.GraficaResponsabile;

public class ControlloreResponsabile {

	private ControlloreAccount controlloreAccount;
	private ControlloreDipendenti controlloreDipendenti;
	private ControlloreMagazzino controlloreMagazzino;
	private ControlloreNotifiche controlloreNotifiche;
	private GraficaResponsabile grafica_Responsabile;
	private ControlloreNotificaVisualizzata controlloreNotificaVisualizzata;
	private ControlloreDipendenteVisualizzato controlloreDipendenteVisualizzato;
	private ControlloreProdotto controlloreProdotto;
	private Dipendente dipendente;
	
	public ControlloreResponsabile()
	{
		controlloreAccount = new ControlloreAccount();
		controlloreDipendenti = new ControlloreDipendenti();
		controlloreMagazzino = new ControlloreMagazzino();
		controlloreNotifiche = new ControlloreNotifiche();
		grafica_Responsabile = new GraficaResponsabile();
		controlloreNotificaVisualizzata = new ControlloreNotificaVisualizzata();
		controlloreDipendenteVisualizzato = new ControlloreDipendenteVisualizzato();
		controlloreProdotto = new ControlloreProdotto();
		dipendente = new Dipendente();
	}
	
	public void setDipendente(Dipendente d)
	{
		this.dipendente = d;
	}
	
	public JTable getTabellaNotifiche()
	{
		return grafica_Responsabile.getTableNotifiche();
	}
	public void start()
	{
		grafica_Responsabile.init();
	}
	
	public void doLogout()
	{
		dispose();
	}
	
	public void dispose()
	{
		grafica_Responsabile.disposeF();
	}
	
	//Account
	public void showAccount()
	{
		controlloreAccount.showAccountResp(dipendente, grafica_Responsabile);
	}
	
	//Magazzino
	public MyModel getMagazzino()
	{
		return controlloreMagazzino.getMagazzino();
	}
	
	public void initMagazzino()
	{
		controlloreMagazzino.initMagazzino();
	}
	
	public void updateMagazzino(int x)
	{
		controlloreMagazzino.updateMagazzino(grafica_Responsabile, x);
	}
	
	public void showMagazzino()
	{
		controlloreMagazzino.showMagazzino(grafica_Responsabile);
	}
	
	//Inserimento Prodotto
	
	public void inserisciProdotto()
	{
		controlloreProdotto.inserisciProdotto(grafica_Responsabile, controlloreMagazzino);
	}
	
	public void gotoMagazzino(int x)
	{
		controlloreProdotto.gotoMagazzino(grafica_Responsabile, controlloreMagazzino, x);
	}
	
	public void showOption()
	{
		controlloreProdotto.showOption(grafica_Responsabile, controlloreMagazzino);
	}
	
	//Modifica Prodotto
	
	public void showModificaProdotto(int x)
	{
		controlloreProdotto.showModificaProdotto(grafica_Responsabile, x);
	}
	
	public void modificaProdottoResponsabile()
	{
		controlloreProdotto.modificaProdottoResponsabile(grafica_Responsabile, controlloreMagazzino);
	}
	
	public void rimuoviProdottoResponsabile()
	{
		controlloreProdotto.rimuoviProdottoResponsabile(grafica_Responsabile, controlloreMagazzino);
	}
	
	public void gotoMagazzino2()
	{
		controlloreProdotto.gotoMagazzino2(grafica_Responsabile, controlloreMagazzino);
	}
	//Notifiche
	
	public void showNotifiche()
	{
		controlloreNotifiche.showNotifiche(grafica_Responsabile);
	}
	
	public void initNotifiche()
	{
		controlloreNotifiche.initNotifiche();
	}
	
	public MyModel getNotifiche()
	{
		return controlloreNotifiche.getNotifiche();
	}
	
	public void updateNotifiche(int x)
	{
		controlloreNotifiche.updateNotifiche(grafica_Responsabile, x);
	}
	
	//Notifica selezionata
	
	public void showNotifica(int x) 
	{
		controlloreNotificaVisualizzata.showNotifica(grafica_Responsabile, x);
	}
	
	public void eliminaNotifica()
	{
		controlloreNotificaVisualizzata.eliminaNotifica(grafica_Responsabile, controlloreNotifiche);
	}
	
	public void gotoNotifiche(int x)
	{
		controlloreNotificaVisualizzata.gotoNotifiche(controlloreNotifiche, grafica_Responsabile, x);
	}
	
	//Lista Dipendenti
	
	public void updateDipendenti(int x)
	{
		controlloreDipendenti.updateDipendenti(grafica_Responsabile, x);
	}
	
	public MyModel getListaDip()
	{
		return controlloreDipendenti.getListaDip();
	}
	
	public void initListaDip()
	{
		controlloreDipendenti.initListaDip();
	}
	
	public void showListaDip()
	{
		controlloreDipendenti.showListaDip(grafica_Responsabile);
	}
	
	//Dipendente Selezionato
	
	public void rimuoviDipendenteResp()
	{
		controlloreDipendenteVisualizzato.rimuoviDipendenteResp(grafica_Responsabile,controlloreDipendenti);
	}
	
	public void modificaDipendenteResp()
	{
		controlloreDipendenteVisualizzato.modificaDipendenteResp(grafica_Responsabile, controlloreDipendenti);
	}
	
	public void showDipendente(int x)
	{
		controlloreDipendenteVisualizzato.showDipendente(grafica_Responsabile, x);
	}
	
	public void gotoDipendenti()
	{
		controlloreDipendenteVisualizzato.gotoDipendenti(controlloreDipendenti, grafica_Responsabile);
	}
	
	
}
