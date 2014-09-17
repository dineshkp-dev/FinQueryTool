package financialQueryTool;

public class ParamMarketCapitalization implements ParamListInterface {
	private String paramName = "MarketCapitalization";
	private String paramUlsdCode = "j1";
	private String paramData;
	private static String paramYahooTabName = "Market Cap:";
	@Override
	public String getParamYahooTabName() {
		return paramYahooTabName;
	}
	@Override
	public String getparamName() {
		return paramName;
	}

	@Override
	public String getparamData() {
		return paramData;
	}

	@Override
	public String getparamUlsdCode() {
		return paramUlsdCode;
	}

	@Override
	public void setparamData(String Data) {
		this.paramData = Data;
	}
}
