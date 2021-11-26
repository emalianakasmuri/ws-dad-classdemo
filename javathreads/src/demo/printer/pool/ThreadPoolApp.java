package demo.printer.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import demo.imprun.NumberPrinter;

/**
 * This program demonstrate the implementation of a thread pool.
 * 
 * @author emalianakasmuri
 *
 */
public class ThreadPoolApp {

	public static void main(String[] args) {
		
		
		
		// Create runnable objects
		Runnable numberPrinter1 = new NumberPrinter();
		Runnable numberPrinter2 = new NumberPrinter();
		Runnable numberPrinter3 = new NumberPrinter();
		Runnable numberPrinter4 = new NumberPrinter();
				
		// Create a fixed thread pool with maximum three threads
		ExecutorService printExecutorService = Executors.newFixedThreadPool(3);
		
		// Submit to executor
		printExecutorService.execute(numberPrinter3);
		printExecutorService.execute(numberPrinter1);
		printExecutorService.execute(numberPrinter2);
		printExecutorService.execute(numberPrinter4);
		
		
		// Shutdown the executor
		// No new task will be accepted, the existing will continue until finish
		printExecutorService.shutdown();
		
		

	}

}
