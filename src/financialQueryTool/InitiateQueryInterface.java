package financialQueryTool;

import java.net.URI;

public interface InitiateQueryInterface {
	public void printURI();
	public void printStock();
	public URI getURI();
	public URI setURI();
	public String initiateQuery();
}
