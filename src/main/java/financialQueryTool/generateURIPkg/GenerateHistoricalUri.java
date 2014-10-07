package main.java.financialQueryTool.generateURIPkg;

import java.net.URI;

import main.java.financialQueryTool.stockPkg.Stock;

public class GenerateHistoricalUri extends GenerateURI {

	public static URI getHistoricalUri(Stock stock) {
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
}
