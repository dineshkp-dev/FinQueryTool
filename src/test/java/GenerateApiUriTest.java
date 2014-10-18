package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import main.java.financialQueryTool.generateURIPkg.GenerateApiUri;
import main.java.financialQueryTool.generateURIPkg.GenerateURI;
import main.java.financialQueryTool.parseInputOutputPkg.QueryType;
import main.java.financialQueryTool.queryParametersPkg.APIQueryParameters;
import main.java.financialQueryTool.queryParametersPkg.QueryParamInterface;
import main.java.financialQueryTool.stockPkg.Stock;

import org.junit.Before;
import org.junit.Test;

public class GenerateApiUriTest {

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
		generateURI = new GenerateApiUri();
		getAllParams = new APIQueryParameters();
	}

	@Test
	public void testGetQueryType() {
		assertNotNull(generateURI.getQueryType());
		assertEquals(QueryType.API , generateURI.getQueryType());
	}

	@Test
	public void testGetURIArrayListOfStock() throws URISyntaxException {
		assertEquals(new URI("http://finance.yahoo.com/d/quotes.csv?s=stockA+stockB&f="+getAllParams.getAllQueryParams()),generateURI.getURI(stockList));
	}

	@Test(expected=RuntimeException.class)
	public void testGetURIArrayListOfStockNoStockList() throws URISyntaxException {
		generateURI.getURI(emptyStockList);
	}

	@Test(expected=RuntimeException.class)
	public void testGetURI() throws RuntimeException {
		generateURI.getURI();
	}
	@Test
	public void testGetURIvalidStock() throws RuntimeException, URISyntaxException {
		generateURI.getURI(stocka);
		assertEquals("The expected URI was not generated",new URI("http://finance.yahoo.com/d/quotes.csv?s=stockA&f="+getAllParams.getAllQueryParams()) , generateURI.getURI(stocka));
	}
	@Test
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
