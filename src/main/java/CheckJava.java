package main.java;

import javax.management.RuntimeErrorException;

/**
 * @author dineshkp
 *
 */
public class CheckJava {
	public String sysJava = null;
	/**
	 * Checks if the version of Java in the system is 1.7 or above. This program requires Java 1.7 or above for working
	 * properly
	 * 
	 * @param nil
	 * @return nil
	 */
	//	public String sysJava = System.getProperty("java.version");

	public void JavaVersion() {
		
		try {
			sysJava = "1.6.0_65";
//			sysJava = System.getProperty("java.version");
		}
		catch (Exception err) {
			System.out.println("Unable to get the Java Version property" + err.getMessage());
			throw new RuntimeException("Java version property was not found.");
		}
		System.out.println("Current Java version is: " + sysJava);
		Integer sysJavaMajRev = Integer.parseInt(sysJava.split("\\.")[1].toString());
		if (sysJavaMajRev < 7) {
			System.out.println("Please use version 7 or above for this program.");
			throw new RuntimeException ("jre version incompatibility exception.");
		}
	}
}
