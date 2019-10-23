import java.util.Scanner;

public class MiMain {
    public static void main(String[] args) {
        Scanner lectorTeclado = new Scanner(System.in).useDelimiter("\n");
        GeneradorDatosTemperatura generadorDatos = new GeneradorDatosTemperatura();

        DiarioDeTemperaturas diario = new DiarioDeTemperaturas();
        PromedioTemperaturas promedio = new PromedioTemperaturas();
        RegistroTemperaturasCriticas criticas = new RegistroTemperaturasCriticas();

        generadorDatos.registrarConsumidor(diario);
        generadorDatos.registrarConsumidor(promedio);
        generadorDatos.registrarConsumidor(criticas);

        boolean terminar = false;
        while (!terminar){
            System.out.print("Indica la hora: ");
            int hora = lectorTeclado.nextInt();
            System.out.print("Indica la temperatura");
            double temperatura = lectorTeclado.nextDouble();
            generadorDatos.nuevaLecturaDeTemperatura(temperatura,hora);
            System.out.println("=======================================");
            System.out.println(diario);
            System.out.println(promedio);
            System.out.println(criticas);
            System.out.print("Terminar?: ");
            String cadenaTerminar = lectorTeclado.next();
            if (cadenaTerminar.equalsIgnoreCase("S"))
                terminar = true;
        }
    }
}
