package financialQueryTool;

public class ParamApiList extends Paramlist {
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
	@Override
	public String getOpen() {
		return "o";
	}

	@Override
	public String getPreviousClose() {
		return "p";
	}

	@Override
	public String getBid() {
		return "b";
	}

	@Override
	public String getAsk() {
		return "a";
	}

	@Override
	public String getOneYearTarget() {
		return "t8";
	}

	@Override
	public String getBeta() {
		return super.getBeta();
	}

	@Override
	public String getEarnDate() {
		return super.getEarnDate();
	}

	@Override
	public String getDaysRange() {
		return "m";
	}

	@Override
	public String getWeek52Range() {
		return "w";
	}

	@Override
	public String getVolume() {
		return "v";
	}

	@Override
	public String getAverageVolume() {
		return "a2";
	}

	@Override
	public String getMarketCap() {
		return "j1";
	}

	@Override
	public String getPeRatio() {
		return "r";
	}

	@Override
	public String getEarningsPerShare() {
		return "e";
	}

	@Override
	public String getDividendYield() {
		return "y";
	}

	@Override
	public String getStockName() {
		return "n";
	}

	@Override
	public String getAll() {
		return super.getAll();
	}

}
