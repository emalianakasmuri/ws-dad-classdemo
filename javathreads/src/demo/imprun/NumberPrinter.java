package demo.imprun;

/**
 * This class demonstrate a class definition of a thread using 
 * implements Runnable.
 * 
 * @author emalianakasmuri
 *
 */
public class NumberPrinter implements Runnable {

	/**
	 * This method prints numbers based on the counter
	 */
	public void printNumbers () {

		for (int counter = 0; counter < 5; counter++) {
			System.out.println(counter);
		}
	}

	@Override
	public void run() {
		
		// Execute task
		printNumbers( );
		
	}
}



