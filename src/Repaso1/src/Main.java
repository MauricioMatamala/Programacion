public class Main {
    public final static int TERMINAR = -1;
    private static Interfaz interfaz;

    public static void main(String[] args) {
        interfaz = new Interfaz();
        int unidad = -1;
        int operación = -1;
        boolean terminar = false;

        while (!terminar){
            unidad = obtenerUnidad();
            if (unidad == TERMINAR) terminar = true;

            if (!terminar) {
                operación = obtenerOperación();
                if (operación == TERMINAR) terminar = true;
            }

            if (!terminar){
                Triángulo triángulo = obtenerTriángulo(operación);
                double resultado = triángulo.calcular(operación);
                interfaz.mostrarResultado(resultado,operación,unidad);
            }
        }
    }

    private static int obtenerUnidad(){
        boolean unidadVálida = false;
        int unidad = -1;
        while (!unidadVálida){
            try{
                unidad = interfaz.preguntarUnidad();
                unidadVálida = true;
            } catch(UnsupportedOperationException e){
                System.out.println(e.getMessage());
            }
        }
        return unidad;
    }

    private static int obtenerOperación(){
        boolean operaciónVálida = false;
        int operación = -1;
        while (!operaciónVálida){
            try {
                operación = interfaz.preguntarOperación();
                operaciónVálida = true;
            } catch(UnsupportedOperationException operaciónNoSoportada){
                System.out.println(operaciónNoSoportada.getMessage());
            }
        }
        return operación;
    }

    private static Triángulo obtenerTriángulo(int operación) {
        Triángulo triángulo = new Triángulo();
        triángulo.setCateto1(interfaz.preguntarParámetro("cateto1"));

        switch (operación){
            case Triángulo.HIPOTENUSA_BY_CATETOS:
            case Triángulo.AREA_BY_CATETOS:
                triángulo.setCateto2(interfaz.preguntarParámetro("cateto2"));
                return triángulo;
            case Triángulo.CATETO2_BY_CATETO1_HIPOTENUSA:
            case Triángulo.AREA_BY_CATETO1_HIPOTENUSA:
                triángulo.setHipotenusa(interfaz.preguntarParámetro("hipotenusa"));
                return triángulo;
            default: return null;
        }
    }
}
