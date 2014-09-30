package financialQueryTool;

import java.util.ArrayList;

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

	/*	public static String getAllQueryValues() {
		String queryParams = "";
		System.out.println("Generating string for all applicable Query Values for API.");
		queryParams = getParamAskVal() + getParamAverageVolumeVal() + getParamBidVal() + getParamDaysRangeVal() + getParamDividendYieldVal() + getParamEarningsPerShareVal()
				+ getParamMarketCapitalizationVal() + getParamOneYearTargetVal() + getParamOpenVal() + getParamPERatioVal() + getParamPreviousCloseVal() + getParamStockNameVal()
				+ getParamVolumeVal() + getParamWeekRangeVal();
		return queryParams;
	}*/




}
