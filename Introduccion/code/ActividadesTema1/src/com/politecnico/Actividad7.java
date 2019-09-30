package com.politecnico;

import java.util.Scanner;

public class Actividad7 {
    public static void main(String[] args) {
        int[][] ventasPorEmpleado = {
                {7, 7, 10, 6, 4},
                {4, 7, 5, 4, 5}
        };
        double[] promedio = {0.0, 0.0};
        int maximoVendido = -1;
        int maximoVendedor = -1;

        Scanner lectorTeclado = new Scanner(System.in);
        String[] vendedores = {"Isabel","Vicente"};

        System.out.println("Promedio de ventas\n\n");

        for (int numEmp = 0; numEmp < vendedores.length ; numEmp++ ){
            for (int venta = 0; venta < ventasPorEmpleado[numEmp].length; venta++){
                promedio[numEmp] += ventasPorEmpleado[numEmp][venta];
                if (maximoVendido < ventasPorEmpleado[numEmp][venta]){
                    maximoVendido = ventasPorEmpleado[numEmp][venta];
                    maximoVendedor = numEmp;
                }
            }
            promedio[numEmp] /= ventasPorEmpleado[numEmp].length;
        }


        for ( int numEmp = 0; numEmp < vendedores.length; numEmp++ ){
            System.out.print("\n" + vendedores[numEmp] + " " + promedio[numEmp]);
            if (numEmp == maximoVendedor) System.out.println(" *");
        }

    }
}
