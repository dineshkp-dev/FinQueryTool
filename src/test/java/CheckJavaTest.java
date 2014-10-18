package test.java;

import main.java.CheckJava;

//import org.junit.FixMethodOrder;
import org.junit.Test;
//import org.junit.runners.MethodSorters;
//set the test order
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class CheckJavaTest {
	CheckJava checkJavaTest = new CheckJava();
	//Current implementation is not practical for TDD (Test Driven Development, need to refactor the codes for Test support)
	@Test
	public void testaCheckJava() {
		System.out.println("Test one");
		checkJavaTest.JavaVersion();
	}
//This test expects the RunTimeException to be thrown
	@Test(expected = RuntimeException.class)
	public void testzWrongJavaVersion() {
		System.out.println("Test two.");
		System.setProperty("java.version", "1.6.32"); //Should not set the System property
		checkJavaTest.JavaVersion();
	}
}
