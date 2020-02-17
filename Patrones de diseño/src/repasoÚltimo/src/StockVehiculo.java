public class StockVehiculo {
    private int unidades;
    private Vehiculo vehiculo;

    public StockVehiculo(Vehiculo vehiculo, int unidades){
        this.unidades = unidades;
        this.vehiculo = vehiculo;
    }

    public int getUnidades(){
        return unidades;
    }

    public Vehiculo getVehiculo(){
        return vehiculo;
    }

    public String getMarca(){
        return vehiculo.getMarca();
    }

    public String getModelo(){
        return vehiculo.getModelo();
    }

    public void sacarDeStock(int numeroUnidades){
        if (unidades > numeroUnidades){
            unidades -= numeroUnidades;
        }
    }

    @Override
    public String toString() {
        return "StockVehiculo{" +
                "unidades=" + unidades +
                ", vehiculo=" + vehiculo +
                '}';
    }
}
