package financialQueryTool;

public class ParamAsk implements ParamListInterface {
	private String paramName = "Ask";
	private static String paramUlsdCode = "a";
	private static String paramYahooTabName = "Ask:";
	private String paramData;

	@Override
	public String getparamName() {
		return paramName;
	}
	
	@Override
	public String getParamYahooTabName() {
		return paramYahooTabName;
	}

	@Override
	public String getparamData() {
		return paramData;
	}
	
	@Override
	public String getparamUlsdCode() {
		return paramUlsdCode;
	}

//	@Override
	public void setparamData(String Data) {
		this.paramData = Data;
	}
	
/*	public static boolean validApi(){
		return false;
		
	}*/
}
