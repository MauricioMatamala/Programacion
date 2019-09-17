package com.politecnico;
import java.util.Scanner;

public class Saludo {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.println("Indica tu nombre");

        String nombre = lector.nextLine();

        System.out.println("Hola " + nombre + " ¿Qué tal estás hoy?");
    }

}
