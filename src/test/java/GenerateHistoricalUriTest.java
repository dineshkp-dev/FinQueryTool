package test.java;

import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import main.java.financialQueryTool.control.generateURIPkg.GenerateHistoricalUri;
import main.java.financialQueryTool.control.generateURIPkg.GenerateURI;
import main.java.financialQueryTool.control.queryParametersPkg.QueryParamInterface;
import main.java.financialQueryTool.control.queryParametersPkg.YahooWebQueryParameters;
import main.java.financialQueryTool.model.stockPkg.Stock;
import main.java.financialQueryTool.view.parseInputOutputPkg.QueryType;

import org.junit.Before;
import org.junit.Test;

public class GenerateHistoricalUriTest {
	private GenerateURI generateURI;
	private ArrayList<Stock> stockList;
	private ArrayList<Stock> emptyStockList;
	Stock stocka;
	Stock stockb;
	Stock stocknull;
	QueryParamInterface getAllParams;

	@Before
	public void setup() {
		stocka = new Stock("stockA");
		stockb = new Stock("stockB");
		stocknull = new Stock("");
		stockList = new ArrayList<Stock>();
		stockList.add(stocka);
		stockList.add(stockb);
		generateURI = new GenerateHistoricalUri();
		getAllParams = new YahooWebQueryParameters();
	}

	@Test
	public void testGetQueryType() {
		assertEquals("Wrong Query type detected.", QueryType.HISTORICAL, generateURI.getQueryType());
	}

	@Test(expected=RuntimeException.class)
	public void testGetURI() {
		generateURI.getURI();
	}
	@Test(expected=RuntimeException.class)
	public void testGetURIArrayListOfStockNoStockList() throws URISyntaxException {
		generateURI.getURI(emptyStockList);
	}
	@Test(expected=RuntimeException.class)
	public void testGetURIArrayListOfStock() {
		generateURI.getURI(stockList);
	}

	@Test
	public void testGetURIvalidStock() throws URISyntaxException {
		assertEquals("The URI generated is not valid", new URI("http://ichart.finance.yahoo.com/table.csv?s=stockA&c=1962"), generateURI.getURI(stocka));
	}
	@Test(expected=RuntimeException.class)
	public void testGetURIArrayListOfStock100() {
		for (int i=0; i<100;i++) {
			stockList.add(new Stock("stock"+i));
		}
		generateURI.getURI(stockList);
	}
	@Test(expected=RuntimeException.class)
	public void testGetURINullStock() throws RuntimeException {
		generateURI.getURI(stocknull);
	}

}
