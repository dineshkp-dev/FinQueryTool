package main.java.financialQueryTool.model.stockPkg;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "stocks")
public class StockListWrapper {
	private ArrayList<Stock> stocks;
	
	@XmlElement(name = "stock")
	public ArrayList<Stock> getStocks() {
		return stocks;
	}
	public void setStocks(ArrayList<Stock> stocks) {
		this.stocks = stocks;
	}
}
