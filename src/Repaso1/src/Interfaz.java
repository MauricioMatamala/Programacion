import java.util.Scanner;

public class Interfaz {
    Scanner lectorPantalla;

    Interfaz(){
        lectorPantalla = new Scanner(System.in).useDelimiter("\n");
    }

    public int preguntarUnidad(){
        System.out.print("\n¿Qué unidad desea utilizar?\n" +
                "1. mm\n" +
                "2. cm\n" +
                "3. m\n" +
                "4. terminar\n" +
                "opción:");
        int opción = lectorPantalla.nextInt();
        switch(opción){
            case 1: return Unidades.MEDIDA_MM;
            case 2: return Unidades.MEDIDA_CM;
            case 3: return Unidades.MEDIDA_M;
            case 4: return -1;
            default: throw new UnsupportedOperationException("La opción " + opción + " no está definida");
        }
    }

    public int preguntarOperación(){
        System.out.print("\n¿Qué operación desea realizar?\n" +
                "1. Calcular la hipotenusa de un triángulo a aprtir de sus catetos.\n" +
                "2. Calcular un cateto de un triángulo a partir de el otro cateto y la hipotenusa\n" +
                "3. Calcular el área de un triángulo a partir un cateto y la hipotenusa\n" +
                "4. Caluclar el área de un triángulo a partir de dos catetos.\n" +
                "5. Terminar\n" +
                "opción:");
        int opción = lectorPantalla.nextInt();
        switch(opción){
            case 1: return Triángulo.HIPOTENUSA_BY_CATETOS;
            case 2: return Triángulo.CATETO2_BY_CATETO1_HIPOTENUSA;
            case 3: return Triángulo.AREA_BY_CATETO1_HIPOTENUSA;
            case 4: return Triángulo.AREA_BY_CATETOS;
            case 5: return -1;
            default: throw new UnsupportedOperationException("No existe esa operación");
        }
    }

    public double preguntarParámetro(String nombreParámetro){
        System.out.print("\nIntroduzca el " + nombreParámetro + ":");
        return lectorPantalla.nextDouble();
    }

    public void mostrarResultado(double resultado, int operación, int unidad) {
        String nombreUnidad = Unidades.getNombreUnidad(unidad);
        String textoResultado = "";
        switch (operación){
            case Triángulo.HIPOTENUSA_BY_CATETOS:
                textoResultado += "La hipotenusa mide " + resultado;
                break;
            case Triángulo.CATETO2_BY_CATETO1_HIPOTENUSA:
                textoResultado += "El cateto 2 mide " + resultado;
                break;
            case Triángulo.AREA_BY_CATETOS:
            case Triángulo.AREA_BY_CATETO1_HIPOTENUSA:
                textoResultado += "El área mide " + resultado;
        }
        System.out.println(textoResultado + " " + Unidades.getNombreUnidad(unidad));
    }
}
