package demo.bytestream.raw;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;

/**
 * This program generates a series of integer values and store it in bytes
 * 
 * @author emalianakasmuri
 *
 */

public class ByteDataGenerator {
	
	
	public static void main(String[] args) {
		
		// Sample of data
		int numbers[] = {100, 200, 300, 400, 5000};
		
		// Destination to store the data as byte
		String destination = "integerInByte.dat";
		
		try {
			
			// Create stream to destination
			FileOutputStream fos = new FileOutputStream(destination);
			
			
			// Process data
			for (int index=0; index < numbers.length; index++) {
				
				// Convert to bytes
				BigInteger intObject = BigInteger.valueOf(numbers[index]);
				byte blockData[ ] = intObject.toByteArray();
				System.out.println(blockData.length);
				
				// Write into stream
				fos.write(blockData);
				
				
				
				fos.flush();
				
			}
			
			// Close the stream
			fos.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("End of program. Check out " + destination);
		

	}

}
