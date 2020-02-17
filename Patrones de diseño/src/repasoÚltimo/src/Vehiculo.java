public class Vehiculo {
    private String marca;
    private String modelo;
    private int kilometros;
    private String combustible;
    private double precio;

    public Vehiculo(String marca, String modelo, int kilometros, String combustible, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.kilometros = kilometros;
        this.combustible = combustible;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", kilometros=" + kilometros +
                ", combustible='" + combustible + '\'' +
                ", precio=" + precio +
                "}\n";
    }
}
