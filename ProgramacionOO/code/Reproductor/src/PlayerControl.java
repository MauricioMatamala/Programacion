import javax.xml.stream.XMLInputFactory;

public class PlayerControl {
    public static void main(String[] args) {
        XMLSongsReader xmlSongsReader = new XMLSongsReader();
        while (xmlSongsReader.hasNext())
            System.out.println(xmlSongsReader.next());
    }
}
