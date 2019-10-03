package com.politecnico;

public class Cliente {
    private String nombre, apellidos, NIF, cuentaBancaria;

    public Cliente(){
        // El constructor no hace nada, porque hay que comprobar la idoneidad de
        // los datos de la persona. Esto es algo que podríamos gestionar con excepciones
        // aunque de momento no hemos visto esa tecnología.
    }

    public String getNombre() {
        // Devuelve el nombre
    }

    public boolean setNombre(String nombre) {
        // Asigna un nombre si no es vacío
        // - Devuelve true cuando el nombre no es vacío
        // - Devuelve false cuando el nombre es vacío
    }

    public String getApellidos() {
        // Devuelve los apellidos
    }

    public boolean setApellidos(String apellidos) {
        // Asigna unos apellidos si no son vacío
        // - Devuelve true cuando el apellido no es vacío
        // - Devuelve false cuando el apellido es vacío
    }

    public String getNIF() {
        // Devuelve el NIF
    }

    public boolean setNIF(String NIF) {
        // Asigna un NIF si tiene el formato correcto
        // - Devuelve true si el formato es correcto
        // - Devuelve false si el formato no es correcto
        //
        // Pista:
        // La expresión regular necesaria es la siguiente:
        // [A-Z][0-9]{8}
    }

    public String getCuentaBancaria() {
        // Devuelve la cuenta bancaria
    }

    public boolean setCuentaBancaria(String cuentaBancaria) {
        // Asigna una cuenta bancaria si tiene el formato correcto
        // - Devuelve true si el formato es válido
        // - Devuelve false si el formato no es válido
        //
        // Pista:
        // expresión regular necesaria es la siguiente:
        // ES[0-9]{22}
    }
}
