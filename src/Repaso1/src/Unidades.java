public class Unidades {
   public final static int MEDIDA_MM = 1;
   public final static int MEDIDA_CM = 2;
   public final static int MEDIDA_M = 3;

   public static String getNombreUnidad(int unidad){
      switch (unidad){
         case MEDIDA_MM: return "mm";
         case MEDIDA_CM: return "cm";
         case MEDIDA_M: return "m";
         default: return "unidades";
      }
   }
}
