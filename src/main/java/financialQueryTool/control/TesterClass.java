package main.java.financialQueryTool.control;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import main.java.financialQueryTool.control.generateURIPkg.GenerateApiUri;
import main.java.financialQueryTool.model.stockPkg.GenerateStockList;
import main.java.financialQueryTool.model.stockPkg.Stock;

public class TesterClass {

	public static void main(String[] args) {
		GenerateApiUri generateApiUri = new GenerateApiUri();
		String[] stockSym = {"AAPL", "GOOG", "MSFT"};
//		StandardOpenOption
		
		System.out.println("printing args: " + args[0]);
		
//		generateApiUri.setQueryType(QueryType.API);
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
		
		Path path = Paths.get("inputdetails.xml");
		File file = path.toFile();
		System.out.println(file.exists());
		
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
