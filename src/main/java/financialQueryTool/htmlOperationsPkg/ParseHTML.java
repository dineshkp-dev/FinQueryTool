
package main.java.financialQueryTool.htmlOperationsPkg;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author dineshkp
 *
 */
public class ParseHTML {

	/**
	 * Creates a HTML Doc from the 'String xmlValue' and extracts the required data from the doc file
	 * Uses Jsoup for HTML Parsing (treated as an xml)
	 * 
	 * @param xmlValue String input containing the HTML page
	 * @return mappedData Map of all the required Headers vs Data
	 */
	public Map<String, String> searchFoVal(String xmlValue) {
		Map<String, String> mappedData = new HashMap<String, String>();
		Document doc =Jsoup.parse(xmlValue);
		mappedData = extractReqdDatafrmYahooWebsite(doc);
		return mappedData;
	}

	/**
	 * Parse the HTML Document to create a map of required Headers vs Data
	 * Works on finance.yahoo.com website only
	 * @param doc Document (Jsoup) HTML file format
	 * @return mappedData Map of all the required Headers vs Data
	 */
	public static Map<String, String> extractReqdDatafrmYahooWebsite (Document doc) {
		Map<String, String> mappedData = new HashMap<String, String>();

		System.out.println("*********************");
		System.out.println("Extracting the required data from page: ParseHTML.extractReqdDatafrmYahooWebsite");
		System.out.println("Document title is: "+doc.title());
		Elements tableElement = doc.getElementsByClass("yfi_quote_summary").select("tr"); //This is the Content that we are interested in.
		for (Element eachTableElement : tableElement) { //stepping through each element of the table
//						System.out.println(eachTableElement.select("th").text());  //Enable for DEBUG, this prints the table headers
			mappedData.put(eachTableElement.select("th").text(), eachTableElement.select("td").text());
//						System.out.println(eachTableElement.select("td").text()); //Enable for DEBUG, this prints the table data
		}
		System.out.println("*********************");

		return mappedData;

	}

	/**
	 * Creates a HTML Document by reading from a HTML file on the disk.
	 * Works on finance.yahoo.com website only
	 * @param fileName Path which points to the HTML file on the disk. 
	 * @return mappedData Map of all the required Headers vs Data
	 */
	public Map<String, String> readFromYahooFile(Path fileName) {

		System.out.println("Reading from the file: " + fileName.toAbsolutePath());
		String lines="";
		String xmlVal = "";
		Map<String, String> mappedData = new HashMap<String, String>();

		try {
			BufferedReader xmlReader = Files.newBufferedReader(fileName, StandardCharsets.UTF_8);
			while ( (lines = xmlReader.readLine()) != null) {
				xmlVal = lines;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		Document doc = Jsoup.parse(xmlVal);
		mappedData = extractReqdDatafrmYahooWebsite(doc);
		return mappedData;
	}
}
