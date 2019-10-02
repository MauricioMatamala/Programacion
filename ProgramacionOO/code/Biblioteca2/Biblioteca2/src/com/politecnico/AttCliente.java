package com.politecnico;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class AttCliente {
    Scanner lectorTeclado;
    public final static int OP_NO_DEFINIDA = 0;
    public final static int OP_INTRODUCIR_LIBRO = 1;
    public final static int OP_MOSTRAR_LIBROS = 2;
    public final static int OP_TERMINAR = 3;

    public AttCliente(){
        lectorTeclado = new Scanner(System.in);
    }

    public int preguntarOpciones(){
        mostrarMenuOpciones();
        return leerRespuestaMenuOpciones();
    }

    public Libro preguntarDatosNuevoLibro(){
        mostrarMenuNuevoLibro();
        return leerNuevoLibro();
    }

    public void mostrarMenuOpciones(){
        System.out.print("Por favor, introduzca una opción:\n" +
                "1. Introducir un nuevo libro\n" +
                "2. Mostrar los libros existentes\n" +
                "3. Terminar\n" +
                "Opción: ");
    }

    public int leerRespuestaMenuOpciones(){
        return lectorTeclado.nextInt();
    }

    public void mostrarMenuNuevoLibro(){
        System.out.println("Por favor, introduzca los datos del libro:");
    }

    public Libro leerNuevoLibro(){
        System.out.print("Autor: ");
        String autor = lectorTeclado.next();
        System.out.print("Título: ");
        String titulo = lectorTeclado.next();
        System.out.print("Editorial: ");
        String editorial = lectorTeclado.next();
        System.out.print("ISBN: ");
        String isbn = lectorTeclado.next();
        System.out.print("Edicion: ");
        int edicion = lectorTeclado.nextInt();
        return new Libro(titulo,autor,editorial,edicion,isbn);
    }

    public void mostrarListadoLibros(Biblioteca biblioteca){
        System.out.println("Los libros de la biblioteca son:");
        System.out.println(biblioteca);
    }
}
