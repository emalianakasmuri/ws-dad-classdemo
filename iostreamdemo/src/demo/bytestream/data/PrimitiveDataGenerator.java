package demo.bytestream.data;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

/**
 * This program demonstrate writing byte-based data using DataOuputStream
 * 
 * @author emalianakasmuri
 *
 */
public class PrimitiveDataGenerator {

	public static void main(String[] args) {
		
		
		// 1. Declare output file 
		String outFile = "bedUtilization.txt";
		
		// Data declaration
		String states[] = {"Kelantan", "Perlis", "Terengganu", "Melaka", "Johor", 
				"Kedah", "Perak", "Pulau Pinang"};
		double utilizations[] = {79.0, 75.0, 75.0, 74.0, 73.1, 72.6, 70.6, 69.2};
		
		try {
			
			// 2. Create stream to read data
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(outFile));
			
			// 3. Write data into data stream
			for (int index = 0; index < states.length; index++) {
				
				dos.writeUTF(states[index]);
				dos.writeDouble(utilizations[index]);
				
				// 4. Flush for each writing
				dos.flush();
			}
			
			// 5. Close stream
			dos.close();
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}
		
		// Indicate end of program - Could be successful
		System.out.println("End of program. Check out " + outFile); 
	}

}
