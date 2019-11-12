import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.xpath.XPathExpressionException;

public class ProbandoXPath {
	public static void main(String[] args) {
		XPathEvaluator eval = new XPathEvaluator("songlist.xml");

		try {
			NodeList nodeSet = eval.evaluateXPath("/listas/lista");
			for (int k = 0; k < nodeSet.getLength(); k++) {
				Element e = (Element) nodeSet.item(k);
				NodeList canciones = e.getChildNodes();
				System.out.println("Longitud del nodeset: " + canciones.getLength());
				for (int i = 0; i < canciones.getLength(); i++) {
					if (canciones.item(i).getNodeType() == Element.ELEMENT_NODE) {
						Element cancion = (Element) canciones.item(i);
						System.out.println(cancion.getTextContent());
						System.out.println(cancion.getAttribute("id"));
						System.out.println(cancion.getAttribute("duracion"));
					}
				}
			}
			/*Element e = (Element) nodeSet.item(0);
			System.out.println(e.getAttribute(""));

			NodeList canciones = e.getElementsByTagName("cancion");
			for (int i=0; i<canciones.getLength(); i++){
				Element cancion = (Element) canciones.item(i);
				System.out.print("ID: " +cancion.getAttribute("id"));
				System.out.println("DURACIÓN: " + cancion.getAttribute("duracion"));
				System.out.println("NOMBRE: " + cancion.getTextContent());

			}
			/*NodeList canciones.item(0).getChildNodes();
			System.out.println(canciones.item(0).hasAttributes());
			System.out.println(canciones.item(0).getAttribute(
			for (int i=0; i<hijosDeCancion_0.getLength(); i++){
				System.out.println(hijosDeCancion_0.item(i).getTextContent());

			}*/
			/*ELEMENT_NODE = 1
				ATTRIBUTE_NODE = 2
				TEXT_NODE = 3
			 */
			/*for (int i=0; i<nodeSet.getLength();i++){
				if (nodeSet.item(i).getNodeType() == Element.ELEMENT_NODE){
					Element elemento = (Element) nodeSet.item(i);
					System.out.println("ELEMENTO:"+elemento.getNodeName());
					System.out.println("ATRIBUTO ID:"+elemento.getAttribute("id"));
					System.out.println("ATRIBUTO DURACIÓN:"+elemento.getAttribute("duracion"));
					NodeList nodosHijos = elemento.getChildNodes();
					for (int j=0; j< nodosHijos.getLength(); j++){
						if (nodosHijos.item(j).getNodeType() == Element.TEXT_NODE)
							System.out.println("CONTENIDO"+nodosHijos.item(j).getTextContent());
					}
				}
			}*/
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}

	}
}
