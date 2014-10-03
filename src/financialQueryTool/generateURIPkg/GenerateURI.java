package financialQueryTool.generateURIPkg;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import financialQueryTool.QueryType;
import financialQueryTool.Stock;
import financialQueryTool.parametersPkg.ParamListInterface;

public abstract class GenerateURI {
	public ArrayList<Stock> stocks;
	public String[] stockParameters;
	public QueryType queryType; //ENUM = api/historical/web

	public String[] getStockParameters() {
		return stockParameters;
	}
	public QueryType getQueryType() {
		return queryType;
	}
	public void setStockParameters(String[] stockParameters) {
		this.stockParameters = stockParameters;
	}
	public void setQueryType(QueryType type) {
		this.queryType = type;
	}

	public URI getURI() throws URISyntaxException{
		System.out.println("Generating the URI.");
		return null;
	}
	public URI getURI(ArrayList<Stock> stocks) {
		System.out.println("Generating the URI.");
		return null;
	}
	public URI getURI(ArrayList<Stock> stocks, ArrayList<ParamListInterface> applicableQueryParams){
		System.out.println("Generating the URI.");
		return null;
	}

	public URI getURI(Stock stock, ArrayList<ParamListInterface> applicableQueryParams){
		System.out.println("Generating the URI.");
		return null;
	}
	public URI getURI(Stock stock) {
		System.out.println("Generating the URI, no Parameters List provided.");
		return null;
	}
}
