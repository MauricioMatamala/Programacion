import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        // Cargar datos

        ArchivoXML archivoXML = new ArchivoXML("estaciones.xml");
        archivoXML.abrir();
        Ciudades ciudades = archivoXML.leerCiudades();
        System.out.println(ciudades);

        // Consultar las ciudades en las que hay alguna estación
        // Consultar las estaciones en una ciudad
        // Consultar las estaciones de un cierto tipo
        // Consultar las estación más cercana a mi ubicación actual
    }
}
