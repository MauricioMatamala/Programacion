public class Estaciones {
    public static void main(String[] args) {
        int meses[] = {1,2,3,4,5,6,7,8,9,10,11,12};

        int mes = 7;

        if ((mes == 12) || (mes == 1) || (mes == 2)){
            System.out.println("Invierno");
        }

        switch (mes){
            case 12:
            case 1:
            case 2:
                System.out.println("Iniverno");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("Primavera");
                break;
            case 6:
            case 7:
                System.out.println("Julio");
            case 8:
                System.out.println("Verano");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("Otoño");
        }
    }
}
