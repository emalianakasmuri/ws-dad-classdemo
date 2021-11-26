package demo.account.cooperation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccoutCooperationApp {

	public static void main(String[] args) {
		
		
		Account account = new Account();
		
		Runnable depositTask = new DepositTask(account);
		Runnable withdrawTask = new WithdrawTask(account);
		
		ExecutorService accountExecutor = Executors.newFixedThreadPool(2);
		accountExecutor.execute(depositTask);
		accountExecutor.execute(withdrawTask);
		
		accountExecutor.shutdown();
		
		System.out.println("Thread 1\t\tThread 2\t\tBalance");

	}

}
