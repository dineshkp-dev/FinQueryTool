package financialQueryTool;

import java.net.URISyntaxException;
import java.util.ArrayList;

public class TesterClass {

	public static void main(String[] args) {
		GenerateApiUri generateApiUri = new GenerateApiUri();
		String[] stockSym = {"AAPL", "GOOG", "MSFT"};
		
		generateApiUri.setQueryType(QueryType.API);
		System.out.println("Tester class.");
		String stockNamesStr="";

		for (String stocks : stockSym) {
			stockNamesStr = stockNamesStr + ", " + stocks;
		}
		
		System.out.println("Stockname: " + stockNamesStr);
		
		ArrayList<Stock> stockList = new ArrayList<Stock>();
		System.out.println("Creating Stock ArrayList");
		stockList = GenerateStockList.getStockList(stockSym);
/*		for (String eachStock : stockNames) {
			stock.add(new Stock(eachStock));
			System.out.println("Added " + eachStock);
		}*/
		System.out.println(stockList.size());
		try {
			System.out.println(generateApiUri.getURI(stockList));
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
