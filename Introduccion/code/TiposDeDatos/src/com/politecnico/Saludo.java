package com.politecnico;
import java.util.Scanner;

/*
    Programa destinado a
    comprender como leer un
    texto desde el teclado.

 */

public class Saludo {

    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in); // Creo un objeto de tipo Scanner.

        System.out.println("Indica tu nombre");  // Imprimo una cadena de texto.



        String nombre = lector.nextLine();

        System.out.println("Hola " + nombre + " ¿Qué tal estás hoy?");
    }

}