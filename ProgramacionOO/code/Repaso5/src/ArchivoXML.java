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
                String nombreCiudad = getNombreCiudadDeElementoRow(elementoRow);
                Ciudad ciudad = getCiudadOCrearSiNoExiste(nombreCiudad,ciudades);
                Estación estación = getEstaciónDeElementoRow(elementoRow);
                ciudad.addEstación(estación);
            }
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return ciudades;
    }

    private String getNombreCiudadDeElementoRow(Element elementoRow){
        NodeList listaNodosLocality = elementoRow.getElementsByTagName("locality");
        Element locality = (Element) listaNodosLocality.item(0);
        if (locality == null)
            return "Sin nombre";
        else
            return locality.getTextContent();
    }

    private Ciudad getCiudadOCrearSiNoExiste(String nombreCiudad, Ciudades ciudades){
        Ciudad ciudad = ciudades.getCiudadByNombre(nombreCiudad);
        if (ciudad == null) {
            Ciudad nuevaCiudad = new Ciudad(nombreCiudad);
            ciudades.addCiudad(nuevaCiudad);
            return nuevaCiudad;
        } else
            return ciudad;
    }

    private Estación getEstaciónDeElementoRow(Element elementoRow){
        String nombreEstación = elementoRow.getElementsByTagName("documentname").item(0).getTextContent();
        String teléfono = elementoRow.getElementsByTagName("phone").item(0).getTextContent();
        String dirección = elementoRow.getElementsByTagName("address").item(0).getTextContent();
        Ubicación ubicación = getUbicaciónDeElementoRow(elementoRow);
        int tipo = getTipoEstaciónDeElementoRow(elementoRow);
        Estación estación = new Estación(nombreEstación,dirección,teléfono,ubicación,tipo);
        return estación;
    }

    private Ubicación getUbicaciónDeElementoRow(Element elementoRow){
        double latitud = 0;
        double longitud = 0;
        Element elementoLatwgs84 = (Element) elementoRow.getElementsByTagName("latwgs84").item(0);
        Element elementoLonwgs84 = (Element) elementoRow.getElementsByTagName("lonwgs84").item(0);
        if (elementoLatwgs84 != null)
            latitud = Double.parseDouble(elementoLatwgs84.getTextContent());
        if (elementoLonwgs84 != null)
            longitud = Double.parseDouble(elementoLonwgs84.getTextContent());
        return new Ubicación(latitud,longitud);
    }

    public int getTipoEstaciónDeElementoRow(Element elementoRow){
        String tipo = elementoRow.getElementsByTagName("transporttype").item(0).getTextContent();
        switch (tipo){
            case "Tren":
                return Estación.ESTACIÓN_TREN;
            case "Autobús":
                return Estación.ESTACIÓN_AUTOBÚS;
            case "Funicular":
                return Estación.ESTACIÓN_FUNICULAR;
            case "Marítimo":
                return Estación.ESTACIÓN_MARÍTIMA;
            default:
                return Estación.ESTACIÓN_TREN;
        }
    }
}
