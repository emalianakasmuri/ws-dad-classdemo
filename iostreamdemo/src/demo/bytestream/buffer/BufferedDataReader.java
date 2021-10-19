package demo.bytestream.buffer;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

/**
 * This program demonstrate reading byte-based data from a buffer using BufferedInputStream.
 * The data represents bed utilization for COVID-19 cases in several states of Malaysia.
 *
 * The program calculates the average of bed utilization.
 * 
 * 
 * 
 * @author emalianakasmuri
 *
 */
public class BufferedDataReader {

	public static void main(String[] args) {
		
		// 1. Declare output file 
		String sourceFile = "bedUtilization2.txt";
		System.out.println("Reading data from " + sourceFile + "\n");

		try {

			// 2. Create stream to read data
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));

			// Variables for processing byte-based data
			int utilization = 0;
			int totalUtilization = 0;
			int noOfRecords = 0;

			// 3. Process data until end-of-file
			while(bis.available() > 0) {

				// Read data
				utilization = bis.read();
				
				System.out.println(utilization);

				// Calculate total utilization
				totalUtilization += utilization;
				noOfRecords ++;
			}

			// 4. Close stream
			bis.close();

			// Calculate average utlization
			int averageUtlization = totalUtilization / noOfRecords;
			System.out.print("\nAverage utlization for " + noOfRecords 
					+ " states: " + averageUtlization + "%");

		} catch (Exception ex) {

			ex.printStackTrace();
		}

		// Indicate end of program - Could be successful
		System.out.println("\nEnd of program.");

	}

}
