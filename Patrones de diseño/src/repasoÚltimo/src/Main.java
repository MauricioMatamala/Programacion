import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        VehiculosXMLReader xmlReader = new VehiculosXMLReader();
        ArrayList<Vehiculo> vehiculos = xmlReader.getVehiculos();
        System.out.println(vehiculos);

        /*ClientesCSVReader csvReader = new ClientesCSVReader();
        csvReader.getClientes();*/
    }
}
