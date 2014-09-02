package financialQueryTool;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FinancialQueryTool {
	Path inputXmlLoc = FileSystems.getDefault().getPath("inputdetails.xml"); // input xml that contains User defined configurations
	Map<String, String> inputMap = new HashMap<>();  // should create a inputData class to have different data types (esp. QueryType)
	ArrayList<Stock> stockList = new ArrayList<Stock>();
	URI queryUri = null;
	

	public static void main(String[] args) {
		FinancialQueryTool finQuery = new FinancialQueryTool();
		finQuery.go();
		
	}
	
	public void go () {
		System.out.println("Starting the Financial Query Tool.");
		System.out.println("....");
		System.out.println("Parsing input file");
		//call to parse input file
//		ParseInputXml inputDetails = new ParseInputXml();
		inputMap = ParseInputXml.parseInputXml(inputXmlLoc);
		
		System.out.println("Stocks obtained: " + inputMap.get("RequiredStockSymbols"));
		stockList = GenerateStockList.getStockList(inputMap.get("RequiredStockSymbols"));
		System.out.println(stockList.get(0).getStockName());
		//[reqParams, outputFileLoc, tempFileLoc, RequiredStockSymbols, queryType]
		System.out.println(inputMap.get("queryType"));
		String queryType = "";
		if (QueryType.API.toString() != queryType) {
			GenerateURI apiUri = new GenerateApiUri();
			try {
				queryUri = apiUri.getURI(stockList);
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
			System.out.println("URI to be used for query is: " + queryUri.toString());
		}
//		if (query)
	}

}
