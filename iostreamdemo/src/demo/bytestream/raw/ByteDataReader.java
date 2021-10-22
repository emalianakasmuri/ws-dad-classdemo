package demo.bytestream.raw;

import java.io.FileInputStream;
import java.math.BigInteger;

public class ByteDataReader {

	public static void main(String[] args) {

		// Destination to store the data as byte
		String source = "integerInByte.dat";
		
		int size = 2;
		byte blockData[ ] = new byte[size];
		
		try {
			
			// Create stream to read the data
			FileInputStream fis = new FileInputStream(source);
			
			int eof = fis.read(blockData);
			System.out.println("@ 22 " + eof);
			while (eof != -1) {
				
				int data = new BigInteger(1, blockData).intValueExact();
				System.out.println("@ 26 " + data);
				eof = fis.read(blockData);
				System.out.println("@ 28 " + eof);
				
			}
			
			// Close stream
			fis.close();
			
			
		} catch (Exception ex) {
			
			
		}
	}

}
