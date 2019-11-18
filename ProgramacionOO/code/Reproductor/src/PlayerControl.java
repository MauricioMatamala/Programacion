import javax.xml.stream.XMLInputFactory;
import java.util.LinkedList;

public class PlayerControl {
    public static void main(String[] args) {
        XMLSongsReader xmlSongsReader = new XMLSongsReader();
        LinkedList<Song> songsList = new LinkedList<>();
        while (xmlSongsReader.hasNext())
            songsList.add(xmlSongsReader.next());
        ListaReproducción listaReproducción = new ListaReproducción(songsList);
        listaReproducción.iniciar();
        listaReproducción.detener();
    }
}
