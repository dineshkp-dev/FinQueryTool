package initiateQuery;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import financialQueryTool.APIQueryParameters;
import financialQueryTool.GenerateApiUri;
import financialQueryTool.GenerateURI;
import financialQueryTool.ParamListInterface;
import financialQueryTool.Stock;
import financialQueryTool.WriteToCSV;

public class InitiateAPIQuery implements InitiateQueryInterface{

	/**
	 * @param queryUri
	 * @param outputCsvPath
	 */
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


	//	String[] requiredParameters, Path outputFileLocation
	public void initiateQuery (ArrayList<Stock> stockList, String[] requiredParameters, Path outputFileLocation) {
		URI queryUri = null;
		GenerateURI apiUri = new GenerateApiUri();
		HttpURLConnection apiConnection = null;
		InputStream connectionStream = null;
		ArrayList<ParamListInterface> validParamList = APIQueryParameters.queryParamList();
		int bufferSize = 2048;
		boolean captureStream = true;

		Map<String, String> requiredDataList = new HashMap<String, String>();
		ArrayList<String> userRequestedData = new ArrayList<String>();

		//create the URI for querying.
		//		queryUri = apiUri.getURI(stockList, validParamList);
		queryUri = apiUri.getURI(stockList);

		System.out.println("Using the URI: \t" + queryUri.toString());
		//Original value: 	http://finance.yahoo.com/d/quotes.csv?s=GOOG+AAPL+AMZN+BIDU+MA+NFLX&f=aa2bmyej1t8orpnvw
		try {
			apiConnection = (HttpURLConnection) queryUri.toURL().openConnection();
			//set timeout
			connectionStream = apiConnection.getInputStream();
			System.out.println(apiConnection.getContentType());

			String queryResult = InitiateAPIQuery.getAPIData(connectionStream, bufferSize, captureStream);
			setStockDatafrmStr(stockList, queryResult);
			userRequestedData = InitiateAPIQuery.getRequireDataOnly(stockList, requiredParameters);

			WriteToCSV.WriteDataToCSV(outputFileLocation, userRequestedData);
			if (WriteToCSV.fileExistsCheck(outputFileLocation)){	
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

	public static ArrayList<String> getRequireDataOnly(ArrayList<Stock> stockList, String[] requiredParameters){
		Map<String, String> requiredDataList = new HashMap<String, String>();
		Stock stock = null;
		ArrayList<String> finalData = new ArrayList<String>();
		for (int i =0; i<stockList.size(); i++){
			stock = stockList.get(i);
			System.out.println("Stock Name:" + stock.getStockName());
			requiredDataList = stock.getRequiredParamData(requiredParameters);
			if (i == 0) {
				finalData.add(i, "StockName" + ","+ requiredDataList.keySet().toString().replaceAll("\\[|\\]", ""));
				System.out.println("StockName" + ","+ requiredDataList.keySet().toString().replaceAll("\\[|\\]", ""));
			}
			finalData.add(i, (stock.getStockName() + ","+ requiredDataList.values().toString().replaceAll("\\[|\\]", "")));
			System.out.println(stock.getStockName() + ","+ requiredDataList.values().toString().replaceAll("\\[|\\]", ""));
		}
		Collections.reverse(finalData);
		return finalData;
	}


	/**
	 * This method writes the data from an InputStream (ususally linked to a HTTPUrlConnection)
	 * 
	 * @param csvFilePath Path location to csv file
	 * @param connectionStream InputStream data
	 * @param bufferSize int Buffersize of data from InputStream
	 * @return writeSuccess boolean is set to true if file is successfully created
	 * @throws IOException
	 */
	public static String getAPIData(InputStream connectionStream, int bufferSize, boolean captureStream ) throws IOException {
		int byteRead, byteWritten=0;
		String output = "";

		try {

			byte[] fileBuffer = new byte[bufferSize];
			while (( byteRead = connectionStream.read(fileBuffer)) != -1) {
				if (captureStream){
					output = output + (new String(fileBuffer,0,bufferSize,StandardCharsets.UTF_8)).trim();
				}
				byteWritten += byteRead;
			}
			System.out.println("Output value: \n" + output.toString());
			System.out.println("Bytes downloaded: " + byteWritten + "Bytes.");
		} catch (IOException err) {
			err.printStackTrace();
		}
		finally {
			System.out.println("Completed getting API Data from HTTP.");
		}
		return output;
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
			APIQueryParameters.addApiStockData(data, stockList.get(count));
			System.out.println(stockList.get(count).getStockName());
			stockList.get(count).printDetails();
			count++;
		}
		return stockList;
	}

	@Override
	public String initiateQuery(String stockSymbol) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void initiateQuery(ArrayList<Stock> stockList, Path outputFile) {
		// TODO Auto-generated method stub
		
	}
}
