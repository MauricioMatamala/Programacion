import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
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
import java.util.TreeMap;

public class Proyectos {
	private TreeMap<String,Proyecto> proyectos;

	public Proyectos(){
		proyectos = new TreeMap<String,Proyecto>();
	}

	public void leer(String nombreFicheroXML){
		String dir = System.getProperty("user.dir");
		System.out.println(dir);
		try {
			File inputFile = new File(dir + File.separator + nombreFicheroXML);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();

			XPath xPath = XPathFactory.newInstance().newXPath();
			String xpathExpr = "/proyectos/proyecto";
			NodeList nodeList = (NodeList) xPath.compile(xpathExpr).evaluate(doc, XPathConstants.NODESET);

			for (int i=0; i<nodeList.getLength();i++){
				Node nodoProyecto = nodeList.item(i);
				NamedNodeMap atributos = nodoProyecto.getAttributes();
				String nombreProyecto = atributos.getNamedItem("nombre").getTextContent();
				String departamentoProyecto = atributos.getNamedItem("departamento").getTextContent();
				double fprodProyecto  = Double.parseDouble(atributos.getNamedItem("fprod").getTextContent());
				String descripción = nodoProyecto.getTextContent();
				proyectos.put(nombreProyecto,new Proyecto(nombreProyecto,departamentoProyecto,fprodProyecto,descripción));
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

	public Proyecto getProyectoPorNombre(String nombreProyecto){
		return proyectos.get(nombreProyecto);
	}

	@Override
	public String toString() {
		return proyectos.toString();
	}
}
