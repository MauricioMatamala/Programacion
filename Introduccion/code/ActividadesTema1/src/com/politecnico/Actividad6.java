package com.politecnico;

import java.util.Scanner;

public class Actividad6 {
    //Isabel: 7, 7, 10, 6, 4 Vicente: 4, 7, 5, 4, 5
    public static void main(String[] args) {
        int[][] ventasPorEmpleado = {
                {7, 7, 10, 6, 4},
                {4, 7, 5, 4, 5}
        };
        Scanner lectorTeclado = new Scanner(System.in);
        String[] vendedores = {"Isabel","Vicente"};
        int ventasDeInteres = -1;
        boolean[] vendedoresDeInteres = {false,false};
        boolean existenVendedoresDeInteres = false;

        System.out.print("Qué número de ventas de interesa:");
        ventasDeInteres = lectorTeclado.nextInt();

        for (int numEmp = 0; numEmp < vendedores.length ; numEmp++ ){

            for (int venta = 0;
                 venta < ventasPorEmpleado[numEmp].length && !vendedoresDeInteres[numEmp];
                 venta++){

                if (ventasDeInteres == ventasPorEmpleado[numEmp][venta]){
                   vendedoresDeInteres[numEmp] = true;
                   existenVendedoresDeInteres = true;
                }
            }
        }
        if (existenVendedoresDeInteres)
            System.out.println("Los vendedores que han vendido " + ventasDeInteres + " son:");
        else
            System.out.println("Lo siento. Nadie ha vendido esa cantidad");

        for (int numEmp = 0; numEmp < vendedoresDeInteres.length; numEmp++)
            if (vendedoresDeInteres[numEmp])
                System.out.println("\t\t\t- " + vendedores[numEmp]);
    }
}
