package financialQueryTool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InitiateYahooWebQuery implements InitiateQueryInterface {

	@Override
	public void printURI() {
		// TODO Auto-generated method stub

	}

	@Override
	public void printStock() {
		// TODO Auto-generated method stub

	}

	@Override
	public URI getURI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public URI setURI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String initiateQuery(String stockSymbol) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initiateQuery(ArrayList<Stock> stockList, Path outputFile) {
		System.out.println("An output path is not required for Web queries.");
	}

	@Override
	public void initiateQuery(ArrayList<Stock> stockList) {
		URI queryUri = null;
		int timeout = 5*1000;
		GenerateURI yahooWebUri = new GenerateYahooWebQueryUri();
		QueryHtmlPage queryYahooPage = new QueryHtmlPage();
		ParseHTML parsehtml = new ParseHTML();
		Map<String, String> mappedData = new HashMap<String, String>();
		
		for (Stock stock : stockList) {
			queryUri = yahooWebUri.getURI(stock);
			System.out.println("URI: " + queryUri.toString());
			
			String queriedHTML = "";
				try {
					HttpURLConnection httpConnection = (HttpURLConnection) queryUri.toURL().openConnection();
					httpConnection.setConnectTimeout(timeout);
					queriedHTML = queryYahooPage.queryHTML(httpConnection);
					mappedData = parsehtml.searchFoVal(queriedHTML);
					System.out.println(mappedData.keySet().toString());
					System.out.println(mappedData.values().toString());
					
/* 					 [Day's Range:, P/E (ttm):, 52wk Range:, Div & Yield:, Volume:, Prev Close:, Ask:, Open:, Avg Vol (3m):, 1y Target Est:, Next Earnings Date:, EPS (ttm):, Beta:, Market Cap:, Bid:]
					 [568.21 - 574.95, 30.03, 502.80 - 604.83, N/A (N/A), 1,596,224, 575.62, 581.91 x 100, 573.43, 1,544,670, N/A, N/A, 19.09, 1.159, 387.64B, 569.00 x 100]
					 */			
					} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
//				System.out.println(queriedHTML);
				
		}
	}

	public static ArrayList<ParamListInterface> queryParamListInterfaces () {
		ArrayList<ParamListInterface> applicableQueryParams = new ArrayList<ParamListInterface> ();

		applicableQueryParams.add(new ParamPreviousClose());
		applicableQueryParams.add(new ParamOpen());
		applicableQueryParams.add(new ParamBid());
		applicableQueryParams.add(new ParamAsk());
		applicableQueryParams.add(new ParamOneYearTarget());
		applicableQueryParams.add(new ParamBeta());
		applicableQueryParams.add(new ParamEarnDate());
		applicableQueryParams.add(new ParamDaysRange());
		applicableQueryParams.add(new ParamWeekRange());
		applicableQueryParams.add(new ParamVolume());
		applicableQueryParams.add(new ParamAverageVolume());
		applicableQueryParams.add(new ParamMarketCapitalization());
		applicableQueryParams.add(new ParamPERatio());
		applicableQueryParams.add(new ParamEarningsPerShare());
		applicableQueryParams.add(new ParamDividendYield());

		return applicableQueryParams;
	}
}
