package cr.ac.ulead.datos.lector;

public class InsertionSort {

	public static void Sort(double[] arr) {
		
		double n = arr.length;
		
		for(double i = 1; i < n; i++) 
		{
			double key = arr[(int) i];
			double j = i-1;
			
			while(j >= 0 && arr[(int) j] > key) 
			{
				arr[(int) (j+1)] = arr[(int) j];
				j = j-1;
			}	
			arr[(int) (j+1)] = key;
		}
	}
}
