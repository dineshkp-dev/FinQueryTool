package financialQueryTool;

public class ParamStockName implements ParamListInterface {
	private String paramName = "StockName";
	private String paramUlsdCode = "n";
	private String paramData="N/A";
	private static String paramYahooTabName = "";
	@Override
	public String getparamName() {
		return paramName;
	}

	@Override
	public String getparamData() {
		return paramData;
	}

	@Override
	public void setparamData(String data) {
		this.paramData = data;
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
