package financialQueryTool.parseInputOutputPkg;

import java.util.ArrayList;
import java.util.Map;

public class ProcessDataToWrite {

	/**
	 * Generates the list of headers and their specific data values, based on the user's requirements
	 * 
	 * @param stockSymbol
	 * @param stockData
	 * @param inputRequestArray
	 * @return finalData Array contains only the List of items, required by the user, for the specific Stock
	 */
	public static ArrayList<String> dataToWrite( String stockSymbol, Map<String, String> stockData, ArrayList<String> inputRequestArray) {
		int numOfReqdData = inputRequestArray.size();
		ArrayList<String> finalData = new ArrayList<String>();
		
		for (int i=0; i<numOfReqdData; i++) {
			/*
			 * finalData => "GOOG,Open,541.03"
			 */
			finalData.add(stockSymbol + "," + inputRequestArray.get(i) + "," + stockData.get(inputRequestArray.get(i)+":"));
		}
		System.out.println(finalData);
		return finalData;
	}
}
