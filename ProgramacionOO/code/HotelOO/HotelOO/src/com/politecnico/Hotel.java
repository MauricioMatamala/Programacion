package com.politecnico;

public class Hotel {
    Habitacion[] habitaciones;

    public Hotel(int numeroPlantas, int numeroHabitaciones){
        // Crea el array habitaciones.
    }

    void reservarHabitacion(Habitacion habitacion, Cliente cliente){
        // Se le pasa una Habitacion y se le asigna el cliente.
    }

    Habitacion buscarHabitacionDisponible(int tipoDeHabitacion){
        // se le pasa un número que representa el tipo de habitación:
        // Habitacion.SUITE
        // Habitacion.SIMPLE
        // Habitacion.DOBLE
        // Devuelve la habitación o null si no existe
    }

    String visualizarHotel(){
        // Devuelve una cadena de texto con un resumen del estado de ocupación
        // del hotel. La cadena devuelta podría ser algo como esto:
        //
        // ====================================
        // Habitación 101 (Suite)
        // ------------------------------------
        // Ocupada por María Antúnez, con DNI 5555555D
        // ====================================
        // Habitación 102 (Doble)
        // ------------------------------------
        // No está ocupada
        // ====================================
        // ....
    }

    int buscarHabitacionPorCliente(Cliente cliente){
        // Devuelve el número de habitacion
        // o -1 en caso de que no esté alojado.
    }

    Factura liberarHabitacion(int numeroHabitacion, int diasOcupada){
        // Se pasa un número de habitación.
        // La habitación pasa a estar desocupada y el cliente
        // Se devuelve una factura por los días que ha estado ocupada
        // o bien null si no está ocupada.
    }
}
