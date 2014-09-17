package financialQueryTool;

public class ParamEarningsPerShare implements ParamListInterface {
	private String paramName = "EarningsPerShare";
	private String paramUlsdCode = "e";
	private String paramData;
	private static String paramYahooTabName = "EPS (ttm):";
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
