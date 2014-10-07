package main.java.financialQueryTool.initiateQueryPkg;

import java.net.URI;
import java.nio.file.Path;
import java.util.ArrayList;

import main.java.financialQueryTool.stockPkg.Stock;

public interface InitiateQueryInterface {
	// Display the stock information in HTML
	public void printURI();
	public void printStock();
	public URI getURI();
	public URI setURI();
	public String initiateQuery(String stockSymbol);
	public void initiateQuery(ArrayList<Stock> stockList, String[] requiredParameters, Path outputFile);
	public void initiateQuery(ArrayList<Stock> stockList, Path outputFile);
}
