public class LoteDeProductos {
    private Producto[] productos;
    // private final static int MAX_PRODUCTOS = 100;
    private int totalProductos;
    private SelectorDeMejorProducto selectorDeMejorProducto;

    public LoteDeProductos(){
        totalProductos = 0;
        productos = new Producto[100];
        selectorDeMejorProducto = new CriterioMejorPrecio();
    }

    public void addProducto(Producto producto){
        if (producto == null) {
            throw new NullProductoException("Intento ilegal de crear un producto nulo");
        } else {
            if (totalProductos < productos.length){
                productos[totalProductos] = producto;
                totalProductos++;
            }
        }
    }

    public Producto getProductoEnPosicion(int i) throws ProductPositionException{
        if ((i >= 0) && (i < totalProductos))
            return productos[i];
        else
            throw new ProductPositionException(i,totalProductos-1);
    }

    public int getTotalProductos(){
        return totalProductos;
    }

    public void setSelectorDeMejorProducto(SelectorDeMejorProducto selectorDeMejorProducto) {
        this.selectorDeMejorProducto = selectorDeMejorProducto;
    }

    public Producto getSellersChoice(){
        return selectorDeMejorProducto.elegirMejorProducto(this);
    }
}
