package test.java;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import main.java.financialQueryTool.control.CheckJava;

import org.junit.Before;
import org.junit.Test;

public class CheckJavaTest {
	CheckJava mockCheckJava;
	@Before
	public void setup() {
		mockCheckJava= mock(CheckJava.class);
//		checkJavaTest = new CheckJava();
	}
	
	@Test
	public void testCheckJava() {
		mockCheckJava.JavaVersion();
	}
//This test expects the RunTimeException to be thrown
//Mock the CheckJava class and set the 'System' static method 
//'getProperty' to return '1.6.32' (fail condition)
	@Test(expected = RuntimeException.class)
	public void testWrongJavaVersion() {
		when(System.getProperty("java.version")).thenReturn("1.6.32");
		mockCheckJava.JavaVersion();
	}
}
