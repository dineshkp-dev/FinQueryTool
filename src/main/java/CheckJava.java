package main.java;

/**
 * @author dineshkp
 *
 */
public class CheckJava {
	private String sysJava = null;
	/**
	 * Checks if the version of Java in the system is 1.7 or above. This program requires Java 1.7 or above for working
	 * properly
	 * 
	 * @param nil
	 * @return nil
	 */
	//	public String sysJava = System.getProperty("java.version");

	public void JavaVersion() {
		this.setSysJava();
		System.out.println("Current Java version is: " + this.sysJava);
		Integer sysJavaMajRev = Integer.parseInt(this.sysJava.split("\\.")[1].toString());
		if (sysJavaMajRev < 7) {
			System.out.println("Please use version 7 or above for this program.");
			throw new RuntimeException ("jre version incompatibility exception.");
		}
	}
	public String getSysJava() {
		return sysJava;
	}
	public void setSysJava() {
		try {
			this.sysJava = System.getProperty("java.version");
		}
		catch (Exception err) {
			System.out.println("Unable to get the Java Version property" + err.getMessage());
			throw new RuntimeException("Java version property was not found.");
		}
	}
}
