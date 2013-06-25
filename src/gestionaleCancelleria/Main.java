package gestionaleCancelleria;

import javax.swing.JOptionPane;

public class Main {
	private static GraficaLogin gr;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		gr = new GraficaLogin();
		Dipendente dip = new Dipendente();
		Controllore contro = new Controllore();
		/*String pass = JOptionPane.showInputDialog("Prima password");
		String pass1 = JOptionPane.showInputDialog("Seconda password");
		dip.setPassword(pass);
		dip.setPassword2(pass1);
		Controllore contro = new Controllore();
		int noError = contro.checkPassword(dip.getPassword(), dip.getPassword2());*/
		boolean err = contro.validateEmail("emmeci92@gmail.com");
		System.out.println("Il numero errore è: "+err);
	}

}
