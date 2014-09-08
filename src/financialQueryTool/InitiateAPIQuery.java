package financialQueryTool;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

public class InitiateAPIQuery implements InitiateQueryInterface{

	public void queryFromApi (URI queryUri, Path outputCsvPath) {
		HttpURLConnection apiConnection = null;
		InputStream connectionStream = null;
		int bufferSize = 2048;
		try {
			apiConnection = (HttpURLConnection) queryUri.toURL().openConnection();
			//set timeout
			connectionStream = apiConnection.getInputStream();
			System.out.println(apiConnection.getContentType());
			//			Path path = FileSystems.getDefault().getPath("output_newApi.csv");


			WriteToCSV.WriteDataToCSV(outputCsvPath, connectionStream, bufferSize);
			if (WriteToCSV.fileExistsCheck(outputCsvPath)){	
				System.out.println("Successfully written to file");
			}
			else {
				System.out.println("Error during CSV writing.");
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				apiConnection.disconnect();
				connectionStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void queryFromApi (ArrayList<Stock> stockList, Path outputCsvPath) {
		URI queryUri = null;
		GenerateURI apiUri = new GenerateApiUri();
		HttpURLConnection apiConnection = null;
		InputStream connectionStream = null;
		int bufferSize = 2048;
		//create the URI for querying.

		try {
			queryUri = apiUri.getURI(stockList);
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}

		try {
			apiConnection = (HttpURLConnection) queryUri.toURL().openConnection();
			//set timeout
			connectionStream = apiConnection.getInputStream();
			System.out.println(apiConnection.getContentType());

			String queryResult = WriteToCSV.WriteDataToCSV(outputCsvPath, connectionStream, bufferSize);
			setStockDatafrmStr(stockList, queryResult);
			/*			String stock1 = queryResult.split("\n")[0];
			System.out.println("Stock1 data: " + stock1);*/
			if (WriteToCSV.fileExistsCheck(outputCsvPath)){	
				System.out.println("Successfully written to file");
			}
			else {
				System.out.println("Error during CSV writing.");
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				apiConnection.disconnect();
				connectionStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static String queryFromApi (String stockSymbol) {

		String api_url = "http://finance.yahoo.com/d/quotes.csv?s=AAPL+GOOG+MSFT&f=nab";
		String queriedData = null;

		HttpURLConnection apiConnection = null;
		InputStream connectionStream = null;
		try {
			URL yahooFinApi = new URL(api_url);
			apiConnection = (HttpURLConnection) yahooFinApi.openConnection();
			//set timeout
			connectionStream = apiConnection.getInputStream();
			System.out.println(apiConnection.getContentType());
			Path path = FileSystems.getDefault().getPath("output_newApi.csv");
			int bufferSize = 2048;

			WriteToCSV.WriteDataToCSV(path, connectionStream, bufferSize);
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				apiConnection.disconnect();
				connectionStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return queriedData;
	}

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
	public String initiateQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Stock> setStockDatafrmStr(ArrayList<Stock> stockList, String queryResult) {
		System.out.println("Setting the query result to each Stock Symbol.\t" + this.getClass());
		//		ArrayList<String> queryResultarr = new ArrayList<String>();
		String[] queryResultarr = queryResult.split("\n");
		System.out.println("Number of returned items: " + queryResultarr.length);
		int count =0;
		for (String queryResultRow : queryResultarr) {
			System.out.println("Row"+count+" Value: " + queryResultRow );
			//each of the queryResultRow has the following data from the API query:
			//
			String[] data = queryResultRow.split(",");
			InitiateAPIQuery.addApiStockData(data, stockList.get(count));
			System.out.println(stockList.get(count).getStockName());
			count++;
		}
		return stockList;
	}

	/**
	 * Adds all the information from the query result for each stock
	 * @param stockData
	 * @param stock
	 * @return
	 * Row0 Value: 
	 * ask:587.80,
	 * volume:1548080,
	 * beta:582.80,
	 * daysrange: "581.95 - 586.55",
	 * divnyield: N/A,
	 * Earndate:19.30,
	 * EpsTTM: 396.4B,
	 * MktCap: N/A,
	 * One year target: 583.95,
	 * Open: 30.15,581.98,
	 * PeTTM: "Google Inc.",
	 * Prevclose: 1629518,
	 * Volume: 
	 * W52 Week Range: "502.80 - 604.83"
	 */
	public static Stock addApiStockData(String[] stockData, Stock stock) {
		ArrayList<String> stockDataList = new ArrayList<String>(Arrays.asList(stockData));
//		if (stockDataList.)
		System.out.println("Setting stock data for : " + stock.getStockName());
		stock.setAsk(stockData[0]);
		stock.setAvgVol(stockData[1]);
		stock.setBeta(stockData[2]);
		stock.setDaysRng(stockData[3]);
		stock.setDivnYield(stockData[4]);
		stock.setEarnDate(stockData[5]);
		stock.setEpsTtm(stockData[6]);
		stock.setMktCap(stockData[7]);
		stock.setOneYrTarg(stockData[8]);
		stock.setOpen(stockData[9]);
		stock.setPeTtm(stockData[10]);
		stock.setPrevClose(stockData[11]);
		stock.setStockName(stockData[12]);
		stock.setVol(stockData[13]);
		stock.setWk52Rng(stockData[14]);
		return stock;
	}

	/*	paramList = new ParamAsk();
		paramList = new ParamAverageVolume();
		paramList = new ParamBeta();
		paramList = new ParamBid();
		paramList = new ParamDaysRange();
		paramList = new ParamDividendYield();
		paramList = new ParamEarnDate();
		paramList = new ParamEarningsPerShare();
		paramList = new ParamMarketCapitalization();
		paramList = new ParamOneYearTarget();
		paramList = new ParamOpen();
		paramList = new ParamPERatio();
		paramList = new ParamPreviousClose();
		paramList = new ParamStockName();
		paramList = new ParamVolume();
		paramList = new ParamWeekRange();
	}*/
}
