import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

public class Empleados {
	private TreeMap<String,Empleado> empleados;

	public Empleados(){
		empleados = new TreeMap<String,Empleado>();
	}

	public void registrar(Empleado empleado){
		empleados.put(empleado.getDni(),empleado);
	}

	public Empleado getEmpleadoPorDni(String dni){
		return empleados.get(dni);
	}

	public void calcularNominas(Actividades actividades){
		empleados.entrySet().stream().forEach(dniConEmpleado -> {dniConEmpleado.getValue().calcularNómina(actividades);});
	}

	public void escribirXMLNóminas(String nombreFicheroXML){
		if (empleados.size() > 0){
			String xmlSerializado = componerXMLNóminas();
			FicheroXML ficheroXML = new FicheroXML(nombreFicheroXML);
			ficheroXML.escribir(xmlSerializado);
		}
	}

	private String componerXMLNóminas() {
		String xmlSerializado = "<nóminas>";
		Iterator<Empleado> it = empleados.values().iterator();
		while (it.hasNext()){
			Empleado empleado = it.next();
			Nómina nómina = empleado.getNómina();
			double sueldoTotal = nómina.getSueldoBase() + nómina.getProductividad();
			xmlSerializado += "<nómina dni=\"" + empleado.getDni() + "\" nombre=\"" + empleado.getNombre() + "\" apellidos=\"" + empleado.getApellidos() + "\">";
			xmlSerializado += 	"<sueldo apartado=\"base\" valor=\"" + nómina.getSueldoBase() + "\"/>";
			xmlSerializado += 	"<sueldo apartado=\"productividad\" valor=\"" + nómina.getProductividad() + "\"/>";
			xmlSerializado += 	"<sueldo apartado=\"total\" valor=\"" + sueldoTotal + "\"/>";
			xmlSerializado += "</nómina>";
		}
		xmlSerializado += "</nóminas>";
		return xmlSerializado;
	}
}
