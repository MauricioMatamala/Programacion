public class Proyecto {
	private String nombre;
	private String departamento;
	private double fprod;
	private String descripción;

	public Proyecto(String nombre, String departamento, double fprod, String descripción) {
		this.nombre = nombre;
		this.departamento = departamento;
		this.fprod = fprod;
		this.descripción = descripción;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public double getFprod() {
		return fprod;
	}

	public void setFprod(double fprod) {
		this.fprod = fprod;
	}

	public String getDescripción() {
		return descripción;
	}

	public void setDescripción(String descripción) {
		this.descripción = descripción;
	}

	@Override
	public String toString() {
		return "Proyecto{" +
				"nombre='" + nombre + '\'' +
				", departamento='" + departamento + '\'' +
				", fprod=" + fprod +
				", descripción='" + descripción + '\'' +
				'}';
	}
}
