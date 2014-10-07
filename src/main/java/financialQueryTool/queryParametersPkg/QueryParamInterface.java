package main.java.financialQueryTool.queryParametersPkg;

public interface QueryParamInterface {

	public String getParamAskVal();
	public String getParamAverageVolumeVal();
	public String getParamBetaVal();
	public  String getParamBidVal();
	public  String getParamDaysRangeVal();
	public  String getParamDividendYieldVal();
	public  String getParamEarnDateVal();
	public  String getParamEarningsPerShareVal();
	public  String getParamMarketCapitalizationVal();
	public  String getParamOneYearTargetVal();
	public  String getParamOpenVal();
	public  String getParamPERatioVal();
	public  String getParamPreviousCloseVal();
	public  String getParamStockNameVal() ;
	public  String getParamStockSymVal();
	public  String getParamVolumeVal();
	public  String getParamWeekRangeVal();
	
	
	/**
	 * Returns all the query param Values, invalid ones are populated with empty Strings ""
	 * @return String containing all the query params
	 */
	public String getAllQueryParams();
	public String getApplicableQueryParams();
	
	
	/**
	 * @return String[] containing all the applicable query params
	 */
	public String[] getAllQueryParamsArray();
	public String[] getApplicableQueryParamsArray();
}
