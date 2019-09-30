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

        for (int i = 0; i < piramide.length; i++) {
            for (int j = 0; j < piramide[i].length; j++) {
                piramide[i][j] = " ";
            }
        }

        for (int fila = 0; fila < mayorNumeroEnPiramide; fila++) {
            piramide[fila][celdaCentralColumnaPiramide] = Integer.toString(fila+1);
            for (int digitoEnFila = 1; digitoEnFila < (fila + 1); digitoEnFila++) {
                piramide[fila][celdaCentralColumnaPiramide - digitoEnFila] = Integer.toString(fila + 1 - digitoEnFila);
                piramide[fila][celdaCentralColumnaPiramide + digitoEnFila] = Integer.toString(fila + 1 - digitoEnFila);
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
