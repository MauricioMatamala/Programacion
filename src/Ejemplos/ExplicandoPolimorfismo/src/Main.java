public class Main {
    public static void main(String[] args) {
        Padre padre0 = new Padre();
        Padre padre1 = new Hijo1();
        Padre padre2 = new Hijo2();
        Hijo1 hijo1 = new Hijo1();

        // Hijo2 hijo2 = dameLoQueTengas();

        Padre[] padres = new Padre[4];
        padres[0] = padre0;
        padres[1] = padre1;
        padres[2] = padre2;
        padres[3] = hijo1;

        for (int i=0; i<padres.length; i++){
            padres[i].saludo();
        }

        // -------------------------------------
        Father father = new Son();
        father.saludo();
    }
}
