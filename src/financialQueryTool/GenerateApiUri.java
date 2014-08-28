package financialQueryTool;

import java.net.URI;
import java.net.URISyntaxException;
/*
 * "http://finance.yahoo.com/d/quotes.csv?s=AAPL+GOOG+MSFT&f=nab"
 * */
public class GenerateApiUri extends GenerateURI {

	String[] stockParams = {ApiParamMap.Name.val, ApiParamMap.Ask.val, ApiParamMap.AverageVolume.val, ApiParamMap.Bid.val, ApiParamMap.DaysRange.val, ApiParamMap.DividendYield.val, 
			ApiParamMap.EarningsPerShare.val, ApiParamMap.MarketCap.val, ApiParamMap.OneYearTarget.val, ApiParamMap.Open.val, ApiParamMap.PERatio.val, ApiParamMap.PreviousClose.val, 
			ApiParamMap.Volume.val, ApiParamMap.Week52Range.val};
	
	@Override
	public URI getURI() throws URISyntaxException {
		
		URI finalURI = null;
		String stockNamesStr = "", stockParamStr = "";
		for (String eachStock : this.getStockNames()){
			stockNamesStr = stockNamesStr + "+" + eachStock;
		}
		stockNamesStr = stockNamesStr.substring(1);
		
		for (String eachParam : stockParams) {
			stockParamStr = stockParamStr + eachParam;
		}
		finalURI = new URI ("http://finance.yahoo.com/d/quotes.csv?s=" + stockNamesStr + "&f=" + stockParamStr);
		return finalURI;
	}

}
