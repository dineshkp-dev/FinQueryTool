package financialQueryTool;

/**
 * @author dineshkp
 *
 */
public class CheckJava {
	
	/**
	 * Checks if the version of Java in the system is 1.7 or above. This program requires Java 1.7 or above for working
	 * properly
	 * 
	 * @param nil
	 * @return nil
	 */
	public static void JavaVersion() {
		String sysJava = System.getProperty("java.version");
		System.out.println("Current Java version is: " + sysJava);
		Integer sysJavaMajRev = Integer.parseInt(sysJava.split("\\.")[1].toString());
		if (sysJavaMajRev < 7) {
			System.out.println("Please use version 7 or above for this program.");
			throw new RuntimeException ("jre version incompatibility exception.");
		}
	}
}
