package com.politecnico;

import java.util.Scanner;

public class Actividad8Refactorizada {

    // --------------- Métodos extraídos del código original ---------------

    public static int solicitarAlturaPiramide()
    {
        Scanner lectorTeclado = new Scanner(System.in);
        System.out.print("Indica cuál es el número más grande que aparecerá en la pirámide: ");
        return lectorTeclado.nextInt();
    }

    public static String[][] crearPiramideVacia(int altura){
        int anchura = altura * 2 - 1;
        String[][] piramide = new String[altura][anchura];
        for ( int fila = 0; fila < altura; fila++ ) {
            for ( int columna = 0; columna < anchura; columna++ )
                piramide[fila][columna] = " ";
        }
        return piramide;
    }

    public static void rellenarFila(String[][] piramide, int fila){
        int celdaCentralColumnaPiramide = piramide.length - 1;
        piramide[fila][celdaCentralColumnaPiramide] = Integer.toString(fila+1);
        for (int incremento = 1; incremento <= fila; incremento++){
            piramide[fila][celdaCentralColumnaPiramide - incremento] = Integer.toString(fila + 1 - incremento);
            piramide[fila][celdaCentralColumnaPiramide + incremento] = Integer.toString( fila + 1 - incremento);
        }
    }

    private static void rellenarPiramide(String[][] piramide) {
        for (int fila = 0; fila < piramide.length; fila++) {
            rellenarFila(piramide,fila);
        }
    }

    public static void mostrarPiramide(String[][] piramide) {
        for (String[] filaPiramide : piramide) {
            for (String s : filaPiramide) {
                System.out.print(s);
            }
            System.out.println();
        }
    }

    // -------- Función main ----------

    public static void main(String[] args) {
        int alturaPiramide = solicitarAlturaPiramide();
        String[][] piramide = crearPiramideVacia(alturaPiramide);
        rellenarPiramide(piramide);
        mostrarPiramide(piramide);
    }
}
