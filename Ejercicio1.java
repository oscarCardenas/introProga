public class Ejercicio1{
    
    // color2gris: num num num -> num
    // calcula la tonalidad de gris a partir de la 
    // intensidad de rojo, verde y azul
    // ejemplo: color2gris(255, 0, 0) debe producir 76
    static public int color2gris(int intensidadRojo, int intensidadVerde, int intensidadAzul){
        double tonalidadGris = (0.3 * intensidadRojo) + (0.59 * intensidadVerde) + (0.11 * intensidadAzul);
        return (int) tonalidadGris;
    }
    
    // Test para color2gris
    static public void color2grisTest(){
        assert color2gris(255, 0, 0) == 76;
        assert color2gris(0, 255, 0) == 150;
        assert color2gris(0, 0, 255) == 28;        
    }
    
    static public void main(String[] args){
        color2grisTest();
        // System.out.println(color2gris(255, 0, 0));
        // System.out.println(color2gris(0, 255, 0));
        // System.out.println(color2gris(0, 0, 255));
    }
}