package financialQueryTool;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class InitiateAPIQuery {
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
	
	

	public static void main (String[] args) {
		queryFromApi("AAPL");
	}
}
