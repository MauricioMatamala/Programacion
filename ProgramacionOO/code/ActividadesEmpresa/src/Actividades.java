import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Actividades {
	private ArrayList<Actividad> actividades;

	public Actividades(){
		actividades = new ArrayList<>();
	}

	public void addActividad(Actividad actividad){
		actividades.add(actividad);
	}

	@Override
	public String toString() {
		return actividades.toString();
	}

	public ArrayList<Actividad> getActividadesPorEmpleado(String dni){
		ArrayList<Actividad> actividadesPorDni = new ArrayList<Actividad>();
		actividades.stream().filter(actividad -> {return actividad.getEmpleado().getDni().equals(dni);}).forEach(actividadesPorDni::add);
		return actividadesPorDni;
	}

	public ArrayList<Actividad> getActividadesPorProyecto(String nombre){
		ArrayList<Actividad> actividadesPorProyecto = new ArrayList<Actividad>();
		//actividades.stream().filter(actividad->{return actividad.getProyecto().getNombre().equals(nombre);}).forEach(actividadesPorProyecto::add);
		Iterator<Actividad> it = actividades.iterator();
		while (it.hasNext()){
			Actividad actividad = it.next();
			if (actividad.getProyecto().getNombre().equals(nombre))
				actividadesPorProyecto.add(actividad);
		}
		return actividadesPorProyecto;
	}

	public void escribirXMLActividadesPorEmpleado(String nombreFicheroXML, String dni){
		ArrayList<Actividad> actividadesPorDNI = (ArrayList<Actividad>) getActividadesPorEmpleado(dni);
		if (actividadesPorDNI.size() > 0) {
			String xmlSerializado = componerXMLActividadesPorEmpleado(actividadesPorDNI);
			FicheroXML ficheroXML = new FicheroXML(dni+".xml");
			ficheroXML.escribir(xmlSerializado);
		}
	}

	public void escribirXMLActividadesPorProyecto(String nombreFicheroXML, String nombreProyecto){
		ArrayList<Actividad> actividadesPorProyecto = (ArrayList<Actividad>) getActividadesPorProyecto(nombreProyecto);
		if (actividadesPorProyecto.size() > 0) {
			String xmlSerializado = componerXMLActividadesPorProyecto(actividadesPorProyecto);
			FicheroXML ficheroXML = new FicheroXML(nombreProyecto + ".xml");
			ficheroXML.escribir(xmlSerializado);
		}
	}


	private String componerXMLActividadesPorEmpleado(ArrayList<Actividad> actividadesPorDNI){
		Empleado empleado = actividadesPorDNI.get(0).getEmpleado();
		String xmlSerializado = "<empleado nombre=\"" + empleado.getNombre() + "\" apellidos=\"" + empleado.getApellidos() + "\" dni=\"" + empleado.getDni() + "\" categoría=\"" + empleado.getCategoría() + "\">";
		Iterator<Actividad> it = actividadesPorDNI.iterator();
		while (it.hasNext()){
			Actividad actividad = it.next();
			Proyecto proyecto = actividad.getProyecto();
			xmlSerializado +="<actividad proyecto=\"" + proyecto.getNombre() + "\" duración=\"" + actividad.getDuración() + "\">" +
									actividad.getDescripción() +
					         "</actividad>";
		}
		xmlSerializado += "</empleado>";
		return xmlSerializado;
	}

	private String componerXMLActividadesPorProyecto(ArrayList<Actividad> actividadesPorProyecto){
		Proyecto proyecto = actividadesPorProyecto.get(0).getProyecto();
		String xmlSerializado = "<proyecto nombre=\"" + proyecto.getNombre() + "\" departamento=\"" + proyecto.getDepartamento() + "\" fprod=\"" + proyecto.getFprod() + "\">";
		xmlSerializado += "<descripcion>" + proyecto.getDescripción() + "</descripcion>";
		Iterator<Actividad> it = actividadesPorProyecto.iterator();
		while (it.hasNext()){
			Actividad actividad = it.next();
			Empleado empleado = actividad.getEmpleado();
			xmlSerializado += "<actividad duracion=\"" + actividad.getDuración() + "\">";
			xmlSerializado += "<descripcion>" + actividad.getDescripción() + "</descripcion>";
			xmlSerializado += "<empleado nombre=\"" + empleado.getNombre() + "\" apellidos=\"" + empleado.getApellidos() + "\" dni=\"" + empleado.getDni() + "\" categoría=\"" + empleado.getCategoría() + "\"/>";
			xmlSerializado += "</actividad>";
		}
		xmlSerializado += "</proyecto>";
		return xmlSerializado;
	}


}
