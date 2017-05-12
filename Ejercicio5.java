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
    
    // heapsort: 
    static public void heapsort(int[] array){
        ColaPrioridad cola = ColaPrioridad.creaColaPrioridad();
        for (int i=0; i < array.length ; i++ ) {
            ColaPrioridad.insertar(cola, array[i]);
        }

        for (int i=0; i < array.length ; i++ ) {
            array[i]=ColaPrioridad.extraerMinimo(cola);
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
        // Agregue los tests adicionales aqui
    }
    
    static public void main(String[] args) throws IOException{
        heapsortTest();
    }
}