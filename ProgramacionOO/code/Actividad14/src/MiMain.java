public class MiMain {
    public static void main(String[] args) {
        LoteDeProductos lote = new LoteDeProductos();
        lote.addProducto(new Producto("p1",4.3,3.2));
        lote.addProducto(new Producto("p2",3.5,3));
        try{
            lote.addProducto(new Producto("p3",4.9,30));
            lote.addProducto(null);
        } catch (NullProductoException e){
            System.out.println(e);
            System.out.println("Algunos productos no se han añadido.");
        }

        try {
            lote.getProductoEnPosicion(10);
        } catch (ProductPositionException e){
            System.out.println(e);
        }

        lote.setSelectorDeMejorProducto(new CriterioMejorPrecio());

        System.out.println(lote.getSellersChoice());

        lote.setSelectorDeMejorProducto(new CriterioMejorValorado());

        System.out.println(lote.getSellersChoice());

        lote.setSelectorDeMejorProducto(new CriterioMejorRatioValoraciónPrecion());

        System.out.println(lote.getSellersChoice());

    }
}
