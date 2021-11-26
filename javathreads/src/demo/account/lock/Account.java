package demo.account.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
	
	// Represent the shared data
	private int balance = 0;
	
	// Use lock
	private Lock accountLock = new ReentrantLock();

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void deposit(int amount) {
		
		// Acquire lock
		accountLock.lock();
		
		int newBalance = balance + amount;
		
		// This block is to magnify the data corruption
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		balance = newBalance;
		
		// Release lock
		accountLock.unlock();
	}
	
	

}
