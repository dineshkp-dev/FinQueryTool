package financialQueryTool;

public class ParamPreviousClose implements ParamListInterface {
	private String paramName = "PreviousClose";
	private String paramUlsdCode = "p";
	private String paramData;
	private static String paramYahooTabName = "Prev Close:";
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
