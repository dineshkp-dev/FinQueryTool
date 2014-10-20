package test.java;

import main.java.CheckJava;
import static org.mockito.Mockito.*;

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
//Mock the CheckJava class and set the 'System' static method 
//'getProperty' to return '1.6.32' (fail condition)
	@Test(expected = RuntimeException.class)
	public void testzWrongJavaVersion() {
		System.out.println("Test two.");
		CheckJava mockCheckJava = mock(CheckJava.class);
		when(System.getProperty("java.version")).thenReturn("1.6.32");
		mockCheckJava.JavaVersion();
	}
}
