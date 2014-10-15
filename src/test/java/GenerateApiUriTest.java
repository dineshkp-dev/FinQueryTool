package test.java;

import static org.junit.Assert.*;

import java.net.URI;
import java.util.ArrayList;

import main.java.financialQueryTool.stockPkg.Stock;

import org.junit.Before;
import org.junit.Test;

public class GenerateApiUriTest {

	
	@Before
	public void setup() {
		Stock stocka = new Stock("stockA");
		Stock stockb = new Stock("stockB");
		ArrayList<Stock> stockList = new ArrayList<Stock>();
		stockList.add(stocka);
		stockList.add(stockb);
	}
	
	
	
//	public static ArrayList<Stock> stockListTest = new ArrayList<Stock>();
	
	@Test
	public void testGetQueryType() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetURIArrayListOfStock() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetStockParameters() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSetStockParameters() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSetQueryType() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetURI() {
		
	}

	@Test
	public void testGetURIArrayListOfStockArrayListOfParamListInterface() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetURIStockArrayListOfParamListInterface() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetURIStock() {
		fail("Not yet implemented"); // TODO
	}

}
