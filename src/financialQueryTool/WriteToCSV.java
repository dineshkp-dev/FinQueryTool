package financialQueryTool;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import javax.rmi.CORBA.Util;

import org.w3c.dom.CharacterData;

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
	 * @throws IOException 
	 */
	public static boolean WriteDataToCSV( Path csvFilePath, ArrayList<String> finalData ) throws IOException {
		OpenOption[] options = {StandardOpenOption.CREATE, StandardOpenOption.APPEND};
		String writeInto = "";
		BufferedWriter writer = null;
		for (int i =0; i<finalData.size(); i++) {
			writeInto = writeInto + finalData.get(i) + "\n";
		}
		try {
			writer = Files.newBufferedWriter(csvFilePath, StandardCharsets.UTF_8, options);
			writer.write(writeInto);
			System.out.println("Done writing to file.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			writer.close();
		}
		return false;

	}

	/**
	 * This method writes the data from an InputStream (possibly linked to a HTTPUrlConnection)
	 * 
	 * @param csvFilePath Path location to csv file
	 * @param connectionStream InputStream data
	 * @param bufferSize int Buffersize of data from InputStream
	 * @return writeSuccess boolean is set to true if file is successfully created
	 * @throws IOException
	 */
	@SuppressWarnings("null")
	public static String WriteDataToCSV( Path csvFilePath, InputStream connectionStream, int bufferSize, boolean captureStream ) throws IOException {
		int byteRead, byteWritten=0;
		OutputStream outputStream = null;
		String output = "";

		try {
			outputStream = new BufferedOutputStream(new FileOutputStream (csvFilePath.toFile(),true));

			byte[] fileBuffer = new byte[bufferSize];
			while (( byteRead = connectionStream.read(fileBuffer)) != -1) {
				if (captureStream){
					output = output + (new String(fileBuffer,0,bufferSize,StandardCharsets.UTF_8)).trim();
				}
				outputStream.write(fileBuffer, 0, byteRead);
				byteWritten += byteRead;
			}
			outputStream.flush(); // Pushes out all the OutputStream.
			System.out.println("Output value: \n" + output.toString());
			System.out.println("Bytes Written: " + byteWritten + "Bytes.");
			System.out.println("Downloaded successfully to:\n" + (csvFilePath.toFile().getAbsolutePath()));
		} catch (IOException err) {
			err.printStackTrace();
		}
		finally {
			outputStream.close();
		}
		return output;
	}
	
	/**
	 * This method writes the data from an InputStream (possibly linked to a HTTPUrlConnection)
	 * 
	 * @param csvFilePath Path location to csv file
	 * @param connectionStream InputStream data
	 * @param bufferSize int Buffersize of data from InputStream
	 * @return writeSuccess boolean is set to true if file is successfully created
	 * @throws IOException
	 */
	@SuppressWarnings("null")
	public static String WriteAppendedDataToCSV( Path csvFilePath, InputStream connectionStream, int bufferSize, boolean captureStream, Stock stock ) throws IOException {
		int byteRead, byteWritten=0;
		OutputStream outputStream = null;
		String output = "";
		PrintWriter printWriter = new PrintWriter(csvFilePath.toFile());
		
		try {
			outputStream = new BufferedOutputStream(new FileOutputStream (csvFilePath.toFile(),true));

			byte[] fileBuffer = new byte[bufferSize];
			while (( byteRead = connectionStream.read(fileBuffer)) != -1) {
				if (captureStream){
					output = output + (new String(fileBuffer,0,bufferSize,StandardCharsets.UTF_8)).trim();
				}
				byteWritten += byteRead;
			}
			
			String[] queryResultList = output.split("\n");
			for (int i = 0; i<queryResultList.length; i++) {
				if (i ==0) {
					queryResultList[i] = queryResultList[i].trim().concat(",Stock Name\n");				
				}
				else {
					queryResultList[i] = queryResultList[i].trim().concat(","+stock.getStockName()+"\n");
				}
				printWriter.write(queryResultList[i]);
			}
			printWriter.flush();
			printWriter.close();
			System.out.println("Output value: \n" + output.toString());
			System.out.println("Bytes Written: " + byteWritten + "Bytes.");
			System.out.println("Downloaded successfully to:\n" + (csvFilePath.toFile().getAbsolutePath()));
		} catch (IOException err) {
			err.printStackTrace();
		}
		finally {
			outputStream.close();
		}
		return output;
	}

	/**
	 * Simple method to check whether a file exists. Can be used to check a file has been created successfully.
	 * NOTE: Does not check for the validity of the file.
	 * @param filePath Path Location of file to check
	 * @return boolean true if file exists
	 */
	public static boolean fileExistsCheck(Path filePath) {
		return ( filePath.toFile().exists());

	}

}
