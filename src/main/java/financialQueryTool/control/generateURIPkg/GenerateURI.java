package main.java.financialQueryTool.control.generateURIPkg;

import java.net.URI;
import java.util.ArrayList;

import main.java.financialQueryTool.model.stockPkg.Stock;
import main.java.financialQueryTool.view.parseInputOutputPkg.QueryType;

public abstract class GenerateURI {
	public ArrayList<Stock> stocks;
	public String[] stockParameters;
	public QueryType queryType; //ENUM = api/historical/web

	public QueryType getQueryType() {
		return queryType;
	}
	public URI getURI(){
		System.out.println("Generating the URI.");
		return null;
	}
	public URI getURI(ArrayList<Stock> stocks) {
		System.out.println("Generating the URI.");
		return null;
	}
	public URI getURI(Stock stock) {
		System.out.println("Generating the URI, no Parameters List provided.");
		return null;
	}
}
