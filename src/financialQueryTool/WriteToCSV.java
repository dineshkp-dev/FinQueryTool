package financialQueryTool;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class WriteToCSV {
	private WriteToCSV() {}
	
	/**
	 * Writes the final data, from an ArrayList, into a csv file. If the file exists, then data is appended
	 * to the end, else a new file is created if it already exists.
	 * NOTE: does not work if the file exists and is being used by another process.
	 * 
	 * @param csvFilePath Path where the csv file has to be written
	 * @param finalData
	 * @return boolean value, showing success/fail.
	 */
	public static boolean WriteDataToCSV( Path csvFilePath, ArrayList<String> finalData ) {
		OpenOption[] options = {StandardOpenOption.CREATE, StandardOpenOption.APPEND};
		String writeInto = "";
		for (int i =0; i<finalData.size(); i++) {
			writeInto = writeInto + finalData.get(i) + "\n";
		}
			try {
				BufferedWriter writer = Files.newBufferedWriter(csvFilePath, StandardCharsets.UTF_8, options);
				writer.write(writeInto);
				writer.close();
				System.out.println("Done writing to file.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		return false;
		
	}
	
}
