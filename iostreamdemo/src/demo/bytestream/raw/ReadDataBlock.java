package demo.bytestream.raw;

import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

public class ReadDataBlock {
	
	public static void main (String args[]) {
		
		// 1. Declaration of input source
		String fileName = "dataBlock.dat";
		System.out.println("Input from " + fileName);

		try {

			// 2. Create input stream object
			FileInputStream fisObject = new FileInputStream(fileName);

			// Define data block
			int blockSize = 20;
			byte blockData [ ] = new byte[blockSize];
			
			// 3. Read values for a specific size of block
			int size = fisObject.read(blockData);
			
			
			// Process data
			String data = new String(blockData, StandardCharsets.UTF_8);
			System.out.println("Block data: " + data);
			System.out.println("Size read: " + size);
			// 4. Close stream
			fisObject.close();

		} catch (Exception ex) {

			ex.printStackTrace();
		}

		// Indicate end of program - Could be successful
		System.out.println("End of program");  
		
		
		
	}

}
