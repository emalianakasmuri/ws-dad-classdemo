package demo.multithreads;

import demo.extthr.StatementPrinter;
import demo.imprun.NumberPrinter;

/**
 * This class is used to differentiate between joining and non-joining threads.
 * 
 * This is a class with joining the threads.
 * 
 * @author emalianakasmuri
 *
 */
public class MultiThreadsJoinApp {

	public static void main(String[] args) {
		
		// Create object of threads
		Thread statementThread = new StatementPrinter();
		
		Runnable numberable1 = new NumberPrinter();
		Thread numberThread1 = new Thread(numberable1, "Number 1");
		
		Thread numberThread2 = new Thread(numberable1, "Number 2");
		
		try {
			
			// Execute the threads
			numberThread2.start();
			statementThread.start();
			numberThread1.start();
			
			// Let threads of lower priority to execute,
			// wait until its finished, then continue execution
			numberThread2.join();
			statementThread.join();
			numberThread1.join();
			
			
			System.out.println("Program ends");
		
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}

	}

}


