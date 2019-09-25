import java.util.Scanner;

public class TrabajandoConBucles {

    public static void main(String[] args) {

        int opcion;
        Scanner lectorTeclado = new Scanner(System.in);
        /*
        int maximaTemperatura = -100;
        int horaMaximaTemperatura = -1;

        do {
            System.out.print( "1. Opción 1\n" +
                                "2. Opción 2\n" +
                                "3. Salir\n" +
                                "Introduce una opción: ");
            opcion = lectorTeclado.nextInt();

            if (opcion == 1){
                System.out.println("Hacer cosas de la opción 1");
            } if (opcion == 2){
                System.out.println("Hacer cosas de la opción 2");
            } if (opcion == 3){
                System.out.println("Que tengas un buen día");
            }

        } while ( !(opcion == 3) );
        
        // ========================= Trabajando con for =========================

        int[] temperaturasDia = {21, 22, 21, 18, 17, 14,
                15, 14, 16, 19, 21, 22,
                23, 26, 29, 29, 27, 28,
                27, 25, 21, 22, 19, 20};
        System.out.println("=============================================");
        System.out.println("Primer for");
        System.out.println("=============================================");

        for (int hora = 0; hora < temperaturasDia.length; hora++) {
            if (maximaTemperatura < temperaturasDia[hora]) {
                maximaTemperatura = temperaturasDia[hora];
                horaMaximaTemperatura = hora;
            }
        }
        System.out.println("La máxima temperatura se ha dado a las " +
                horaMaximaTemperatura +
                " y ha sido de " + maximaTemperatura + "ºC");

        System.out.println("\n\n\n=============================================");
        System.out.println("Segundo for");
        System.out.println("=============================================");


        maximaTemperatura = -100;


        for (int temperatura : temperaturasDia) {
            if (maximaTemperatura < temperatura)
                maximaTemperatura = temperatura;
        }

        System.out.println("La máxima temperatura se ha dado a las " +
                horaMaximaTemperatura +
                " y ha sido de " + maximaTemperatura + "ºC");


    boolean condicion = false;
    for ( ;!condicion; ){
        if (lectorTeclado.nextInt() == 1)
            condicion = true;
    }*/

    // For sobre array multidimensional


        int[][] matriz = {
                {1,2,3,5},
                {5,12,11,9}
        };
        System.out.println(matriz.length);
        System.out.println(matriz[0].length);

        for (int fila = 0; fila < matriz.length;fila++){
            for (int columna=0;columna<matriz[fila].length;columna++){
                System.out.println("Fila " + fila +
                                   " columna " + columna +
                                   " ==> " + matriz[fila][columna]);
            }
        }

        for (int[] fila: matriz){
            for (int elemento: fila){
                System.out.println(elemento + "\n");
            }
        }
    }
}