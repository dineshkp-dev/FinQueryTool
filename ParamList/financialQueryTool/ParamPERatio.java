package financialQueryTool;

public class ParamPERatio implements ParamListInterface {
	private String paramName = "PERatio";
	private String paramUlsdCode = "r";
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
