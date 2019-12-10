import java.util.ArrayList;
import java.util.HashSet;

public class Ciudades {
    HashSet<Ciudad> ciudades;

    public Ciudades(){
        ciudades = new HashSet<>();
    }

    public void addCiudad(Ciudad ciudad){
        ciudades.add(ciudad);
    }

    @Override
    public String toString() {
        return "Ciudades{" +
                "ciudades=" + ciudades +
                '}';
    }
}
