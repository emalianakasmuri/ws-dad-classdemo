package demo.outstream;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * This method demonstrate manipulation of output stream using subclass 
 * of OutputStream.
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

			// 3. Write single bytes for three times
			// Refer to ASCII table.
			fosObject.write(65);
			fosObject.write(66);
			fosObject.write(67);
			
			// 4. Clear the buffer
			fosObject.flush();

			// Write string
			/*String text = "Writes the specified byte to this file output stream.";
					byte textInBytes[ ] = text.getBytes();
					fileOutputStream.write(textInBytes);

					fileOutputStream.flush();*/

			// 5. Close the stream
			fosObject.close();  

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  

		// Indicate end of program - Could be succcessful
		System.out.println("End of program.  Check out " + targetStorage);   
	}
}
