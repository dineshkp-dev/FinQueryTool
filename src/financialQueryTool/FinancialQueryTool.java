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
	GenerateURI apiUri = new GenerateApiUri();


	public static void main(String[] args) {
		FinancialQueryTool finQuery = new FinancialQueryTool();
		finQuery.go();
	}

	public void go () {
		System.out.println("Starting the Financial Query Tool.");
		System.out.println("....");
		System.out.println("Parsing input file");
		//call to parse input file
		InputData inputData = ParseInputXml.parseInputData(inputXmlLoc);
		InitiateAPIQuery initateQuery;


		System.out.println("Stocks obtained: " + inputData.getRequiredStockSymbols());
		stockList = GenerateStockList.getStockList(inputData.getRequiredStockSymbols());
		System.out.println(stockList.get(0).getStockName());
		System.out.println("Query Type requested by User is: " + inputData.getQueryType().toString());
		String queryType = "";
		/*		if (QueryType.API.toString() != queryType) {
			GenerateURI apiUri = new GenerateApiUri();
			try {
				queryUri = apiUri.getURI(stockList);
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
			System.out.println("URI to be used for query is: " + queryUri.toString());
		}*/
		//		if (query)
		try {
			switch (inputData.getQueryType()) {
			case API : System.out.println("Query type is API!!!");
				queryUri = apiUri.getURI(stockList);
				initateQuery = new InitiateAPIQuery();
				initateQuery.queryFromApi(queryUri, inputData.getOutputFile());
			break;
			case HISTORICAL : System.out.println("Query type is HISTORICAL!!!");
			break;
			case WEB : System.out.println("Query type is WEB!!!");
			break;
			default : System.out.println("Unknown query type detected" + FinancialQueryTool.class);
			break;

			}
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		/*		if (inputData.getQueryType() == QueryType.API){
			System.out.println("Query type is API!!!");
		}
		else if (inputData.getQueryType() == QueryType.WEB) {
			System.out.println("Query type is WEB!!!");
		}*/
	}

}
