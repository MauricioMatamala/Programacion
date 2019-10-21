public class Asalariado extends Empleado {
    private double sueldo;

    public Asalariado(String nombre, String apellidos, String DNI, double sueldo){
        super(nombre,apellidos,DNI);
        this.sueldo = sueldo;
    }

    public double getSueldo(){
        return sueldo;
    }

    @Override
    public String getSpecificData() {
        return "";
    }
}
