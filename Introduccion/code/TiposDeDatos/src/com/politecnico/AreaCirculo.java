package com.politecnico;
import java.util.Scanner;

public class AreaCirculo {
    public static void main(String[] args) {
        Scanner lectorConsola = new Scanner(System.in);
        double areaCirculo;
        double radioCirculo;

        System.out.print("Introduce el radio del círculo en mm: ");
        radioCirculo = lectorConsola.nextDouble();
        areaCirculo = Math.pow( radioCirculo, 2 ) * Math.PI;

        System.out.println("El área del círculo es de " + areaCirculo + " mm²");
    }
}
