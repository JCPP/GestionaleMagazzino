package gestionaleCancelleria;

import graficaCancelleria.GraficaQuantita;
import graficaCancelleria.*;

import javax.swing.JOptionPane;

public class Main {
	private static GraficaLogin gr;

	public static void main(String[] args) {
		gr = new GraficaLogin();
		Dipendente dip = new Dipendente();
		Controllore contro = new Controllore();
	}

}
