public class Actividad {
	private Empleado empleado;
	private Proyecto proyecto;
	private String descripción;
	private long duración;

	public Actividad(Empleado empleado, Proyecto proyecto, String descripción, long duración) {
		this.empleado = empleado;
		this.proyecto = proyecto;
		this.descripción = descripción;
		this.duración = duración;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public String getDescripción(){
		return descripción;
	}

	public long getDuración(){
		return duración;
	}

	@Override
	public String toString() {
		return "Actividad{" +
				"empleado=" + empleado +
				", proyecto=" + proyecto +
				", descripción='" + descripción + '\'' +
				'}';
	}
}
