package financialQueryTool.initiateQueryPkg;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import financialQueryTool.generateURIPkg.GenerateURI;
import financialQueryTool.generateURIPkg.GenerateYahooWebQueryUri;
import financialQueryTool.htmlOperationsPkg.ParseHTML;
import financialQueryTool.htmlOperationsPkg.QueryHtmlPage;
import financialQueryTool.parametersPkg.ParamAsk;
import financialQueryTool.parametersPkg.ParamAverageVolume;
import financialQueryTool.parametersPkg.ParamBeta;
import financialQueryTool.parametersPkg.ParamBid;
import financialQueryTool.parametersPkg.ParamDaysRange;
import financialQueryTool.parametersPkg.ParamDividendYield;
import financialQueryTool.parametersPkg.ParamEarnDate;
import financialQueryTool.parametersPkg.ParamEarningsPerShare;
import financialQueryTool.parametersPkg.ParamListInterface;
import financialQueryTool.parametersPkg.ParamMarketCapitalization;
import financialQueryTool.parametersPkg.ParamOneYearTarget;
import financialQueryTool.parametersPkg.ParamOpen;
import financialQueryTool.parametersPkg.ParamPERatio;
import financialQueryTool.parametersPkg.ParamPreviousClose;
import financialQueryTool.parametersPkg.ParamVolume;
import financialQueryTool.parametersPkg.ParamWeekRange;
import financialQueryTool.parseInputOutputPkg.WriteToCSV;
import financialQueryTool.queryParametersPkg.QueryParamInterface;
import financialQueryTool.queryParametersPkg.YahooWebQueryParameters;
import financialQueryTool.stockPkg.Stock;

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

	/* (non-Javadoc)
	 * @see financialQueryTool.InitiateQueryInterface#initiateQuery(java.util.ArrayList, java.lang.String, java.nio.file.Path)
	 */
	@Override
	public void initiateQuery(ArrayList<Stock> stockList, String[] requiredParameters, Path outputFileLocation) {
		URI queryUri = null;
		int timeout = 5*1000; //timeout for HTTP connection, in ms
		GenerateURI yahooWebUri = new GenerateYahooWebQueryUri();
		QueryHtmlPage queryYahooPage = new QueryHtmlPage();
		ParseHTML parsehtml = new ParseHTML();
		Map<String, String> mappedData = new HashMap<String, String>();
		QueryParamInterface paramCodeValues = new YahooWebQueryParameters();
		ArrayList<String> userRequestedData = new ArrayList<String>();

		for (Stock stock : stockList) { //Use Threads to simultaneaouly query for Stock information.
			String queriedHTML = "";
			queryUri = yahooWebUri.getURI(stock);
			System.out.println("URI: " + queryUri.toString());
			//Ensure that all the Query Codes are set for each Stock
			//The query codes will be used to identify the <key, value> pair from the Map mappedData <String, String>()
			Stock.setAllParamsQueryCode(stock, paramCodeValues);

			try {
				HttpURLConnection httpConnection = (HttpURLConnection) queryUri.toURL().openConnection();
				httpConnection.setConnectTimeout(timeout);
				queriedHTML = queryYahooPage.queryHTML(httpConnection);
				mappedData = parsehtml.searchFoVal(queriedHTML);
				System.out.println(mappedData.keySet().toString());
				System.out.println("Setting the Stock's Parameters from Web Query.");
				stock = InitiateYahooWebQuery.setStockParams(stock, mappedData);
				stock.printDetails();

			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		userRequestedData = getRequireDataOnly(stockList, requiredParameters, outputFileLocation);
		WriteToCSV.WriteDataToCSV(outputFileLocation, userRequestedData);
	}

	public static void printRequireDataOnly(ArrayList<Stock> stockList, String[] requiredParameters, Path outputFileLocation) {
		Map<String, String> requiredDataList = new HashMap<String, String>();
		Stock stock = null;
		ArrayList<String> finalData = new ArrayList<String>();
		for (int i =0; i<stockList.size(); i++) {
			stock = stockList.get(i);
			System.out.println("Stock Name:" + stock.getStockName());
			requiredDataList = stock.getRequiredParamData(requiredParameters);
			if (i == 0) {
				finalData.add(i, "StockName" + ","+ requiredDataList.keySet().toString().replaceAll("\\[|\\]", ""));
				System.out.println("StockName" + ","+ requiredDataList.keySet().toString().replaceAll("\\[|\\]", ""));
			}
			finalData.add(i, (stock.getStockName() + ","+ requiredDataList.values().toString().replaceAll("\\[|\\]", "")));
			System.out.println(stock.getStockName() + ","+ requiredDataList.values().toString().replaceAll("\\[|\\]", ""));
		}
		Collections.reverse(finalData);
	}

	/**
	 * @param stockList
	 * @param requiredParameters
	 * @param outputFileLocation
	 * @return
	 */
	public static ArrayList<String> getRequireDataOnly(ArrayList<Stock> stockList, String[] requiredParameters, Path outputFileLocation) {
		Map<String, String> requiredDataList = new HashMap<String, String>();
		Stock stock = null;
		ArrayList<String> finalData = new ArrayList<String>();
		for (int i =0; i<stockList.size(); i++) {
			stock = stockList.get(i);
			System.out.println("Stock Name:" + stock.getStockName());
			requiredDataList = stock.getRequiredParamData(requiredParameters);
			if (i == 0) {
				finalData.add(i, "StockName" + ","+ requiredDataList.keySet().toString().replaceAll("\\[|\\]", ""));
				System.out.println("StockName" + ","+ requiredDataList.keySet().toString().replaceAll("\\[|\\]", ""));
			}
			finalData.add(i, (stock.getStockName() + ","+ requiredDataList.values().toString().replaceAll("\\[|\\]", "")));
			System.out.println(stock.getStockName() + ","+ requiredDataList.values().toString().replaceAll("\\[|\\]", ""));
		}
		Collections.reverse(finalData);
		return finalData;
	}
	/**
	 * The method sets the values from the Map 'mappedData' to the parameters of the stock Object
	 * The Parameters are extracted from the Map using the 'Param'x Class's 'getParamYahooTabName' which corresponds to 
	 * the table name in the Yahoo Finance Website.
	 * @param stock
	 * @param mappedData
	 * @return stock Stock after all the necessary Parameters' data have been updated
	 */
	public static Stock setStockParams (Stock stock, Map<String, String> mappedData) {
		if (mappedData.containsKey(stock.getStockAsk().getQueryCode())){
			stock.getStockAsk().setparamData(mappedData.get(stock.getStockAsk().getQueryCode()));
		}
		System.out.println("Looking for Average data now...");

		System.out.println("Average data in Stock class: " + stock.getStockAverageVolume().getQueryCode());
		if (mappedData.containsKey(stock.getStockAverageVolume().getQueryCode())){
			stock.getStockAverageVolume().setparamData(mappedData.get(stock.getStockAverageVolume().getQueryCode()));
		}
		if (mappedData.containsKey(stock.getStockBeta().getQueryCode())) {
			stock.getStockBeta().setparamData(mappedData.get(stock.getStockBeta().getQueryCode()));
		}
		if (mappedData.containsKey(stock.getStockBid().getQueryCode())) {
			stock.getStockBid().setQueryCode(mappedData.get(stock.getStockBid().getQueryCode()));
		}
		if (mappedData.containsKey(stock.getStockDaysRange().getQueryCode())) {
			stock.getStockDaysRange().setparamData(mappedData.get(stock.getStockDaysRange().getQueryCode()));
		}
		if (mappedData.containsKey(stock.getStockDividendYield().getQueryCode())){
			stock.getStockDividendYield().setparamData(mappedData.get(stock.getStockDividendYield().getQueryCode()));
		}
		if (mappedData.containsKey(stock.getStockEarnDate().getQueryCode())) {
			stock.getStockEarnDate().setparamData(mappedData.get(stock.getStockEarnDate().getQueryCode()));
		}
		if (mappedData.containsKey(stock.getStockEarningsPerShare().getQueryCode())) {
			stock.getStockEarningsPerShare().setparamData(mappedData.get(stock.getStockEarningsPerShare().getQueryCode()));
		}
		if (mappedData.containsKey(stock.getStockMarketCapitalization().getQueryCode())) {
			stock.getStockMarketCapitalization().setparamData(mappedData.get(stock.getStockMarketCapitalization().getQueryCode()));
		}
		if (mappedData.containsKey(stock.getStockOneYearTarget().getQueryCode())) {
			stock.getStockOneYearTarget().setparamData(mappedData.get(stock.getStockOneYearTarget().getQueryCode()));
		}
		if (mappedData.containsKey(stock.getStockOpen().getQueryCode())) {
			stock.getStockOpen().setparamData(mappedData.get(stock.getStockOpen().getQueryCode()));
		}
		if (mappedData.containsKey(stock.getStockPERatio().getQueryCode())) {
			stock.getStockPERatio().setparamData(mappedData.get(stock.getStockPERatio().getQueryCode()));
		}
		if (mappedData.containsKey(stock.getStockPreviousClose().getQueryCode())) {
			stock.getStockPreviousClose().setparamData(mappedData.get(stock.getStockPreviousClose().getQueryCode()));
		}
		if (mappedData.containsKey(stock.getStockVolume().getQueryCode())) {
			stock.getStockVolume().setparamData(mappedData.get(stock.getStockVolume().getQueryCode()));
		}

		/*
		if (stock.stockPreviousClose.getParamYahooTabName().equals(mappedData.get(new ParamPreviousClose().getParamYahooTabName()))){
			stock.stockPreviousClose.setparamData(mappedData.get(new ParamPreviousClose().getParamYahooTabName()));
		}
		stock.stockOpen.setparamData(mappedData.get(new ParamOpen().getParamYahooTabName()));
		stock.stockBid.setparamData(mappedData.get(new ParamBid().getParamYahooTabName()));
		stock.stockAsk.setparamData(mappedData.get(new ParamAsk().getParamYahooTabName()));
		stock.stockOneYearTarget.setparamData(mappedData.get(new ParamOneYearTarget().getParamYahooTabName()));
		stock.stockBeta.setparamData(mappedData.get(new ParamBeta().getParamYahooTabName()));
		if (stock.stockEarnDate.getParamYahooTabName().equals(mappedData.get(new ParamEarnDate().getParamYahooTabName()))) {
			stock.stockEarnDate.setparamData(mappedData.get(new ParamEarnDate().getParamYahooTabName()));
		}
		stock.stockDaysRange.setparamData(mappedData.get(new ParamDaysRange().getParamYahooTabName()));
		stock.stockWeekRange.setparamData(mappedData.get(new ParamWeekRange().getParamYahooTabName()));
		stock.stockVolume.setparamData(mappedData.get(new ParamVolume().getParamYahooTabName()));
		stock.stockAverageVolume.setparamData(mappedData.get(new ParamAverageVolume().getParamYahooTabName()));
		stock.stockMarketCapitalization.setparamData(mappedData.get(new ParamMarketCapitalization().getParamYahooTabName()));
		stock.stockPERatio.setparamData(mappedData.get(new ParamPERatio().getParamYahooTabName()));
		stock.stockEarningsPerShare.setparamData(mappedData.get(new ParamEarningsPerShare().getParamYahooTabName()));
		stock.stockDividendYield.setparamData(mappedData.get(new ParamDividendYield().getParamYahooTabName()));*/

		/*		
		if (stock.stockAsk.getQueryCode().equals(mappedData.get(stock.stockAsk.getQueryCode()))) {
			stock.stockAsk.setparamData(mappedData.get(stock.stockAsk.getQueryCode()));
		}
		if (stock.getStockAverageVolume().getQueryCode().equals(mappedData.get(stock.getStockAverageVolume().getQueryCode()))){
			stock.getStockAverageVolume().setparamData(mappedData.get(stock.getStockAverageVolume().getQueryCode()));

		}
		if (stock.getStockBeta().getQueryCode().equals(mappedData.get(stock.getStockBeta().getQueryCode()))) {
			stock.getStockBeta().setparamData(mappedData.get(stock.getStockBeta().getQueryCode()));
		}
		if (stock.getStockBid().getQueryCode().equals(mappedData.get(stock.getStockBid().getQueryCode()))) {

		}
		if (stock.getStockDaysRange().getQueryCode().equals(mappedData.get(stock.getStockDaysRange().getQueryCode()))) {

		}
		if (stock.getStockDividendYield().getQueryCode().equals(mappedData.get(stock.getStockDividendYield().getQueryCode()))){

		}
		if (stock.getStockEarnDate().getQueryCode().equals(mappedData.get(stock.getStockEarnDate().getQueryCode()))) {

		}
		if (stock.getStockEarningsPerShare().getQueryCode().equals(mappedData.get(stock.getStockEarningsPerShare().getQueryCode()))) {

		}
		if (stock.getStockMarketCapitalization().getQueryCode().equals(mappedData.get(stock.getStockMarketCapitalization().getQueryCode()))) {

		}
		if (stock.getStockOneYearTarget().getQueryCode().equals(mappedData.get(stock.getStockOneYearTarget().getQueryCode()))) {

		}
		if (stock.getStockOpen().getQueryCode().equals(mappedData.get(stock.getStockOpen().getQueryCode()))) {

		}
		if (stock.getStockPERatio().getQueryCode().equals(mappedData.get(stock.getStockPERatio().getQueryCode()))) {

		}
		if (stock.getStockPreviousClose().getQueryCode().equals(mappedData.get(stock.getStockPreviousClose().getQueryCode()))) {

		}
		if (stock.getStockVolume().getQueryCode().equals(mappedData.get(stock.getStockVolume().getQueryCode()))) {

		}*/


		return stock;
	}
	/**
	 * The method identifies all the valid parameters which can be queried for this class
	 * @return applicableQueryParams ArrayList<ParamListInterface> the list of all the applicable parameters for which valid data should be available from query
	 */
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
