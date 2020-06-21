package com.politecnico;

import java.util.Scanner;

/*
    En este ejercicio comprobamos el uso de números enteros.
    Debido a la limitación del tipo "long", podremos obtener valores
    correctos para un máximo de 355839970 días. A partir de ahí,
    los valores se salen del rango del tipo "long".
 */

public class VelocidadLuz {

    public static void main(String[] args) {
        Scanner lectorConsola = new Scanner(System.in);
        int velocidadLuz = 300000;
        long dias;
        long distancia;

        System.out.print("Por favor, introduce el número de días: ");
        dias = lectorConsola.nextLong();
        distancia = velocidadLuz * dias * 24 * 60 * 60;  // Se produce un casting automático.

        /*
            Un casting automático se produce cuando tipos compatibles (aunque diferentes) son
            transformados para que una expresión se pueda resolver.
            En la expresión anterior:
                - la variable "velocidadLuz" es tratada como de tipo "long"
                - los números 24, 60 y 60 son tratados como tipo "long"

            Dado que el tipo destino ("long") tiene un rango de valores mayor que el tipo origen ("int")
            los tipos son compatibles, lo que permite el "casting" automático.
         */

        System.out.println("La luz recorrerá un total de " + distancia +
                " kilómetros en " + dias +  " dias.");

    }
}
