import java.util.ArrayList;

public class ParqueVehiculos {
    private ArrayList<Vehiculo> vehiculos;

    public ParqueVehiculos(ArrayList<Vehiculo> vehiculos){
        this.vehiculos = vehiculos;
    }

    public ArrayList<Vehiculo> getVehiculos(){
        return vehiculos;
    }
}
