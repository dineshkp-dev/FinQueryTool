package financialQueryTool;

public class ParamVolume implements ParamListInterface {
	private String paramName = "Volume";
	private String paramUlsdCode = "v";
	private String paramData="N/A";
	private static String paramYahooTabName = "Volume:";
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
