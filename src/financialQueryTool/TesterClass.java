package financialQueryTool;

import java.net.URISyntaxException;

public class TesterClass {

	public static void main(String[] args) {
		GenerateApiUri generateApiUri = new GenerateApiUri();
		String[] stockNames = {"AAPL", "GOOG", "MSFT"};
		
		
//		Stock stock1 = new Stock 
		for (ApiParamMap mapper : ApiParamMap.values()){
			System.out.print(mapper.val + ", ");
		}
		System.out.println();
		
		generateApiUri.setQueryType(QueryType.API);
		System.out.println("Tester class.");
		String stockNamesStr="";

		for (String stocks : stockNames) {
			stockNamesStr = stockNamesStr + ", " + stocks;
		}
		
		System.out.println("Stockname: " + stockNamesStr);
		
		generateApiUri.setStockNames(stockNames);
		//generateApiUri.setStockParameters(stockParams);
		try {
			System.out.println(generateApiUri.getURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

}