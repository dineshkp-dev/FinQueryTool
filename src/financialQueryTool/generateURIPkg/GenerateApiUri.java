package financialQueryTool.generateURIPkg;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import financialQueryTool.parseInputOutputPkg.QueryType;
import financialQueryTool.queryParametersPkg.APIQueryParameters;
import financialQueryTool.queryParametersPkg.QueryParamInterface;
import financialQueryTool.stockPkg.Stock;
/*
 * "http://finance.yahoo.com/d/quotes.csv?s=AAPL+GOOG+MSFT&f=nab"
 * */
public class GenerateApiUri extends GenerateURI {

	//	String[] stockParams = {ApiParamMap.Name.val, ApiParamMap.Ask.val, ApiParamMap.AverageVolume.val, ApiParamMap.Bid.val, ApiParamMap.DaysRange.val, ApiParamMap.DividendYield.val, 
	//			ApiParamMap.EarningsPerShare.val, ApiParamMap.MarketCap.val, ApiParamMap.OneYearTarget.val, ApiParamMap.Open.val, ApiParamMap.PERatio.val, ApiParamMap.PreviousClose.val, 
	//			ApiParamMap.Volume.val, ApiParamMap.Week52Range.val};

	@Override
	public URI getURI(ArrayList<Stock> stocks){

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

	public QueryType getQueryType() {
		return QueryType.API;
	}

}
