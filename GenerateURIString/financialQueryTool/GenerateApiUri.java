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
			finalURI = new URI ("http://finance.yahoo.com/d/quotes.csv?s=" + stockNamesStr + "&f=" + GenerateApiUri.getAllURIParams());
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
		System.out.println(" Size of : applicableQueryParams.size(): " + applicableQueryParams.size());
		for (ParamListInterface parameter : applicableQueryParams) {
			System.out.println("Parameter name: " + parameter.getparamName());
			validParams = (validParams + parameter.getparamUlsdCode().toString());
		}

			finalURI = new URI ("http://finance.yahoo.com/d/quotes.csv?s=" + stockNamesStr + "&f=" + validParams);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		return finalURI;
	}
	
	public static String getAllURIParams() {
		String allParameters = "";
		
		ParamListInterface paramList = new ParamAsk();
		allParameters = allParameters+paramList.getparamUlsdCode();
		paramList = new ParamAverageVolume();
		allParameters = allParameters+paramList.getparamUlsdCode();
		paramList = new ParamBeta();
		allParameters = allParameters+paramList.getparamUlsdCode();
		paramList = new ParamBid();
		allParameters = allParameters+paramList.getparamUlsdCode();
		paramList = new ParamDaysRange();
		allParameters = allParameters+paramList.getparamUlsdCode();
		paramList = new ParamDividendYield();
		allParameters = allParameters+paramList.getparamUlsdCode();
		paramList = new ParamEarnDate();
		allParameters = allParameters+paramList.getparamUlsdCode();
		paramList = new ParamEarningsPerShare();
		allParameters = allParameters+paramList.getparamUlsdCode();
		paramList = new ParamMarketCapitalization();
		allParameters = allParameters+paramList.getparamUlsdCode();
		paramList = new ParamOneYearTarget();
		allParameters = allParameters+paramList.getparamUlsdCode();
		paramList = new ParamOpen();
		allParameters = allParameters+paramList.getparamUlsdCode();
		paramList = new ParamPERatio();
		allParameters = allParameters+paramList.getparamUlsdCode();
		paramList = new ParamPreviousClose();
		allParameters = allParameters+paramList.getparamUlsdCode();
		paramList = new ParamStockName();
		allParameters = allParameters+paramList.getparamUlsdCode();
		paramList = new ParamVolume();
		allParameters = allParameters+paramList.getparamUlsdCode();
		paramList = new ParamWeekRange();
		allParameters = allParameters+paramList.getparamUlsdCode();
		
		return allParameters;
	}
}
