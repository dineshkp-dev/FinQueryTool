package financialQueryTool;

import java.io.IOException;
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
		ParamListInterface queryParam = null;

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
				System.out.println("Setting the Stock's Parameters from Web Query.");
				stock = InitiateYahooWebQuery.setStockParams(stock, mappedData);
				stock.printDetails();

			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see financialQueryTool.InitiateQueryInterface#initiateQuery(java.util.ArrayList, java.lang.String, java.nio.file.Path)
	 */
	@Override
	public void initiateQuery(ArrayList<Stock> stockList, String[] requiredParameters, Path outputFileLocation) {
		URI queryUri = null;
		int timeout = 5*1000;
		GenerateURI yahooWebUri = new GenerateYahooWebQueryUri();
		QueryHtmlPage queryYahooPage = new QueryHtmlPage();
		ParseHTML parsehtml = new ParseHTML();
		Map<String, String> mappedData = new HashMap<String, String>();
		ParamListInterface queryParam = null;

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
				System.out.println("Setting the Stock's Parameters from Web Query.");
				stock = InitiateYahooWebQuery.setStockParams(stock, mappedData);
				stock.printDetails();
				

			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		printRequireDataOnly(stockList, requiredParameters);
	}
	
	public static void printRequireDataOnly(ArrayList<Stock> stockList, String[] requiredParameters) {
		for (Stock stock : stockList) {
			System.out.println("Stock Name:" + stock.getStockName());
//			for (String requiredParam : requiredParameters) {
				stock.getRequiredParamData(requiredParameters);
//			}
		}
	}
	/**
	 * The method sets the values from the Map 'mappedData' to the parameters of the stock Object
	 * The Parameters are extracted from the Map using the 'Param'x Class's 'getParamYahooTabName' which corresponds to 
	 * the table name in the Yahoo Finance Website.
	 * @param stock
	 * @param mappedData
	 * @return stock Stock after all the necessary Parameters' data have been updated
	 */
	public static Stock setStockParams (Stock stock, Map<String, String> mappedData) {
		
		stock.stockPreviousClose.setparamData(mappedData.get(new ParamPreviousClose().getParamYahooTabName()));
		stock.stockOpen.setparamData(mappedData.get(new ParamOpen().getParamYahooTabName()));
		stock.stockBid.setparamData(mappedData.get(new ParamBid().getParamYahooTabName()));
		stock.stockAsk.setparamData(mappedData.get(new ParamAsk().getParamYahooTabName()));
		stock.stockOneYearTarget.setparamData(mappedData.get(new ParamOneYearTarget().getParamYahooTabName()));
		stock.stockBeta.setparamData(mappedData.get(new ParamBeta().getParamYahooTabName()));
		stock.stockEarnDate.setparamData(mappedData.get(new ParamEarnDate().getParamYahooTabName()));
		stock.stockDaysRange.setparamData(mappedData.get(new ParamDaysRange().getParamYahooTabName()));
		stock.stockWeekRange.setparamData(mappedData.get(new ParamWeekRange().getParamYahooTabName()));
		stock.stockVolume.setparamData(mappedData.get(new ParamVolume().getParamYahooTabName()));
		stock.stockAverageVolume.setparamData(mappedData.get(new ParamAverageVolume().getParamYahooTabName()));
		stock.stockMarketCapitalization.setparamData(mappedData.get(new ParamMarketCapitalization().getParamYahooTabName()));
		stock.stockPERatio.setparamData(mappedData.get(new ParamPERatio().getParamYahooTabName()));
		stock.stockEarningsPerShare.setparamData(mappedData.get(new ParamEarningsPerShare().getParamYahooTabName()));
		stock.stockDividendYield.setparamData(mappedData.get(new ParamDividendYield().getParamYahooTabName()));

		return stock;
	}
	/**
	 * The method identifies all the valid parameters which can be queried for this class
	 * @return applicableQueryParams ArrayList<ParamListInterface> the list of all the applicable parameters for which valid data should be available from query
	 */
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
