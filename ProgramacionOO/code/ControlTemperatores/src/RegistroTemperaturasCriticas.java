public class RegistroTemperaturasCriticas implements ConsumidorDeTemperaturas{
    private double[] temperaturasCriticas;
    private final static double UMBRAL_SUPERIOR = 110.0;

    public RegistroTemperaturasCriticas(){
        temperaturasCriticas = new double[24];
        for (int i=0; i<temperaturasCriticas.length; i++){
            temperaturasCriticas[i] = 0;
        }
    }

    @Override
    public void setNuevaTemperatura(double temperatura, int hora) {
        if (temperatura > UMBRAL_SUPERIOR)
            temperaturasCriticas[hora]++;
    }

    @Override
    public String toString() {
        String textoTemperaturasCriticas = "";
        for (int i=0; i<temperaturasCriticas.length; i++)
            textoTemperaturasCriticas += i + "(" + temperaturasCriticas[i] + ") - ";
        return textoTemperaturasCriticas;
    }
}
