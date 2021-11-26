package demo.extthr;

/**
 * This class demonstrate implementation of multiple threads
 * from the same definition of class Thread.
 * 
 * @author emalianakasmuri
 *
 */
public class MultiPrinterApp {

	public static void main(String[] args) {
		
		// Create objects of thread
		Thread printerThread1 = new StatementPrinter();
		Thread printerThread2 = new StatementPrinter();

		// Execute threads
		printerThread2.start();
		printerThread1.start();

	}

}
