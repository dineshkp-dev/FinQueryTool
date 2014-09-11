package financialQueryTool;

public class ParamStockSym implements ParamListInterface {
	private String paramName = "StockSymbol";
	private static String paramUlsdCode = "";
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

//	@Override
	public void setparamData(String Data) {
		this.paramData = Data;
	}
	
/*	public static boolean validApi(){
		return false;
		
	}*/
}
