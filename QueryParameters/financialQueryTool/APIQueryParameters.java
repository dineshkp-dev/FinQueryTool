package financialQueryTool;

import java.util.ArrayList;

public class APIQueryParameters {
	private static String ParamAskVal = "a";
	private static String ParamAverageVolumeVal = "a2";
	private static String ParamBidVal = "b";
	private static String ParamDaysRangeVal = "m";
	private static String ParamDividendYieldVal = "y";
	private static String ParamEarningsPerShareVal = "e";
	private static String ParamMarketCapitalizationVal = "j1";
	private static String ParamOneYearTargetVal = "t8";
	private static String ParamOpenVal = "o";
	private static String ParamPERatioVal = "r";
	private static String ParamPreviousCloseVal = "p";
	private static String ParamStockNameVal = "n";
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
	public static String getParamAskVal() {
		return ParamAskVal;
	}
	public static String getParamAverageVolumeVal() {
		return ParamAverageVolumeVal;
	}
	public static String getParamBidVal() {
		return ParamBidVal;
	}
	public static String getParamDaysRangeVal() {
		return ParamDaysRangeVal;
	}
	public static String getParamDividendYieldVal() {
		return ParamDividendYieldVal;
	}
	public static String getParamEarningsPerShareVal() {
		return ParamEarningsPerShareVal;
	}
	public static String getParamMarketCapitalizationVal() {
		return ParamMarketCapitalizationVal;
	}
	public static String getParamOneYearTargetVal() {
		return ParamOneYearTargetVal;
	}
	public static String getParamOpenVal() {
		return ParamOpenVal;
	}
	public static String getParamPERatioVal() {
		return ParamPERatioVal;
	}
	public static String getParamPreviousCloseVal() {
		return ParamPreviousCloseVal;
	}
	public static String getParamStockNameVal() {
		return ParamStockNameVal;
	}
	public static String getParamVolumeVal() {
		return ParamVolumeVal;
	}
	public static String getParamWeekRangeVal() {
		return ParamWeekRangeVal;
	}

	public static String getAllQueryValues() {
		String queryParams = "";
		System.out.println("Generating string for all applicable Query Values for API.");
		queryParams = getParamAskVal() + getParamAverageVolumeVal() + getParamBidVal() + getParamDaysRangeVal() + getParamDividendYieldVal() + getParamEarningsPerShareVal()
				+ getParamMarketCapitalizationVal() + getParamOneYearTargetVal() + getParamOpenVal() + getParamPERatioVal() + getParamPreviousCloseVal() + getParamStockNameVal()
				+ getParamVolumeVal() + getParamWeekRangeVal();
		return queryParams;
	}

}
