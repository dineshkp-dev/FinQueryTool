package financialQueryTool;

import java.net.URI;

public interface InitiateQueryInterface {
	public URI publicURI = null;
	
	public void printURI();
	public void printStock();
	public String[] queryStockName = new String[1];
	public String[] queryParam = new String[1];
	public URI generateURI();
}
