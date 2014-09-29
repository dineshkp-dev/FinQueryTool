package financialQueryTool;

public class ParamEarnDate implements ParamListInterface {
	private String paramName = "EarnDate";
	private String paramUlsdCode = "";//"EarnDate";
	private String paramData="N/A";
	private static String paramYahooTabName = "Earnings Date:";
	@Override
	public String getparamName() {
		return paramName;
	}

	@Override
	public String getparamData() {
		return this.paramData;
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
