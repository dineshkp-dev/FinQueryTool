package financialQueryTool;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
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
		for (Stock eachStock : stocks){
			stockNamesStr = stockNamesStr + "+" + eachStock.getStockName();
		}
		stockNamesStr = stockNamesStr.substring(1);
		try {
			finalURI = new URI ("http://finance.yahoo.com/d/quotes.csv?s=" + stockNamesStr + "&f=" + APIQueryParameters.getAllQueryValues());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return finalURI;
	}
	
	public QueryType getQueryType() {
		return QueryType.API;
	}
	
	public URI getURI (ArrayList<Stock> stocks, ArrayList<ParamListInterface> applicableQueryParams) {
		System.out.println("Generating the API URI using Stock List, Applicable Query Params \t: " + this.getClass());

		URI finalURI = null;
		String stockNamesStr = "", validParams = "";
		try {
		for (Stock eachStock : stocks){
			stockNamesStr = stockNamesStr + "+" + eachStock.getStockName();
			
		}
		//stockNameStr = +AMD+GOOG+YAHOO
		stockNamesStr = stockNamesStr.substring(1);
		//stockNameStr = AMD+GOOG+YAHOO
		for (ParamListInterface parameter : applicableQueryParams) {
			System.out.println("Parameter name: " + parameter.getparamName());
			validParams = (validParams + parameter.getparamUlsdCode().toString());
		}
		validParams = APIQueryParameters.getAllQueryValues();

			finalURI = new URI ("http://finance.yahoo.com/d/quotes.csv?s=" + stockNamesStr + "&f=" + validParams);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		return finalURI;
	}
}
