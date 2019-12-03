import java.util.ArrayList;
import java.util.Iterator;

public class Empleado {
	private String nombre;
	private String apellidos;
	private String dni;
	private int categoría;
	private Nómina nómina;

	public Empleado(String nombre, String apellidos, String dni, int categoría) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.categoría = categoría;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getCategoría() {
		return categoría;
	}

	public void setCategoría(int categoría) {
		this.categoría = categoría;
	}

	public double getSueldo(){
		return Categoría.getSueldo(categoría);
	}

	public void calcularNómina(Actividades actividades){
		nómina = new Nómina();
		ArrayList<Actividad> actividadesDelEmpleado = actividades.getActividadesPorEmpleado(dni);
		nómina.calcularProductividad(actividadesDelEmpleado);
		nómina.setSueldoBase(Categoría.getSueldo(categoría));
	}

	public Nómina getNómina(){
		return nómina;
	}

	@Override
	public String toString() {
		return "Empleado{" +
				"nombre='" + nombre + '\'' +
				", apellidos='" + apellidos + '\'' +
				", dni='" + dni + '\'' +
				", categoría=" + categoría +
				'}';
	}
}
