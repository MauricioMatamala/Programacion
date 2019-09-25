import java.util.Scanner;

public class Actividad4 {

    public static void main(String[] args) {

        Scanner lectorTeclado = new Scanner(System.in);
        int opcionUnidad;
        int opcionOperacion = 1;
        double cateto1 = 0;
        double cateto2 = 0;
        double hipotenusa = 0;
        String unidad = "mm";

        System.out.print("\n========================\n" +
                "¿Qué unidad desea utilizar?\n" +
                "1. mm\n" +
                "2. cm\n" +
                "3. m\n" +
                "Introduzca una opción:");

        if (lectorTeclado.hasNextInt())
            opcionUnidad = lectorTeclado.nextInt();
        else {
            lectorTeclado.next();
            opcionUnidad = 1;
            System.out.println("Esa unidad no es válida. Se utilizarán mm.");
        }

        switch (opcionUnidad){
            case 1:
                unidad = "mm";
                break;
            case 2:
                unidad = "cm";
                break;
            case 3:
                unidad = "m";
                break;
            default:
                unidad = "mm";
        }

        System.out.print("\n\n=============================" +
                "\n¿Qué operación desea realizar?\n" +
                "\n1. Calcular la hipotenusa de un triángulo a aprtir de sus catetos." +
                "\n2. Calcular un cateto de un triángulo a partir de el otro cateto y la hipotenusa" +
                "\n3. Calcular el área de un triángulo a partir un cateto y la hipotenusa" +
                "\n4. Caluclar el área de un triángulo a partir de dos catetos." +
                "\nElige una opción:");

        if (lectorTeclado.hasNextInt()) {
            opcionOperacion = lectorTeclado.nextInt();
        } else {
            opcionOperacion = 1;
            System.out.println("Esa opción no existe. El programa termina aquí");
            return;
        }

        switch (opcionOperacion) {
            case 1:
                System.out.print("Introduce la longitud del primer cateto: ");
                cateto1 = lectorTeclado.nextDouble();
                System.out.print("Introduce la longitud del segundo cateto: ");
                cateto2 = lectorTeclado.nextDouble();
                hipotenusa = Math.sqrt(Math.pow(cateto1, 2) + Math.pow(cateto2, 2));
                System.out.println("La longitud de la hipotenusa es " + hipotenusa + " " + unidad);
                break;
            case 2:
                System.out.print("Introduce la longitud del primer cateto: ");
                cateto1 = lectorTeclado.nextDouble();
                System.out.print("Introduce la longitud de la hipotenusa: ");
                hipotenusa = lectorTeclado.nextDouble();
                cateto2 = Math.sqrt(Math.pow(hipotenusa, 2) - Math.pow(cateto1, 2));
                System.out.println("La longitud del segundo cateto es " + cateto2 + " " + unidad);
                break;
            case 3:
                System.out.print("Introduce la longitud del primer cateto: ");
                cateto1 = lectorTeclado.nextDouble();
                System.out.print("Introduce la longitud de la hipotenusa: ");
                hipotenusa = lectorTeclado.nextDouble();
                System.out.println("El área del triángulo es " + (cateto1 * hipotenusa) / 2 + " " + unidad);
                break;
            case 4:
                System.out.print("Introduce la longitud del primer cateto: ");
                cateto1 = lectorTeclado.nextDouble();
                System.out.print("Introduce la longitud del segundo cateto: ");
                cateto2 = lectorTeclado.nextDouble();
                hipotenusa = Math.sqrt(Math.pow(cateto1, 2) + Math.pow(cateto2, 2));
                System.out.println("El área del triángulo es " + (cateto1 * hipotenusa) / 2 + " " + unidad);
                break;
            default:
                System.out.println("No ha elegido una opción váida");
        }
    }

}