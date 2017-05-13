// Implementacion de TDA ColaPrioridad de Prioridad
// valores de la ColaPrioridad de Prioridad son enteros
// Esta cola sirve para extraer el minimo (Min-Heap)

import java.io.*;

class ColaPrioridad{
    public int[] arreglo;
    public final int maxSize = 100;
    public int ultimo;
    
    static public ColaPrioridad creaColaPrioridad(){
        ColaPrioridad cola = new ColaPrioridad();
        cola.arreglo = new int[cola.maxSize];
        cola.ultimo = 0;
        return cola;
    }
    
    // insertar: ColaPrioridad int -> None
    // efecto: inserta valor en la cola de prioridad
    // manteniendo la propiedad de heap
    static public void insertar(ColaPrioridad cola, int valor){
        if (full(cola)){
            throw new RuntimeException("Cola de Prioridad llena!");
        }
        cola.ultimo = cola.ultimo + 1;
        cola.arreglo[cola.ultimo] = valor;
        int j = cola.ultimo;
        while (j > 1){
            if (cola.arreglo[j] < cola.arreglo[j/2]){
                int tmp = cola.arreglo[j];
                cola.arreglo[j] = cola.arreglo[j/2];
                cola.arreglo[j/2] = tmp;
            }
            j = j/2;
        }
    }
    
    // extraerMinimo: ColaPrioridad -> str
    // devuelve el valor con maxima prioridad
    // efecto: saca de la cola el valor con maxima prioridad
    // manteniendo la propiedad de heap
    static public int extraerMinimo(ColaPrioridad cola){
        if (empty(cola)){
            throw new RuntimeException("ColaPrioridad vacia!");
        }
        int minimo = cola.arreglo[1];
        cola.arreglo[1] = cola.arreglo[cola.ultimo];
        cola.ultimo = cola.ultimo - 1;
        int j = 1;
        while (2 * j <= cola.ultimo){            
            int k = 2 * j;
            if ((k + 1 <= cola.ultimo) && (cola.arreglo[k + 1] < cola.arreglo[k])){
                k = k + 1;
            }
            if (cola.arreglo[j] < cola.arreglo[k]){
                break;
            }
            int tmp = cola.arreglo[j];
            cola.arreglo[j] = cola.arreglo[k];
            cola.arreglo[k] = tmp;
            j = k;
        }
        return minimo;
    }
    
    // reset: ColaPrioridad -> none
    // efecto: deja vacia la cola
    static public void reset(ColaPrioridad cola){
        cola.arreglo = new int[cola.maxSize];
        cola.ultimo = 0;
    }
    
    // empty: ColaPrioridad -> bool
    // devuelve true si la cola esta vacia
    static public boolean empty(ColaPrioridad cola){
        return cola.ultimo == 0;
    }
    
    // full: ColaPrioridad -> bool
    // devuelve true si la cola esta llena
    static public boolean full(ColaPrioridad cola){
        return cola.ultimo == cola.maxSize - 1;
    }
}

public class Ejercicio5{
    
    // heapsort: int[] => None
    // efecto: ordena de manera ascendente el arreglo enviado como parametro 
    // ejemplo: heapsort([2, 3, 1]) muta a [1, 2, 3] 
    static public void heapsort(int[] arreglo){
        ColaPrioridad cola = ColaPrioridad.creaColaPrioridad();
        for (int i=0; i < arreglo.length ; i++ ) {
            ColaPrioridad.insertar(cola, arreglo[i]);
        }

        int indice = 0;
        sort(arreglo, cola, indice);        
    }

    // sort: int[] ColaPrioridad int => None
    // efecto: ordena de manera ascendente el arreglo enviado como parametro a partir de una cola de priorirdad
    // ejemplo: heapsort([2, 3, 1], ColaPrioridad, 0) muta a [1, 2, 3] 
    static public void sort(int[] arreglo, ColaPrioridad cola, int indice){
    	if(!ColaPrioridad.empty(cola)) {
    		int minimo = ColaPrioridad.extraerMinimo(cola);
    		arreglo[indice] = minimo;
    		indice++;
    		sort(arreglo, cola, indice);
    	}
    }
    
    // Test
    static public void heapsortTest(){        
        int[] arr1 = {44, 86, 40, 68, 71, 17, 54, 56, 60, 73, 46, 66, 49, 49, 71, 18, 29, 96, 99, 98};
        int[] arr1Ordenado = {17, 18, 29, 40, 44, 46, 49, 49, 54, 56, 60, 66, 68, 71, 71, 73, 86, 96, 98, 99};
        heapsort(arr1);
        for (int i = 0; i < arr1.length; i = i + 1){
            assert arr1[i] == arr1Ordenado[i];
        }
        
        int[] arr2 = {5, 3, 1, 0, -1, 9, 8};
        int[] arr2Ordenado = {-1, 0, 1, 3, 5, 8, 9};
        heapsort(arr2);
        for (int i = 0; i < arr2.length; i = i + 1){
            assert arr2[i] == arr2Ordenado[i];
        }

        int[] arr3 = {20, -20, -50, 290, 30, 1, 0};
        int[] arr3Ordenado = {-50, -20, 0, 1, 20, 30, 290};
        heapsort(arr3);
        for (int i = 0; i < arr3.length; i = i + 1){
            assert arr3[i] == arr3Ordenado[i];
        }

    }
    
    static public void main(String[] args) throws IOException{
        heapsortTest();
    }
}