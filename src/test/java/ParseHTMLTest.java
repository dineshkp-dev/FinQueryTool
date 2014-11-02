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
//import org.mockito.MockitoAnnotations.Mock;


import org.mockito.Mock;
import org.mockito.Mockito;

public class ParseHTMLTest {
//	@Mock
	ParseHTML mockparseHTML;
	ParseHTML parseHTML;
	Map<String, String> mappedData;
	String expectedKeys, expectedValues, malformedHTML, htmlValue, htmlValue_noTable;
	Document testDoc;

	@Before
	public void setUp() {
//		MockitoAnnotations.initMocks(this);
		parseHTML = new ParseHTML();
		mockparseHTML = Mockito.mock(ParseHTML.class);
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

	@Test
	public void testSearchFoValMalformedHTML() throws Exception{
		mappedData = new HashMap<String, String>();
		try {
			parseHTML.searchFoVal(malformedHTML);
			fail("Should have thrown exception.");
		}
		catch(Exception err) {}
		System.out.println("Mapped return value for result: " + mappedData.values().toString());
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
		assertEquals("Expected value does not match.", "{Table2Header1_Value Table2Header2_Value Table2Header3_Value Table2Header4_Value=Table2Data1_Value Table2Data2_Value Table2Data3_Value Table2Data4_Value, Table1Header1_Value=Table1Data1_Value}", ParseHTML.extractReqdDatafrmYahooWebsite(testDoc).toString());
	}
	// Requires a mock object
	@Test
	public void testReadFromYahooFile() {
//		fail("Not yet implemented"); // TODO
	}

}
