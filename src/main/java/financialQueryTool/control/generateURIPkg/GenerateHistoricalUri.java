package main.java.financialQueryTool.control.generateURIPkg;

import java.net.URI;
import java.util.ArrayList;

import javax.management.RuntimeErrorException;

import main.java.financialQueryTool.model.stockPkg.Stock;
import main.java.financialQueryTool.view.parseInputOutputPkg.QueryType;

public class GenerateHistoricalUri extends GenerateURI {

	public URI getURI(Stock stock) {
		if (stock.isStockInvalid()){
			throw new RuntimeException("Stock is not valid");
		}
		URI finalUri = null;
		String baseUri = "http://ichart.finance.yahoo.com/table.csv?s=";
		String beginYr = "&c=1962";
		
		finalUri = URI.create(baseUri + stock.getStockName() + beginYr);
		return finalUri;
	}
	/* http://ichart.finance.yahoo.com/table.csv?s=GOOG&c=1962
	 * http://ichart.finance.yahoo.com/table.csv?s=GOOG&c=1962
	 * http://ichart.yahoo.com/table.csv?s=GOOG&c=1962
	 */
	public QueryType getQueryType() {
		return QueryType.HISTORICAL;
	}
	@Override
	public URI getURI(ArrayList<Stock> stocks) {
		throw new RuntimeErrorException(null, "HISTORICAL QUERY URI generation currently doesnt support Multiple Stock queries.");
	}
	@Override
	public URI getURI() throws RuntimeException{
		throw new RuntimeErrorException(null, "HISTORICAL QUERY URI generation requires a Stock Parameter.");
	}
}
