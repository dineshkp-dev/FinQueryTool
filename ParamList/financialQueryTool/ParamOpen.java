package financialQueryTool;

public class ParamOpen implements ParamListInterface {
	private String paramName = "Open";
	private String paramUlsdCode = "o";
	private String paramData;
	private static String paramYahooTabName = "Open:";
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
