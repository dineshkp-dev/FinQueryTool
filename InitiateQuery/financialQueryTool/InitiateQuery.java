package financialQueryTool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class InitiateQuery {
	private InitiateQuery() {}
	/**
	 * Establishes a 'HttpURLConnection' to query from the website, based on the Stock Symbol (eg. GOOG)
	 * and returns the entire html page as a String value.
	 * 
	 * @param stockSymbol the stock symbol whose data needs to be collected
	 * @param timeout the time-out calculated in seconds
	 * @return String the queried Html page
	 */
	public static String queryFromWebsite(String stockSymbol, int timeout) {

		/*
		 * 
		    Create a URL.
		    Retrieve the URLConnection object.
		    Set output capability on the URLConnection.
		    Open a connection to the resource.
		    Get an output stream from the connection.
		    Write to the output stream.
		    Close the output stream.
		 *
		 */
		timeout = timeout*1000;
		String inputLine;
		String queriedXML = "";
		String query_URL = "http://finance.yahoo.com/q;_ylt=AmqI70JwGoQRGTnHFJQ3aNyiuYdG;_ylu=X3oDMTBxdGVyNzJxBHNlYwNVSCAzIERlc2t0b3AgU2VhcmNoIDEx;_ylg=X3oDMTBsdWsyY2FpBGxhbmcDZW4tVVMEcHQDMgR0ZXN0Aw--;_ylv=3;_ylc=X1MDMjE0MjQ3ODk0OARfcgMyBGZyA3VoM19maW5hbmNlX3dlYl9ncwRmcjIDc2EtZ3AEZ3ByaWQDBG5fZ3BzAzEwBG9yaWdpbgNmaW5hbmNlLnlhaG9vLmNvbQRwb3MDMQRwcXN0cgMEcXVlcnkDR09PRywEc2FjAzEEc2FvAzE-?p=http%3A%2F%2Ffinance.yahoo.com%2Fq%3Fs%3D" + stockSymbol + "%26ql%3D0&type=2button&uhb=uhb2&fr=uh3_finance_vert_gs&s=" + stockSymbol;
	//	http://finance.yahoo.com/q;_ylt=AmqI70JwGoQRGTnHFJQ3aNyiuYdG;_ylu=X3oDMTBxdGVyNzJxBHNlYwNVSCAzIERlc2t0b3AgU2VhcmNoIDEx;_ylg=X3oDMTBsdWsyY2FpBGxhbmcDZW4tVVMEcHQDMgR0ZXN0Aw--;_ylv=3;_ylc=X1MDMjE0MjQ3ODk0OARfcgMyBGZyA3VoM19maW5hbmNlX3dlYl9ncwRmcjIDc2EtZ3AEZ3ByaWQDBG5fZ3BzAzEwBG9yaWdpbgNmaW5hbmNlLnlhaG9vLmNvbQRwb3MDMQRwcXN0cgMEcXVlcnkDR09PRywEc2FjAzEEc2FvAzE-?p=http%3A%2F%2Ffinance.yahoo.com%2Fq%3Fs%3DAMD%26ql%3D0&type=2button&uhb=uhb2&fr=uh3_finance_vert_gs&s=AMD"
		try {
			URL yahooFinData = new URL(query_URL);
			HttpURLConnection connection = (HttpURLConnection) yahooFinData.openConnection();
			connection.setConnectTimeout(timeout);
			InputStreamReader connectionReadVal = new InputStreamReader(connection.getInputStream());
			BufferedReader incomingData = new BufferedReader(connectionReadVal);
			System.out.println(incomingData.readLine());

			while (((inputLine = incomingData.readLine()) != null)) {
//				System.out.println(inputLine); //enable for DEBUG, displays the entire returned value from website
				queriedXML = queriedXML + inputLine;
			}
			System.out.println("Succesfully queried data for " + stockSymbol);
			incomingData.close(); //close the Buffered reader


		} catch (MalformedURLException e) {
			System.out.println("Error when adding URL");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error during HTTP connection");
			e.printStackTrace();
		}
		return queriedXML; // return the queried xml data to be written into a temp file
	}
}
