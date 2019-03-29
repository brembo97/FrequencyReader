package cr.ac.ulead.datos.lector;

public class UserInterface {

		public void showMenu() {
			System.out.println("Ingrese una de las siguientes opciones: ");
			System.out.println("1. Alimentar frecuencias por archivo");
			System.out.println("2. Alimentar frecuencias de todos los archivos");
			System.out.println("3. Visualizar tabla de frecuencias");
			System.out.println("4. Intentar de descifrar");
			System.out.println("5. Salir");
		}
		
		public void salir() {
			System.out.println("Ha salido exitosamente!");
		}
		
		public void opcionInvalida() {
			System.out.println("La opcion ingresada es invalida, ingrese una nueva opcion. \n");
		}
		
		public void ingresarNombre() {
			System.out.println("Ingrese el nombre del archivo que desea alimentar");
		}
		
		public void ingresarEncriptado() {
			System.out.println("Ingrese el nombre del archivo que desea desencriptar");
		}
}
