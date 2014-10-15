package test.java;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(CheckJavaTest.class, FinancialQueryToolTest.class);
		for (Failure fails : result.getFailures()) {
			System.out.println(fails.toString());
		}
		System.out.println("Total number of Tests: " + result.getRunCount() + ".");
		System.out.println("Total Failing: " + result.getFailureCount());
		System.out.println("Total Ignored tests: " + result.getIgnoreCount());
		System.out.println("Overall Pass: " + result.wasSuccessful());
	}

}
