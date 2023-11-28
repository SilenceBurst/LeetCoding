package parser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ManifestParser {

    public static void main(String[] args) {
        try {
            File manifestFile = new File("/Users/sign/Desktop/AndroidManifest.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(manifestFile);

            List<Node> notDeclareList = new ArrayList<>();

            NodeList activities = document.getElementsByTagName("activity");
            printComponentsInfo(activities, "Activity", notDeclareList);

            NodeList services = document.getElementsByTagName("service");
            printComponentsInfo(services, "Service", notDeclareList);

            NodeList receivers = document.getElementsByTagName("receiver");
            printComponentsInfo(receivers, "Receiver", notDeclareList);

            System.out.println("===============printCopyCode==============");
            printCopyCode(notDeclareList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printCopyCode(List<Node> notDeclareList) {
        for (Node node : notDeclareList) {
            Element element = (Element) node;
            String elementName = element.getAttribute("android:name");
            System.out.println("<" + node.getNodeName() + " android:name=\"" + elementName + "\" " + "android:exported=\"false\"" + " tools:node=\"merge\"" + " />");
        }
    }

    private static void printComponentsInfo(NodeList nodeList, String componentName, List<Node> notDeclareList) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String name = element.getAttribute("android:name");
                String exported = element.getAttribute("android:exported");
                NodeList intentFilters = element.getElementsByTagName("intent-filter");
                if (intentFilters.getLength() > 0) {
                    System.out.println(componentName + " Name: " + name);
                    System.out.println("Exported: " + (exported.isEmpty() ? "Not declared" : exported));
                    if (exported.isEmpty()) {
                        notDeclareList.add(node);
                    }
                }
            }
        }
    }
}
