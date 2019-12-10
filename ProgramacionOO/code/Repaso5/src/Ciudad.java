public class Ciudad {
    String nombre;

    public Ciudad(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    @Override
    public int hashCode() {
        return nombre.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Ciudad otraCiudad = (Ciudad) obj;
        return nombre.equals(otraCiudad.getNombre());
    }

    @Override
    public String toString() {
        return "Ciudad{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
