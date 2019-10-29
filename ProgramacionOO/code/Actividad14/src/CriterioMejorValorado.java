public class CriterioMejorValorado implements SelectorDeMejorProducto {
    @Override
    public Producto elegirMejorProducto(LoteDeProductos lote) {
        double mejorValoración = Double.MIN_VALUE;
        Producto productoMejorValorado = null;
        for (int i=0; i<lote.getTotalProductos(); i++){
            Producto productoActual = lote.getProductoEnPosicion(i);
            double valoraciónActual = productoActual.getValoración();
            if (valoraciónActual > mejorValoración ){
                mejorValoración = valoraciónActual;
                productoMejorValorado = productoActual;
            }
        }
        return productoMejorValorado;
    }
}
