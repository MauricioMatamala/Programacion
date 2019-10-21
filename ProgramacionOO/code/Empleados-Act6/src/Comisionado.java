public class Comisionado extends Empleado{
    private int numeroVentas;
    private double sueldoBase;
    private double sueldoPorVenta;

    public Comisionado(String nombre, String apellidos, String DNI,
                       int numeroVentas, double sueldoBase, double sueldoPorVenta){
        super(nombre,apellidos,DNI);
        this.numeroVentas = numeroVentas;
        this.sueldoBase = sueldoBase;
        this.sueldoPorVenta = sueldoPorVenta;
    }

    @Override
    public double getSueldo() {
        return sueldoBase + (double) numeroVentas * sueldoPorVenta;
    }

    @Override
    public String getSpecificData() {
        return "\nNumero de ventas: " + numeroVentas +
                "\nSueldo base: " + sueldoBase +
                "\nSueldo por venta: " + sueldoPorVenta;
    }
}
