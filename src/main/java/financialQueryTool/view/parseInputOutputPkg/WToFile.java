package main.java.financialQueryTool.view.parseInputOutputPkg;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * @author dineshkp
 * 
 * This class is deprecated.
 *
 */

public class WToFile {
	BufferedWriter writeToFile = null;
	OutputStreamWriter outputStreamWriter = null;
	FileOutputStream fileoutputstream = null;
//	Document doc = new Document(null);
	
	/**
	 * Writes a String data to a file.
	 * Uses the Java 1.6 APIs to write, hence is backward compatible
	 * 
	 * @param fileName String file name of the output file
	 * @param dataToWrite String input to be written into the file
	 * @return nil
	 */
	public void writeDatatoFile(String fileName, String dataToWrite) {
		try {
/*
 * Writing to a file in JAVA 1.6:
 * For Java 1.7 onwards, use newBufferedWriter(Path, charset, (options))
 * FileOutputStream -> OutputStream -> BufferedWriter
 */
			fileoutputstream = new FileOutputStream (fileName);
			outputStreamWriter = new OutputStreamWriter(fileoutputstream, StandardCharsets.UTF_8);
			writeToFile = new BufferedWriter(outputStreamWriter);
			writeToFile.write(dataToWrite);
		}	
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {writeToFile.close();} catch (Exception e2) {
			}
		}
		
	}

}
