import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;

public class Inventario {

    ArrayList<Componente> existencias;

    public Inventario() {
        existencias = new ArrayList<Componente>();
    }

    public void addExistencia(Componente existencia, int cantidadInicial) {
        // TODO Comprobar que no existe ya
        existencia.setCantidad(cantidadInicial);
        existencias.add(existencia);
    }

    public void reponer(String id, int cantidad) {
        Iterator<Componente> itExistencia = existencias.iterator();
        while (itExistencia.hasNext()) {
            Componente existencia = itExistencia.next();
            if (existencia.getId().equals(id))
                existencia.setCantidad(existencia.getCantidad() + cantidad);
        }
    }

    public void contabilizarProducto(Producto producto) {
        Iterator<Componente> itEspecificaciones = producto.getEspecificaciones().iterator();
        while (itEspecificaciones.hasNext()) {
            Componente especificación = itEspecificaciones.next();
            Iterator<Componente> itExistencias = existencias.iterator();
            boolean encontrado = false;
            while ((itExistencias.hasNext()) && (!encontrado)) {
                Componente existencia = itExistencias.next();
                if (existencia.equals(especificación)) {
                    existencia.setCantidad(existencia.getCantidad() - especificación.getCantidad());
                    encontrado = true;
                }
            }
        }
    }

    public ArrayList<Componente> minimasExistencias(Producto producto) {
        ArrayList<Componente> escasos = new ArrayList<Componente>();
        Iterator<Componente> itEspecificaciones = producto.getEspecificaciones().iterator();
        while (itEspecificaciones.hasNext()) {
            Componente especificación = itEspecificaciones.next();
            Iterator<Componente> itExistencias = existencias.iterator();
            boolean encontrado = false;
            while ((itExistencias.hasNext()) && (!encontrado)) {
                Componente existencia = itExistencias.next();
                if (existencia.equals(especificación)) {
                    if (existencia.getCantidad() - especificación.getCantidad() * 10 < 0)
                        escasos.add(existencia);
                    encontrado = true;
                }
            }
        }
        return escasos;
    }

    @Override
    public String toString() {
        // TODO mejorar presentación
        return "Inventario{" +
                "existencias=" + existencias +
                '}';
    }

    public void leerXML(String nombreArchivo) {
        String dir = System.getProperty("user.dir");
        System.out.println(dir);
        try {
            File inputFile = new File(dir + File.separator + nombreArchivo);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            XPath xPath = XPathFactory.newInstance().newXPath();
            String xpathExpr = "/inventario/componente";
            NodeList nodeList = (NodeList) xPath.compile(xpathExpr).evaluate(doc, XPathConstants.NODESET);

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element elementoExistencia = (Element) nodeList.item(i);
                String id = elementoExistencia.getAttribute("id");
                int cantidad = Integer.parseInt(elementoExistencia.getAttribute("existencias"));
                existencias.add(new Componente(id, cantidad));
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

    }

    public void escribirXML(String nombreArchivo) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();


            String xmlSerializado = "<inventario>";
            Iterator<Componente> itComponente = existencias.iterator();
            while (itComponente.hasNext()) {
                Componente componete = itComponente.next();
                xmlSerializado += "<componente id=\"" + componete.getId() + "\" existencias=\"" + componete.getCantidad() + "\"/>";
            }
            xmlSerializado += "</inventario>";
            Document doc = db.parse(new InputSource(new StringReader(xmlSerializado)));
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(nombreArchivo));
            transformer.setOutputProperty(OutputKeys.INDENT,"yes");
            transformer.transform(source, result);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
// CREAR UN GESTORXML aparte
// INCLUR MÉTODOS EN INVENTARIO
}