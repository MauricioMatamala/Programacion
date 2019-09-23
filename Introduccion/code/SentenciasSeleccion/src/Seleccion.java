import java.util.Scanner;

public class Seleccion {
    public static void main(String[] args) {
        double lado=0;

        int opcionElegida = 1;
        Scanner lectorTeclado = new Scanner(System.in);

        System.out.print( "Elija una opción.\n" +
                            "1. Introducir un nuevo lado de cuadrado \n" +
                            "2. Calcular el perímetro del cuadrado actual\n"+
                            "3. Calcular el área del cuadrado\n"+
                            "4. Finalizar el programa" +
                            "Indica la opción[1]: ");

        opcionElegida = lectorTeclado.nextInt();
        System.out.println("opcionElegida = " + opcionElegida);
        while (opcionElegida!=4) {

            if (opcionElegida == 1) {
                System.out.print("\n\nIntroduzca el valor del lado: ");
                lado = lectorTeclado.nextDouble();
                System.out.println("El lado del cuadrado actual es " + lado);
            } else if (opcionElegida == 2) {
                System.out.println("El perímetro del cuadrado actual es " + 4 * lado);
            } else if (opcionElegida == 3) {
                System.out.println("El área del cuadrado actual es " + lado * lado);
            } else {
                System.out.println("No entiendo esa opción.");
            }

            System.out.print( "Elija una opción.\n" +
                    "1. Introducir un nuevo lado de cuadrado \n" +
                    "2. Calcular el perímetro del cuadrado actual\n"+
                    "3. Calcular el área del cuadrado\n"+
                    "4. Finalizar el programa" +
                    "Indica la opción[1]: ");

            opcionElegida = lectorTeclado.nextInt();
        }
        /*
        switch (opcionElegida){
            case 1:
                System.out.print("\n\nIntroduzca el valor del lado: ");
                lado = lectorTeclado.nextDouble();
                System.out.println("El lado del cuadrado actual es " + lado);
                break;
            case 2:
                System.out.println("El perímetro del cuadrado actual es " + 4*lado);
                break;
            case 3:
                System.out.println("El área del cuadrado actual es " + lado*lado);
                break;
            default:
                System.out.println("No entiendo esa opción.");
        }*/
    }
}
