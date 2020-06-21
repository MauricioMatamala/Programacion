import java.util.Scanner;

public class MenuDosVeces {
    public static void main(String[] args) {
        double lado=0;

        int opcionElegida = 0;
        Scanner lectorTeclado = new Scanner(System.in);

        while (opcionElegida!=4) {

            System.out.print("\n================================\n" +
                            "Elija una opción.\n" +
                            "1. Introducir un nuevo lado de cuadrado \n" +
                            "2. Calcular el perímetro del cuadrado actual\n" +
                            "3. Calcular el área del cuadrado\n" +
                            "4. Finalizar el programa\n" +
                            "Indica la opción[1]: ");

            if (lectorTeclado.hasNextInt()){
                opcionElegida = lectorTeclado.nextInt();
            } else{
                opcionElegida = 0;
                lectorTeclado.next();
            }

            if (opcionElegida == 1) {
                System.out.print("\n\nIntroduzca el valor del lado: ");
                lado = lectorTeclado.nextDouble();
                System.out.println("\n\nEl lado del cuadrado actual es " + lado + "\n\n");
            } else if (opcionElegida == 2) {
                System.out.println("\n\nEl perímetro del cuadrado actual es " + 4 * lado + "\n\n");
            } else if (opcionElegida == 3) {
                System.out.println("\n\nEl área del cuadrado actual es " + lado * lado + "\n\n");
            } else if (opcionElegida == 4) {
                System.out.println("\n\nQue tengas un buen día.\n\n");
            } else {
                System.out.println("\n\nNo entiendo esa opción.\n\n");
            }
        }
    }
}
