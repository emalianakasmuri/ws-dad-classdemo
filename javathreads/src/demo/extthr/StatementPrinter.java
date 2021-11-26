package demo.extthr;

/**
 * This class demonstrate definition of task to be run simultaneously using 
 * extends Thread.
 *
 * 
 * @author emalianakasmuri
 *
 */
public class StatementPrinter extends Thread {

	/**
	 * This method prints a statement for five times
	 */
	public void printStatement() {

		for (int counter = 0; counter < 5; counter++) {

			System.out.println("Java is easy");
		}
	}

	@Override
	public void run() {

		// Execute task to print statements
		printStatement();

	}

}
