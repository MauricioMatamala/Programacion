import java.util.ArrayList;

public class Ciudad {
    String nombre;
    ArrayList<Estación> estaciones;

    public Ciudad(String nombre){
        this.nombre = nombre;
        estaciones = new ArrayList<Estación>();
    }

    public String getNombre(){
        return nombre;
    }

    public ArrayList<Estación> getEstaciones(){
        return estaciones;
    }

    public void addEstación(Estación estación){
        estaciones.add(estación);
    }

    public ArrayList<Estación> getEstacionesByTipo(int tipo){
        ArrayList<Estación> estacionesPorTipo = new ArrayList<Estación>();
        for (Estación estación: estaciones){
            System.out.println(estación);
            if (estación.getTipo() ==  tipo)
                estacionesPorTipo.add(estación);
        }
        return estacionesPorTipo;
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
                ", estaciones=" + estaciones +
                '}';
    }
}
