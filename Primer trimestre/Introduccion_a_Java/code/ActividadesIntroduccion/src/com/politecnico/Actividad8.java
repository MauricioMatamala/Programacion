package com.politecnico;

import java.util.Scanner;

public class Actividad8 {
    public static void main(String[] args) {
        int mayorNumeroEnPiramide;
        int mayorNumeroEnFila;
        String[][] piramide;
        int celdaCentralColumnaPiramide;
        Scanner lectorTeclado = new Scanner(System.in);

        System.out.print("Indica cuál es el número más grande que aparecerá en la pirámide: ");
        mayorNumeroEnPiramide = lectorTeclado.nextInt();

        piramide = new String[mayorNumeroEnPiramide][2 * mayorNumeroEnPiramide - 1];
        celdaCentralColumnaPiramide = (2 * mayorNumeroEnPiramide) / 2 - 1;

        for (int fila = 0; fila < piramide.length; fila++) {
            for (int columna = 0; columna < piramide[fila].length; columna++) {
                piramide[fila][columna] = " ";
            }
        }

        for (int fila = 0; fila < mayorNumeroEnPiramide; fila++) {
            piramide[fila][celdaCentralColumnaPiramide] = Integer.toString(fila+1);
            for (int incremento = 1; incremento < (fila + 1); incremento++) {
                piramide[fila][celdaCentralColumnaPiramide - incremento] = Integer.toString(fila + 1 - incremento);
                piramide[fila][celdaCentralColumnaPiramide + incremento] = Integer.toString(fila + 1 - incremento);
            }
        }

        for (String[] filaPiramide : piramide) {
            for (String s : filaPiramide) {
                System.out.print(s);
            }
            System.out.println();
        }
    }
}
