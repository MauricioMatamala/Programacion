import java.util.Comparator;

public class ElementoTest implements Comparable<ElementoTest>{
    private String nombre;
    private int valor;

    public ElementoTest(String nombre, int valor){
        this.nombre = nombre;
        this.valor = valor;
    }

    public int getValor(){
        return valor;
    }

    public void setValor(int valor){
        this.valor = valor;
    }

    @Override
    public boolean equals(Object obj) {
        boolean test = valor == ((ElementoTest) obj).getValor();
        System.out.println("Estoy en equals: " + test);
        return valor == ((ElementoTest) obj).getValor();
    }

    @Override
    public String toString() {
        return " (" + nombre + "," + valor + ") ";
    }

    @Override
    public int hashCode() {
        /*System.out.println("Estoy en hashCode: " + valor);
        return valor;*/
        return (int) Math.random()*10000;
    }

    public int comparar(ElementoTest e){
        System.out.println("Comparar" + valor + "," + e.getValor());
        if (valor > e.getValor()) return 1;
        else if (valor == e.getValor()) return 0;
        else return -1;
    }

    @Override
    public int compareTo(ElementoTest elementoTes) {
        if (valor > elementoTes.getValor()) return 1;
        else if (valor == elementoTes.getValor()) return 0;
        else return -1;
    }
}
