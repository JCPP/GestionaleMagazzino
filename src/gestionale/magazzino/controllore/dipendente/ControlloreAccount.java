package gestionale.magazzino.controllore.dipendente;

import gestionale.magazzino.Dipendente;
import gestionale.magazzino.grafica.dipendente.finestre.GraficaDipendente;

public class ControlloreAccount{

	private static Dipendente dip;

	public ControlloreAccount()
	{
		dip = new Dipendente();
	}
	/**
	 * mostra la tabella dell'account con i dati dell'utente
	 */
	public void showAccount(Dipendente d,GraficaDipendente grafica_Dip)
	{
		
		dip = d;
		grafica_Dip.setAccount(dip.getEmail(), dip.getNome(), dip.getCognome(), dip.getTipo());
		grafica_Dip.setPannelloSelezionato("account");
	}
	
	public void dispose()
	{
		dip = null;
	}
	
	

}
