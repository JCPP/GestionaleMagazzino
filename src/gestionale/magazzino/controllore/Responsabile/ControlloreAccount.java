package gestionale.magazzino.controllore.Responsabile;

import gestionale.magazzino.Dipendente;
import gestionale.magazzino.grafica.responsabile.finestre.GraficaResponsabile;

public class ControlloreAccount {

	private Dipendente dip;
	
	public ControlloreAccount()
	{
		dip = new Dipendente();
	}
	
	public void showAccountResp(Dipendente d,GraficaResponsabile grafica_Resp)
	{
		dip = d;
		grafica_Resp.setAccount(dip.getEmail(),dip.getNome(),dip.getCognome(),dip.getTipo());
		grafica_Resp.setPannelloSelezionato("account");
	}
}
