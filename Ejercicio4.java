class Hogar{
    public String jefe;
    public int miembros;
    public String[] nombres = new String[15];

    static public Hogar creaHogar(String jefe, int miembros, String[] nombres){
        // rellenar
        Hogar hogar = new Hogar();
        hogar.jefe = jefe;
        hogar.miembros = miembros;
        for (int i = 0; i < hogar.miembros-1; i++) {
            hogar.nombres[i] = nombres[i];
        }
        return hogar;
    }
    
    
    // obtenerJefe: Hogar => String
    // efecto: devuelve un String con el valor de la variable jefe de la estructura Hogar enviada
    // ejemplo: 
    // Hogar hogar = Hogar.creaHogar('jefe', 3, ['miembro1', 'miembro2']);
    // Hogar.obtenerJefe(hogar) debe producir 'jefe'
    static public String obtenerJefe(Hogar hogar){
        return hogar.jefe;
    }

    // obtenerMiembros: Hogar => int
    // efecto: devuelve un entero con el valor de la variable miembros de la estructura Hogar enviada
    // ejemplo: 
    // Hogar hogar = Hogar.creaHogar('jefe', 3,['miembro1', 'miembro2']);
    // Hogar.obtenerMiembros(hogar) debe producir 3
    static public int obtenerMiembros(Hogar hogar){
        return hogar.miembros;
    }

    // obtenerNombres: Hogar => String[]
    // efecto: devuelve un arregleo de Strings con el valor de la variable nombres de la estructura Hogar enviada
    // ejemplo: 
    // Hogar hogar = Hogar.creaHogar('jefe', 3,['miembro1', 'miembro2']);
    // Hogar.obtenerNombres(hogar) debe producir ['miembro1', 'miembro2']
    static public String[] obtenerNombres(Hogar hogar){
        return hogar.nombres;
    }

    
    // modificarJefe: Hogar String => None
    // efecto: Muta la estructura Hogar modificando el valor de la variable jefe por el valor enviado como parametro
    // ejemplo: 
    // Hogar hogar = Hogar.creaHogar('jefe', 3,['miembro1', 'miembro2']);
    // Hogar.modificarJefe(hogar, 'jefecito') debe mutar el valor hogar.jefe a 'jefecito'
    static public void modificarJefe(Hogar hogar, String jefe ){
        hogar.jefe=jefe;
    }
    

    // agregarMiembro: Hogar String => None
    // efecto: Si la variable miembros es menor a la catidad maxima de miembros(16) muta la estructura Hogar 
    // aumentando el valor de miembros por el de miembros mas uno y añadiendo un nombre al arreglo nombres
    // caso contrario no hace nada
    // ejemplo: 
    // Hogar hogar = Hogar.creaHogar('jefe', 3,['miembro1', 'miembro2']);
    // Hogar.agregarMiembro(hogar, 'miembro3') debe mutar el valor hogar.nombres a 
    // ['miembro1', 'miembro2', 'miembro3'] y el valor de hogar.miembros a 4
    static public void agregarMiembro(Hogar hogar, String miembro ){
        int maxMiembros = 16;
        if (hogar.miembros < maxMiembros) {
           hogar.nombres[hogar.miembros-1]=miembro;
           hogar.miembros++;
        }
    }


    // nombresHogar: Hogar => String
    // efecto: devuelve un String que contiene el nombre del jefe junto con los nombres de todos los miembros del hogar separados una coma
    // ejemplo: 
    // Hogar hogar = Hogar.creaHogar('jefe', 3,['miembro1', 'miembro2']);
    // Hogar.nombresHogar(hogar) debe producir 'jefe,miembro1,miembro2'
    static public String nombresHogar(Hogar hogar){
        String nombres = hogar.jefe;
        for (int i = 0; i < hogar.miembros - 1; i++) {
            nombres = nombres + "," + hogar.nombres[i];
        }
        return nombres;
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

