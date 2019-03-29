package cr.ac.ulead.datos.main;
import cr.ac.ulead.datos.lector.*;
import java.io.*;

public class Main {
	//private static String texto;
	private static int opcion;

	public static void main(String[] args) {
		
		Frecuencias f = new Frecuencias();
		Frecuencias e = new Frecuencias();
		UserInterface UI = new UserInterface();
		ScannerLector lector = new ScannerLector();
		Archivos archivo = new Archivos();
		File regulares = new File("./textos");
		File cesar = new File("./encriptados");
		
		do {
			UI.showMenu();
			opcion = lector.leerOpcion();
			
			switch(opcion) {
			case 1:
				UI.ingresarNombre();
				String nombre = lector.leerNombre();
				File agregar = archivo.buscar(regulares,nombre);
				System.out.println("Leyendo del archivo " + agregar.getName());
				String texto = archivo.leer(agregar);
				f.alimentar(texto);
				break;
				
			case 2:
				String[] todos = archivo.leerTodos();
				for(int i = 0; i < todos.length; i++) {
					f.alimentar(todos[i]);
				}
				break;
			
			case 3:
				f.mostrarFrecuencias();
				break;
				
			case 4:
				UI.ingresarEncriptado();
				String buscar = lector.leerNombre();
				File encontrado = archivo.buscar(cesar,buscar);
				System.out.println("Leyendo del archivo " + encontrado.getName());
				String letras = archivo.leer(encontrado).toLowerCase();
				e.alimentar(letras);
				e.mostrarFrecuencias();
				String desencriptado = f.desencriptar(f, e, letras);
				System.out.println(desencriptado);
				break;
				
			case 5:
				UI.salir();
				break;
				
			default:
				UI.opcionInvalida();
				break;
			}
		}while(opcion != 5);	
	}
}
