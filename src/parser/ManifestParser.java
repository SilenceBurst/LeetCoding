package parser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ManifestParser {

    public static void main(String[] args) {
        try {
            File manifestFile = new File("/Users/sign/Desktop/AndroidManifest.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(manifestFile);

            NodeList activities = document.getElementsByTagName("activity");
            printComponentsInfo(activities, "Activity");

            NodeList services = document.getElementsByTagName("service");
            printComponentsInfo(services, "Service");

            NodeList receivers = document.getElementsByTagName("receiver");
            printComponentsInfo(receivers, "Receiver");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printComponentsInfo(NodeList nodeList, String componentName) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String name = element.getAttribute("android:name");
                String exported = element.getAttribute("android:exported");
                System.out.println(componentName + " Name: " + name);
                System.out.println("Exported: " + (exported.isEmpty() ? "Not declared" : exported));
            }
        }
    }
}
