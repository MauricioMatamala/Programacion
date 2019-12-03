import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class Nómina {
	private double sueldoBase;
	private double productividad;

	public double getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(double sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	public double getProductividad() {
		return productividad;
	}

	public void calcularProductividad(ArrayList<Actividad> actividades){
		Iterator<Actividad> it = actividades.iterator();
		productividad = 0;
		while (it.hasNext()){
			Actividad actividad = it.next();
			Proyecto proyecto = actividad.getProyecto();
			productividad += (((double)actividad.getDuración())/3600000)*proyecto.getFprod();
		}
	}

	@Override
	public String toString() {
		return "Nómina{" +
				"sueldoBase=" + sueldoBase +
				", productividad=" + productividad +
				'}';
	}
}
