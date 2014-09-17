package financialQueryTool;

import java.io.IOException;
import java.nio.file.FileSystems;
//import java.jsoup;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class QueryYahooFin {

	public static void main(String[] args) {
		//		String[] stockSymbolArray = {"NFLX", "AAPL", "AMZN", "BIDU", "MA", "GOOG"};
		String[] stockSymbolArray = null;
		Path inputXmlLoc = FileSystems.getDefault().getPath("koreInfoProject", "inputdetails.xml"); // input xml that contains User defined configurations
		Path tempHtmlLoc = null; //temporary storage for the html page from the website (can be used for offline viewing/validation)
		Path csvPath = null; //final output data in csv format, newer data gets appended to the bottom of the file
		Path inputFileLocation = FileSystems.getDefault().getPath("koreInfoProject", "input.txt"); //input file that contains the required items to be queried
		String queriedXML = null; // container for the entire queried html page from the website
		int timeoutVal = 10; //10 -> 10seconds, 5 -> 5seconds


		WToFile writeToTempFile = new WToFile();
		ParseHTML parsetempHtml = new ParseHTML();
		CheckJava.JavaVersion(); //ensures that Java version 1.7 or greater is used

		Map<String, String> stockData = new HashMap<String, String> (); // map that contains the overall data for each of the stock queries
		ArrayList<String> inputRequestArray = new ArrayList<String>(); // container for the data that needs to be queried (user provided)
		ArrayList<String> finalData = new ArrayList<String>(); //container for final data for each of the stock queries (based on 'inputRequestArray' and data from 'stockData')
		ArrayList<String> overallData = new ArrayList<String>(); // container that contains all the data from each of the stock queries and gets written to csv file
		Map<String, String> userInput = new HashMap<String, String>();

		userInput = ParseInputXml.parseInputXml(inputXmlLoc);//(inputHtmlLoc);
		stockSymbolArray = userInput.get("RequiredStockSymbols").split(",");

		System.out.println("Reading the input file: " + inputFileLocation.toAbsolutePath() );

		/*	Reading the input requirements from the user */
		for (String eachItem : userInput.get("reqParams").split(",")) {
			inputRequestArray.add(eachItem);
		}
		tempHtmlLoc = FileSystems.getDefault().getPath(userInput.get("tempFileLoc"));
		csvPath = FileSystems.getDefault().getPath(userInput.get("outputFileLoc"));
		/* Completed reading user input from xml file. */
		/* iterate for each of the stock symbols, for which data needs to be gathered */
		for (String eachStockSymbol : stockSymbolArray ) {
			System.out.println("Querying for : " + eachStockSymbol);
			/* initiate query and store the query results into 'queriedXML' */
						queriedXML = InitiateQuery.queryFromWebsite(eachStockSymbol, timeoutVal);
			/* write the queried data into a temporary html file 'tempHtmlLoc.toString()' (uses the old format of writing files)*/
						writeToTempFile.writeDatatoFile(tempHtmlLoc.toString(), queriedXML);

			if (queriedXML != null) {
				/* get the 'stockData' from the container 'queriedXML'
				 * works in ONLINE-MODE
				 */
				stockData = parsetempHtml.searchFoVal(queriedXML);	//pass the data queried from the Yahoo website
			}
			else {
				/* get the 'stockData' from the temporary file
				 * works in OFFLINE-MODE
				 */
				try {
					stockData = parsetempHtml.readFromYahooFile(tempHtmlLoc); // read and parse the temp html file on local directory
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			finalData = ProcessDataToWrite.dataToWrite(eachStockSymbol, stockData, inputRequestArray);
			overallData.addAll(finalData);
			finalData=null; //resetting the finalData for the next query
		}
		/* 
		 * Write the overall data into the csv file
		 */
		try {
			WriteToCSV.WriteDataToCSV(csvPath, overallData);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
