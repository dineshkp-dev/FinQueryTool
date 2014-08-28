package financialQueryTool;

import java.net.URI;
import java.net.URISyntaxException;

public abstract class GenerateURI {
	public String[] stockNames;
	public String[] stockParameters;
	public QueryType queryType; //ENUM = api/historical/web
	
	public String[] getStockNames() {
		return stockNames;
	}
	public String[] getStockParameters() {
		return stockParameters;
	}
	public QueryType getQueryType() {
		return queryType;
	}
	public void setStockNames(String[] stockNames) {
		this.stockNames = stockNames;
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
}
