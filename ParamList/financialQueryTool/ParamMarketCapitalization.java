package financialQueryTool;

public class ParamMarketCapitalization implements ParamListInterface {
	private String paramName = "MarketCapitalization";
	private String paramUlsdCode = "j1";
	private String paramData;
	
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
