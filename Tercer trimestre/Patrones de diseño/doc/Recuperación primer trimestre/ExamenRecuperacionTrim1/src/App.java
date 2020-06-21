import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        XMLProductosReader xmlReader = new XMLProductosReader();
        CSVClientesReader csvReader = new CSVClientesReader();

        MHTApp mhtApp = new MHTApp(csvReader.getClientes(),new ControlDeAlmacen(),new Almacen(xmlReader.getProductos()));

        System.out.println("\n\nCONSULTA 1: EXISTENCIAS EN EL ALMACÉN");

        ArrayList<StockProducto> stockProductos = mhtApp.getProductosAlmacen();
        for (StockProducto stockProducto : stockProductos){
            System.out.println("Producto: " + stockProducto.getNombre() + "\n" +
                    "- existencias:" + stockProducto.getUnidades() + "\n" +
                    "- umbral mínimo:" + stockProducto.getUmbral() + "\n");
        }

        System.out.println("\n\nCONSULTA 2: EXISTENCIAS DE UN PRODUCTO CONCRETO");

        StockProducto producto = mhtApp.getStockProductoByRef("f001");
        System.out.println("Producto: " + producto.getNombre() + " - " + producto.getUnidades() + " unidades (umbral - " + producto.getUmbral() + ")");

        System.out.println("\n\nCONSULTA 3: REALIZAR UN PEDIDO. MOSTRAR MENSAJE SI HAY PROBLEMAS DE EXISTENCIAS");

        try {
            mhtApp.hacerPedido("ImanSA", "f001", 18000);
            mhtApp.hacerPedido("ImanSA", "f001", 1000);
        } catch(ProblemaDeExistenciasException e){
            System.out.println(e.getMessage());
        }

        System.out.println("\n\nCONSULTA 4: REVISAR LOS PEDIDOS DE LOS CLIENTES");

        ArrayList<Cliente> clientes = mhtApp.getClientes();
        for (Cliente cliente : clientes){
            System.out.println("Pedidos del cliente " + cliente.getNombre() + " :");
            ArrayList<Pedido> pedidos = cliente.getPedidos();
            if (pedidos.size() > 0) {
                for (Pedido pedido : pedidos) {
                    System.out.println(" - " + pedido.getNombre() + " - " + pedido.getCantidad() + " unidades");
                }
            } else
                System.out.println(" - No hay pedidos");
        }

        System.out.println("\n\nCONSULTA 5: REVISAR LAS ÓRDENES DE REPOSICIÓN");

        ArrayList<StockProducto> ordenesReposicion = mhtApp.getOrdenesReposicion();
        for (StockProducto ordenReposicion: ordenesReposicion){
            System.out.println("Reponer el producto " +  ordenReposicion.getNombre() + ". Quedan " + ordenReposicion.getUnidades() + " unidades. El umbral mínimo es de " + ordenReposicion.getUmbral() + " unidades");
        }
    }
}
