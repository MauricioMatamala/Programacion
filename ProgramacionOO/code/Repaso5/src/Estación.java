public class Estación {
    public final static int ESTACIÓN_TREN = 1;
    public final static int ESTACIÓN_AUTOBÚS = 2;
    public final static int ESTACIÓN_FUNICULAR = 3;
    public final static int ESTACIÓN_MARÍTIMA = 4;

    String nombre;
    String dirección;
    String teléfono;
    Ubicación ubicación;
    int tipo;

    public Estación(String nombre, String dirección, String teléfono, Ubicación ubicación, int tipo) {
        this.nombre = nombre;
        this.dirección = dirección;
        this.teléfono = teléfono;
        this.ubicación = ubicación;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTeléfono() {
        return teléfono;
    }

    public void setTeléfono(String teléfono) {
        this.teléfono = teléfono;
    }

    public Ubicación getUbicación() {
        return ubicación;
    }

    public void setUbicación(Ubicación ubicación) {
        this.ubicación = ubicación;
    }

    public int getTipo(){
        return tipo;
    }

    @Override
    public String toString() {
        return "Estación{" +
                "nombre='" + nombre + '\'' +
                ", dirección='" + dirección + '\'' +
                ", teléfono='" + teléfono + '\'' +
                ", ubicación=" + ubicación +
                ", tipo=" + tipo +
                '}';
    }
}
