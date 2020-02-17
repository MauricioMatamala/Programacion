import java.util.ArrayList;

public class Ventas {
    private ArrayList<Venta> ventas;

    public Ventas(){
        ventas = new ArrayList<>();
    }

    public void addVenta(Venta venta){
        ventas.add(venta);
    }

    public ArrayList<Venta> getVentas(){
        return ventas;
    }

    public ArrayList<Venta> getVentasByComprador(String nombre){
        ArrayList<Venta> ventasPorComprador = new ArrayList<>();
        for (Venta venta: ventas){
            if (venta.getComprador().getNombre().equals(nombre))
                ventasPorComprador.add(venta);
        }
        return ventasPorComprador;
    }

    public int getNumeroVentas(){
        return ventas.size();
    }

    public Venta getVenta(int i){
        return ventas.get(i);
    }

    @Override
    public String toString() {
        return "Ventas{" +
                "ventas=" + ventas +
                '}';
    }
}
