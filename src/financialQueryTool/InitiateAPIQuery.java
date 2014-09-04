package financialQueryTool;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;

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
			
			
			if (WriteToCSV.WriteDataToCSV(outputCsvPath, connectionStream, bufferSize)) {
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
			
			if (WriteToCSV.WriteDataToCSV(path, connectionStream, bufferSize)) {
				System.out.println("Successfully written to file");
			}
			else {
				System.out.println("Error during CSV writing.");
			}
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
	
	

/*	public static void main (String[] args) {
		queryFromApi("AAPL");
	}*/
}
