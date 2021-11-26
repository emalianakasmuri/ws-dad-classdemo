package demo.account.nosync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This program demonstrate the effect of non-synchronized multithreaded 
 * application accessing the shared data.
 * 
 * @author emalianakasmuri
 *
 */
public class AddRinggitNoSyncApp {

	public static void main(String[] args) {

		// This object represent the shared resource - data
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
		
		System.out.println("The final current balance : " + 
				account.getBalance());
			
	}

}
