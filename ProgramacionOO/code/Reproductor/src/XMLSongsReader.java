import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.File;

public class XMLSongsReader {
    private NodeList nodeList;
    private int nodeIndex = 0;

    public XMLSongsReader(){
        String dir = System.getProperty("user.dir");
        System.out.println(dir);
        try {
            File inputFile = new File(dir + File.separator + "songs.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            XPath xPath = XPathFactory.newInstance().newXPath();
            String xpathExpr = "/songs/song";
            nodeList = (NodeList) xPath.compile(xpathExpr).evaluate(doc, XPathConstants.NODESET);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean hasNext(){
        return nodeIndex < nodeList.getLength();
    }

    public Song next(){
        Element songNode = (Element) nodeList.item(nodeIndex);
        Song song = new Song();
        song.setFileName(songNode.getAttribute("file"));
        song.setSongTitle(songNode.getAttribute("title"));
        nodeIndex++;
        return song;
    }
}
