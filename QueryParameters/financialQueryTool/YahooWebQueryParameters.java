package financialQueryTool;

/*
 * Prev Close:	3.70,Open:	3.70,Bid:	3.61 x 16600,Ask:	3.64 x 18600
 * 1y Target Est:	4.15,Beta:	2.21,Next Earnings Date:	16-Oct-14,
 * Day's Range:	3.60 - 3.72,52wk Range:	3.04 - 4.80,Volume:	17,556,480,
 * Avg Vol (3m):	29,145,400,Market Cap:	2.78B,P/E (ttm):	33.93,
 * EPS (ttm):	0.11,Div & Yield:	N/A (N/A)
 */

public class YahooWebQueryParameters implements QueryParamInterface {
	private static String ParamAskVal = "Ask:";
	private static String ParamAverageVolumeVal = "Avg Vol (3m):";
	private static String ParamBetaVal = "Beta:";
	private static String ParamBidVal = "Bid:";
	private static String ParamDaysRangeVal = "Day's Range:";
	private static String ParamDividendYieldVal = "Div & Yield:";
	private static String ParamEarnDateVal = "Earnings Date:";
	private static String ParamEarningsPerShareVal = "EPS (ttm):";
	private static String ParamMarketCapitalizationVal = "Market Cap:";
	private static String ParamOneYearTargetVal = "1y Target Est:";
	private static String ParamOpenVal = "Open:";
	private static String ParamPERatioVal = "P/E (ttm):";
	private static String ParamPreviousCloseVal = "Prev Close:";

	private static String ParamStockNameVal = "";
	private static String ParamStockSymVal = "";
	private static String ParamVolumeVal = "Volume:";
	private static String ParamWeekRangeVal = "52wk Range:";
	@Override
	public String getParamAskVal() {
		return ParamAskVal;
	}
	@Override
	public String getParamAverageVolumeVal() {
		return ParamAverageVolumeVal;
	}
	@Override
	public String getParamBetaVal() {
		return ParamBetaVal;
	}
	@Override
	public String getParamBidVal() {
		return ParamBidVal;
	}
	@Override
	public String getParamDaysRangeVal() {
		return ParamDaysRangeVal;
	}
	@Override
	public String getParamDividendYieldVal() {
		return ParamDividendYieldVal;
	}
	@Override
	public String getParamEarnDateVal() {
		return ParamEarnDateVal;
	}
	@Override
	public String getParamEarningsPerShareVal() {
		return ParamEarningsPerShareVal;
	}
	@Override
	public String getParamMarketCapitalizationVal() {
		return ParamMarketCapitalizationVal;
	}
	@Override
	public String getParamOneYearTargetVal() {
		return ParamOneYearTargetVal;
	}
	@Override
	public String getParamOpenVal() {
		return ParamOpenVal;
	}
	@Override
	public String getParamPERatioVal() {
		return ParamPERatioVal;
	}
	@Override
	public String getParamPreviousCloseVal() {
		return ParamPreviousCloseVal;
	}
	@Override
	public String getParamStockNameVal() {
		return ParamStockNameVal;
	}
	@Override
	public String getParamStockSymVal() {
		return ParamStockSymVal;
	}
	@Override
	public String getParamVolumeVal() {
		return ParamVolumeVal;
	}
	@Override
	public String getParamWeekRangeVal() {
		return ParamWeekRangeVal;
	}
	@Override
	public String getAllQueryParams() {
		// TODO Auto-generated method stub
		return null;
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
}
