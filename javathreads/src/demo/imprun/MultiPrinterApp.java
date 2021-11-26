package demo.imprun;

/**
 * This class demonstrate creation of thread objects from class 
 * that implements Runnable
 * 
 * @author emalianakasmuri
 *
 */
public class MultiPrinterApp {

	public static void main(String[] args) {

		// Create objects of runnable
		Runnable numberPrinter1 = new NumberPrinter();
		Runnable numberPrinter2 = new NumberPrinter();
		
		// Create objects of thread
		Thread printerThread1 = new Thread(numberPrinter1);
		Thread printerThread2 = new Thread(numberPrinter2);
		

		printerThread2.start();
		printerThread1.start();

	}

}

