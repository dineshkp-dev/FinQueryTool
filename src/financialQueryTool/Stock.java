package financialQueryTool;

public class Stock {
	public ParamAsk stockAsk;
	public ParamAverageVolume stockAverageVolume;
	public ParamBeta stockBeta;
	public ParamBid stockBid;
	public ParamDaysRange stockDaysRange;
	public ParamDividendYield stockDividendYield;
	public ParamEarnDate stockEarnDate;
	public ParamEarningsPerShare stockEarningsPerShare;
	public ParamMarketCapitalization stockMarketCapitalization;
	public ParamOneYearTarget stockOneYearTarget;
	public ParamOpen stockOpen;
	public ParamPERatio stockPERatio;
	public ParamStockName stockName;
	public ParamPreviousClose stockPreviousClose;
	public ParamVolume stockVolume;
	public ParamWeekRange stockWeekRange;

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

	public String getStockName() {
		return this.stockName.getparamData();
	}
	public void setStockName(ParamListInterface stockName) {
		this.stockName = (ParamStockName) stockName;
	}

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
	//	public Stock(ParamPreviousClose prevClose, ParamListInterface open, ParamListInterface ask, ParamListInterface oneYrTarg,
	//			ParamListInterface beta, ParamListInterface earnDate, ParamListInterface daysRng, ParamListInterface wk52Rng,
	//			ParamListInterface vol, ParamListInterface avgVol, ParamListInterface mktCap, ParamListInterface peTtm,
	//			ParamListInterface epsTtm, ParamListInterface divnYield, ParamStockName stockName) {
	//
	///*		this.prevClose = prevClose;
	//		this.open = open;
	//		this.ask = ask;
	//		this.oneYrTarg = oneYrTarg;
	//		this.beta = beta;
	//		this.earnDate = earnDate;
	//		this.daysRng = daysRng;
	//		this.wk52Rng = wk52Rng;
	//		this.vol = vol;
	//		this.avgVol = avgVol;
	//		this.mktCap = mktCap;
	//		this.peTtm = peTtm;
	//		this.epsTtm = epsTtm;
	//		this.divnYield = divnYield;*/
	//		this.stockName = stockName;
	//	}
	@SuppressWarnings("unused")
	public Stock(){

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


}
