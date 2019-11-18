import java.util.LinkedList;
import java.util.ListIterator;

public class ListaReproducción {
    private LinkedList<Song> listaReproducción;

    private static final int ESTADO_NO_INICIADO = 0;
    private static final int ESTADO_REPRODUCIENDO = 1;
    private static final int ESTADO_DETENIDO = 2;
    private static final int ESTADO_REPRODUCCIÓN_ALEATORIA = 3;
    private static final int ESTADO_FINALIZADO = 4;
    private static final int ESTADO_PAUSADO = 5;
    private int status;
    private ListIterator<Song> listIterator;

    private Player player;
    private Song currentSong;

    public ListaReproducción(LinkedList<Song> listaReproducción){
        listIterator = listaReproducción.listIterator();
        player = new Player();
        this.listaReproducción = listaReproducción;
        status = ESTADO_NO_INICIADO;
    }

    public void iniciar(){
        switch(status){
            case ESTADO_NO_INICIADO: case ESTADO_DETENIDO:
                inciarEstadoReproduciendo();
                break;
            case ESTADO_FINALIZADO:
                listIterator = listaReproducción.listIterator();
                inciarEstadoReproduciendo();
                break;
            default:
                System.out.println("Operación no permitida");
        }
    }

    public void detener(){
        switch (status){
            case ESTADO_REPRODUCIENDO: case ESTADO_REPRODUCCIÓN_ALEATORIA:
                player.stop(currentSong);
        }
    }

    private void inciarEstadoReproduciendo() {
        if (listIterator.hasNext()) {
            currentSong = listIterator.next();
            player.play(currentSong);
            status = ESTADO_REPRODUCIENDO;
        }
    }

    /*
        - Iniciar
        - Detener
        - AñadirSiguiente
        - Anterior
        - Siguiente
        - Pausar
        - Aleatorio
     */
}
