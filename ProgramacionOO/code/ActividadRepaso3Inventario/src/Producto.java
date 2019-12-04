import java.util.ArrayList;

public class Producto {
    private String id;
    private ArrayList<Componente> especificaciones;

    public Producto(String id){
        this.id = id;
        especificaciones = new ArrayList<>();
    }

    public ArrayList<Componente> getEspecificaciones(){
        return especificaciones;
    }

    public void setEspecificación(Componente especificación){
        especificaciones.add(especificación);
    }

}
