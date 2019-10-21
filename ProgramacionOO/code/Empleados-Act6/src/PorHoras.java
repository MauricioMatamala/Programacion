public class PorHoras extends Empleado{
    private double horasTrabajadas;
    private double sueldoPorHora;

    public PorHoras(String nombre, String apellidos, String DNI,
                    double horasTrabajadas, double sueldoPorHora){
        super(nombre,apellidos,DNI);
        this.horasTrabajadas = horasTrabajadas;
        this.sueldoPorHora = sueldoPorHora;
    }

    @Override
    public double getSueldo() {
        return horasTrabajadas*sueldoPorHora;
    }

    public double getHorasTrabajadas() {
        return horasTrabajadas;
    }

    @Override
    public String getSpecificData() {
        return "\nHoras trabajadas: " + horasTrabajadas +
                "\nSueldo por hora: " + sueldoPorHora;
    }
}
