package demo.instream;

import java.io.FileInputStream;

public class ReadDataBlock {
	
	public static void main (String args[]) {
		
		// 1. Declaration of input source
		String fileName = "dataBlock.dat";
		System.out.println("Input from " + fileName);

		try {

			// 2. Create input stream object
			FileInputStream fisObject = new FileInputStream(fileName);

			// 3. Read values for a specific size of block
			int blockSize = 20;
			byte blockData [ ] = new byte[blockSize];
			int size = fisObject.read(blockData);
			
			// Process data
			System.out.println("Block data: " + blockData);
			System.out.println("Size: " + size);
			
			// 4. Close stream
			fisObject.close();

		} catch (Exception ex) {

			ex.printStackTrace();
		}

		// Indicate end of program - Could be successful
		System.out.println("End of program");  
		
		
		
	}

}
