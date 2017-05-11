class Hogar{
    public String jefe;
    public int miembros;
    public String[] nombres = new String[15];

    static public Hogar creaHogar(String jefe, int miembros, String[] nombres){
        // rellenar
        Hogar h = new Hogar();
        h.jefe = jefe;
        h.miembros = miembros;
        for (int i = 0; i < h.miembros-1; i++) {
            h.nombres[i] = nombres[i];
        }
        return h;
    }
    
    
    // obtenerJefe:
        static public String obtenerJefe(Hogar h){
            return h.jefe;
        }

    // obtenerMiembros:
        static public int obtenerMiembros(Hogar h){
            return h.miembros;
        }

    // obtenerNombres:
        static public String[] obtenerNombres(Hogar h){
            return h.nombres;
        }

    
    // modificarJefe:
        static public void modificarJefe(Hogar h, String jefe ){
            h.jefe=jefe;
            
        }
    

    // agregarMiembro:
        static public void agregarMiembro(Hogar h, String miembro ){            
            if (h.miembros < 16) {
               h.nombres[h.miembros-1]=miembro;
               h.miembros++;
            }
        }


    // nombresHogar:
        static public String nombresHogar(Hogar h){
            String nombres = h.jefe;
            for (int i = 0; i < h.miembros - 1; i++) {
                nombres = nombres + "," + h.nombres[i];
            }
            return nombres;
        }
}

public class Ejercicio4Oscar{
        
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

