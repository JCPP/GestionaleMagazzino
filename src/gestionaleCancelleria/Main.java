package gestionaleCancelleria;

import graficaCancelleria.*;

import javax.swing.JOptionPane;

public class Main {
	//private static Querist query;
	private static GraficaLogin gr;
	public static void main(String[] args) {
		//query = new Querist();
		//query.inserisciFondo("ciao", 3);
		gr = new GraficaLogin();
		Dipendente dip = new Dipendente();
		Controllore contro = new Controllore();
		Querist que = new Querist();
		que.inserisciProdotto("Lettore Floppy Disk", 5, (float) 10.10);
	}

}
