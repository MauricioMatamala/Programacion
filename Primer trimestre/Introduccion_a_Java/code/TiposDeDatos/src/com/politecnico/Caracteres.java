package com.politecnico;

public class Caracteres {
    public static void main(String[] args) {
        char caracter= 88;      // 88 representa la letra X
        char caracter2 = 'X';

        System.out.println("El carácter " + caracter + " es igual que el carácter " + caracter2);

        char caracter3 = (char) (caracter + 1); // Dado que el tipo 'char' abarca un rango numérico, es posible
                                                // operar matemáticamente sobre él. Aunque, ¡OJO! El compilador
                                                // determinará que 'caracter + 1' es un 'int', así que hay que
                                                // degradar el resultado de la expresión a 'char'

        System.out.println("El carácter siguiente a " + caracter + " es el carácter " + caracter3);
    }
}
