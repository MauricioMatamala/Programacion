public class Producto {
    private String nombre;
    private double valoración;
    private double precio;

    public Producto(String nombre, double valoración, double precio){
        this.nombre = nombre;
        this.valoración = valoración;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getValoración() {
        return valoración;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", valoración=" + valoración +
                ", precio=" + precio +
                '}';
    }
}
