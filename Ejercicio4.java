class Hogar{
    public String jefe;
    public int miembros;
    public String[] nombres = new String[15];

    static public Hogar creaHogar(String jefe, int miembros, String[] nombres){
        // rellenar
        this.jefe = jefe;
        this.miembros = miembros;
        this.nombres = nombres;
    }
    
    // obtenerJefe:
    public static  String obtenerJefe(){
        return this.jefe;
    }

    // obtenerMiembros:
    public static  int obtenerMiembros(){
        return this.miembros;
    }

    // obtenerNombres:
    public static  String[] obtenerNombres(){
        return this.nombres;
    }
    
    // modificarJefe:
    public static  void modificarJefe(Hogar hogar, String jefe){
        hogar.jefe = jefe;        
    }

    // agregarMiembro:
    public static  void agregarMiembro(Hogar hogar, String nombre){
        hogar.nombres[];
        this.miembros++;
    }

    // nombresHogar:
    public static  String nombresHogar(Hogar hogar){
        return hogar.nombres.toString();
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

