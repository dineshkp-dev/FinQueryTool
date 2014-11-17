package main.java.financialQueryTool.control.generateURIPkg;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.management.RuntimeErrorException;

import main.java.financialQueryTool.model.stockPkg.Stock;
import main.java.financialQueryTool.view.parseInputOutputPkg.QueryType;

public class GenerateYahooWebQueryUri extends GenerateURI {
	
	@Override
	public QueryType getQueryType() {
		return QueryType.WEBYAHOO;
	}
	@Override
	public URI getURI(Stock stock) {
		
		URI finalURI = null;
		if (stock.isStockInvalid()){
			throw new RuntimeException("Stock cannot be null/empty.");
		}
		System.out.println("Generating Yahoo Web Query URI.");
		//http://finance.yahoo.com/q?s=AMD&ql=1
		try {
			finalURI = new URI("http://finance.yahoo.com/q?s=" + stock.getStockName() + "&ql=1");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return finalURI;
	}
	@Override
	public URI getURI(ArrayList<Stock> stocks) {
		throw new RuntimeErrorException(null, "WEB QUERY URI generation currently doesnt support Multiple Stock queries.");
	}
	@Override
	public URI getURI() throws RuntimeException{
		throw new RuntimeErrorException(null, "WEB QUERY URI generation requires at least one Stock Parameter.");
	}
}
