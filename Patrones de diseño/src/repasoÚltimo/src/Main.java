import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        VehiculosXMLReader xmlReader = new VehiculosXMLReader();
        ParqueVehiculos vehiculos = new ParqueVehiculos(xmlReader.getStockVehiculos());
        System.out.println(vehiculos.getStockVehiculos());

        ClientesCSVReader csvReader = new ClientesCSVReader();
        ArrayList<Persona> personas = csvReader.getClientes();
        System.out.println(personas);

        /*

        // Crear una clase llamada "Venta" que mantenga información sobre una persona y un vendedor, así como la cantidad de vehículos. Realizar una venta y mostrarla por pantalla.
        Persona persona1 = new Persona("Juan García");
        Vehiculo vehiculo1 = new Vehiculo("Ford","Focus",30000,"Gasolina",20000);
        Venta venta1 = new Venta(persona1,vehiculo1,4);

        Persona persona2 = new Persona("Pepe García");
        Vehiculo vehiculo2 = new Vehiculo("Seat","Ibiza",30000,"Gasolina",20000);
        Venta venta2 = new Venta(persona2,vehiculo2,3);

        Persona persona3 = new Persona("Ana Ruiz");
        Vehiculo vehiculo3 = new Vehiculo("Seat","Ibiza",30000,"Gasolina",20000);
        Venta venta3 = new Venta(persona3,vehiculo3,1);

        // Escribir código para almacenar varias ventas, y mostrarlas por pantalla. Las ventas estarán gestionadas por una clase llamada "Ventas".

        Ventas ventas = new Ventas();
        ventas.addVenta(venta1);
        ventas.addVenta(venta2);
        ventas.addVenta(venta3);
        System.out.println(ventas);

        // Escribir el código necesario para obtener las ventas realizadas a una persona.

        ArrayList<Venta> ventasDeAna = ventas.getVentasByComprador("Ana Ruiz");
        System.out.println(ventasDeAna);

        */

        // Recorrer las ventas y actualizar la cantidad disponible de cada vehículo según las ventas realizadas.

        // - Primero vamos a hacer algunas ventas:
        Concesionario concesionario = new Concesionario(vehiculos,new Ventas(),personas);
        concesionario.crearVenta(concesionario.getCompradorByNombre("Juan Pérez García"),concesionario.getVehiculoByMarcaYModelo("Alfa-Romeo","Giulietta 1.4TB Sport 120CV"),2);
        concesionario.crearVenta(concesionario.getCompradorByNombre("Ana Rodríguez Córdoba"),concesionario.getVehiculoByMarcaYModelo("Audi","A1 1.0 TFSI Sportback 95CV"),2);
        System.out.println(concesionario.getVentas());
        // - Ahora vamos mostrar cómo han descendido las unidades en stock.
        System.out.println(concesionario.getParqueVehiculos().getStockVehiculos());

        // Os dejo la interfaz para vosotros
    }
}
