package financialQueryTool;

import java.util.ArrayList;

/**
 * @author dineshkp
 * Class to generate an ArrayList of Stock from a String of StockSymbols
 */

public class GenerateStockList {

	/**
	 * 
	 * Static method that can be used to create an ArrayList of Stocks based on the Stock
	 * Names, the Stock objects will *ONLY* have Stock Name parameter populated through the Constructor for the 
	 * Stock Class.
	 *  
	 * @param stockSym String[]
	 * @return stockList ArrayList<Stock> Array List of the Stocks
	 * 
	 */
	public static ArrayList<Stock> getStockList(String[] stockSym) {
		ArrayList<Stock> stockList = new ArrayList<Stock>();
		for (String eachStockSym : stockSym) {
			System.out.println("Adding Symbol: " + eachStockSym);
			stockList.add(new Stock(eachStockSym));
		}
		return stockList;
	}

	/**
	 * Static method that can be used to create an ArrayList of Stocks based on the Stock
	 * Names, the Stock objects will *ONLY* have Stock Name parameter populated through the Constructor for the 
	 * Stock Class.
	 *  
	 * @param stockSym String
	 * @return stockList ArrayList<Stock> Array List of the Stocks
	 */
	public static ArrayList<Stock> getStockList(String stockSym) {
		ArrayList<Stock> stockList = new ArrayList<Stock>();
		String[] stockSymArray = stockSym.split(",");
		stockList = getStockList(stockSymArray);
		return stockList;
	}
}
