import static org.junit.Assert.fail;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@SuppressWarnings("javadoc")
public class VerifyPluginTest {

    @Test
    public void shouldHaveAllClasses() throws SAXException, IOException, ParserConfigurationException {
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(getClass().getResourceAsStream(
            "/plugin.xml"));
        NodeList els = doc.getDocumentElement().getElementsByTagName("class");
        for (int i = 0; i < els.getLength(); i++) {
            String attribute = ((Element) els.item(i)).getAttribute("value");
            try {
                Class.forName(attribute);
            } catch (@SuppressWarnings("unused") ClassNotFoundException e) {
                fail("VerifyPluginTest.shouldHaveAllClasses() " + attribute);
            }
        }
    }
}
