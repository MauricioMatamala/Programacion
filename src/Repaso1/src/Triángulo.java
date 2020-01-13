public class Triángulo {

    /**
     *    /|
     * h / |c2
     *  /__|
     *   c1
     *
     *
     */

    public final static int HIPOTENUSA_BY_CATETOS = 1;
    public final static int CATETO2_BY_CATETO1_HIPOTENUSA = 2;
    public final static int AREA_BY_CATETO1_HIPOTENUSA = 3;
    public final static int AREA_BY_CATETOS = 4;

    private double cateto1, cateto2, hipotenusa;

    public void setCateto1(double cateto1) {
        this.cateto1 = cateto1;
    }

    public void setCateto2(double cateto2) {
        this.cateto2 = cateto2;
    }

    public void setHipotenusa(double hipotenusa) {
        this.hipotenusa = hipotenusa;
    }

    public double calcular(int operación){
        switch(operación){
            case HIPOTENUSA_BY_CATETOS: return hipotenusaByCatetos();
            case CATETO2_BY_CATETO1_HIPOTENUSA: return cateto2ByCateto1Hipotenusa();
            case AREA_BY_CATETO1_HIPOTENUSA: return areaByCateto1Hipotenusa();
            case AREA_BY_CATETOS: return areaByCatetos();
            default: throw new UnsupportedOperationException("No existe la operación solicitada");
        }
    }

    public double hipotenusaByCatetos(){
        return Math.sqrt(Math.pow(cateto1,2.0)+Math.pow(cateto2,2.0));
    }

    public double cateto2ByCateto1Hipotenusa(){
        return Math.sqrt(Math.pow(hipotenusa,2.0)-Math.pow(cateto1,2.0));
    }

    public double areaByCateto1Hipotenusa(){
        cateto2 = cateto2ByCateto1Hipotenusa();
        return areaByCatetos();
    }

    public double areaByCatetos(){
        return (cateto1 * cateto2)/2;
    }
}
