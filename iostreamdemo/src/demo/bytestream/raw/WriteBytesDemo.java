package demo.bytestream.raw;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * This program demonstrate multiple data using FileOutputStream
 * 
 * @author emalianakasmuri
 *
 */
public class WriteBytesDemo {

	public static void main(String[] args) {
		
		// 1. Declaration of target storage
		String targetStorage = "outBytesDemo.dat";

		// 2. Declaration of output stream object
		FileOutputStream fosObject;

		try {

			// 2.1 Create an output stream between this file and data.dat
			fosObject = new FileOutputStream(targetStorage);

			// 3. Single bytes of data for 120 times
			// Refer to ASCII table.
			for (int counter = 0; counter < 120; counter++)
				fosObject.write(counter);

			// 4. Clear the buffer
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


