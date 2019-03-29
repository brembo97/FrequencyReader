package cr.ac.ulead.datos.lector;

public class Frecuencias {
	private char[] letras = new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',};
	private int[] frecuencias = new int[letras.length];
	private double[] porcentajes = new double[letras.length];
	
	public double[] getPorcentajes() {
		return porcentajes;
	}

	//Analiza texto y va contando la aparicion de cada letra
	public void alimentar(String str) {
		for(int i = 0; i < letras.length; i++) {
			for(int j = 0; j < str.length();j++) {
				if(letras[i] == str.toLowerCase().charAt(j)) {
					frecuencias[i]++;
				}
			}
		}
		actualizarPorcentajes();
	}
	
	//Actualiza los % de cada letra
	private void actualizarPorcentajes() {
		double suma = 0;
		for(int i = 0; i < frecuencias.length; i++) {
			suma += frecuencias[i];
		}
		for(int i = 0; i < porcentajes.length; i ++) {
			double redondeo = (Math.round((frecuencias[i]*10000)/suma))/100.0;
			porcentajes[i] = redondeo;
		}
	}
	
	//Muestra la tabla de frecuencias actuales y sus %
	public void mostrarFrecuencias() {
		for(int i = 0; i < frecuencias.length;i++) {
			System.out.println("La frecuencia de la letra " + letras[i] + " es: " + frecuencias[i] + " apariciones y un porcentaje total de " + porcentajes[i] + " %");
		}
	}
	
	//Compara % de frecuencias para desencriptar
	public String desencriptar(Frecuencias referencia, Frecuencias cesar, String letras) {
		String respuesta = letras;
		double[] porcentajesRef = referencia.getPorcentajes();
		double[] porcentajesEncrip = cesar.getPorcentajes();
		
		for(int i = 0; i < porcentajesEncrip.length;i++) {
			double minimo = 100;
			int indice = i;
			for(int j = 0; j < porcentajesRef.length;j++) {
				double dif = Math.abs((porcentajesEncrip[i] - porcentajesRef[j]));
				if(dif < minimo) {
					minimo = dif;
					indice = j;	
					System.out.println(minimo);
					System.out.println(cesar.letras[i] + " cambiado por " + referencia.letras[j]);
				}
			}
			System.out.println(respuesta);
			respuesta = respuesta.replace(cesar.letras[i], referencia.letras[indice]);
			System.out.println(respuesta);
		}
		return respuesta;
	}
	
}
