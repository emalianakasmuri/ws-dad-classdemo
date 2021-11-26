package demo.sleep;

/**
 * This class represent a Printer to print numbers
 * @author emalianakasmuri
 *
 */
public class NumberPrinter implements Runnable {

	/**
	 * This method prints some numbers and suspend the current thread.
	 * 
	 * @param threadName - name of the thread
	 */
	public void printNumbers (String threadName) {
		
		try {
			for (int counter = 0; counter < 5; counter++) {
				
				System.out.println(threadName + "-> " + counter);
				
				// Suspend the current thread for 3 milliseconds
				Thread.sleep(3000);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void run() {
		
		// Get current thread
		Thread currentThread = Thread.currentThread();
		
		// Execute task
		printNumbers(currentThread.getName() );
		
	}
}



