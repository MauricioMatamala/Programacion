public class Venta {
    private Persona comprador;
    private Vehiculo vehiculo;
    private int unidades;

    public Venta(Persona comprador, Vehiculo vehiculo, int cantidad) {
        this.comprador = comprador;
        this.vehiculo = vehiculo;
        this.unidades = cantidad;
    }

    public Persona getComprador(){
        return comprador;
    }

    public int getUnidades(){
        return unidades;
    }

    public Vehiculo getVehiculo(){
        return vehiculo;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "comprador=" + comprador +
                ", vehiculo=" + vehiculo +
                ", unidades=" + unidades +
                '}';
    }
}
