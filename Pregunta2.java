public class Pregunta2{

	// diferenciaSimetrica: int[] int[] => int[]
	// efecto: retorna un arreglo con las diferencias que existe entre los arreglos enviados como parametros
	// ejemplo: diferenciaSimetrica([1,4,2],[2,7,8]) debe producir [1,4,7,8]
	public static int[] diferenciaSimetrica(int[] arr1, int[] arr2){
		
		int diferencias1 = cantidadDiferencias(arr1, arr2);
		int diferencias2 = cantidadDiferencias(arr2, arr1);		

		int[] resultado1 = obtenerElementosDiferentes(arr1,arr2);
		int[] resultado2 = obtenerElementosDiferentes(arr2,arr1);

		int [] resultado = new int[diferencias1+diferencias2];

		for (int i=0;i<diferencias1;i++) {
			resultado[i] = resultado1[i];
		}

		for (int i=0;i<diferencias2;i++) {
			resultado[diferencias1+i] = resultado2[i];
		}

		return resultado;
	}

	// cantidadDiferencias: int[] int[] => int
	// efecto: retorna un cantidad de diferencias que existe entre los arreglos enviados como parametros
	// ejemplo: diferenciaSimetrica([1,4,2],[2,7,8]) debe producir 4
	public static int cantidadDiferencias(int[] arr1, int[] arr2){		
		int contador=0;
		for( int i =0; i<arr1.length; i++){
			int elemento=arr1[i];
			if(!contieneElemento(elemento, arr2)){				
				contador++;
			}
		}
		return contador;
	}

	// obtenerElementosDiferentes: int[] int[] => int[]
	// efecto: retorna un arreglo con las diferencias que existe entre el primer arreglo enviado contra el segundo
	// ejemplo: diferenciaSimetrica([1,4,2],[2,7,8]) debe producir [1,4]
	public static int[] obtenerElementosDiferentes(int[] arr1, int[] arr2){	
		int[] resultado = new int[arr1.length];
		int contador=0;
		for( int i =0; i<arr1.length; i++){
			int elemento=arr1[i];			
			if(!contieneElemento(elemento, arr2)){
				resultado[contador]=elemento;
				contador++;
			}
		}
		return resultado;
	}

	// contieneElemento: int int[] => boolean
	// efecto: verifica si el arreglo contiene el elemento enviado
	// ejemplo: diferenciaSimetrica(2,[2,7,8]) debe producir true
	public static boolean contieneElemento(int elemento, int[] arr){
		boolean contiene=false;
		for( int i=0; i<arr.length; i++){
			if(arr[i]==elemento){
				contiene=true;
				break;
			}
		}
		return contiene;
	}



	public static void diferenciaSimetricaTest(){
		int[] arr1 = {1,4};
		int[] arr2 = {1,4,3};
		int[] resEsperado1 = {3};
		int[] res1=diferenciaSimetrica(arr1,arr2);

		for(int i=0;i<res1.length;i++){			
			assert res1[i]==resEsperado1[i];
		}

		int[] arr3 = {1,4,3};
		int[] arr4 = {1,4};
		int[] resEsperado2 = {3};
		int[] res2=diferenciaSimetrica(arr3,arr4);

		for(int i=0;i<res2.length;i++){			
			assert res2[i]==resEsperado2[i];
		}

		int[] arr5 = {1,4,3};
		int[] arr6 = {5,6};
		int[] resEsperado3 = {1,4,3,5,6};
		int[] res3=diferenciaSimetrica(arr5,arr6);

		for(int i=0;i<res3.length;i++){
			assert res3[i]==resEsperado3[i];
		}
	}

	public static void main(String[] args){
		diferenciaSimetricaTest();
	}
}