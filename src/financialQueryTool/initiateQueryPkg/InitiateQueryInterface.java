package financialQueryTool.initiateQueryPkg;

import java.net.URI;
import java.nio.file.Path;
import java.util.ArrayList;

import financialQueryTool.Stock;

public interface InitiateQueryInterface {
	public void printURI();
	public void printStock();
	public URI getURI();
	public URI setURI();
	public String initiateQuery(String stockSymbol);
	public void initiateQuery(ArrayList<Stock> stockList, String[] requiredParameters, Path outputFile);
	public void initiateQuery(ArrayList<Stock> stockList, Path outputFile);
//	public void initiateQuery(ArrayList<Stock> stockList);
	//public static ArrayList<ParamListInterface> queryParamList();
}
