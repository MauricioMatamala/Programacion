package com.politecnico;

import java.util.Date;

public class Habitacion {

    final static int SUITE = 1;
    final static int SIMPLE = 2;
    final static int DOBLE = 3;

    private Cliente cliente;
    private Date fechaEntrada;

    public Habitacion(){
    }

    public Cliente getCliente() {
        // Devuelve el cliente
    }

    public boolean setCliente(Cliente cliente) {
        // Asigna un cliente a la habitración
        // - Devuelve true si se puedo asignar el cliente
        // - Devuelve false si la habitación ya está ocupada
    }

    public Date getFechaEntrada() {
        // Devuelve la fecha de entrada. Cuando no hay fecha de entrada porque la habitación
        // no ha sido reservada, devuelve null

    }

    public void setFechaEntrada(Date fechaEntrada) {
        // Asigna una fecha de entrada
    }

    public boolean liberarHabitacion(){
        // El cliente y la fecha pasan a ser null
    }
}
