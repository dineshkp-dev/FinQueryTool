package financialQueryTool;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

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
		InputData inputData = new InputData();
		NodeList nListUserData = ParseInputXml.getInputNodeList(inpuPathXmlLoc);


		for (int i=0; i<nListUserData.getLength(); i++) {
			Node nNode = nListUserData.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) nNode;
				inputData.setRequiredParameters(element.getElementsByTagName("RequiredParameters").item(0).getTextContent());
				inputData.setRequiredStockSymbols(element.getElementsByTagName("RequiredStockSymbols").item(0).getTextContent());
				inputData.setTempFile(FileSystems.getDefault().getPath(element.getElementsByTagName("TempFile").item(0).getTextContent()).toAbsolutePath());
				inputData.setOutputFile(FileSystems.getDefault().getPath(element.getElementsByTagName("OutputFile").item(0).getTextContent()).toAbsolutePath());
				inputData.setQueryType(QueryType.valueOf(element.getElementsByTagName("QueryType").item(0).getTextContent()));
			}
		}
		return inputData;
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


	public static Map<String, String> parseInputXml(Path inputXmlLoc) {
		/*
		 * inputHTML file should have the following elements
		 * tempfileLoc
		 * outputcsvLoc
		 * reqdStockSymbols
		 * reqdStockParams
		 */
		//		XML
		Map<String, String> parsedInputs = new HashMap<String, String>();
		String reqSymbols = "";
		String reqParams = "";
		String tempFileLoc = "";
		String outputFileLoc = "";
		String queryType = "";
		NodeList nListUserData = ParseInputXml.getInputNodeList(inputXmlLoc);
		for (int i =0; i<nListUserData.getLength(); i++){
			Node nNode = nListUserData.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				reqSymbols = eElement.getElementsByTagName("RequiredStockSymbols").item(0).getTextContent();
				reqParams = eElement.getElementsByTagName("RequiredParameters").item(0).getTextContent();

				System.out.println("RequiredStockSymbols : " + reqSymbols);
				System.out.println("RequiredParameters : " + reqParams);
				tempFileLoc = eElement.getElementsByTagName("TempFile").item(0).getTextContent();
				outputFileLoc = eElement.getElementsByTagName("OutputFile").item(0).getTextContent();
				queryType = eElement.getElementsByTagName("QueryType").item(0).getTextContent();
				System.out.println("TempFile Location : " + tempFileLoc);
				System.out.println("OutputFile : " + outputFileLoc);
				parsedInputs.put("RequiredStockSymbols", reqSymbols);
				parsedInputs.put("reqParams", reqParams);
				parsedInputs.put("tempFileLoc", tempFileLoc);
				parsedInputs.put("outputFileLoc", outputFileLoc);
				parsedInputs.put("queryType", queryType);
			}
		}
		return parsedInputs;
	}

}
