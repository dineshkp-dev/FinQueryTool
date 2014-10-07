package main.java.financialQueryTool.parametersPkg;

public class ParamStockName implements ParamListInterface {
	private String paramName = "StockName";
	private String paramData="N/A";
	private String queryCode;
	
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
		return this.queryCode;
	}

	@Override
	public void setQueryCode(String queryCode) {
		this.queryCode =queryCode;
		
	}
}
