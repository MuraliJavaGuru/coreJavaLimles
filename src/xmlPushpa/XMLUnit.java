package xmlPushpa;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLUnit {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		System.out.println(compareXMLs("source.xml", "target.xml"));
	}

	public static int compareXMLs(String xml1, String xml2)
			throws ParserConfigurationException, SAXException, IOException {
		Document sourceDoc = getDocumentinstance(xml1);
		Document targetDoc = getDocumentinstance(xml2);

		Element sourceRoot = sourceDoc.getDocumentElement();
		Element targetRoot = targetDoc.getDocumentElement();

		if (!sourceRoot.getNodeName().equals(targetRoot.getNodeName())) {
			return 1;
		} else {
			Items src = new Items(sourceRoot.getNodeName());
			processNodes(src, sourceRoot);
			Items target = new Items(targetRoot.getNodeName());
			processNodes(target, targetRoot);
			//System.out.println(src);
			//System.out.println(target);
			return src.equals(target) ? 0 : 1;
		}
	}

	private static Document getDocumentinstance(String xml)
			throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File(xml));
		document.getDocumentElement().normalize();
		return document;
	}

	private static void processNodes(Items parent, Node source) {
		updateAttributesMap(parent, source);

		NodeList sourceList = source.getChildNodes();
		for (int temp = 0; temp < sourceList.getLength(); temp++) {
			Node sourceNode = sourceList.item(temp);
			if (sourceNode.getNodeType() == Node.ELEMENT_NODE) {
				String elementName = sourceNode.getNodeName();
				if (isSimpleElement(sourceNode)) {
					parent.addSimpleElement(elementName, sourceNode.getTextContent());
				} else {
					Items items = new Items(elementName);
					parent.addSubElement(items);
					processNodes(items, sourceNode);
				}
			}
		}
	}

	private static boolean isSimpleElement(Node node) {
		return node.getChildNodes().getLength() == 1;
	}

	private static void updateAttributesMap(Items parent, Node node) {
		if (node.hasAttributes()) {
			NamedNodeMap nodeMap = node.getAttributes();
			for (int i = 0; i < nodeMap.getLength(); i++) {
				Node sourceNodeAttr = nodeMap.item(i);
				String nodeName = sourceNodeAttr.getNodeName();
				if (nodeName.equalsIgnoreCase("id")) {
					continue;
				}
				parent.addAttributes(nodeName, sourceNodeAttr.getNodeValue());
			}
		}
	}
}

class Items {
	String nodeName = "";
	Map<String, List<String>> simpleElements = new HashMap<>();
	Map<String, List<String>> attributes = new HashMap<>();
	List<Items> subElements = new ArrayList<>();

	public Items() {
		super();
	}

	public Items(String nodeName) {
		super();
		this.nodeName = nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	@Override
	public String toString() {
		return "Items [nodeName=" + nodeName + ", simpleElements=" + simpleElements + ", attributes=" + attributes
				+ ", subElements=" + subElements + "]";
	}

	public void addSubElement(Items subElement) {
		subElements.add(subElement);
	}

	public Map<String, List<String>> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, List<String>> attributes) {
		this.attributes = attributes;
	}

	public Map<String, List<String>> getSimpleElements() {
		return simpleElements;
	}

	public void addSimpleElement(String elementName, String textContent) {
		List<String> list = simpleElements.get(elementName);
		if (list == null) {
			list = new ArrayList<>();
		}
		list.add(textContent);
		Collections.sort(list);
		simpleElements.put(elementName, list);
	}

	public void addAttributes(String elementName, String textContent) {
		List<String> list = attributes.get(elementName);
		if (list == null) {
			list = new ArrayList<>();
		}
		list.add(textContent);
		Collections.sort(list);
		attributes.put(elementName, list);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attributes == null) ? 0 : attributes.hashCode());
		result = prime * result + ((nodeName == null) ? 0 : nodeName.hashCode());
		result = prime * result + ((simpleElements == null) ? 0 : simpleElements.hashCode());
		result = prime * result + ((subElements == null) ? 0 : subElements.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Items other = (Items) obj;

		if (!simpleElements.equals(other.simpleElements))
			return false;

		for (Items item : subElements) {
			if (!other.subElements.contains(item)) {
				return false;
			}
		}
		if (!attributes.equals(other.attributes))
			return false;

		if (!nodeName.equals(other.nodeName))
			return false;
		return true;
	}
}
