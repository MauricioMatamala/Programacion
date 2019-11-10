import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.xpath.XPathExpressionException;

public class ProbandoXPath {
	public static void main(String[] args) {
		XPathEvaluator eval = new XPathEvaluator("songlist.xml");

		try {
			NodeList nodeSet = eval.evaluateXPath("/listas/lista[@name='Lista de TripHop']/song");
			Element e = (Element) nodeSet.item(0);
			Element.ATTR
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
