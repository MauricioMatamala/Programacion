package com.politecnico;

import java.util.Scanner;

public class Actividad8 {
    public static void main(String[] args) {
        String[][] piramide;
        Scanner lectorTeclado = new Scanner(System.in);
        int altura = -1;
        int anchura;
        int columnaCentral;

        System.out.println("¿Cuántas filas deseas que tenga tu pirámide?:");
        altura = lectorTeclado.nextInt();
        anchura = 2 * altura - 1;
        columnaCentral = altura - 1;

        piramide = new String[altura][anchura];
        for (int fila = 0; fila < altura; fila++){
            for (int columna = 0; columna < anchura; columna++)
                piramide[fila][columna] = " ";
        }

        for (int fila = 0; fila < altura; fila++ ){
            for (int incremento = 0; incremento <= fila; incremento++ ){
                piramide[fila][columnaCentral-incremento] = Integer.toString(fila + 1 - incremento);
                piramide[fila][columnaCentral+incremento] = Integer.toString(fila + 1 - incremento);
            }
        }

        for (int fila = 0; fila < altura; fila++){
            for (int columna = 0; columna < anchura; columna++){
        }

    }
}
