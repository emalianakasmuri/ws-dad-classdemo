package demo.naming;

/**
 * This class demonstrate the task to print numbers
 * 
 * @author emalianakasmuri
 *
 */
public class NumberPrinter implements Runnable {

	/**
	 * This method prints name of thread and numbers
	 * 
	 * @param currentThread - name of current Thread
	 */
	public void printNumbers (String currentThread) {

		for (int counter = 0; counter < 5; counter++) {
			
			System.out.println(currentThread + "->" + counter);
		}
	}

	@Override
	public void run() {
		
		// Get current thread
		Thread currentThread = Thread.currentThread();
		
		// Execute task
		printNumbers( currentThread.getName());
		
	}
}



