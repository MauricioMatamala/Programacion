import java.util.Scanner;

public class Seleccion {
    public static void main(String[] args) {
        double lado=0;

        int opcionElegida = 1;
        String textoOpcionElegida = "";
        Scanner lectorTeclado = new Scanner(System.in);

        while (opcionElegida!=4) {
            System.out.print( "\n=============================\n" +
                    "Elija una opción.\n" +
                    "1. Introducir un nuevo lado de cuadrado \n" +
                    "2. Calcular el perímetro del cuadrado actual\n"+
                    "3. Calcular el área del cuadrado\n"+
                    "4. Finalizar el programa" +
                    "Indica la opción[1]: ");

            if (lectorTeclado.hasNextInt())
                opcionElegida = lectorTeclado.nextInt();
            else {
                opcionElegida = -1;
                lectorTeclado.next();
            }

            System.out.println("opcionElegida = " + opcionElegida);
            if (opcionElegida == 1) {
                System.out.print("\n\nIntroduzca el valor del lado: ");
                lado = lectorTeclado.nextDouble();
                System.out.println("El lado del cuadrado actual es " + lado);
            } else if (opcionElegida == 2) {
                System.out.println("El perímetro del cuadrado actual es " + 4 * lado);
            } else if (opcionElegida == 3) {
                System.out.println("El área del cuadrado actual es " + lado * lado);
            } else if (opcionElegida == 4) {
                System.out.println("\nQue tengas un buen día");
            } else {
                System.out.println("\nNo entiendo esa opción.");
            }
        }
    }
}
