package demo.account.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This program demonstrate locking the critical region on shared data
 * 
 * @author emalianakasmuri
 *
 */
public class AddRinggitSyncApp {

	public static void main(String[] args) {

		// Represent the shared data for multiple threads
		Account account = new Account();
		
		
		// Create executor
		ExecutorService executor = Executors.newCachedThreadPool();
		
		// Launch 50 threads - it should get RM 50
		// Submit task
		for (int counter = 0; counter < 50; counter++)
			executor.execute(new AddRinggitTask(account));
		
		executor.shutdown();
		
		// Wait until all task is finished
		while (executor.isTerminated() == false) {
			
		}
		
		System.out.println("The final current balance : " + account.getBalance());
			
	}

}
