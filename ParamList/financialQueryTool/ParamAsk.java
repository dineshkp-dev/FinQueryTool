package financialQueryTool;

public class ParamAsk implements ParamListInterface {
	private String paramName = "Ask";
	private static String paramUlsdCode = "a";
	private static String paramYahooTabName = "Ask:";
	private String queryCode;
	public String getQueryCode() {
		return queryCode;
	}

	public void setQueryCode(String queryCode) {
		this.queryCode = queryCode;
	}

	private String paramData="N/A";

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
	
/*	public static boolean validApi(){
		return false;
		
	}*/
}
