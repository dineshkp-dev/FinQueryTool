package test.java;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(CheckJavaTest.class, FinancialQueryToolTest.class, GenerateApiUriTest.class, GenerateYahooWebQueryUriTest.class
				,GenerateHistoricalUriTest.class);
		for (Failure fails : result.getFailures()) {
			System.out.println(fails.toString());
		}
		System.out.println("\n");
		System.out.println("\t******************************");
		System.out.println("\t\tUNIT TEST SUMMARY");
		System.out.println("\tTotal number of Tests\t: " + result.getRunCount());
		System.out.println("\tTotal Failing\t\t: " + result.getFailureCount());
		System.out.println("\tTotal Ignored tests\t: " + result.getIgnoreCount());
		System.out.println("\tOverall Pass\t\t: " + result.wasSuccessful());
		System.out.println("\t******************************");
	}

}
