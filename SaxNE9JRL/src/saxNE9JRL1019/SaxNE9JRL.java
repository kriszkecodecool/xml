package saxNE9JRL1019;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

@SuppressWarnings("unused")
public class SaxNE9JRL {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

		SAXParser saxParser = saxParserFactory.newSAXParser();

		SaxHandler handler = new SaxHandler();

		saxParser.parse(new File("szemelyekNE9JRL.xml"), handler);

	}

}
