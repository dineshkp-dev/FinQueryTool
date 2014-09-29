package financialQueryTool;

public class ParamBid implements ParamListInterface {
	private String paramName = "Bid";
	private String paramUlsdCode = "b";
	private String paramData="N/A";
	private static String paramYahooTabName = "Bid:";
	@Override
	public String getparamName() {
		return paramName;
	}

	@Override
	public String getparamData() {
		return this.paramData;
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
