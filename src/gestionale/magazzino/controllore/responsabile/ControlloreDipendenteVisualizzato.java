package gestionale.magazzino.controllore.responsabile;

import gestionale.magazzino.Dipendente;
import gestionale.magazzino.grafica.responsabile.finestre.GraficaDipendenteSlezionato;
import gestionale.magazzino.grafica.responsabile.finestre.GraficaResponsabile;

import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ControlloreDipendenteVisualizzato {
	private GraficaDipendenteSlezionato grafica_DipSel;
	private Dipendente dipSel;
	
	public ControlloreDipendenteVisualizzato()
	{
		grafica_DipSel = new GraficaDipendenteSlezionato();
		dipSel = new Dipendente();
	}
	public void rimuoviDipendenteResp(GraficaResponsabile grafica_Responsabile,ControlloreDipendenti controlloreDipendenti) 
	{
	
		int i =JOptionPane.showConfirmDialog(grafica_DipSel,"Cancellare Dipendente?",null,JOptionPane.YES_NO_OPTION);
		if(i == 0)
		{
			gestionale.magazzino.models.Dipendente.cancellaDipendente(Integer.parseInt(grafica_DipSel.getID()));
			dipSel = null;
			grafica_DipSel.doClose();
			controlloreDipendenti.initListaDip();
			grafica_Responsabile.updateDipendenti(controlloreDipendenti.getListaDip());
			controlloreDipendenti.updateDipendenti(grafica_Responsabile,0);
		}
	}
	
	public void modificaDipendenteResp(GraficaResponsabile grafica_Responsabile,ControlloreDipendenti controlloreDipendenti) 
	{
		Dipendente dip = new Dipendente();
		int i = Integer.parseInt(grafica_DipSel.getID());
		String pass = (gestionale.magazzino.models.Dipendente.visualizzaDipendente(i).getPassword());
		gestionale.magazzino.models.Dipendente.cancellaDipendente(i);
		String t = grafica_DipSel.getTipoScelto();
		if(t.equals("res"))
		{
			t = "";
			t = "responsabile";
		}
		else
		{
			t = "";
			t = "dipendente";
		}
		dip.setTipo(t);
		gestionale.magazzino.models.Dipendente.inserisciDipendente(grafica_DipSel.getNome(), grafica_DipSel.getCognome(), pass, grafica_DipSel.getEmail(), t);
		String s = grafica_DipSel.getStatoScelto();
		if(s.equals("Attivo"))
		{
			gestionale.magazzino.models.Dipendente.attivaDipendente(grafica_DipSel.getEmail());
		}
		else
		{
			gestionale.magazzino.models.Dipendente.disattivaDipendente(grafica_DipSel.getEmail());
		}
		
		dip = null;
		grafica_DipSel.doClose();
		controlloreDipendenti.initListaDip();
		grafica_Responsabile.updateDipendenti(controlloreDipendenti.getListaDip());
		controlloreDipendenti.updateDipendenti(grafica_Responsabile,0);
	}
	
	public void showDipendente(GraficaResponsabile grafica_Responsabile,int x)
	{
		grafica_Responsabile.setState(false);
		JTable tabella = grafica_Responsabile.getTableDipendenti();
		int IdDipendente = Integer.parseInt(tabella.getValueAt(x, 0).toString());
		Dipendente dip = new Dipendente();
		dip = gestionale.magazzino.models.Dipendente.visualizzaDipendente(IdDipendente);
		dipSel = new Dipendente(dip.getIdDipendente(),dip.getNome(),dip.getCognome(),dip.getEmail(),dip.getPassword(),dip.getTipo(),dip.isActive());
		grafica_DipSel.init();
		grafica_DipSel.setId(""+dipSel.getIdDipendente());
		grafica_DipSel.setNome(""+dipSel.getNome());
		grafica_DipSel.setCognome(""+dipSel.getCognome());
		grafica_DipSel.setEmail(""+ dipSel.getEmail());
		grafica_DipSel.setTipo(""+dipSel.getTipo().substring(0, 3));
		String s;
		if(dipSel.isActive())
		{
			s = "Attivo";
		}
		else
		{
			s = "Disabilitato";
		}
		grafica_DipSel.setStato(s);
	}
	

	public void gotoDipendenti(ControlloreDipendenti controlloreDipendenti,GraficaResponsabile grafica_Responsabile)
	{
		grafica_DipSel.doClose();
		controlloreDipendenti.updateDipendenti(grafica_Responsabile,0);
	}
}
