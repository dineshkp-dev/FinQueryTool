package main.java.financialQueryTool.control.queryParametersPkg;

import java.util.ArrayList;

import main.java.financialQueryTool.model.parametersPkg.ParamAsk;
import main.java.financialQueryTool.model.parametersPkg.ParamAverageVolume;
import main.java.financialQueryTool.model.parametersPkg.ParamBid;
import main.java.financialQueryTool.model.parametersPkg.ParamDaysRange;
import main.java.financialQueryTool.model.parametersPkg.ParamDividendYield;
import main.java.financialQueryTool.model.parametersPkg.ParamEarningsPerShare;
import main.java.financialQueryTool.model.parametersPkg.ParamListInterface;
import main.java.financialQueryTool.model.parametersPkg.ParamMarketCapitalization;
import main.java.financialQueryTool.model.parametersPkg.ParamOneYearTarget;
import main.java.financialQueryTool.model.parametersPkg.ParamOpen;
import main.java.financialQueryTool.model.parametersPkg.ParamPERatio;
import main.java.financialQueryTool.model.parametersPkg.ParamPreviousClose;
import main.java.financialQueryTool.model.parametersPkg.ParamStockName;
import main.java.financialQueryTool.model.parametersPkg.ParamVolume;
import main.java.financialQueryTool.model.parametersPkg.ParamWeekRange;
import main.java.financialQueryTool.model.stockPkg.Stock;

public class APIQueryParameters implements QueryParamInterface{
	private static String ParamAskVal = "a";
	private static String ParamAverageVolumeVal = "a2";
	private static String ParamBidVal = "b";
	private static String ParamBetaVal = "";// NA
	private static String ParamDaysRangeVal = "m";
	private static String ParamDividendYieldVal = "y";
	private static String ParamEarnDateVal = ""; //NA
	private static String ParamEarningsPerShareVal = "e";
	private static String ParamMarketCapitalizationVal = "j1";
	private static String ParamOneYearTargetVal = "t8";
	private static String ParamOpenVal = "o";
	private static String ParamPERatioVal = "r";
	private static String ParamPreviousCloseVal = "p";
	private static String ParamStockNameVal = "n";
	private static String ParamStockSymVal = ""; //NA
	private static String ParamVolumeVal = "v";
	private static String ParamWeekRangeVal = "w";

	public static ArrayList<ParamListInterface> queryParamList () {
		ArrayList<ParamListInterface> applicableQueryParams = new ArrayList<ParamListInterface>();

		applicableQueryParams.add(new ParamAsk());//a
		applicableQueryParams.add(new ParamAverageVolume());
		/*applicableQueryParams.add(new ParamBeta());*/
		applicableQueryParams.add(new ParamBid());//b
		applicableQueryParams.add(new ParamDaysRange());//m
		applicableQueryParams.add(new ParamDividendYield());//y
		/*applicableQueryParams.add(new ParamEarnDate());*/
		applicableQueryParams.add(new ParamEarningsPerShare());//e
		applicableQueryParams.add(new ParamMarketCapitalization());//j1
		applicableQueryParams.add(new ParamOneYearTarget());//t8
		applicableQueryParams.add(new ParamOpen());//o
		applicableQueryParams.add(new ParamPERatio());//r
		applicableQueryParams.add(new ParamPreviousClose());//p
		applicableQueryParams.add(new ParamStockName());//n
		/*applicableQueryParams.add(new ParamStockSym());*/
		applicableQueryParams.add(new ParamVolume());//v
		applicableQueryParams.add(new ParamWeekRange());//w

		return applicableQueryParams;
	}
	@Override
	public  String getParamAskVal() {
		return ParamAskVal;
	}
	@Override
	public  String getParamAverageVolumeVal() {
		return ParamAverageVolumeVal;
	}
	@Override
	public  String getParamBidVal() {
		return ParamBidVal;
	}
	@Override
	public  String getParamDaysRangeVal() {
		return ParamDaysRangeVal;
	}
	@Override
	public  String getParamDividendYieldVal() {
		return ParamDividendYieldVal;
	}
	@Override
	public  String getParamEarningsPerShareVal() {
		return ParamEarningsPerShareVal;
	}
	@Override
	public  String getParamMarketCapitalizationVal() {
		return ParamMarketCapitalizationVal;
	}
	@Override
	public  String getParamOneYearTargetVal() {
		return ParamOneYearTargetVal;
	}
	@Override
	public  String getParamOpenVal() {
		return ParamOpenVal;
	}
	@Override
	public  String getParamPERatioVal() {
		return ParamPERatioVal;
	}
	@Override
	public  String getParamPreviousCloseVal() {
		return ParamPreviousCloseVal;
	}
	@Override
	public  String getParamStockNameVal() {
		return ParamStockNameVal;
	}
	@Override
	public String getParamVolumeVal() {
		return ParamVolumeVal;
	}
	@Override
	public  String getParamWeekRangeVal() {
		return ParamWeekRangeVal;
	}
	@Override
	public String getParamEarnDateVal() {
		return ParamEarnDateVal;
	}
	@Override
	public String getParamStockSymVal() {
		return ParamStockSymVal;
	}
	@Override
	public String getParamBetaVal() {
		return ParamBetaVal;
	}
	@Override
	public String getAllQueryParams() {
		String queryParams = "";
		System.out.println("Generating string for all applicable Query Values for API.");
		queryParams = getParamAskVal() + getParamAverageVolumeVal() + getParamBidVal() + getParamDaysRangeVal() + getParamDividendYieldVal() + getParamEarningsPerShareVal()
				+ getParamMarketCapitalizationVal() + getParamOneYearTargetVal() + getParamOpenVal() + getParamPERatioVal() + getParamPreviousCloseVal() + getParamStockNameVal()
				+ getParamVolumeVal() + getParamWeekRangeVal();
		return queryParams;
	}
	@Override
	public String getApplicableQueryParams() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String[] getAllQueryParamsArray() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String[] getApplicableQueryParamsArray() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 581.13,1534680,580.72,"579.11 - 581.74",N/A,19.30,392.9B,N/A,580.36,30.21,583.10,"Google Inc.",172180,"502.80 - 604.83"
	 * Adds all the information from the query result for each stock
	 * @param stockData
	 * @param stock
	 * @return
	 * Row0 Value: 
	 * ask:587.80,
	 * volume:1548080,
	 * beta:582.80,
	 * daysrange: "581.95 - 586.55",
	 * divnyield: N/A,
	 * Earndate:19.30,
	 * EpsTTM: 396.4B,
	 * MktCap: N/A,
	 * One year target: 583.95,
	 * Open: 30.15,581.98,
	 * PeTTM: "Google Inc.",
	 * Prevclose: 1629518,
	 * Volume: 
	 * W52 Week Range: "502.80 - 604.83"
	 */
	public static Stock addApiStockData(String[] data, Stock stock) {
		System.out.println("Setting stock data for : " + stock.getStockName());
		stock.getStockAsk().setparamData(data[0]);
		stock.getStockAverageVolume().setparamData(data[1]);
		stock.getStockBid().setparamData(data[2]);
		stock.getStockDaysRange().setparamData(data[3]);
		stock.getStockDividendYield().setparamData(data[4]);
		stock.getStockEarningsPerShare().setparamData(data[5]);
		stock.getStockMarketCapitalization().setparamData(data[6]);
		stock.getStockOneYearTarget().setparamData(data[7]);
		stock.getStockOpen().setparamData(data[8]);
		stock.getStockPERatio().setparamData(data[9]);
		stock.getStockPreviousClose().setparamData(data[10]);
		stock.getStockNameParam().setparamData(data[11]);
		stock.getStockVolume().setparamData(data[12]);
		stock.getStockWeekRange().setparamData(data[13].trim());
		return stock;
	}

	



}
