package demo.bytestream.buffer;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

/**
 * This program demonstrate buffered data genereation using BufferedOutputStream.
 * 
 * @author emalianakasmuri
 *
 */

public class BufferedDataGeneator {

	public static void main(String[] args) {
		
		// 1. Declare output file 
		String outFile = "bedUtilization2.txt";

		// Data declaration
		double utilizations[] = {79.0, 75.0, 75.0, 74.0, 73.1, 72.6, 70.6, 69.2};
		
		try {

			// 2. Create stream to read data
			BufferedOutputStream bos = new BufferedOutputStream (new FileOutputStream(outFile));

			// 3. Write data into buffer
			
			for (int index = 0; index < utilizations.length; index++) {
				
				byte utlization = (byte) utilizations[index];
				bos.write(utlization);

				// 4. Flush for each writing
				bos.flush();
			}

			// 5. Close stream
			bos.close();

		} catch (Exception ex) {

			ex.printStackTrace();
		}

		// Indicate end of program - Could be successful
		System.out.println("End of program. Check out " + outFile); 

	}

}
