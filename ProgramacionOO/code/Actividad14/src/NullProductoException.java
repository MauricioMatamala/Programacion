public class NullProductoException extends IllegalArgumentException{
    public NullProductoException(String message){
        super(message);
    }

    @Override
    public String toString() {
        return "Un producto no puede ser null";
    }
}
