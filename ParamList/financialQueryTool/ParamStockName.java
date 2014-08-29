package financialQueryTool;

public class ParamStockName implements ParamListInterface {
	private String paramName = "StockName";
	private String paramUlsdCode = "n";
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
