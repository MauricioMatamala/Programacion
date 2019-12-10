import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        // Cargar datos

        ArchivoXML archivoXML = new ArchivoXML("estaciones.xml");
        archivoXML.abrir();
        Ciudades ciudades = archivoXML.leerCiudades();
        System.out.println(ciudades);

        // Consultar las ciudades en las que hay alguna estación
        System.out.println("=====================");
        System.out.println("CIUDADES EN LAS QUE HAY ALGUNA ESTACIÓN");
        System.out.println("=====================");
        ArrayList<Ciudad> listaCiudades = ciudades.getCiudades();
        for (Ciudad ciudad: listaCiudades)
            System.out.println(ciudad.getNombre());

        // Consultar las estaciones en una ciudad
        System.out.println("=====================");
        System.out.println("ESTACIONES EN UNA CIUDAD");
        System.out.println("=====================");
        Ciudad ciudad = ciudades.getCiudadByNombre("Bilbao");
        ArrayList<Estación> estaciones = ciudad.getEstaciones();
        for (Estación estación: estaciones){
            System.out.println(estación);
        }

        // Consultar las estaciones de un cierto tipo
        System.out.println("=====================");
        System.out.println("ESTACIONES DE CIERTO TIPO");
        System.out.println("=====================");

        ArrayList<Estación> estacionesTren = ciudades.getEstacionesByTipo(Estación.ESTACIÓN_TREN);
        System.out.println(estacionesTren);

        // Consultar las estación más cercana a mi ubicación actual
        System.out.println("=====================");
        System.out.println("ESTACIÓN MÁS CERCANA");
        System.out.println("=====================");

        Ubicación miUbicación = new Ubicación(43.060017, -2.493796);
        Estación estaciónMásCercana = ciudades.getEstaciónMásCercanaA(miUbicación);
        System.out.println(estaciónMásCercana);
    }
}
