package financialQueryTool;

import java.util.ArrayList;

import financialQueryTool.generateURIPkg.GenerateApiUri;

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
		
		String testingStr = "Hello,there,what,is,this,\"this is one,  value \".csv";
		String testingStr2 = "GOOG[AverageVolume, Ask] GOOG[1,516,460, 583.50 x 100]";
		
		System.out.println(testingStr2.replaceAll("\\[|\\]", ""));
		System.out.println(testingStr2.replaceAll("xxx", ""));
		
		System.out.println(testingStr);
		
		String[] arr = testingStr.split(",(?! )");
		testingStr = testingStr.replaceAll("\\....", ".htm");
		System.out.println(testingStr);
		for (String data : arr ) {
			System.out.println(data);
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
		System.out.println(generateApiUri.getURI(stockList));
	}

}
