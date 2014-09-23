package financialQueryTool;

import javax.management.RuntimeErrorException;

public class Stock {
	protected ParamAsk stockAsk;
	protected ParamAverageVolume stockAverageVolume;
	protected ParamBeta stockBeta;
	protected ParamBid stockBid;
	protected ParamDaysRange stockDaysRange;
	protected ParamDividendYield stockDividendYield;
	protected ParamEarnDate stockEarnDate;
	protected ParamEarningsPerShare stockEarningsPerShare;
	protected ParamMarketCapitalization stockMarketCapitalization;
	protected ParamOneYearTarget stockOneYearTarget;
	protected ParamOpen stockOpen;
	protected ParamPERatio stockPERatio;
	protected ParamStockName stockName;
	protected ParamStockSym stockSym;
	protected ParamPreviousClose stockPreviousClose;
	protected ParamVolume stockVolume;
	protected ParamWeekRange stockWeekRange;

	/*	
	public String getValidParamList(){
		String validParamList = "";
		ArrayList<ParamListInterface> paramList = new ArrayList<ParamListInterface>();
		ParamListInterface parameter = new ParamAsk();
		if (parameter.getparamUlsdCode() != "") {
			paramList.add(parameter);
		}

		return validParamList;

	}*/



	/**
	 * @param prevClose
	 * @param open
	 * @param ask
	 * @param oneYrTarg
	 * @param beta
	 * @param earnDate
	 * @param daysRng
	 * @param wk52Rng
	 * @param vol
	 * @param avgVol
	 * @param mktCap
	 * @param peTtm
	 * @param epsTtm
	 * @param divnYield
	 */
	private Stock(){

	}
	public Stock(ParamListInterface stockName) {
		this.stockName = (ParamStockName) stockName;
	}

	public Stock(String stockSym) {
		ParamStockName stockName = new ParamStockName();
		stockName.setparamData(stockSym);
		this.stockName=stockName;
		this.stockAsk=new ParamAsk();
		this.stockAverageVolume=new ParamAverageVolume();
		this.stockBeta = new ParamBeta();
		this.stockBid = new ParamBid();
		this.stockDaysRange = new ParamDaysRange();
		this.stockDividendYield = new ParamDividendYield();
		this.stockEarnDate = new ParamEarnDate();
		this.stockEarningsPerShare = new ParamEarningsPerShare();
		this.stockMarketCapitalization = new ParamMarketCapitalization();
		this.stockOneYearTarget = new ParamOneYearTarget();
		this.stockOpen = new ParamOpen();
		this.stockPERatio = new ParamPERatio();
		this.stockPreviousClose = new ParamPreviousClose();
		this.stockVolume = new ParamVolume();
		this.stockWeekRange = new ParamWeekRange();

	}

	public void printDetails() {
		System.out.println("Printing Stock details for : " + this.getStockName());
		System.out.println("\tStock Close:" + this.getStockPreviousCloseStr());
		System.out.println("\tStock Open:"+this.getStockOpenStr());
		System.out.println("\tStock Ask:"+this.getStockAskStr());
		System.out.println("\tStock One Year Target:"+this.getStockOneYearTargetStr());
		System.out.println("\tStock Beta:"+this.getStockBetaStr());
		System.out.println("\tStock Earn Date:"+this.getStockEarnDateStr());
		System.out.println("\tStock Day's Range:"+this.getStockDaysRangeStr());
		System.out.println("\tStock 52-Week Range:"+this.getstockWeekRangeStr());
		System.out.println("\tStock Volume:"+this.getStockVolumeStr());
		System.out.println("\tStock Average Volume:"+this.getStockAverageVolumeStr());
		System.out.println("\tStock Market Capitalization:"+this.getStockMarketCapitalizationStr());
		System.out.println("\tStock P/E Ttm:"+this.getStockPERatioStr());
		System.out.println("\tStock Earnings per Share Ttm:"+this.getStockPERatioStr());
		System.out.println("\tStock Divident Yield:"+this.getStockDividendYieldStr());
		//		System.out.println("Stock Stock Name:"+this.getStock);
	}

	public String getRequiredParamData(String[] requiredParameters)  {
		String requiredParametersStr = "";

		for (String requiredParam : requiredParameters) {
			if (requiredParam.equalsIgnoreCase(this.stockAsk.getparamName())) {
				System.out.println("Stock Ask data: " + this.getStockAskStr());
			}
			else if (requiredParam.equalsIgnoreCase(this.stockAverageVolume.getparamName())) {
				System.out.println("Stock " + this.stockAverageVolume.getparamName() + " data: " + this.getStockAverageVolumeStr());
			}
			else if (requiredParam.equalsIgnoreCase(this.stockBeta.getparamName())) {
				System.out.println("Stock " + this.stockBeta.getparamName() + " data: " + this.getStockBetaStr());
			}
			else if (requiredParam.equalsIgnoreCase(this.stockBid.getparamName())) {
				System.out.println("Stock " + this.stockBid.getparamName()+ " data: " + this.getStockBidStr());
			}
			else if (requiredParam.equalsIgnoreCase(this.stockDaysRange.getparamName())) {
				System.out.println("Stock " + this.stockDaysRange.getparamName() + " data: " + this.getStockDaysRangeStr());
			}
			else if (requiredParam.equalsIgnoreCase(this.stockDividendYield.getparamName())) {
				System.out.println("Stock "+ this.stockDividendYield.getparamName() + " data: " + this.getStockDividendYieldStr());
			}
			else if (requiredParam.equalsIgnoreCase(this.stockEarnDate.getparamName())) {
				System.out.println("Stock " + this.stockEarnDate.getparamName() + " data: " + this.getStockEarnDateStr());
			}
			else if (requiredParam.equalsIgnoreCase(this.stockEarningsPerShare.getparamName())) {
				System.out.println("Stock " + this.stockEarningsPerShare.getparamName() + " data: " + this.getStockEarningsPerShareStr());
			}
			else if (requiredParam.equalsIgnoreCase(this.stockMarketCapitalization.getparamName())) {
				System.out.println("Stock " + this.stockMarketCapitalization.getparamName() + " data: " + this.getStockMarketCapitalizationStr());
			}
			else if (requiredParam.equalsIgnoreCase(this.stockOneYearTarget.getparamName())) {
				System.out.println("Stock " +this.stockOneYearTarget.getparamName() + " data: " + this.getStockOneYearTargetStr());
			}
			else if (requiredParam.equalsIgnoreCase(this.stockOpen.getparamName())) {
				System.out.println("Stock " + this.stockOpen.getparamName()+ "  data: " + this.getStockOpenStr());
			}
			else if (requiredParam.equalsIgnoreCase(this.stockPERatio.getparamName())) {
				System.out.println("Stock " + this.stockPERatio.getparamName()+ "  data: " + this.getStockPERatioStr());
			}
			else if (requiredParam.equalsIgnoreCase(this.stockPreviousClose.getparamName())) {
				System.out.println("Stock " + this.stockPreviousClose.getparamName()+ "  data: " + this.getStockPreviousCloseStr());
			}
			else if (requiredParam.equalsIgnoreCase(this.stockName.getparamName())) {
				System.out.println("Stock " + this.stockName.getparamName()+ "  data: " + this.getStockName());
			}
			else if (requiredParam.equalsIgnoreCase(this.stockSym.getparamName())) {
				System.out.println("Stock " + this.stockSym.getparamName()+ "  data: " + this.getStockSymStr());
			}
			else if (requiredParam.equalsIgnoreCase(this.stockVolume.getparamName())) {
				System.out.println("Stock " + this.stockVolume.getparamName()+ "  data: " + this.getStockVolumeStr());
			}
			else if (requiredParam.equalsIgnoreCase(this.stockWeekRange.getparamName())) {
				System.out.println("Stock " + this.stockWeekRange.getparamName()+ "  data: " + this.getstockWeekRangeStr());
			}
			else {
				throw new RuntimeErrorException(null, "Invalid parameter passed for Query Request. \n" + requiredParam);
			}

		}
		return requiredParametersStr;
	}
	
	public ParamAsk getStockAsk() {
		return stockAsk;
	}
	public ParamAverageVolume getStockAverageVolume() {
		return stockAverageVolume;
	}
	public ParamBeta getStockBeta() {
		return stockBeta;
	}
	public ParamBid getStockBid() {
		return stockBid;
	}
	public ParamDaysRange getStockDaysRange() {
		return stockDaysRange;
	}
	public ParamDividendYield getStockDividendYield() {
		return stockDividendYield;
	}
	public ParamEarnDate getStockEarnDate() {
		return stockEarnDate;
	}
	public ParamEarningsPerShare getStockEarningsPerShare() {
		return stockEarningsPerShare;
	}
	public ParamMarketCapitalization getStockMarketCapitalization() {
		return stockMarketCapitalization;
	}
	public ParamOneYearTarget getStockOneYearTarget() {
		return stockOneYearTarget;
	}
	public ParamOpen getStockOpen() {
		return stockOpen;
	}
	public ParamPERatio getStockPERatio() {
		return stockPERatio;
	}
	public ParamPreviousClose getStockPreviousClose() {
		return stockPreviousClose;
	}
	public ParamStockSym getStockSym() {
		return stockSym;
	}
	public ParamVolume getStockVolume() {
		return stockVolume;
	}
	public ParamWeekRange getstockWeekRange() {
		return stockWeekRange;
	}
	/*
	 * Getter methods to return Data as String values for each of the parameters.
	 * 
	 */

	public String getStockAskStr() {
		return stockAsk.getparamData();
	}
	public String getStockAverageVolumeStr() {
		return stockAverageVolume.getparamData();
	}
	public String getStockBetaStr() {
		return stockBeta.getparamData();
	}
	public String getStockBidStr() {
		return stockBid.getparamData();
	}
	public String getStockDaysRangeStr() {
		return stockDaysRange.getparamData();
	}
	public String getStockDividendYieldStr() {
		return stockDividendYield.getparamData();
	}
	public String getStockEarnDateStr() {
		return stockEarnDate.getparamData();
	}
	public String getStockEarningsPerShareStr() {
		return stockEarningsPerShare.getparamData();
	}
	public String getStockMarketCapitalizationStr() {
		return stockMarketCapitalization.getparamData();
	}
	public String getStockOneYearTargetStr() {
		return stockOneYearTarget.getparamData();
	}
	public String getStockOpenStr() {
		return stockOpen.getparamData();
	}
	public String getStockPERatioStr() {
		return stockPERatio.getparamData();
	}
	public String getStockPreviousCloseStr() {
		return stockPreviousClose.getparamData();
	}
	public String getStockVolumeStr() {
		return stockVolume.getparamData();
	}
	public String getstockWeekRangeStr() {
		return stockWeekRange.getparamData();
	}
	public String getStockName() {
		return this.stockName.getparamData();
	}
	public String getStockNameStr() {
		return this.stockName.getparamData();
	}
	public void setStockName(ParamListInterface stockName) {
		this.stockName = (ParamStockName) stockName;
	}

	public String getStockSymStr() {
		return this.stockSym.getparamData();
	}

}
