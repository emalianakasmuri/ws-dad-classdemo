package demo.bytestream.raw;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * This program demonstrate writing a block of data into a file using FileOutputStream
 * 
 * @author emalianakasmuri
 *
 */


public class WriteDataBlock {
	
	public static void main(String[] args) {
		
		// 1. Declaration of target storage
		String targetStorage = "dataBlock.dat";


		try {

			// 2. Create an output stream between this program and the target storage
			FileOutputStream fosObject = new FileOutputStream(targetStorage);

			// 3. Write a block of data
			String text = "Writes the specified byte to this file output stream.";
			byte textInBytes[ ] = text.getBytes();
			fosObject.write(textInBytes);
			
			// 4. Clear the stream
			fosObject.flush();

			// 5. Close the stream
			fosObject.close();  

		} catch (IOException e) {
			
			e.printStackTrace();
		}  

		// Indicate end of program - Could be succcessful
		System.out.println("End of program.  Check out " + targetStorage);   
	}

}
