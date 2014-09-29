package financialQueryTool;

public class ParamPERatio implements ParamListInterface {
	private String paramName = "PERatio";
	private String paramUlsdCode = "r";
	private String paramData="N/A";
	private static String paramYahooTabName = "P/E (ttm):";
	@Override
	public String getparamName() {
		return paramName;
	}

	@Override
	public String getparamData() {
		return paramData;
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
