package financialQueryTool;

import java.util.ArrayList;

public class Stock {
//	public ParamListInterface prevClose;
//	public ParamListInterface open;
//	public ParamListInterface ask;
//	public ParamListInterface oneYrTarg;
//	public ParamListInterface beta;
//	public ParamListInterface earnDate;
//	public ParamListInterface wk52Rng;
//	public ParamListInterface daysRng;
//	public ParamListInterface vol;
//	public ParamListInterface avgVol;
//	public ParamListInterface mktCap;
//	public ParamListInterface peTtm;
//	public ParamListInterface epsTtm;
//	public ParamListInterface divnYield;
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
	
	/*public ParamListInterface getPrevClose() {
		return prevClose;
	}
	public void setPrevClose(ParamListInterface prevClose) {
		this.prevClose = prevClose;
	}
	public ParamListInterface getOpen() {
		return open;
	}
	public void setOpen(ParamListInterface open) {
		this.open = open;
	}
	public ParamListInterface getAsk() {
		return ask;
	}
	public void setAsk(ParamListInterface ask) {
		this.ask = ask;
	}
	public ParamListInterface getOneYrTarg() {
		return oneYrTarg;
	}
	public void setOneYrTarg(ParamListInterface oneYrTarg) {
		this.oneYrTarg = oneYrTarg;
	}
	public ParamListInterface getBeta() {
		return beta;
	}
	public void setBeta(ParamListInterface beta) {
		this.beta = beta;
	}
	public ParamListInterface getEarnDate() {
		return earnDate;
	}
	public void setEarnDate(ParamListInterface earnDate) {
		this.earnDate = earnDate;
	}
	public ParamListInterface getDaysRng() {
		return daysRng;
	}
	public void setDaysRng(ParamListInterface daysRng) {
		this.daysRng = daysRng;
	}
	public ParamListInterface getWk52Rng() {
		return wk52Rng;
	}
	public void setWk52Rng(ParamListInterface wk52Rng) {
		this.wk52Rng = wk52Rng;
	}
	public ParamListInterface getVol() {
		return vol;
	}
	public void setVol(ParamListInterface vol) {
		this.vol = vol;
	}
	public ParamListInterface getAvgVol() {
		return avgVol;
	}
	public void setAvgVol(ParamListInterface avgVol) {
		this.avgVol = avgVol;
	}
	public ParamListInterface getMktCap() {
		return mktCap;
	}
	public void setMktCap(ParamListInterface mktCap) {
		this.mktCap = mktCap;
	}
	public ParamListInterface getPeTtm() {
		return peTtm;
	}
	public void setPeTtm(ParamListInterface peTtm) {
		this.peTtm = peTtm;
	}
	public ParamListInterface getEpsTtm() {
		return epsTtm;
	}
	public void setEpsTtm(ParamListInterface epsTtm) {
		this.epsTtm = epsTtm;
	}
	public ParamListInterface getDivnYield() {
		return divnYield;
	}
	public void setDivnYield(ParamListInterface divnYield) {
		this.divnYield = divnYield;
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
	}

	public void printDetails(Stock stock) {
		System.out.println("Printing Stock details for : " + stock.getStockName());
/*		System.out.println("Stock Close:" + stock.getPrevClose());
		System.out.println("Stock Open:"+stock.getOpen());
		System.out.println("Stock Ask:"+stock.getAsk());
		System.out.println("Stock One Year Target:"+stock.getOneYrTarg());
		System.out.println("Stock Beta:"+stock.getBeta());
		System.out.println("Stock Earn Date:"+stock.getEarnDate());
		System.out.println("Stock Day's Range:"+stock.getDaysRng());
		System.out.println("Stock 52-Week Range:"+stock.getWk52Rng());
		System.out.println("Stock Volume:"+stock.getVol());
		System.out.println("Stock Average Volume:"+stock.getAvgVol());
		System.out.println("Stock Market Capitalization:"+stock.getMktCap());
		System.out.println("Stock P/E Ttm:"+stock.getPeTtm());
		System.out.println("Stock Earnings per Share Ttm:"+stock.getEpsTtm());
		System.out.println("Stock Divident Yield:"+stock.getDivnYield());*/
//		System.out.println("Stock Stock Name:");
	}

}
