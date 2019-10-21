public class EmpleadoMal {
    public final static int ASALARIADO = 1;
    public final static int POR_HORAS = 2;
    public final static int COMISIONADO = 3;
    public final static int PROYECTOS = 4;

    private String nombre;
    private String apellidos;
    private String DNI;
    private double sueldo;
    private int numeroVentas;
    private double sueldoBase;
    private double sueldoPorVenta;
    private double horasTrabajadas;
    private double sueldoPorHora;

    public double getTiempoProyecto() {
        return tiempoProyecto;
    }

    public void setTiempoProyecto(double tiempoProyecto) {
        this.tiempoProyecto = tiempoProyecto;
    }

    private double tiempoProyecto;
    int tipo;

    public EmpleadoMal(String nombre, String apellidos, String DNI, int tipo){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.tipo = tipo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public int getNumeroVentas() {
        return numeroVentas;
    }

    public void setNumeroVentas(int numeroVentas) {
        this.numeroVentas = numeroVentas;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public double getSueldoPorVenta() {
        return sueldoPorVenta;
    }

    public void setSueldoPorVenta(double sueldoPorVenta) {
        this.sueldoPorVenta = sueldoPorVenta;
    }

    public double getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(double horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public double getSueldoPorHora() {
        return sueldoPorHora;
    }

    public void setSueldoPorHora(double sueldoPorHora) {
        this.sueldoPorHora = sueldoPorHora;
    }

    public double getSueldoCalculado(){
        double sueldoCalculado = 0.0;
        if (tipo == ASALARIADO)
            sueldoCalculado = sueldo;
        else if (tipo == POR_HORAS)
            sueldoCalculado = sueldoPorHora*horasTrabajadas;
        else if (tipo == COMISIONADO)
            sueldoCalculado = sueldoBase + sueldoPorVenta*numeroVentas;
        else if (tipo == PROYECTOS)
            sueldoCalculado = tiempoProyecto*sueldoBase;
        return sueldoCalculado;
    }
}
