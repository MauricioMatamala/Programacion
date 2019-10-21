public class Nominas {
    public static void main(String[] args) {
        Empleado[] empleados = new Empleado[3];


        empleados[0] = new Asalariado("Juan","Ramírez","A1234",
                                      1800);
        empleados[1] = new PorHoras("Pedro","González", "B1234",
                                    80,10);
        empleados[2] = new Comisionado("Manolo","Pérez","C9876",
                                       50,900,50);

        for (int i=0; i<empleados.length; i++)
            System.out.println(empleados[i]);
    }
}
