class Hogar{
    public String jefe;
    public int miembros;
    public String[] nombres = new String[15];

    //	creaHogar: String int String[] -> Hogar 
	//	Recibe un string con el nombre del jefe, un entero con la cantidad de miembros y un arreglo
    //	de String con los nombres de los miembros
    //	Efecto: asigna los valores del arreglo nombre al arreglo propio de la clase
    static public Hogar creaHogar(String jefe, int miembros, String[] nombres){
        Hogar hogar = new Hogar();
        hogar.jefe = jefe;
        hogar.miembros = miembros;
        for (int i = 0;i<nombres.length;i++){
        	hogar.nombres[i] = nombres[i];
        }
        return hogar;
    }
    
    //	obtenerJefe: Hogar -> String
	//	Recibe un Hogar y retorna el jefe asociado
    static public String obtenerJefe(Hogar hogar){
    	return hogar.jefe;
    }

    // obtenerMiembros: Hogar -> int
    //	Recibe un Hogar y retorna la cantidad de miembros 
    static public int obtenerMiembros(Hogar hogar){
    	return hogar.miembros;
    }

    // obtenerNombres: Hogar -> String[]
    //	Recibe un Hogar y retorna un arreglo con los miembros (no informa al jefe)
    static public String[] obtenerNombres(Hogar hogar){
    	return hogar.nombres;
    }
    
    // modificarJefe: Hogar String -> none
    // Efecto: Modifica el jefe del hogar en el hogar recibido
    static public void modificarJefe(Hogar hogar, String jefe){
    	hogar.jefe=jefe;
    }

    // agregarMiembro: Hogar String -> none
    // Efecto: Si la cantidad de miembros es menor a 15 agrega el nuevo miembro al
    // arreglo de miembros, luego incrementa la cantidad de miembros en 
    // la variable miembros
    static public void agregarMiembro(Hogar hogar, String miembro){
    	if (hogar.miembros < 15){
    		hogar.nombres[hogar.miembros-1]=miembro;
    		hogar.miembros++;
    	}
    }

    // nombresHogar: Hogar -> String
    // Devuelve un string con los nombres del jefe y los miembros separados por comas
    static public String nombresHogar(Hogar hogar){
    	String miembros = hogar.jefe + ",";
    	for (int i = 0; i < hogar.miembros-1;i++){
    		miembros = miembros + hogar.nombres[i] + ","; 
    	}
    	return miembros.substring(0, miembros.length()-1);
    }

}

public class Ejercicio4{
        
    static public void main(String[] args){
        // Testing del TDA, no modifique este codigo
        String jefe = "Maria";
        int miembros = 5;
        String[] nombres = new String[15];
        nombres[0] = "Pedro";
        nombres[1] = "Juan";
        nombres[2] = "Diego";
        nombres[3] = "Ana";
        Hogar hogar = Hogar.creaHogar(jefe, miembros, nombres);
        assert "Maria".equals(Hogar.obtenerJefe(hogar));
        assert Hogar.obtenerMiembros(hogar) == 5;
        String[] res = Hogar.obtenerNombres(hogar);
        for (int i = 0; i < miembros - 1; i++){
            assert res[i].equals(nombres[i]);
        }
        Hogar.modificarJefe(hogar, "Isabel");
        assert Hogar.obtenerJefe(hogar).equals("Isabel");
        assert Hogar.nombresHogar(hogar).equals("Isabel,Pedro,Juan,Diego,Ana");
        Hogar.agregarMiembro(hogar, "Luis");
        assert Hogar.obtenerMiembros(hogar) == 6;
        assert Hogar.nombresHogar(hogar).equals("Isabel,Pedro,Juan,Diego,Ana,Luis");
        nombres[3] = "Josefa";
        assert Hogar.nombresHogar(hogar).equals("Isabel,Pedro,Juan,Diego,Ana,Luis");
        // Otro hogar
        String jefe2 = "A";
        int miembros2 = 16;
        String[] nombres2 = {"B","C","D","E","F","G","H","I","J","K","L","M","N","O","P"};
        Hogar hogar2 = Hogar.creaHogar(jefe2, miembros2, nombres2);        
        assert Hogar.nombresHogar(hogar2).equals("A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P");
        Hogar.agregarMiembro(hogar2, "Q");
        assert Hogar.nombresHogar(hogar2).equals("A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P");
    }
}
