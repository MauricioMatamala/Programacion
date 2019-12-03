public class Categoría {
	public final static int TÉCNICO = 10;
	public final static int ADMINISTRADOR = 20;
	public final static int PROGRAMADOR = 30;
	public final static int JEFE_PROYECTO = 40;
	public final static int JEFE_OPERACIONES = 50;

	public static double getSueldo(int categoría){
		switch (categoría){
			case TÉCNICO:
				return 900.0;
			case ADMINISTRADOR:
				return 1400.0;
			case PROGRAMADOR:
				return 1800.0;
			case JEFE_PROYECTO:
				return 2500.0;
			case JEFE_OPERACIONES:
				return 3500.0;
			default:
				return 0.0;
		}
	}

	public static String getNombre(int categoría){
		switch (categoría){
			case TÉCNICO:
				return "técnico";
			case ADMINISTRADOR:
				return "administrador";
			case PROGRAMADOR:
				return "programador";
			case JEFE_PROYECTO:
				return "jefe_proyecto";
			case JEFE_OPERACIONES:
				return "jefe_operaciones";
			default:
				return "";
		}
	}
}
