package financialQueryTool;

public class ParamBeta implements ParamListInterface {
	private String paramName = "Beta";
	private String paramUlsdCode = "";
	private String paramData;
	private static String paramYahooTabName = "Beta:";
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
