package demo.account.nosync;

public class Account {
	
	// Represent the shared data
	private int balance = 0;

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void deposit(int amount) {
		
		int newBalance = balance + amount;
		
		// This block is to magnify the data corruption
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		balance = newBalance;
	}
	
	

}
