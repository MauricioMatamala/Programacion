package com.politecnico;
import java.util.Scanner;
import java.util.SortedMap;

public class Factorial {
    public static void main(String[] args) {
        Scanner lectorTeclado = new Scanner(System.in);
        int numero;
        System.out.println("Di un número:");
        numero = lectorTeclado.nextInt();
        int[][] factorialesHastaN = new int[numero][2];
        int factorialDeI;
        for (int i = 0; i < factorialesHastaN.length; i++) {
            factorialesHastaN[i][0]=i+1;
            factorialDeI = 1;
            for (int j = 2; j <= i; j++) {
                factorialDeI*=j;
            }
            factorialesHastaN[i][1]=factorialDeI;
        }

        for (int[] i : factorialesHastaN) {
            System.out.print("--");
            for (int j = 0; j < Integer.toString(i[1]).length(); j++)
                System.out.print("-");
        }
        System.out.print("---------------\n");

        System.out.print("      I       ");
        for (int[] i : factorialesHastaN) {
            String espaciosAdicionales = "";
            int numEspaciosAdicionales = Integer.toString(i[1]).length() - Integer.toString(i[0]).length();
            for (int j = 0; j < numEspaciosAdicionales; j++) {
                espaciosAdicionales += " ";
            }
            System.out.print(" " + espaciosAdicionales + i[0] + " ");
        }
        System.out.println();
        for (int[] i : factorialesHastaN) {
            System.out.print("--");
            for (int j = 0; j < Integer.toString(i[1]).length(); j++)
                System.out.print("-");
        }
        System.out.print("---------------\n");

        System.out.print(" Factorial(I) ");
        for (int[] i : factorialesHastaN) {
            System.out.print(" " + i[1] + " ");
        }
        System.out.println();

        for (int[] i : factorialesHastaN) {
            System.out.print("--");
            for (int j = 0; j < Integer.toString(i[1]).length(); j++)
                System.out.print("-");
        }
        System.out.println("---------------\n");
    }
}
