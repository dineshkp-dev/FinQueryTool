package financialQueryTool.parseInputOutputPkg;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ParseInputXml {

	public static InputData parseInputData(Path inpuPathXmlLoc) {
		InputData userData = new InputData();
		NodeList nListUserData = ParseInputXml.getInputNodeList(inpuPathXmlLoc);


		for (int i=0; i<nListUserData.getLength(); i++) {
			Node nNode = nListUserData.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) nNode;
				userData.setRequiredParameters((element.getElementsByTagName("RequiredParameters").item(0).getTextContent()).toString().split(","));
				userData.setRequiredStockSymbols(element.getElementsByTagName("RequiredStockSymbols").item(0).getTextContent());
				userData.setTempFile(FileSystems.getDefault().getPath(element.getElementsByTagName("TempFile").item(0).getTextContent()).toAbsolutePath());
				userData.setOutputFile(FileSystems.getDefault().getPath(element.getElementsByTagName("OutputFile").item(0).getTextContent()).toAbsolutePath());
				userData.setQueryType(QueryType.valueOf(element.getElementsByTagName("QueryType").item(0).getTextContent().toUpperCase()));
			}
		}
		return userData;
	}

	/**
	 * Generates a NodeList for easily  parsing the XML input file.
	 * @param inputXmlLoc
	 * @return NodeList list of Nodes within the xml that can be used by the program
	 */
	private static NodeList getInputNodeList(Path inputXmlLoc) {
		NodeList nListUserData = null;

		File inputXmlFile = new File(inputXmlLoc.toFile(), "");
		System.out.println(inputXmlFile.getAbsolutePath().toString());

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document inputDoc = dBuilder.parse(inputXmlFile);
			inputDoc.getDocumentElement().normalize();
			nListUserData = inputDoc.getElementsByTagName("Input");
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return nListUserData;
	}
}
