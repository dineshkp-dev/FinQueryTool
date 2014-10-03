package initiateQuery;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;

import financialQueryTool.GenerateHistoricalUri;
import financialQueryTool.Stock;
import financialQueryTool.WriteToCSV;

public class InitiateHistoricalQuery implements InitiateQueryInterface {

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
		URI queryUri = null;
		for (Stock stock : stockList) {
			queryUri = GenerateHistoricalUri.getHistoricalUri(stock);
			System.out.println("Using the URI: \t" + queryUri.toString());

			HttpURLConnection apiConnection = null;
			InputStream connectionStream = null;
			int bufferSize = 2048;
			boolean captureStream = true;
			try {
				apiConnection = (HttpURLConnection) queryUri.toURL().openConnection();
				connectionStream = apiConnection.getInputStream();
				System.out.println(apiConnection.getContentType());
				outputFile = FileSystems.getDefault().getPath(outputFile.toString().replaceAll("\\....$", "_"+stock.getStockName()+".csv"));	
				System.out.println("File Path updated: " + outputFile.toAbsolutePath());
				String queryResult = WriteToCSV.WriteAppendedDataToCSV(outputFile, connectionStream, bufferSize, captureStream, stock);
				if (WriteToCSV.fileExistsCheck(outputFile)){	
					System.out.println("Successfully written to file");
				}
				else {
					System.out.println("Error during CSV writing.");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String appendStockName(String queryResult, Stock stock) {

		System.out.println(queryResult);
		String[] queryResultList = queryResult.split("\n");
		for (int i = 0; i<queryResultList.length; i++) {
			if (i ==0) {
				queryResultList[i] = queryResultList[i].concat(",Stock Name");				
			}
			else {
				queryResultList[i] = queryResultList[i].concat(","+stock.getStockName());
			}
		}
		System.out.println("query result: "  + queryResultList[5]);
		return queryResult;
	}

	@Override
	public void initiateQuery(ArrayList<Stock> stockList,
			String[] requiredParameters, Path outputFile) {
		// TODO Auto-generated method stub
		
	}


}
