/**
 * 
 */
package financialQueryTool;

/**
 * @author dineshkp
 *
 *Source: http://www.jarloo.com/yahoo_finance/
 */

public enum ApiParamMap {

	PreviousClose("p"),
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
	Name("n");
	public String val;
	private ApiParamMap(String val) {
		this.val = val;
	}
}


