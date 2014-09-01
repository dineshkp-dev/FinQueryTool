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
	public URI getURI(ArrayList<Stock> stocks) throws URISyntaxException {
		
		System.out.println("Generating the API URI : " + this.getClass());
		
		URI finalURI = null;
		String stockNamesStr = "", stockParamStr = "";
		for (Stock eachStock : stocks){
			stockNamesStr = stockNamesStr + "+" + eachStock.getStockName();
		}
		
		stockNamesStr = stockNamesStr.substring(1);

//		ParamApiList parameters = new ParamApiList();
		finalURI = new URI ("http://finance.yahoo.com/d/quotes.csv?s=" + stockNamesStr + "&f=" + GenerateApiUri.getAllURIParams());
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
