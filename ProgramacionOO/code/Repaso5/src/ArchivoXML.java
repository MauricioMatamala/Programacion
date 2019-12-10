import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ArchivoXML {
    Document doc;
    private String nombreArchivo;
    public ArchivoXML(String nombreArchivo){
        this.nombreArchivo = nombreArchivo;
    }

    public void abrir(){
        String dir = System.getProperty("user.dir");
        System.out.println(dir);
        try {
            File inputFile = new File(dir + File.separator + nombreArchivo);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public Ciudades leerCiudades(){
        Ciudades ciudades = new Ciudades();
        try {
            XPath xPath = XPathFactory.newInstance().newXPath();
            String xpathExpr = "/rows/row";
            NodeList nodeList = (NodeList) xPath.compile(xpathExpr).evaluate(doc, XPathConstants.NODESET);
            for (int i=0; i<nodeList.getLength();i++){
                Element elementoRow = (Element) nodeList.item(i);
                NodeList listaNodosLocality = elementoRow.getElementsByTagName("locality");
                Element locality = (Element) listaNodosLocality.item(0);
                Ciudad ciudad;
                if (locality == null)
                    ciudad = new Ciudad("Sin nombre");
                else
                    ciudad = new Ciudad(locality.getTextContent());
                ciudades.addCiudad(ciudad);
            }
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return ciudades;
    }
}
