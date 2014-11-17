package main.java.financialQueryTool.model.parametersPkg;

public class ParamAsk implements ParamListInterface {
	private String paramName = "Ask";
	private String paramData="N/A";
	private String queryCode;
	public String getQueryCode() {
		return queryCode;
	}

	public void setQueryCode(String queryCode) {
		this.queryCode = queryCode;
	}

	@Override
	public String getparamName() {
		return paramName;
	}

	@Override
	public String getparamData() {
		return this.paramData;
	}
	
//	@Override
	public void setparamData(String Data) {
		this.paramData = Data;
	}
	
}
