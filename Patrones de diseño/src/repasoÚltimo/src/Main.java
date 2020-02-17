import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        VehiculosXMLReader xmlReader = new VehiculosXMLReader();
        ParqueVehiculos vehiculos = new ParqueVehiculos(xmlReader.getVehiculos());
        System.out.println(vehiculos.getVehiculos());

        ClientesCSVReader csvReader = new ClientesCSVReader();
        ArrayList<Persona> personas = csvReader.getClientes();
        System.out.println(personas);

        Persona persona1 = new Persona("Juan García");
        Vehiculo vehiculo1 = new Vehiculo("Ford","Focus",30000,"Gasolina",20000);
        Venta venta1 = new Venta(persona1,vehiculo1,4);

        Persona persona2 = new Persona("Pepe García");
        Vehiculo vehiculo2 = new Vehiculo("Seat","Ibiza",30000,"Gasolina",20000);
        Venta venta2 = new Venta(persona2,vehiculo2,3);

        Persona persona3 = new Persona("Ana Ruiz");
        Vehiculo vehiculo3 = new Vehiculo("Seat","Ibiza",30000,"Gasolina",20000);
        Venta venta3 = new Venta(persona3,vehiculo3,1);

        Ventas ventas = new Ventas();
        ventas.addVenta(venta1);
        ventas.addVenta(venta2);
        ventas.addVenta(venta3);
        System.out.println(ventas);


    }
}
