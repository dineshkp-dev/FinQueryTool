package stocktickerdata;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.FileSystems;

public class InitiateAPIQuery {
	public static String queryFromApi (String stockSymbol) {
		final int fileSize = 2048;
		String api_url = "http://finance.yahoo.com/d/quotes.csv?s=AAPL+GOOG+MSFT&f=nab";
		String queriedData = null;
		File file = FileSystems.getDefault().getPath("output_api.csv").toFile();
		byte[] fileBuffer;
		HttpURLConnection apiConnection = null;
		InputStream connectionStream = null;
		OutputStream outputstream = null;
		try {
			URL yahooFinApi = new URL(api_url);
			int byteRead, byteWritten=0;
			apiConnection = (HttpURLConnection) yahooFinApi.openConnection();
			//set timeout
			connectionStream = apiConnection.getInputStream();
			System.out.println(apiConnection.getContentType());


			outputstream = new BufferedOutputStream( new FileOutputStream(file,true));
			fileBuffer = new byte[fileSize];
			//			String tempString = connectionStream.
			while (( byteRead = connectionStream.read(fileBuffer)) != -1) {
				outputstream.write(fileBuffer, 0, byteRead);
				//				outputstream.wr

				byteWritten += byteRead;
			}
			System.out.println(fileBuffer[0]);

			System.out.println("Downloaded successfully.");
			System.out.println(file.getAbsolutePath());




		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {

			try {
				//				apiConnection.disconnect();
				connectionStream.close();
				outputstream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return queriedData;
	}
	
	

	public static void main (String[] args) {
		queryFromApi("AAPL");
	}
}
