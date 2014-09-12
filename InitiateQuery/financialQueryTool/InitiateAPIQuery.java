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

import javax.management.RuntimeErrorException;

import financialQueryTool.GenerateApiUri;
import financialQueryTool.GenerateURI;
import financialQueryTool.ParamAsk;
import financialQueryTool.ParamAverageVolume;
import financialQueryTool.ParamBid;
import financialQueryTool.ParamDaysRange;
import financialQueryTool.ParamDividendYield;
import financialQueryTool.ParamEarningsPerShare;
import financialQueryTool.ParamListInterface;
import financialQueryTool.ParamMarketCapitalization;
import financialQueryTool.ParamOneYearTarget;
import financialQueryTool.ParamOpen;
import financialQueryTool.ParamPERatio;
import financialQueryTool.ParamPreviousClose;
import financialQueryTool.ParamStockName;
import financialQueryTool.ParamStockSym;
import financialQueryTool.ParamVolume;
import financialQueryTool.ParamWeekRange;
import financialQueryTool.Stock;
import financialQueryTool.WriteToCSV;

public class InitiateAPIQuery implements InitiateQueryInterface{

	public void queryFromApi (URI queryUri, Path outputCsvPath) {
		HttpURLConnection apiConnection = null;
		InputStream connectionStream = null;
		int bufferSize = 2048;
		boolean captureStream = true;
		try {
			apiConnection = (HttpURLConnection) queryUri.toURL().openConnection();
			//set timeout
			connectionStream = apiConnection.getInputStream();
			System.out.println(apiConnection.getContentType());

			WriteToCSV.WriteDataToCSV(outputCsvPath, connectionStream, bufferSize, captureStream);
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
	
	public static ArrayList<ParamListInterface> queryParamList () {
		ArrayList<ParamListInterface> applicableQueryParams = new ArrayList<ParamListInterface>();
		
		ParamListInterface ask = new ParamAsk(); //a
		ParamListInterface averageVolume = new ParamAverageVolume(); //a2
		/*ParamListInterface beta = new ParamBeta();*/
		ParamListInterface bid = new ParamBid(); //b
		ParamListInterface daysRange = new ParamDaysRange(); //m
		ParamListInterface dividendYield = new ParamDividendYield(); //y
		/*ParamListInterface earnDate = new ParamEarnDate();*/
		ParamListInterface earningsPerShare = new ParamEarningsPerShare(); //e
		ParamListInterface marketCap = new ParamMarketCapitalization(); //j1
		ParamListInterface oneYearTarget = new ParamOneYearTarget(); //t8
		ParamListInterface open = new ParamOpen(); //o
		ParamListInterface peRatio = new ParamPERatio(); //r
		ParamListInterface previousClose = new ParamPreviousClose(); //p
		ParamListInterface stockName = new ParamStockName(); //n
		/*ParamListInterface stockSym = new ParamStockSym();*/
		ParamListInterface volume = new ParamVolume(); //v
		ParamListInterface weekRange = new ParamWeekRange(); //w
		
		applicableQueryParams.add(ask);
		applicableQueryParams.add(averageVolume);
		applicableQueryParams.add(bid);
		applicableQueryParams.add(daysRange);
		applicableQueryParams.add(dividendYield);
		applicableQueryParams.add(earningsPerShare);
		applicableQueryParams.add(marketCap);
		applicableQueryParams.add(oneYearTarget);
		applicableQueryParams.add(open);
		applicableQueryParams.add(peRatio);
		applicableQueryParams.add(previousClose);
		applicableQueryParams.add(stockName);
		applicableQueryParams.add(volume);
		applicableQueryParams.add(weekRange);
		
		return applicableQueryParams;
	}

	public void initiateQuery (ArrayList<Stock> stockList, Path outputCsvPath) {
		URI queryUri = null;
		GenerateURI apiUri = new GenerateApiUri();
		HttpURLConnection apiConnection = null;
		InputStream connectionStream = null;
		ArrayList<ParamListInterface> validParamList = InitiateAPIQuery.queryParamList();
		int bufferSize = 2048;
		boolean captureStream = true;
		
		//create the URI for querying.
		queryUri = apiUri.getURI(stockList, validParamList);
		
		System.out.println("Using the URI: \t" + queryUri.toString());
		//Original value: 	http://finance.yahoo.com/d/quotes.csv?s=GOOG+AAPL+AMZN+BIDU+MA+NFLX&f=aa2bmyej1t8orpnvw
		try {
			apiConnection = (HttpURLConnection) queryUri.toURL().openConnection();
			//set timeout
			connectionStream = apiConnection.getInputStream();
			System.out.println(apiConnection.getContentType());

			String queryResult = WriteToCSV.WriteDataToCSV(outputCsvPath, connectionStream, bufferSize, captureStream);
			setStockDatafrmStr(stockList, queryResult);
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
	@Override
	public String initiateQuery (String stockSymbol) {

		String api_url = "http://finance.yahoo.com/d/quotes.csv?s=AAPL+GOOG+MSFT&f=nab";
		String queriedData = null;

		HttpURLConnection apiConnection = null;
		InputStream connectionStream = null;
		boolean captureStream = true;
		
		try {
			URL yahooFinApi = new URL(api_url);
			apiConnection = (HttpURLConnection) yahooFinApi.openConnection();
			//set timeout
			connectionStream = apiConnection.getInputStream();
			System.out.println(apiConnection.getContentType());
			Path path = FileSystems.getDefault().getPath("output_newApi.csv");
			int bufferSize = 2048;

			WriteToCSV.WriteDataToCSV(path, connectionStream, bufferSize, captureStream);
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

	}

	@Override
	public void printStock() {
	}

	@Override
	public URI getURI() {
		return null;
	}

	@Override
	public URI setURI() {
		return null;
	}

	public ArrayList<Stock> setStockDatafrmStr(ArrayList<Stock> stockList, String queryResult) {
		System.out.println("Setting the query result to each Stock Symbol.\t" + this.getClass());
		String[] queryResultarr = queryResult.trim().split("\n");
		System.out.println("Number of returned items: " + queryResultarr.length);
		int count =0;
		for (String queryResultRow : queryResultarr) {
			//each of the queryResultRow has the following data from the API query:
			//N/A,4238940,N/A,"75.41 - 76.448",0.51,2.766,87.566B,88.90,76.32,27.71,76.65,"Mastercard Incorp",4673567,"64.744 - 84.748"
			String[] data = queryResultRow.split(",(?! )");
			InitiateAPIQuery.addApiStockData(data, stockList.get(count));
			System.out.println(stockList.get(count).getStockName());
			stockList.get(count).printDetails();
			count++;
		}
		return stockList;
	}
	

	/**
	 * 581.13,1534680,580.72,"579.11 - 581.74",N/A,19.30,392.9B,N/A,580.36,30.21,583.10,"Google Inc.",172180,"502.80 - 604.83"
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
	public static Stock addApiStockData(String[] data, Stock stock) {
		System.out.println("Setting stock data for : " + stock.getStockName());
		stock.stockAsk.setparamData(data[0]);
		stock.stockAverageVolume.setparamData(data[1]);
		stock.stockBid.setparamData(data[2]);
		stock.stockDaysRange.setparamData(data[3]);
		stock.stockDividendYield.setparamData(data[4]);
		stock.stockEarningsPerShare.setparamData(data[5]);
		stock.stockMarketCapitalization.setparamData(data[6]);
		stock.stockOneYearTarget.setparamData(data[7]);
		stock.stockOpen.setparamData(data[8]);
		stock.stockPERatio.setparamData(data[9]);
		stock.stockPreviousClose.setparamData(data[10]);
		stock.stockName.setparamData(data[11]);
		stock.stockVolume.setparamData(data[12]);
		stock.stockWeekRange.setparamData(data[13].trim());
		return stock;
	}
}
