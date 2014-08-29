package financialQueryTool;

public class ParamAverageVolume implements ParamListInterface {
	private String paramName = "Ask";
	private String paramUlsdCode = "a2";
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
