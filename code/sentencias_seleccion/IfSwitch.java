import java.util.Scanner;

public class IfSwitch {
    public static void main(String[] args) {
       Scanner lectorTeclado = new Scanner(System.in);
        int unidad, opcion;
        String nombreUnidad, parametroDeInteres;
        double cateto1, cateto2, hipotenusa, area, resultado;

        System.out.print("¿Qué unidad desea utilizar?\n" +
                "1. mm\n" +
                "2. cm\n" +
                "3. m\n" +
                "Introduzca una opción: ");
        unidad = lectorTeclado.nextInt();

        switch (unidad){
            case 1:
                nombreUnidad = "mm";
                break;
            case 2:
                nombreUnidad = "cm";
                break;
            case 3:
                nombreUnidad = "m";
                break;
            default:
                System.out.println("Las opciones válidas son [1 - 3]");
                return;
        }

        System.out.print("¿Qué operación desea realizar?\n" +
                "\n" +
                "1. Calcular la hipotenusa de un triángulo a aprtir de sus catetos.\n" +
                "2. Calcular un cateto de un triángulo a partir de el otro cateto y la hipotenusa\n" +
                "3. Calcular el área de un triángulo a partir un cateto y la hipotenusa\n" +
                "4. Caluclar el área de un triángulo a partir de dos catetos.\n" +
                "\n" +
                "Elige una opción: ");
        opcion = lectorTeclado.nextInt();

        switch(opcion){
            case 1:
                System.out.print("Introduce el cateto 1: ");
                cateto1 = lectorTeclado.nextDouble();
                System.out.print("Introduce el cateto 2: ");
                cateto2 = lectorTeclado.nextDouble();
                resultado = Math.hypot(cateto1, cateto2);
                parametroDeInteres = "la hipotenusa";
                break;
            case 2:
                System.out.print("Introduce el cateto 1: ");
                cateto1 = lectorTeclado.nextDouble();
                System.out.println("Introduce la hipotenusa: ");
                hipotenusa = lectorTeclado.nextDouble();
                resultado = Math.sqrt(Math.pow(hipotenusa,2)-Math.pow(cateto1,2));
                parametroDeInteres = "el cateto 2";
                break;
            case 3:
                System.out.print("Introduce el cateto 1: ");
                cateto1 = lectorTeclado.nextDouble();
                System.out.print("Introduce la hipotenusa: ");
                hipotenusa = lectorTeclado.nextDouble();
                cateto2 = Math.sqrt(Math.pow(hipotenusa,2)-Math.pow(cateto1,2));
                resultado = (cateto1 * cateto2) / 2;
                nombreUnidad = nombreUnidad + "^2";
                parametroDeInteres = "el area";
                break;
             case 4:
                System.out.print("Introduce el cateto 1: ");
                cateto1 = lectorTeclado.nextDouble();
                System.out.print("Introduce el cateto 2: ");
                cateto2 = lectorTeclado.nextDouble();
                resultado = (cateto1 * cateto2) / 2;
                parametroDeInteres = "el area";
                 nombreUnidad = nombreUnidad + "^2";
                break;
            default:
                System.out.println("La opción " + opcion + " es incorrecta");
                return;
        }

        System.out.printf("El valor de " + parametroDeInteres + " es %.2f %s",resultado,nombreUnidad);



        /*if (opcion == 1) {
            System.out.print("Introduce el cateto 1: ");
            cateto1 = lectorTeclado.nextDouble();
            System.out.print("Introduce el cateto 2: ");
            cateto2 = lectorTeclado.nextDouble();
            hipotenusa = Math.hypot(cateto1,cateto2);
            System.out.printf("El valor de la hipotenusa es %.2f %s",hipotenusa,nombreUnidad);
        }
        else if (opcion == 2){
            System.out.print("Introduce el cateto 1: ");
            cateto1 = lectorTeclado.nextDouble();
            System.out.println("Introduce la hipotenusa: ");
            hipotenusa = lectorTeclado.nextDouble();
            cateto2 = Math.sqrt(Math.pow(hipotenusa,2) - Math.pow(cateto1,2));
            System.out.printf("El valor del cateto es %.2f %s",cateto2,nombreUnidad);
        } else if (opcion == 3){
            System.out.print("Introduce el cateto 1: ");
            cateto1 = lectorTeclado.nextDouble();
            System.out.println("Introduce la hipotenusa: ");
            hipotenusa = lectorTeclado.nextDouble();
            cateto2 = Math.sqrt(Math.pow(hipotenusa,2)-Math.pow(cateto1,2));
            area = (cateto1 * cateto2) / 2;
            System.out.printf("El valor del area es %.2f %s",area,nombreUnidad);
        } else if (opcion == 4){
            System.out.print("Introduce el cateto 1: ");
            cateto1 = lectorTeclado.nextDouble();
            System.out.println("Introduce el cateto 2: ");
            cateto2 = lectorTeclado.nextDouble();
            area = (cateto1 * cateto2) / 2;
            System.out.printf("El valor del area es %.2f %s",area,nombreUnidad);
        }
        System.out.printf("El valor " + parametroDeInteres + " es %.2f %s",resultado,nombreUnidad);
        */
    }
}
