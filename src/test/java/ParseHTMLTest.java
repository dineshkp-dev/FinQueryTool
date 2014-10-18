package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import main.java.financialQueryTool.htmlOperationsPkg.ParseHTML;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;

public class ParseHTMLTest {

	public ParseHTML parseHTML;
	Map<String, String> mappedData;
	String expectedKeys, expectedValues, malformedHTML, htmlValue, htmlValue_noTable;
	Document testDoc;

	@Before
	public void setUp() {
		parseHTML = new ParseHTML();
		htmlValue 	= "<HTML>"
				+ "<Title>DummyHTML</Title>"
				+ "<div class=\"yfi_quote_summary\">"
				+ "<table>"
				+ "<th Attr=\"Table1HeaderAttr1\">Table1Header1_Value</th>"
				+ "<td>Table1Data1_Value</td>"
				+ "</table>"
				+ "<table>"
				+ "<th Attr=\"Table2HeaderAttr\">Table2Header1_Value</th>"
				+ "<td>Table2Data1_Value</td>"
				+ "<th Attr=\"Table2HeaderAttr\">Table2Header2_Value</th>"
				+ "<td>Table2Data2_Value</td>"
				+ "<th Attr=\"Table2HeaderAttr\">Table2Header3_Value</th>"
				+ "<td>Table2Data3_Value</td>"
				+ "<th Attr=\"Table2HeaderAttr\">Table2Header4_Value</th>"
				+ "<td>Table2Data4_Value</td>"
				+ "</table>"
				+ "</div>"
				+ "</HTML>";
		htmlValue_noTable = "<HTML>"
				+ "<Title>DummyHTML</Title>"
//				+ "<div class=\"yfi_quote_summary\">"
				+ "<div class=\"invalid value\">"
				+ "<table>"
				+ "<th Attr=\"Table1HeaderAttr1\">Table1Header1_Value</th>"
				+ "<td>Table1Data1_Value</td>"
				+ "</table>"
				+ "<table>"
				+ "<th Attr=\"Table2HeaderAttr\">Table2Header1_Value</th>"
				+ "<td>Table2Data1_Value</td>"
				+ "<th Attr=\"Table2HeaderAttr\">Table2Header2_Value</th>"
				+ "<td>Table2Data2_Value</td>"
				+ "<th Attr=\"Table2HeaderAttr\">Table2Header3_Value</th>"
				+ "<td>Table2Data3_Value</td>"
				+ "<th Attr=\"Table2HeaderAttr\">Table2Header4_Value</th>"
				+ "<td>Table2Data4_Value</td>"
				+ "</table>"
				+ "</div>"
				+ "</HTML>";
		expectedKeys = "[Table2Header1_Value Table2Header2_Value Table2Header3_Value Table2Header4_Value, Table1Header1_Value]";
		expectedValues = "[Table2Data1_Value Table2Data2_Value Table2Data3_Value Table2Data4_Value, Table1Data1_Value]";

		malformedHTML = "INVALID HTML";
		testDoc = Jsoup.parse(malformedHTML);
		/*				"<HTML>"
					+ "<div class=\"yfi_quote_summary\">"
							+ "<table>"
								+ "<th Attr=\"Table1HeaderAttr1\">Table1Header1_Value</th>"
								+ "<td>Table1Data1_Value</td>"
							+ "</table>"
//					+ "</div>" no <div> closing
				+ "</HTML>";*/
	}

	@Test
	public void testSearchFoVal() {
		mappedData = new HashMap<String, String>();
		mappedData = parseHTML.searchFoVal(htmlValue);
		System.out.println(mappedData.values().toString());
		assertEquals("Expected keys are not found", expectedKeys, mappedData.keySet().toString());
		assertEquals("Expected values are not found", expectedValues, mappedData.values().toString());
	}

	@Test(expected=RuntimeException.class)
	public void testSearchFoValMalformedHTML() {
		mappedData = new HashMap<String, String>();
		mappedData = parseHTML.searchFoVal(malformedHTML);
		System.out.println(mappedData.values().toString());
	}

	@Test(expected=RuntimeException.class)
	public void testExtractReqdDatafrmYahooWebsiteMalformedHTML() {
		testDoc = Jsoup.parse(malformedHTML);
		ParseHTML.extractReqdDatafrmYahooWebsite(testDoc);
	}
	@Test(expected=RuntimeException.class)
	public void testExtractReqdDatafrmYahooWebsiteNoTable() {
		testDoc = Jsoup.parse(htmlValue_noTable);
		ParseHTML.extractReqdDatafrmYahooWebsite(testDoc);
	}
	@Test
	public void testExtractReqdDatafrmYahooWebsiteHTML() {
		testDoc = Jsoup.parse(htmlValue);
		assertEquals("Expected value does not match.", "{Table2Header1_Value Table2Header2_Value Table2Header3_Value Table2Header4_Value=Table2Data1_Value Table2Data2_Value Table2Data3_Value Table2Data4_Value, Table1Header1_Value=Table1Data1_Value}", parseHTML.extractReqdDatafrmYahooWebsite(testDoc).toString());
	}
	// Requires a mock object
	@Test
	public void testReadFromYahooFile() {
		fail("Not yet implemented"); // TODO
	}

}
