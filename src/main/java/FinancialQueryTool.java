package main.java;

import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.management.RuntimeErrorException;

import main.java.financialQueryTool.initiateQueryPkg.InitiateAPIQuery;
import main.java.financialQueryTool.initiateQueryPkg.InitiateHistoricalQuery;
import main.java.financialQueryTool.initiateQueryPkg.InitiateQueryInterface;
import main.java.financialQueryTool.initiateQueryPkg.InitiateYahooWebQuery;
import main.java.financialQueryTool.parseInputOutputPkg.InputData;
import main.java.financialQueryTool.parseInputOutputPkg.ParseInputXml;
import main.java.financialQueryTool.stockPkg.GenerateStockList;
import main.java.financialQueryTool.stockPkg.Stock;

public class FinancialQueryTool {
	Path inputXmlLoc = FileSystems.getDefault().getPath("inputdetails.xml"); // input xml that contains User defined configurations
	Map<String, String> inputMap = new HashMap<>();  // should create a inputData class to have different data types (esp. QueryType)
	ArrayList<Stock> stockList = new ArrayList<Stock>();
	URI queryUri = null;



	public static void main(String[] args) {
		FinancialQueryTool finQuery = new FinancialQueryTool();
		CheckJava checkJava = new CheckJava();
		checkJava.JavaVersion();
		finQuery.go(args);
	}

	public void go(String[] inputFileLoc) {
		System.out.println("Starting the Financial Query Tool.");
		System.out.println("....");
		System.out.println("Parsing input file");

		if (inputFileLoc.length == 1){
			System.out.println("Using the User provided input file location: " + inputFileLoc[0].toString());
			inputXmlLoc = FileSystems.getDefault().getPath(inputFileLoc[0]);
		}
		else if (inputFileLoc.length > 1){
			throw new RuntimeErrorException(null, "Invalid arguments passed to the Tool.");
		}

		if (!inputXmlLoc.toFile().exists()) {
			throw new RuntimeErrorException(null, "Input File not found at: " + inputXmlLoc.toAbsolutePath().toString());
		}
		//call to parse input file
		InputData userData = ParseInputXml.parseInputData(inputXmlLoc);
		InitiateQueryInterface initateQuery;// Try to use abstract Factory Design to create new objects

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
