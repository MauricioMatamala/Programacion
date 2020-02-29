import java.util.ArrayList;

public class MHTApp {
    private ArrayList<Cliente> clientes;
    private ControlDeAlmacen controlDeAlmacen;
    private Almacen almacen;

    public MHTApp(ArrayList<Cliente> clientes, ControlDeAlmacen controlDeAlmacen, Almacen almacen){
        this.almacen = almacen;
        this.controlDeAlmacen = controlDeAlmacen;
        this.clientes = clientes;
    }

    public ArrayList<StockProducto> getProductosAlmacen(){

        // Código aquí

        return null;
    }

    public StockProducto getStockProductoByRef(String ref) {

        // Código aquí

        return null;
    }

    public void hacerPedido(String nombreCliente, String ref, int cantidad) throws ProblemaDeExistenciasException{
        // Código aquí
    }

    public Cliente getClienteByNombre(String nombreCliente) {

        // Código aquí

        return null;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }


    public ArrayList<StockProducto> getOrdenesReposicion() {

        // Código aquí

        return null;
    }
}
