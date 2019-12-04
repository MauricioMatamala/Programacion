public class Componente {
    private String id;
    private int cantidad;

    public Componente(String id, int cantidad) {
        this.id = id;
        this.cantidad = cantidad;
    }

    public String getId(){
        return id;
    }

    public int getCantidad(){
        return cantidad;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Componente otroComponente = (Componente) obj;
        return id.equals(otroComponente.getId());
    }

    @Override
    public String toString() {
        return "Componente{" +
                "id='" + id + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}
