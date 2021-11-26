package demo.account.cooperation;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
	
	// Represent the shared data
	private int balance = 0;
	
	// Use lock
	private Lock accountLock = new ReentrantLock();
	
	// Account condition
	private Condition newDeposit = accountLock.newCondition();

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void withdraw(int amount) {
		
		// Acquire lock
		accountLock.lock();
		
		try {
			
			// Test condition to withdraw
			while (balance < amount) {
				
				// Ask Thread to deposit to wait
				System.out.println("\t\tWait for deposit");
				newDeposit.await();
			}
			
			// Withdraw and update balance
			balance -= amount;
			System.out.println("\t\t\tWithdraw " + amount + "\t\t" + getBalance());
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		
		} finally {
			
			// Release lock
			accountLock.unlock();
		}
	}
	
	public void deposit(int amount) {
		
		// Acquire lock
		accountLock.lock();

		balance += amount;
		System.out.println("Deposit " + amount + "\t\t\t\t\t" + getBalance());

		// Signal the thread in waiting
		newDeposit.signalAll();

		// Release lock
		accountLock.unlock();
	}
	
	

}
