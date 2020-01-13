import java.util.Scanner;

public class Interfaz {
    public final static int NUMERO_ITEMS_POR_EMPLEADO = 1;
    public final static int PROMEDIO_VENTAS_EMPLEADO = 2;
    public final static int EMPLEADO_MAYORES_VENTAS_DIA = 3;
    public final static int INSERTAR_EMPLEADO = 4;
    public final static int TERMINAR = 5;

    public final static String[] diasSemana = {"lunes","martes","miércoles","jueves","viernes"};

    Scanner lectorTeclado;

    public Interfaz(){
        lectorTeclado = new Scanner(System.in).useDelimiter("\n");
    }

    public int obtenerOpción(){
        System.out.print("Elige una opción:\n" +
                "1. Empleados que vendiron un número de items.\n" +
                "2. Obtener el promedio de ventas de cada uno.\n" +
                "3. Averiguar quién ha conseguido el mayor número de ventas en un día\n" +
                "4. Insertar un nuevo empleado y sus ventas\n" +
                "5. Terminar\n" +
                "opción:");
        return lectorTeclado.nextInt();
    }

    public String pedirNombreEmpleado() {
        System.out.print("Por favor, indique el nombre del empleado:");
        return lectorTeclado.next();
    }

    public int pedirVentasDia(int i) {
        System.out.print("Introduce las ventas del " + diasSemana[i]+ ":" );
        return lectorTeclado.nextInt();
    }

    public void mostrarVentasEmpleados(String[] empleados, int numeroEmpleados, int[][] ventas) {
        System.out.println(numeroEmpleados);
        for (int i=0; i<numeroEmpleados; i++){
            System.out.println("Nombre del empleado: " + empleados[i]);
            for (int j=0; j<5; j++){
                System.out.println("Ventas del " + diasSemana[j] + ": " + ventas[i][j]);
            }
            System.out.println("=====================================================");
        }
    }

    public int pedirItemsDeInteres(){
        System.out.print("Indica el número de items: ");
        return lectorTeclado.nextInt();
    }

    public void mostrarEmpleado(String empleado) {
        System.out.println("- " + empleado);
    }

    public void mostrarPromedios(String[] empleados, int numeroEmpleados, double[] promedios, int empleadoMaximoPromedio) {
        System.out.println(">"+empleadoMaximoPromedio);
        for (int i=0; i<numeroEmpleados; i++){
            System.out.print("- " + empleados[i] + "\t" + promedios[i]);
            if (empleadoMaximoPromedio == i)
                System.out.println("\t*");
        }
    }

    public void mostrarMayorVendedor(String empleado, int items) {
        System.out.println(empleado + " es el vendedor de la semana con " + items + " en un día");
    }

    public void despedida() {
        System.out.println("Adiós");
    }
}
