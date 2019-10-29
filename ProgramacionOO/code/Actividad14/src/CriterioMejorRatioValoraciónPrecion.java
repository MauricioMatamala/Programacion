public class CriterioMejorRatioValoraciónPrecion implements SelectorDeMejorProducto{
    @Override
    public Producto elegirMejorProducto(LoteDeProductos lote) {
        double mejorRatio = Double.MIN_VALUE;
        Producto productoMejorRatio = null;
        for (int i=0; i<lote.getTotalProductos(); i++){
            Producto productoActual = lote.getProductoEnPosicion(i);
            double precioActual = productoActual.getPrecio();
            double valoraciónActual = productoActual.getValoración();
            double ratioActual = valoraciónActual/precioActual;
            if (ratioActual > mejorRatio){
                mejorRatio = ratioActual;
                productoMejorRatio = productoActual;
            }
        }
        return productoMejorRatio;
    }
}
