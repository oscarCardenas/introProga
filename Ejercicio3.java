import java.io.*;

public class Ejercicio3{

    // doblarCopiando: int[] -> int[]    
    // devuelve una arreglo de enteros con todos sus valores multiplicados por dos
    // ejemplo: doblarCopiando([1,2,3,4]) debe producir [2,4,6,8]
	static public int[] doblarCopiando(int[] array) {
        int[] resultado = new int[array.length];
        for (int i = 0; i < resultado.length; i++){
            resultado[i] = array[i]*2;
        }
		return resultado;
	}
    
    // Test
    static public void doblarCopiandoTest(){
        int[] entrada = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] copiaEntrada = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] salida = {0, 2, 4, 6, 8, 10, 12, 14, 16, 18};
        int[] resultado = doblarCopiando(entrada);
        for (int i = 0; i < entrada.length; i++){
            assert resultado[i] == salida[i] && entrada[i] == copiaEntrada[i];
        }
    }
        
    // doblarMutando: int[] -> None
    // muta el arreglo enviado, haciendo que todos sus valores se multipliquen por dos
    // ejemplo: doblarMutando([1,2,3,4])
    static public void doblarMutando(int[] array) {
    	for (int i = 0; i < array.length; i++){
    		array[i] = array[i]*2;
    	}
	}
    
    // Test
    static public void doblarMutandoTest(){
        int[] entrada = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] salida = {0, 2, 4, 6, 8, 10, 12, 14, 16, 18};
        doblarMutando(entrada);
        for (int i = 0; i < entrada.length; i++){
            assert entrada[i] == salida[i];
        }
    }
    
    static public void main(String[] args) throws IOException{
        doblarCopiandoTest();
        doblarMutandoTest();
    }

}