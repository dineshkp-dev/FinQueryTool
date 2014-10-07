package main.java.financialQueryTool.htmlOperationsPkg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class QueryHtmlPage {

	/**
	 * Method queries a Web Page and returns the HTML content as String from a InputStreamReader
	 * @param connectionStream
	 * @return
	 */
	public String queryHTML (InputStreamReader connectionStream) {
		String queriedHTML = "";
		BufferedReader incomingData = new BufferedReader(connectionStream);
		System.out.println("Connection Encoding: " + connectionStream.getEncoding());
		String inputLine = "";
		try {
			while ((inputLine = incomingData.readLine()) != null){
				queriedHTML.concat(inputLine);
			}


		} catch (IOException e) {
			e.printStackTrace();
		}
		return queriedHTML;
	}

	public String queryHTML (HttpURLConnection httpConnection) {
		String queriedHTML = "";
		InputStreamReader connectionStreamReader = null;
		BufferedReader incomingData = null;
		try {
			connectionStreamReader = new InputStreamReader( httpConnection.getInputStream()); 
			incomingData = new BufferedReader(connectionStreamReader);
			System.out.println("Connection Encoding: " + connectionStreamReader.getEncoding());
			String inputLine = "";

			while ((inputLine = incomingData.readLine()) != null){
				queriedHTML = queriedHTML + inputLine;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				connectionStreamReader.close();
				incomingData.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return queriedHTML;
	}
}
