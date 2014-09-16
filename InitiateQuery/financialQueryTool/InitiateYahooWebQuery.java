package financialQueryTool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.nio.file.Path;
import java.util.ArrayList;

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
//		ArrayList<ParamListInterface> validParamList = InitiateYahooWebQuery.queryParamListInterfaces();
		for (Stock stock : stockList) {
			queryUri = yahooWebUri.getURI(stock);
			System.out.println("URI: " + queryUri.toString());
			HttpURLConnection httpConnection = null;
			InputStreamReader connectionStream = null;
			BufferedReader incomingData = null;
			
			String inputLine = "";
			String queriedHTML = "";
			try {
				httpConnection = (HttpURLConnection) queryUri.toURL().openConnection();
				httpConnection.setConnectTimeout(timeout);
				connectionStream = new InputStreamReader(httpConnection.getInputStream());
				incomingData = new BufferedReader(connectionStream);
				System.out.println(httpConnection.getContentType());
				
				while (((inputLine = incomingData.readLine()) != null)) {
					System.out.println("\t"+inputLine);
					queriedHTML = queriedHTML + inputLine;
				}
				
				 

			}
			catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				try {
					incomingData.close();
					connectionStream.close();
//					httpConnection.
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
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
