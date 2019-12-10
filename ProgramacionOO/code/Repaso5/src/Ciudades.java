import java.util.ArrayList;

public class Ciudades {
    ArrayList<Ciudad> ciudades;

    public Ciudades(){
        ciudades = new ArrayList<>();
    }

    public void addCiudad(Ciudad ciudad){
        ciudades.add(ciudad);
    }

    public ArrayList<Ciudad> getCiudades(){
        return ciudades;
    }

    public ArrayList<Estación> getEstacionesByTipo(int tipo){
        ArrayList<Estación> estaciones = new ArrayList<Estación>();
        for (Ciudad ciudad: ciudades){
            ArrayList<Estación> estacionesCiudad = ciudad.getEstacionesByTipo(tipo);
            if (estacionesCiudad.size() > 0)
                estaciones.addAll(estacionesCiudad);
        }
        return estaciones;
    }

    @Override
    public String toString() {
        return "Ciudades{" +
                "ciudades=" + ciudades +
                '}';
    }

    public Estación getEstaciónMásCercanaA(Ubicación ubicación){
        Estación estaciónMásCercana = null;
        double mínimaDistancia = Double.MAX_VALUE;
        for (Ciudad ciudad: ciudades){
            ArrayList<Estación> estaciones = ciudad.getEstaciones();
            for (Estación estación: estaciones){
                double distanciaAEstación = estación.getUbicación().calcularDistancia(ubicación);
                if (distanciaAEstación<mínimaDistancia){
                    mínimaDistancia = distanciaAEstación;
                    estaciónMásCercana = estación;
                }
            }
        }
        return estaciónMásCercana;
    }

    public Ciudad getCiudadByNombre(String nombreCiudad) {
        Ciudad patrónDeBúsqueda = new Ciudad(nombreCiudad);
        int posiciónCiudad = ciudades.indexOf(patrónDeBúsqueda);
        if (posiciónCiudad > -1)
            return ciudades.get(posiciónCiudad);
        else
            return null;
    }
}
