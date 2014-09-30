package financialQueryTool;

public interface queryParamInterface {

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
	
	public String getAllQueryParams();
	public String getApplicableQueryParams();
	
	public String[] getAllQueryParamsArray();
	public String[] getApplicableQueryParamsArray();
}
