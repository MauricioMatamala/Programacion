public class Ubicación {
    private double latitud;
    private double longitud;

    public Ubicación(double latitud, double longitud){
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public double calcularDistancia(Ubicación ubicación){
        double theta = longitud - ubicación.getLongitud();
        double dist = Math.sin(Math.toRadians(latitud)) * Math.sin(Math.toRadians(ubicación.getLatitud())) + Math.cos(Math.toRadians(latitud)) * Math.cos(Math.toRadians(ubicación.getLatitud())) * Math.cos(Math.toRadians(theta));
        dist = Math.acos(dist);
        dist = Math.toDegrees(dist);
        return dist * 60 * 1.853159616;
    }

    @Override
    public String toString() {
        return "Ubicación{" +
                "latitud=" + latitud +
                ", longitud=" + longitud +
                '}';
    }
}
