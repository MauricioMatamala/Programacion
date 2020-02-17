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

    @Override
    public String toString() {
        return "Ventas{" +
                "ventas=" + ventas +
                '}';
    }
}
