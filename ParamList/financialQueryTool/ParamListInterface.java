/**
 * 
 */
package financialQueryTool;

/**
 * @author dineshkp
 * 
 * Source: http://www.jarloo.com/yahoo_finance/
 *
 */
public interface ParamListInterface {
	/*
	 * 	+getparamName()
		+getparamData()
		+setparamData()
		+getparamUlsdCode()
	 */

	public String getparamName();
	public String getparamData();
	public String getparamUlsdCode();
	public void setparamData(String data);
}
