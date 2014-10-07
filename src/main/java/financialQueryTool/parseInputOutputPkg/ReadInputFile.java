package main.java.financialQueryTool.parseInputOutputPkg;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class ReadInputFile {
	private ReadInputFile() {}
	/**
	 * Parses the input data text file which contains the requirements from the user
	 * 
	 * @param inputLocation Path location of the text file
	 * @return inputRequestArray Array of items that are required by the user
	 */
	public static ArrayList<String> readInputData(Path inputLocation) {
		String line = "";
		String inputData = "";
		ArrayList<String> inputRequestArray = new ArrayList<String>();
		try {
			BufferedReader inputFile = Files.newBufferedReader(inputLocation, StandardCharsets.UTF_8);
			while ((line = inputFile.readLine()) != null) {
				inputData = inputData + line;
			}
			System.out.println(inputData);
			for (String eachItem : inputData.split(",")) {
				inputRequestArray.add(eachItem);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Returning the input requirements.");
		return inputRequestArray;
		
	}
 }
