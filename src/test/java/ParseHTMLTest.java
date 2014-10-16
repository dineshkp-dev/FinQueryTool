package test.java;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import main.java.financialQueryTool.htmlOperationsPkg.ParseHTML;

import org.junit.Before;
import org.junit.Test;

public class ParseHTMLTest {

	public ParseHTML parseHTML;
	Map<String, String> mappedData;
	String expectedKeys, expectedValues, malformedHTML, htmlValue;
	
	
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
		expectedKeys = "[Table2Header1_Value Table2Header2_Value Table2Header3_Value Table2Header4_Value, Table1Header1_Value]";
		expectedValues = "[Table2Data1_Value Table2Data2_Value Table2Data3_Value Table2Data4_Value, Table1Data1_Value]";
		
		malformedHTML = "INVALID HTML";
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
	public void testSearchFoValMalformedHTML() {
		mappedData = new HashMap<String, String>();
		mappedData = parseHTML.searchFoVal(htmlValue);
		System.out.println(mappedData.values().toString());
//		assertEquals("Expected keys are not found", expectedKeys, mappedData.keySet().toString());
//		assertEquals("Expected values are not found", expectedValues, mappedData.values().toString());
	}

	@Test
	public void testExtractReqdDatafrmYahooWebsite() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testReadFromYahooFile() {
		fail("Not yet implemented"); // TODO
	}

}
