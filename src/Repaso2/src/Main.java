public class Main {
    private final static int MAX_EMPLEADOS = 10;
    private final static int DIAS = 5;

    private static String[] empleados;
    private static int[][] ventas;
    private static double[] promedios;
    private static int numeroEmpleados;
    private static Interfaz interfaz;

    public static void main(String[] args) {
        interfaz = new Interfaz();
        empleados = new String[MAX_EMPLEADOS];
        ventas = new int[MAX_EMPLEADOS][DIAS];
        promedios = new double[MAX_EMPLEADOS];
        numeroEmpleados = 0;

        int opcion = -1;
        while (opcion != Interfaz.TERMINAR){
            opcion = interfaz.obtenerOpción();
            switch (opcion) {
                case Interfaz.NUMERO_ITEMS_POR_EMPLEADO:
                    //interfaz.mostrarVentasEmpleados(empleados,numeroEmpleados,ventas);
                    int itemsDeInteres = interfaz.pedirItemsDeInteres();
                    mostrarItemsDeInteres(itemsDeInteres);
                    break;
                case Interfaz.PROMEDIO_VENTAS_EMPLEADO:
                    mostrarPromedioVentas();
                    break;
                case Interfaz.EMPLEADO_MAYORES_VENTAS_DIA:
                    mostrarMayorVendedor();
                    break;
                case Interfaz.INSERTAR_EMPLEADO:
                    insertarNuevoEmpleado();
                    break;
                case Interfaz.TERMINAR:
                    interfaz.despedida();
                    break;
                default:
                    interfaz.mostrarVentasEmpleados(empleados,numeroEmpleados,ventas);
            }
            System.out.println("");
            System.out.println("");
        }
    }

    private static void mostrarMayorVendedor() {
        int mayorVendedor = -1;
        int mayoresVentas = 0;
        for (int i=0; i<numeroEmpleados; i++){
            for (int j=0; j<5; j++){
                if (ventas[i][j]>mayoresVentas) {
                    mayorVendedor = i;
                    mayoresVentas = ventas[i][j];
                }

            }
        }
        interfaz.mostrarMayorVendedor(empleados[mayorVendedor],mayoresVentas);
    }

    private static void mostrarPromedioVentas() {
        for (int i=0; i<numeroEmpleados; i++){
            double promedio = 0.0;
            for (int j=0; j<5; j++)
                promedio += ventas[i][j];
            promedios[i] = promedio/5;
        }

        double maximoPromedio = Double.MIN_VALUE;
        int empleadoMaximoPromedio = -1;
        for (int i=0; i<numeroEmpleados; i++){
            System.out.println(">"+maximoPromedio+" - "+promedios[i]);
             if (maximoPromedio < promedios[i]){
                 empleadoMaximoPromedio = i;
                 maximoPromedio = promedios[i];
             }
        }
        interfaz.mostrarPromedios(empleados,numeroEmpleados,promedios,empleadoMaximoPromedio);
    }

    private static void insertarNuevoEmpleado(){
        numeroEmpleados++;
        empleados[numeroEmpleados-1] = interfaz.pedirNombreEmpleado();
        for (int i = 0; i<5; i++) {
            ventas[numeroEmpleados-1][i] = interfaz.pedirVentasDia(i);
        }
    }

    private static void mostrarItemsDeInteres(int itemsDeInteres){
        for (int i=0; i<numeroEmpleados; i++){
            boolean empleadoVendio = false;
            for (int j=0; j<5; j++){
                if (ventas[i][j] == itemsDeInteres)
                    empleadoVendio = true;
            }
            if (empleadoVendio)
                interfaz.mostrarEmpleado(empleados[i]);
        }
    }
}
