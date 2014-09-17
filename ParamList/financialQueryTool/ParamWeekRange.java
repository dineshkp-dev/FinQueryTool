package financialQueryTool;

public class ParamWeekRange implements ParamListInterface {
	private String paramName = "Week52Range";
	private String paramUlsdCode = "w";
	private String paramData;
	private static String paramYahooTabName = "52wk Range:";
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
	@Override
	public String getQueryCode() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setQueryCode(String queryCode) {
		// TODO Auto-generated method stub
		
	}
}
