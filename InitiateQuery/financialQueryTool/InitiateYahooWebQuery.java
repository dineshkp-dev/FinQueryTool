package financialQueryTool;

import java.net.URI;
import java.nio.file.Path;
import java.util.ArrayList;

public class InitiateYahooWebQuery implements InitiateQueryInterface {

	@Override
	public void printURI() {
		// TODO Auto-generated method stub

	}

	@Override
	public void printStock() {
		// TODO Auto-generated method stub

	}

	@Override
	public URI getURI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public URI setURI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String initiateQuery(String stockSymbol) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initiateQuery(ArrayList<Stock> stockList, Path outputFile) {
		System.out.println("An output path is not required for Web queries.");
	}

	@Override
	public void initiateQuery(ArrayList<Stock> stockList) {
		URI queryUri = null;
		GenerateURI yahooWebUri = new GenerateYahooWebQueryUri();
		ArrayList<ParamListInterface> validParamList = InitiateYahooWebQuery.queryParamListInterfaces();
		for (Stock stock : stockList) {
			queryUri = yahooWebUri.getURI(stock);
			System.out.println("URI: " + queryUri.toString());

		}
	}

	public static ArrayList<ParamListInterface> queryParamListInterfaces () {
		ArrayList<ParamListInterface> applicableQueryParams = new ArrayList<ParamListInterface> ();

		applicableQueryParams.add(new ParamPreviousClose());
		applicableQueryParams.add(new ParamOpen());
		applicableQueryParams.add(new ParamBid());
		applicableQueryParams.add(new ParamAsk());
		applicableQueryParams.add(new ParamOneYearTarget());
		applicableQueryParams.add(new ParamBeta());
		applicableQueryParams.add(new ParamEarnDate());
		applicableQueryParams.add(new ParamDaysRange());
		applicableQueryParams.add(new ParamWeekRange());
		applicableQueryParams.add(new ParamVolume());
		applicableQueryParams.add(new ParamAverageVolume());
		applicableQueryParams.add(new ParamMarketCapitalization());
		applicableQueryParams.add(new ParamPERatio());
		applicableQueryParams.add(new ParamEarningsPerShare());
		applicableQueryParams.add(new ParamDividendYield());

		return applicableQueryParams;
	}
}
