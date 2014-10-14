package test.java;

import main.java.CheckJava;

import org.junit.Test;

public class CheckJavaTest {
	CheckJava checkJavaTest = new CheckJava();

	@Test
	public void testJavaVersion() {
		checkJavaTest.sysJava = "1.6.32";
//		fail("Not yet implemented");
		checkJavaTest.JavaVersion();
	}
	//Current implementation is not practical for TDD (Test Driven Development, need to refactor the codes for Test support)
	@Test
	public void testCheckJava() {
		checkJavaTest.JavaVersion();
		
	}

}
