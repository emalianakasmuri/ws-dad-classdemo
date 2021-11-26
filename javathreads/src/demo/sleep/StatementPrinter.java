package demo.sleep;

/**
 * This class represents a Printer to print text.
 * @author emalianakasmuri
 *
 */
public class StatementPrinter extends Thread {

	/**
	 * This method prints a statement for five times
	 * and demonstrate suspension of Thread for 1 second
	 */
	public void printStatement() {

		try {
			for (int counter = 0; counter < 5; counter++) {
	
				System.out.println("Java is easy");
				
				// Suspend the current thread for 1000 milliseconnds
				Thread.sleep(1000);
			}
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}
	}

	@Override
	public void run() {
		
		// Execute task
		printStatement();

	}

}
