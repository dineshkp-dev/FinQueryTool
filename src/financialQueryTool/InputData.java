/**
 * 
 */
package financialQueryTool;

import java.nio.file.Path;

/**
 * @author dineshkp
 * 
 * <UserData>
	<RequiredStockSymbols>GOOG,AAPL,AMZN,BIDU,MA,NFLX</RequiredStockSymbols>
	<RequiredParameters>Day's Range,52wk Range,Prev Close,Open,Div &amp; Yield,P/E (ttm),EPS (ttm),Beta,1y Target Est</RequiredParameters>
	<QueryType>API</QueryType>
</UserData>
<FileLocation>
	<TempFile>koreInfoProject/tempFile.html</TempFile>
	<OutputFile>koreInfoProject/stockData.csv</OutputFile>
</FileLocation>
 *
 */
public class InputData {
	private String requiredStockSymbols;
	private String[] requiredParameters;
	private QueryType queryType;
	private Path tempFile;
	private Path outputFile;

	public Path getTempFile() {
		return tempFile;
	}
	public Path getOutputFile() {
		return outputFile;
	}
	public void setTempFile(Path tempFile) {
		this.tempFile = tempFile;
	}
	public void setOutputFile(Path outputFile) {
		this.outputFile = outputFile;
	}
	public String getRequiredStockSymbols() {
		return requiredStockSymbols;
	}
	public String[] getRequiredParameters() {
		return requiredParameters;
	}
	public QueryType getQueryType() {
		return queryType;
	}
	public void setRequiredStockSymbols(String requiredStockSymbols) {
		this.requiredStockSymbols = requiredStockSymbols;
	}
	public void setRequiredParameters(String[] requiredParameters) {
		this.requiredParameters = requiredParameters;
	}
	public void setQueryType(QueryType queryType) {
		this.queryType = queryType;
	}
}
