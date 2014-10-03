package financialQueryTool.stockPkg;

import java.util.HashMap;
import java.util.Map;

import javax.management.RuntimeErrorException;

import financialQueryTool.parametersPkg.ParamAsk;
import financialQueryTool.parametersPkg.ParamAverageVolume;
import financialQueryTool.parametersPkg.ParamBeta;
import financialQueryTool.parametersPkg.ParamBid;
import financialQueryTool.parametersPkg.ParamDaysRange;
import financialQueryTool.parametersPkg.ParamDividendYield;
import financialQueryTool.parametersPkg.ParamEarnDate;
import financialQueryTool.parametersPkg.ParamEarningsPerShare;
import financialQueryTool.parametersPkg.ParamListInterface;
import financialQueryTool.parametersPkg.ParamMarketCapitalization;
import financialQueryTool.parametersPkg.ParamOneYearTarget;
import financialQueryTool.parametersPkg.ParamOpen;
import financialQueryTool.parametersPkg.ParamPERatio;
import financialQueryTool.parametersPkg.ParamPreviousClose;
import financialQueryTool.parametersPkg.ParamStockName;
import financialQueryTool.parametersPkg.ParamStockSym;
import financialQueryTool.parametersPkg.ParamVolume;
import financialQueryTool.parametersPkg.ParamWeekRange;
import financialQueryTool.queryParametersPkg.QueryParamInterface;

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
		this.setStockName((ParamStockName) stockName);
		this.stockSym = (ParamStockSym) stockName;
	}
	
	
	
	/**
	 * This method sets the query code to the stock object. The query code depends on the query type and set based on the values 
	 * implementing the 'QueryParamInterface'
	 * @param stock
	 * @param paramCodeValues
	 */
	public static void setAllParamsQueryCode (Stock stock, QueryParamInterface paramCodeValues) {
		System.out.println("Setting the Parameter's Query Code.");
		
		stock.getStockAsk().setQueryCode(paramCodeValues.getParamAskVal());
		stock.getStockAverageVolume().setQueryCode(paramCodeValues.getParamAverageVolumeVal());
		stock.getStockBeta().setQueryCode(paramCodeValues.getParamBetaVal());
		stock.getStockBid().setQueryCode(paramCodeValues.getParamBidVal());
		stock.getStockDaysRange().setQueryCode(paramCodeValues.getParamDaysRangeVal());
		stock.getStockDividendYield().setQueryCode(paramCodeValues.getParamDividendYieldVal());
		stock.getStockEarnDate().setQueryCode(paramCodeValues.getParamEarnDateVal());
		stock.getStockEarningsPerShare().setQueryCode(paramCodeValues.getParamEarningsPerShareVal());
		stock.getStockMarketCapitalization().setQueryCode(paramCodeValues.getParamMarketCapitalizationVal());
		stock.getStockOneYearTarget().setQueryCode(paramCodeValues.getParamOneYearTargetVal());
		stock.getStockOpen().setQueryCode(paramCodeValues.getParamOpenVal());
		stock.getStockPERatio().setQueryCode(paramCodeValues.getParamPERatioVal());
		stock.getStockPreviousClose().setQueryCode(paramCodeValues.getParamPreviousCloseVal());
		stock.getStockVolume().setQueryCode(paramCodeValues.getParamVolumeVal());
		stock.getstockWeekRange().setQueryCode(paramCodeValues.getParamWeekRangeVal());
		
	}

	
	/**
	 * Main constructor which creates the stock object and initializes the Parameters like 'ParamAsk','ParamBid' etc
	 * by creating new instances of these Parameters.
	 * @param stockSym
	 */
	public Stock(String stockSym) {
		ParamStockName stockName = new ParamStockName();
		stockName.setparamData(stockSym);
		ParamStockSym stockSymbol = new ParamStockSym();
		stockSymbol.setparamData(stockSym);
		this.stockSym=stockSymbol;
		this.setStockName(stockName);
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
		this.setStockWeekRange(new ParamWeekRange());
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
		System.out.println("\tStock 52-Week Range:"+this.getStockWeekRangeStr());
		System.out.println("\tStock Volume:"+this.getStockVolumeStr());
		System.out.println("\tStock Average Volume:"+this.getStockAverageVolumeStr());
		System.out.println("\tStock Market Capitalization:"+this.getStockMarketCapitalizationStr());
		System.out.println("\tStock P/E Ttm:"+this.getStockPERatioStr());
		System.out.println("\tStock Earnings per Share Ttm:"+this.getStockPERatioStr());
		System.out.println("\tStock Divident Yield:"+this.getStockDividendYieldStr());
		System.out.println("Stock Symbol:"+this.getStockSymStr());
	}

	public Map<String, String> getRequiredParamData(String[] requiredParameters)  {
		Map<String, String> requiredParametersData = new HashMap<String, String>();

		for (String requiredParam : requiredParameters) {
			if (requiredParam.equalsIgnoreCase(this.stockAsk.getparamName())) {
				System.out.println("Stock Ask data: " + this.getStockAskStr());
				requiredParametersData.put(this.stockAsk.getparamName(), this.getStockAskStr());
			}
			else if (requiredParam.equalsIgnoreCase(this.stockAverageVolume.getparamName())) {
				System.out.println("Stock " + this.stockAverageVolume.getparamName() + " data: " + this.getStockAverageVolumeStr());
				requiredParametersData.put(this.stockAverageVolume.getparamName(), this.getStockAverageVolumeStr());
			}
			else if (requiredParam.equalsIgnoreCase(this.stockBeta.getparamName())) {
				System.out.println("Stock " + this.stockBeta.getparamName() + " data: " + this.getStockBetaStr());
				requiredParametersData.put(this.stockBeta.getparamName(), this.getStockBetaStr());
			}
			else if (requiredParam.equalsIgnoreCase(this.stockBid.getparamName())) {
				System.out.println("Stock " + this.stockBid.getparamName()+ " data: " + this.getStockBidStr());
				requiredParametersData.put(this.stockBid.getparamName(), this.getStockBidStr());
			}
			else if (requiredParam.equalsIgnoreCase(this.stockDaysRange.getparamName())) {
				System.out.println("Stock " + this.stockDaysRange.getparamName() + " data: " + this.getStockDaysRangeStr());
				requiredParametersData.put(this.stockDaysRange.getparamName(), this.getStockDaysRangeStr());
			}
			else if (requiredParam.equalsIgnoreCase(this.stockDividendYield.getparamName())) {
				System.out.println("Stock "+ this.stockDividendYield.getparamName() + " data: " + this.getStockDividendYieldStr());
				requiredParametersData.put(this.stockDividendYield.getparamName(),  this.getStockDividendYieldStr());
			}
			else if (requiredParam.equalsIgnoreCase(this.stockEarnDate.getparamName())) {
				System.out.println("Stock " + this.stockEarnDate.getparamName() + " data: " + this.getStockEarnDateStr());
				requiredParametersData.put(this.stockEarnDate.getparamName(), this.getStockEarnDateStr());
			}
			else if (requiredParam.equalsIgnoreCase(this.stockEarningsPerShare.getparamName())) {
				System.out.println("Stock " + this.stockEarningsPerShare.getparamName() + " data: " + this.getStockEarningsPerShareStr());
				requiredParametersData.put(this.stockEarningsPerShare.getparamName(), this.getStockEarningsPerShareStr());
			}
			else if (requiredParam.equalsIgnoreCase(this.stockMarketCapitalization.getparamName())) {
				System.out.println("Stock " + this.stockMarketCapitalization.getparamName() + " data: " + this.getStockMarketCapitalizationStr());
				requiredParametersData.put(this.stockMarketCapitalization.getparamName(), this.getStockMarketCapitalizationStr());
			}
			else if (requiredParam.equalsIgnoreCase(this.stockOneYearTarget.getparamName())) {
				System.out.println("Stock " + this.stockOneYearTarget.getparamName() + " data: " + this.getStockOneYearTargetStr());
				requiredParametersData.put(this.stockOneYearTarget.getparamName(), this.getStockOneYearTargetStr());
			}
			else if (requiredParam.equalsIgnoreCase(this.stockOpen.getparamName())) {
				System.out.println("Stock " + this.stockOpen.getparamName() + "  data: " + this.getStockOpenStr());
				requiredParametersData.put(this.stockOpen.getparamName(), this.getStockOpenStr());
			}
			else if (requiredParam.equalsIgnoreCase(this.stockPERatio.getparamName())) {
				System.out.println("Stock " + this.stockPERatio.getparamName()+ "  data: " + this.getStockPERatioStr());
				requiredParametersData.put(this.stockPERatio.getparamName(), this.getStockPERatioStr());
			}
			else if (requiredParam.equalsIgnoreCase(this.stockPreviousClose.getparamName())) {
				System.out.println("Stock " + this.stockPreviousClose.getparamName()+ "  data: " + this.getStockPreviousCloseStr());
				requiredParametersData.put(this.stockPreviousClose.getparamName(), this.getStockPreviousCloseStr());
			}
			else if (requiredParam.equalsIgnoreCase(this.getStockNameParam().getparamName())) {
				System.out.println("Stock " + this.getStockNameParam().getparamName()+ "  data: " + this.getStockName());
				requiredParametersData.put(this.getStockNameParam().getparamName(), this.getStockName());
			}
			else if (requiredParam.equalsIgnoreCase(this.stockSym.getparamName())) {
				System.out.println("Stock " + this.stockSym.getparamName() + "  data: " + this.getStockSymStr());
				requiredParametersData.put(this.stockSym.getparamName(), this.getStockSymStr());
			}
			else if (requiredParam.equalsIgnoreCase(this.stockVolume.getparamName())) {
				System.out.println("Stock " + this.stockVolume.getparamName()+ "  data: " + this.getStockVolumeStr());
				requiredParametersData.put(this.stockVolume.getparamName(), this.getStockVolumeStr());
			}
			else if (requiredParam.equalsIgnoreCase(this.getStockWeekRange().getparamName())) {
				System.out.println("Stock " + this.getStockWeekRange().getparamName()+ "  data: " + this.getStockWeekRangeStr());
				requiredParametersData.put(this.getStockWeekRange().getparamName(), this.getStockWeekRangeStr());
			}
			else {
				throw new RuntimeErrorException(null, "Invalid parameter passed for Query Request. \n" + requiredParam);
			}

		}
		return requiredParametersData;
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
		return getStockWeekRange();
	}
	/*
	 * Getter methods to return Data as String values for each of the parameters.
	 * 
	 */

	public String getStockAskStr() {
		return stockAsk.getparamData().replaceAll(",", "");
	}
	public String getStockAverageVolumeStr() {
		return stockAverageVolume.getparamData().replaceAll(",", "");
	}
	public String getStockBetaStr() {
		return stockBeta.getparamData().replaceAll(",", "");
	}
	public String getStockBidStr() {
		return stockBid.getparamData().replaceAll(",", "");
	}
	public String getStockDaysRangeStr() {
		if (stockDaysRange.getparamData().length() != 0) {
			return stockDaysRange.getparamData().replaceAll(",", "");
		}
		return stockDaysRange.getparamData();
	}
	public String getStockDividendYieldStr() {
		if (stockDividendYield.getparamData().length() != 0) {
			return stockDividendYield.getparamData().replaceAll(",", "");
		}
		return stockDividendYield.getparamData();
	}
	public String getStockEarnDateStr() {
		if (!stockEarnDate.getparamData().isEmpty()) {
			return stockEarnDate.getparamData().replaceAll(",", "");
		}
		return stockEarnDate.getparamData();
	}
	public String getStockEarningsPerShareStr() {
		return stockEarningsPerShare.getparamData().replaceAll(",", "");
	}
	public String getStockMarketCapitalizationStr() {
		return stockMarketCapitalization.getparamData().replaceAll(",", "");
	}
	public String getStockOneYearTargetStr() {
		return stockOneYearTarget.getparamData().replaceAll(",", "");
	}
	public String getStockOpenStr() {
		return stockOpen.getparamData().replaceAll(",", "");
	}
	public String getStockPERatioStr() {
		return stockPERatio.getparamData().replaceAll(",", "");
	}
	public String getStockPreviousCloseStr() {
		return stockPreviousClose.getparamData().replaceAll(",", "");
	}
	public String getStockVolumeStr() {
		return stockVolume.getparamData().replaceAll(",", "");
	}
	public String getStockWeekRangeStr() {
		return getStockWeekRange().getparamData().replaceAll(",", "");
	}
	public String getStockName() {
		return this.getStockNameParam().getparamData().replaceAll(",", "");
	}
	public String getStockNameStr() {
		return this.getStockNameParam().getparamData().replaceAll(",", "");
	}
	public String getStockSymStr() {
		return this.stockSym.getparamData().replaceAll(",", "");
	}

	public void setStockName(ParamListInterface stockName) {
		this.stockName = (ParamStockName) stockName;
	}
	public ParamStockName getStockNameParam() {
		return stockName;
	}
	public void setStockName(ParamStockName stockName) {
		this.stockName = stockName;
	}
	public ParamWeekRange getStockWeekRange() {
		return stockWeekRange;
	}
	public void setStockWeekRange(ParamWeekRange stockWeekRange) {
		this.stockWeekRange = stockWeekRange;
	}
}
