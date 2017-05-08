import java.io.*;

class Persona{
    public String nombre;
    public int edad;
    public int estatura;
    public int peso;

    public static Persona crearPersona(String nombre, int edad, int estatura, int peso){
        Persona persona = new Persona();
        persona.nombre = nombre;
        persona.edad = edad;
        persona.estatura = estatura;
        persona.peso = peso;

        return persona;
    }
    
}

public class Ejercicio2{

    // ICM: Persona -> real
    // calcula el indice de masa corporal de una persona
    // ejemplo: ICM(Persona.crearPersona("persona1", 20, 170, 74)) debe producir 25.605536
    static public double ICM(Persona persona){
        double estaturaMetros = persona.estatura/100.0;
        return persona.peso/Math.pow(estaturaMetros, 2);
    }

    // Test para ICM
    static public void ICMTest(){
        Persona persona1 = Persona.crearPersona("persona1", 20, 170, 74);
        Persona persona2 = Persona.crearPersona("persona1", 20, 180, 90);
        Persona persona3 = Persona.crearPersona("persona1", 20, 155, 50);

        assert ICM(persona1) == 74/Math.pow(1.70, 2);
        assert ICM(persona2) == 90/Math.pow(1.80, 2);
        assert ICM(persona3) == 50/Math.pow(1.55, 2);
    }

    static public void main(String[] args) throws IOException {
        ICMTest();

        String nombre = U.readLine("Nombre? ");
        int edad = U.readInt("Edad? ");
        int estatura = U.readInt("Estatura (cm)? ");
        int peso = U.readInt("Peso (kg)? ");
        Persona persona = Persona.crearPersona(nombre, edad, estatura, peso);        
        U.println(String.format("El ICM de %s es %f", persona.nombre, ICM(persona)));
    }
}