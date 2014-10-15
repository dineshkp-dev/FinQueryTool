package test.java;

import static org.junit.Assert.*;
import main.java.FinancialQueryTool;

import org.junit.Test;

public class FinancialQueryToolTest {

	String[] inputFileLoc = {"../inputLoc.xml"};
	@Test(expected=RuntimeException.class)
	public void testGo() {
		FinancialQueryTool queryTool = new FinancialQueryTool();
		queryTool.go(inputFileLoc);
	}

}
