package financialQueryTool;

/**
 * @author dineshkp
 *
 *Source: http://www.jarloo.com/yahoo_finance/
 */

public abstract class Paramlist {

/*	PreviousClose("p"),
	Open("o"),
	Bid("b"),
	Ask("a"),
	OneYearTarget("t8"), //1 yr Target Price 
	//Beta(""),
	//EarnDate("d2"), // using 'trade date' instead
	DaysRange("m"), //days range
	Week52Range("w"), //52 week range
	Volume("v"), 
	AverageVolume("a2"), //average daily volume
	MarketCap("j1"), //Market capitalization
	PERatio("r"),
	EarningsPerShare("e"), //EPS
	DividendYield("y"),
	Name("n");*/
	String open,previousClose,bid,ask,oneYearTarget,beta,earnDate,daysRange,week52Range,volume,averageVolume,marketCap,peRatio,earningsPerShare,dividendYield,stockName;

	public String getOpen() {
		return open;
	}

	public String getPreviousClose() {
		return previousClose;
	}

	public String getBid() {
		return bid;
	}

	public String getAsk() {
		return ask;
	}

	public String getOneYearTarget() {
		return oneYearTarget;
	}

	public String getBeta() {
		return beta;
	}

	public String getEarnDate() {
		return earnDate;
	}

	public String getDaysRange() {
		return daysRange;
	}

	public String getWeek52Range() {
		return week52Range;
	}

	public String getVolume() {
		return volume;
	}

	public String getAverageVolume() {
		return averageVolume;
	}

	public String getMarketCap() {
		return marketCap;
	}

	public String getPeRatio() {
		return peRatio;
	}

	public String getEarningsPerShare() {
		return earningsPerShare;
	}

	public String getDividendYield() {
		return dividendYield;
	}

	public String getStockName() {
		return stockName;
	}
	

	
}
