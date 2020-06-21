package com.politecnico;

import java.util.Scanner;

public class Actividad6 {
    public static void main(String[] args) {

        Scanner lectorTeclado = new Scanner(System.in);
        int numeroVentasConsultadas;
        String vendedores[] = {"Isabel","Vicente"};
        boolean vendedoresSeleccionados[] = {false,false};
        int[][] ventas = {
                {7,7,10,6,4},
                {4,7,5,4,5}
        };

        System.out.print("¿Qué número de ventas deseas consultar? ");
        numeroVentasConsultadas = lectorTeclado.nextInt();
        for (int i = 0; i < ventas.length; i++) {
            for (int j = 0; j < ventas[i].length; j++) {
                if (ventas[i][j] == numeroVentasConsultadas) {
                    vendedoresSeleccionados[i] = true;
                }
            }
        }
        System.out.println("Los empleados que vendiero " + numeroVentasConsultadas + " son: ");
        for (int i = 0; i < vendedoresSeleccionados.length; i++) {
            if (vendedoresSeleccionados[i]) {
                System.out.println("      - " + vendedores[i]);
            }
        }

    }
}
