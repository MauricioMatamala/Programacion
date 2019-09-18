package com.politecnico;

import java.util.Scanner;

public class ManejandoArrays {
    public static void main(String[] args) {
        int diaDeLaSemanaConsultado;
        int tramoHorarioConsultado;
        Scanner lectorTeclado = new Scanner(System.in);

        String[] nombreTramoHorario = {"primera","segunda","tercera","cuarta","quinta","sexta"};

        String[][] horario = {
                {"Lunes","Lunes primera","Lunes segunda","Lunes tercera","Lunes cuarta","Lunes quinta","Lunes sexta"},
                {"Martes","Martes primera","Martes segunda","Martes tercera","Martes cuarta","Martes quinta","Martes sexta"},
                {"Miércoles","Miércoles primera","Miércoles segunda","Miércoles tercera","Miércoles cuarta","Miércoles quinta","Miércoles sexta"},
                {"Jueves","Jueves primera","Jueves segunda","Jueves tercera","Jueves cuarta","Jueves quinta","Jueves sexta"},
                {"Viernes","Viernes primera","Viernes segunda","Viernes tercera","Viernes cuarta","Viernes quinta","Viernes sexta"}
        };

        System.out.print("Indica el día que quieres consultar (1-5):");
        diaDeLaSemanaConsultado = lectorTeclado.nextInt();

        System.out.print("Indica la hora que quieres consultar (1-6):");
        tramoHorarioConsultado = lectorTeclado.nextInt();

        System.out.println("Los " + horario[diaDeLaSemanaConsultado-1][0] + " a " + nombreTramoHorario[tramoHorarioConsultado-1] +
                           " tienes clase de " + horario[diaDeLaSemanaConsultado-1][tramoHorarioConsultado]);
    }
}
