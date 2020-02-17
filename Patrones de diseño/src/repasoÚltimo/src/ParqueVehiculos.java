import java.util.ArrayList;

public class ParqueVehiculos {
    private ArrayList<StockVehiculo> stockVehiculos;

    public ParqueVehiculos(){
        stockVehiculos = new ArrayList<>();
    }

    public ParqueVehiculos(ArrayList<StockVehiculo> stockVehiculos){
        this.stockVehiculos = stockVehiculos;
    }

    public ArrayList<StockVehiculo> getStockVehiculos(){
        return stockVehiculos;
    }

    public StockVehiculo getStockVehiculoByMarcaYModelo(String marca, String modelo){
        for (StockVehiculo stockVehiculo: stockVehiculos){
            if (stockVehiculo.getMarca().equals(marca) && stockVehiculo.getModelo().equals(modelo))
                return stockVehiculo;
        }
        return null;
    }

    public void actualizarUnidades(Venta venta){
        Vehiculo vehiculo = venta.getVehiculo();
        StockVehiculo stockVehiculo = getStockVehiculoByMarcaYModelo(vehiculo.getMarca(),vehiculo.getModelo());
        stockVehiculo.sacarDeStock(venta.getUnidades());
    }
}
