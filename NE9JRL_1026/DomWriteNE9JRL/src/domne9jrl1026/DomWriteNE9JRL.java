package domne9jrl1026;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DomWriteNE9JRL {

	public static void main(String[] args) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder docBuilder = dbf.newDocumentBuilder();

			Document doc = docBuilder.newDocument();

			Element rootElement = doc.createElement("users");
			rootElement.setAttribute("xmlns", "domNE9JRL");
			doc.appendChild(rootElement);

			Element user = doc.createElement("user");
			rootElement.appendChild(user);
			user.setAttribute("id", "1");

			Element firstname = doc.createElement("firstname");
			firstname.setTextContent("Iváncsik");
			user.appendChild(firstname);

			Element lastname = doc.createElement("lastname");
			lastname.setTextContent("Krisztián");
			user.appendChild(lastname);

			Element profession = doc.createElement("profession");
			profession.setTextContent("Tanuló");
			user.appendChild(profession);

			try {
				FileOutputStream fos = new FileOutputStream(new File("users1NE9JRL.xml"));
				writeXml(doc, fos);
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void writeXml(Document doc, OutputStream output) {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		try {
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			StreamResult result = new StreamResult(output);
			StreamResult result2 = new StreamResult(System.out);
			transformer.transform(source, result);
			transformer.transform(source, result2);

		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
