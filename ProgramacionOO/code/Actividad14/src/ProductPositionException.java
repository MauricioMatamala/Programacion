public class ProductPositionException extends IndexOutOfBoundsException{

    public ProductPositionException(int i, int límiteMáximo){
        super("El índice " + i + " supera al máximo permitido: " + límiteMáximo);
    }

    @Override
    public String toString() {
        return this.getMessage();//"El índice " + i + " supera al máximo permitido: " + límiteMáximo;
    }
}
