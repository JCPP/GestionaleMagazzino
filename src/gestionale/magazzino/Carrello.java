package gestionale.magazzino;

import java.util.ArrayList;

public class Carrello {
	private ArrayList<Acquisto> acquisti;
	
	public Carrello()
	{
		acquisti = new ArrayList<Acquisto>();
	}
	
	public ArrayList<Acquisto> gettCarrello()
	{
		return acquisti;
	}
	
	public void setCarrello(ArrayList<Acquisto> acq)
	{
		acquisti = acq;
	}
	
}
