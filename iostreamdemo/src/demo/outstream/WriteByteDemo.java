package demo.outstream;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * This program demonstrate writing into a file using FileOutputStream
 * 
 * @author emalianakasmuri
 *
 */
public class WriteByteDemo {

	public static void main(String[] args) {
		
		// 1. Declaration of target storage
		String targetStorage = "outByteDemo.dat";

		// 2. Declaration of output stream object
		FileOutputStream fosObject;

		try {

			// 2.1 Create an output stream between this file and data.dat
			fosObject = new FileOutputStream(targetStorage);

			// 3. Create output for the file
			fosObject.write(1);
			fosObject.write(2);
			fosObject.write(3);
			
			// 4. Clear the buffer
			fosObject.flush();
			
			// Create another output
			fosObject.write(400);

			// 5. Close the stream
			fosObject.close();  

		} catch (IOException e) {
			
			e.printStackTrace();
		}  

		// Indicate end of program - Could be succcessful
		System.out.println("End of program.  Check out " + targetStorage);   
	}
}

//Write string
			/*String text = "Writes the specified byte to this file output stream.";
					byte textInBytes[ ] = text.getBytes();
					fileOutputStream.write(textInBytes);

					fileOutputStream.flush();*/
