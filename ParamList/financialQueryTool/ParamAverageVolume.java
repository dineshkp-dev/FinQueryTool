package financialQueryTool;

public class ParamAverageVolume implements ParamListInterface {
	private String paramName = "AverageVolume";
	private String paramUlsdCode = "a2";
	private String paramData="N/A";
	private static String paramYahooTabName = "Avg Vol (3m):";
	
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
