package cr.ac.ulead.datos.lector;
import java.io.*;

public class Archivos {
	File folder = new File("./textos");
	
	//Busca si el archivo existe
	public File buscar(File dir, String nombre) {
		File[] listaArchivos = dir.listFiles();
		File file;
		
		//buscar el archivo en el folder
		for(int i = 0; i < listaArchivos.length; i++) {
			if(listaArchivos[i].getName().equalsIgnoreCase(nombre)) {
				file = listaArchivos[i];
				return file;
			}
		}
		System.out.println("Ese archivo no existe...");
		return file = new File("NULO");
	}
	
	//Pasa el contenido del archivo a un String
	public String leer(File file) {
		String texto = "";
		
		if(file.getName().equals("NULO")) {
			return texto;
		}
		
		try {
			//leer el contenido de cada archivo
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			while((linea = br.readLine()) != null) {
				texto += linea;
			}
			br.close();
		}catch(IOException e) {
			System.err.format("Archivo no encontrado \n");
		}
		return texto;
	}
	
	//Leer todos los archivos disponibles
	public String[] leerTodos() {
		String temp = "";
		String[] noFunciono = new String[0];
		
		try {
		File[] listaArchivos = folder.listFiles();
		FileReader fr;
		BufferedReader br;
		String[] texto = new String[listaArchivos.length];
			
			//recorrer el array de archivos y leer su contenido
			for(int i = 0; i < listaArchivos.length;i++) {
				File file = listaArchivos[i];
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				String str;
				
				System.out.println("Leyendo del archivo " + listaArchivos[i]);
				while((str = br.readLine()) != null) {
					temp += str;
				}
			//pasar el contenido a un array de strings
			texto[i] = temp;
			temp = "";
			br.close();
			}
		return texto;
		}catch(IOException e) {
			System.err.format("Archivo no encontrado \n");
		}
		return noFunciono;
	}
	
}
