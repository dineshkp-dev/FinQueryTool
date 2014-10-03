package financialQueryTool;

import financialQueryTool.initiateQueryPkg.InitiateAPIQuery;
import financialQueryTool.initiateQueryPkg.InitiateHistoricalQuery;
import financialQueryTool.initiateQueryPkg.InitiateQueryInterface;
import financialQueryTool.initiateQueryPkg.InitiateYahooWebQuery;

import java.net.URI;
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
		CheckJava.JavaVersion();
		finQuery.go();
	}

	public void go () {
		System.out.println("Starting the Financial Query Tool.");
		System.out.println("....");
		System.out.println("Parsing input file");
		//call to parse input file
		InputData userData = ParseInputXml.parseInputData(inputXmlLoc);
		InitiateQueryInterface initateQuery;


		System.out.println("Stocks obtained: " + userData.getRequiredStockSymbols());
		stockList = GenerateStockList.getStockList(userData.getRequiredStockSymbols());
		System.out.println("Query Type requested by User is: " + userData.getQueryType().toString());
		switch (userData.getQueryType()) {
		case API : System.out.println("Query type is API!!!");
			initateQuery = new InitiateAPIQuery();
//			initateQuery.initiateQuery(stockList, inputData.getOutputFile());
			initateQuery.initiateQuery(stockList, userData.getRequiredParameters(), userData.getOutputFile());
		break;
		case HISTORICAL : System.out.println("Query type is HISTORICAL!!!");
			initateQuery = new InitiateHistoricalQuery();
			initateQuery.initiateQuery(stockList, userData.getOutputFile());
		break;
		case WEBYAHOO : System.out.println("Query type is WEB!!!");
			initateQuery = new InitiateYahooWebQuery();
			initateQuery.initiateQuery(stockList, userData.getRequiredParameters(),userData.getOutputFile());
		break;
		default : System.out.println("Unknown query type detected" + FinancialQueryTool.class);
		break;

		}

		/*		if (inputData.getQueryType() == QueryType.API){
			System.out.println("Query type is API!!!");
		}
		else if (inputData.getQueryType() == QueryType.WEB) {
			System.out.println("Query type is WEB!!!");
		}*/
	}

}
