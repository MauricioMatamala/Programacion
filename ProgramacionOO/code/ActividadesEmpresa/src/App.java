import java.util.ArrayList;

public class App {
	public static void main(String[] args) {
		Proyectos proyectos = new Proyectos();
		Empleados empleados = new Empleados();
		Actividades actividades = new Actividades();

		proyectos.leer("proyectos.xml");

		empleados.registrar(new Empleado("Juan Pedro","López González","12345678A",Categoría.TÉCNICO));
		empleados.registrar(new Empleado("Manuel","Antúnez Piñero","23456789B",Categoría.PROGRAMADOR));
		empleados.registrar(new Empleado("Gonzalo","Zubizarreta García","34567890C",Categoría.ADMINISTRADOR));

		actividades.addActividad(new Actividad(empleados.getEmpleadoPorDni("12345678A"),
				                               proyectos.getProyectoPorNombre("Alphasec"),
								    "Análisis perimetral de puertos de la red de Málaga Oeste",
												2000000));
		actividades.addActividad(new Actividad(empleados.getEmpleadoPorDni("23456789B"),
											   proyectos.getProyectoPorNombre("PaperGest"),
									"Desarrollo de manejador de errores.",20000000));
		actividades.addActividad(new Actividad(empleados.getEmpleadoPorDni("23456789B"),
											   proyectos.getProyectoPorNombre("iMed"),
									"Desarrollo de la vista de administrativos en atención al cliente",20000000));

		System.out.println(actividades.getActividadesPorEmpleado("23456789B"));
		actividades.escribirXMLActividadesPorEmpleado("23456789B.xml","23456789B");

		System.out.println(actividades.getActividadesPorProyecto("Alphasec"));
		actividades.escribirXMLActividadesPorProyecto("Alphasec.xml","Alphasec");

		Empleado juanPedro = empleados.getEmpleadoPorDni("12345678A");
		//juanPedro.calcularNómina(actividades);
		//System.out.println(juanPedro.getNómina());

		empleados.calcularNominas(actividades);
		empleados.escribirXMLNóminas("nóminas.xml");
	}
}
