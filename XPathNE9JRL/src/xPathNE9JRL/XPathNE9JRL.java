package xPathNE9JRL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XPathNE9JRL {

	public static void main(String[] args) {

		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

			Document document = documentBuilder.parse("studentNE9JRL.xml");

			document.getDocumentElement().normalize();

			XPathFactory xPathFactory = XPathFactory.newInstance();
			XPath xPath = xPathFactory.newXPath();

			String expression = "class";

			NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);

			NodeList childs = nodeList.item(0).getChildNodes();

			System.out.println("Összes elem listázása");

			for (int i = 0; i < childs.getLength(); i++) {

				Node node = childs.item(i);

				System.out.println("\n Aktuális elem: " + node.getNodeName());

				if (node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("student")) {

					Element element = (Element) node;

					System.out.println("Hallgató ID: " + element.getAttribute("id"));

					System.out.println(
							"Keresztnév: " + element.getElementsByTagName("keresztnev").item(0).getTextContent());

					System.out.println(
							"Vezetéknév: " + element.getElementsByTagName("vezeteknev").item(0).getTextContent());

					System.out.println("Becenév: " + element.getElementsByTagName("becenev").item(0).getTextContent());

					System.out.println("Kor: " + element.getElementsByTagName("kor").item(0).getTextContent());

				}
			}

			String expression2 = "/class/student[@id=" + "'" + 1 + "'" + "]";

			NodeList elso = (NodeList) xPath.compile(expression2).evaluate(document, XPathConstants.NODESET);

			for (int i = 0; i < elso.getLength(); i++) {
				Node node = elso.item(i);

				System.out.println("\n Az egyes ID-vel rendelkező tanuló: " + node.getNodeName());

				if (node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("student")) {

					Element element = (Element) node;

					System.out.println("Hallgató ID: " + element.getAttribute("id"));

					System.out.println(
							"Keresztnév: " + element.getElementsByTagName("keresztnev").item(0).getTextContent());

					System.out.println(
							"Vezetéknév: " + element.getElementsByTagName("vezeteknev").item(0).getTextContent());

					System.out.println("Becenév: " + element.getElementsByTagName("becenev").item(0).getTextContent());

					System.out.println("Kor: " + element.getElementsByTagName("kor").item(0).getTextContent());

				}
			}

			String expression3 = "*/student";

			NodeList harmadik = (NodeList) xPath.compile(expression3).evaluate(document, XPathConstants.NODESET);

			System.out.println(harmadik.getLength());

			for (int i = 0; i < harmadik.getLength(); i++) {
				Node node = harmadik.item(i);

				System.out.println("\n Studentek listázása újra, viszont már nem csak a class alosztályból: "
						+ node.getNodeName());

				if (node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("student")) {

					Element element = (Element) node;

					System.out.println("Hallgató ID: " + element.getAttribute("id"));

					System.out.println(
							"Keresztnév: " + element.getElementsByTagName("keresztnev").item(0).getTextContent());

					System.out.println(
							"Vezetéknév: " + element.getElementsByTagName("vezeteknev").item(0).getTextContent());

					System.out.println("Becenév: " + element.getElementsByTagName("becenev").item(0).getTextContent());

					System.out.println("Kor: " + element.getElementsByTagName("kor").item(0).getTextContent());

				}
			}

			String expression4 = "/class/student[2]";
			String expression5 = "/class/student[last()]";
			String expression6 = "/class/student[last() - 1]";
			String expression7 = "/class/student[position() < 3]";
			String expression8 = "/class/*";
			String expression9 = "/class/student[@*]";
			String expression10 = "//*";
			String expression11 = "/class/student[kor>20]";
			String expression12 = "/class/student/vezeteknev | // keresztnev";

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
