public class Venta {
    private Persona comprador;
    private Vehiculo vehiculo;
    private int cantidad;

    public Venta(Persona comprador, Vehiculo vehiculo, int cantidad) {
        this.comprador = comprador;
        this.vehiculo = vehiculo;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "comprador=" + comprador +
                ", vehiculo=" + vehiculo +
                ", cantidad=" + cantidad +
                '}';
    }
}
