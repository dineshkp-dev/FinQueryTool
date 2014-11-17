package main.java.financialQueryTool.control.generateURIPkg;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.management.RuntimeErrorException;

import main.java.financialQueryTool.control.queryParametersPkg.APIQueryParameters;
import main.java.financialQueryTool.control.queryParametersPkg.QueryParamInterface;
import main.java.financialQueryTool.model.stockPkg.Stock;
import main.java.financialQueryTool.view.parseInputOutputPkg.QueryType;
/*
 * "http://finance.yahoo.com/d/quotes.csv?s=AAPL+GOOG+MSFT&f=nab"
 * */
public class GenerateApiUri extends GenerateURI {

	//	String[] stockParams = {ApiParamMap.Name.val, ApiParamMap.Ask.val, ApiParamMap.AverageVolume.val, ApiParamMap.Bid.val, ApiParamMap.DaysRange.val, ApiParamMap.DividendYield.val, 
	//			ApiParamMap.EarningsPerShare.val, ApiParamMap.MarketCap.val, ApiParamMap.OneYearTarget.val, ApiParamMap.Open.val, ApiParamMap.PERatio.val, ApiParamMap.PreviousClose.val, 
	//			ApiParamMap.Volume.val, ApiParamMap.Week52Range.val};

	@Override
	public URI getURI(ArrayList<Stock> stocks){
		if (stocks.size() <1) {
			throw new RuntimeException("No Stocks found. Please check the input.");
		}
		System.out.println("Generating the API URI : " + this.getClass());

		URI finalURI = null;
		String stockNamesStr = "";
		QueryParamInterface getAllParams = new APIQueryParameters();

		for (Stock eachStock : stocks){
			stockNamesStr = stockNamesStr + "+" + eachStock.getStockName();
		}
		stockNamesStr = stockNamesStr.substring(1);
		try {
			finalURI = new URI ("http://finance.yahoo.com/d/quotes.csv?s=" + stockNamesStr + "&f=" + getAllParams.getAllQueryParams());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return finalURI;
	}
	
	@Override
	public URI getURI(Stock stock){
		if (stock.getStockNameStr().isEmpty()) {
			throw new RuntimeException("Invalid Stock name.");
		}
		System.out.println("Generating the API URI : " + this.getClass());

		URI finalURI = null;
		QueryParamInterface getAllParams = new APIQueryParameters();

		try {
			finalURI = new URI ("http://finance.yahoo.com/d/quotes.csv?s=" + stock.getStockNameStr() + "&f=" + getAllParams.getAllQueryParams());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return finalURI;
	}

	public QueryType getQueryType() {
		return QueryType.API;
	}
	
	@Override
	public URI getURI() throws RuntimeException{
		throw new RuntimeErrorException(null, "API URI generation requires at least one Stock Parameter.");
	}

}
