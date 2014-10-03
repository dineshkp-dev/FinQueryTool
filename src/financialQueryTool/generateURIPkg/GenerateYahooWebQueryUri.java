package financialQueryTool.generateURIPkg;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import financialQueryTool.Stock;
import financialQueryTool.parametersPkg.ParamListInterface;

public class GenerateYahooWebQueryUri extends GenerateURI {
	
	@Override
	public URI getURI(Stock stock,
			ArrayList<ParamListInterface> applicableQueryParams) {
		URI finalURI = null;
		System.out.println("Generating Yahoo Web Query URI.");
		//http://finance.yahoo.com/q?s=AMD&ql=1
		
		
		return finalURI;
	}
	@Override
	public URI getURI(Stock stock) {
		
		URI finalURI = null;
		
		System.out.println("Generating Yahoo Web Query URI.");
		//http://finance.yahoo.com/q?s=AMD&ql=1
		try {
			finalURI = new URI("http://finance.yahoo.com/q?s=" + stock.getStockName() + "&ql=1");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		return finalURI;
	}
}
