package financialQueryTool;

/**
 * @author dineshkp
 *
 *Source: http://www.jarloo.com/yahoo_finance/
 */

public abstract class Paramlist {

	String open ="",previousClose="",bid="",ask="",oneYearTarget="",beta="",earnDate="",daysRange="",week52Range="",volume="",averageVolume="",marketCap="",peRatio="",earningsPerShare="",dividendYield="",stockName="";

	public String getOpen() {
		System.out.println("Warning! 'Open' is not applicable for this query.");
		return open;
	}

	public String getPreviousClose() {
		System.out.println("Warning! 'Previous Close' is not applicable for this query.");
		return previousClose;
	}

	public String getBid() {
		System.out.println("Warning! 'Bid' is not applicable for this query.");
		return bid;
	}

	public String getAsk() {
		System.out.println("Warning! 'Ask' is not applicable for this query.");
		return ask;
	}

	public String getOneYearTarget() {
		System.out.println("Warning! 'One Year Target' is not applicable for this query.");
		return oneYearTarget;
	}

	public String getBeta() {
		System.out.println("Warning! 'Beta' is not applicable for this query.");
		return beta;
	}

	public String getEarnDate() {
		System.out.println("Warning! 'Earn Date' is not applicable for this query.");
		return earnDate;
	}

	public String getDaysRange() {
		System.out.println("Warning! 'Days Range' is not applicable for this query.");
		return daysRange;
	}

	public String getWeek52Range() {
		System.out.println("Warning! '52 Week Range' is not applicable for this query.");
		return week52Range;
	}

	public String getVolume() {
		System.out.println("Warning! '52 Week Range' is not applicable for this query.");
		return volume;
	}

	public String getAverageVolume() {
		System.out.println("Warning! 'Average Volume' is not applicable for this query.");
		return averageVolume;
	}

	public String getMarketCap() {
		System.out.println("Warning! 'Market Capitalization' is not applicable for this query.");
		return marketCap;
	}

	public String getPeRatio() {
		System.out.println("Warning! 'P/E Ratio' is not applicable for this query.");
		return peRatio;
	}

	public String getEarningsPerShare() {
		System.out.println("Warning! 'Earnings Per Share' is not applicable for this query.");
		return earningsPerShare;
	}

	public String getDividendYield() {
		System.out.println("Warning! 'Dividend Yield' is not applicable for this query.");
		return dividendYield;
	}

	public String getStockName() {
		System.out.println("Warning! 'Stock Name' is not applicable for this query.");
		return stockName;
	}
	
	public String getAll(){
		return (this.getStockName()+this.getAsk()+this.getAverageVolume()+this.getBeta()+this.getBid()+this.getDaysRange()+this.getDividendYield()+this.getEarnDate()+this.getEarningsPerShare()+this.getMarketCap()
				+this.getOneYearTarget()+this.getOpen()+this.getPeRatio()+this.getPreviousClose()+this.getVolume()+this.getWeek52Range());
	}
	

	
}
