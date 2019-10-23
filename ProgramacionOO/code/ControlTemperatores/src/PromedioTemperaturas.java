public class PromedioTemperaturas implements ConsumidorDeTemperaturas{
    private double promedioTemperaturas;
    private int numeroTemperaturas;

    public PromedioTemperaturas(){
        promedioTemperaturas = 0;
        numeroTemperaturas = 0;
    }

    @Override
    public void setNuevaTemperatura(double temperatura, int hora) {
        promedioTemperaturas += ((promedioTemperaturas*numeroTemperaturas)+temperatura)/(numeroTemperaturas + 1);
        numeroTemperaturas++;
    }

    @Override
    public String toString() {
        return Double.toString(promedioTemperaturas);
    }
}
