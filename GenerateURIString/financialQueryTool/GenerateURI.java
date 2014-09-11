package financialQueryTool;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

public abstract class GenerateURI {
	public ArrayList<Stock> stocks;
	public String[] stockParameters;
	public QueryType queryType; //ENUM = api/historical/web
	
/*	public ArrayList<Stock> getStockNames() {
		return stocks;
	}*/
	public String[] getStockParameters() {
		return stockParameters;
	}
	public QueryType getQueryType() {
		return queryType;
	}
/*	public void setStockNames(String[] stockNames) {
		this.stocks = stocks;
	}*/
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
}
