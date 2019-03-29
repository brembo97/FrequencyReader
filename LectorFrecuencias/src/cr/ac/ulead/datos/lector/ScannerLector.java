package cr.ac.ulead.datos.lector;

import java.util.Scanner;

public class ScannerLector {
	
	Scanner lector = new Scanner(System.in);
	
	public int leerOpcion() {
		int opcion = Integer.parseInt(lector.nextLine());
		return opcion;
	}
	
	public String leerNombre() {
		String opcion = lector.nextLine();
		return opcion;
	}
}
