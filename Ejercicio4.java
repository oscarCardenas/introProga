class Hogar{
    public String jefe;
    public int miembros;
    public String[] nombres = new String[15];

    static public Hogar creaHogar(String jefe, int miembros, String[] nombres){
        // rellenar
    	Hogar hogar = new Hogar();
    	hogar.jefe = jefe;
        hogar.miembros = miembros;
        for (int i = 0; i < nombres.length; i++) {
        	hogar.nombres[i] = nombres[i];
		}
        return hogar;
    }

    // obtenerJefe: Hogar
    // devuelve el nombre en String[] del jefe de hogar
	public static String obtenerJefe(Hogar hogar) {
		// TODO Auto-generated method stub
		return hogar.jefe;
	}

    // obtenerMiembros: Hogar -> int
	// devuelve la cantidad de miembros del hogar
	public static int obtenerMiembros(Hogar hogar) {
		// TODO Auto-generated method stub
		return hogar.miembros;
	}

    // modificarJefe: Hogar, String
	// efecto: modifica el jefe del hogar recibido
	public static void modificarJefe(Hogar hogar, String nuevoJefe) {
		// TODO Auto-generated method stub
		hogar.jefe = nuevoJefe;
	}

    // nombresHogar: Hogar
	// devuelve un String separado por comas con todos los nombres de los miembros, incluido el jefe
	public static String nombresHogar(Hogar hogar) {
		// TODO Auto-generated method stub
		String nombresSalida = hogar.jefe;
		for (int i = 0; i < hogar.miembros-1; i++) {
			nombresSalida = nombresSalida+","+hogar.nombres[i];
		}
		return nombresSalida;
	}

    // agregarMiembro: Hogar, String
	// efecto: agregar el miembro recibido al hogar recibido
	public static void agregarMiembro(Hogar hogar, String nuevoMiembro) {
		// TODO Auto-generated method stub
		if (hogar.miembros < 15){
			hogar.nombres[hogar.miembros-1] = nuevoMiembro;
			hogar.miembros ++;
		}
	}

	// obtenerNombres: Hogar -> String[]
	// devuelve el arreglo de nombres del hogar recibido
	public static String[] obtenerNombres(Hogar hogar) {
		// TODO Auto-generated method stub
		return hogar.nombres;
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

