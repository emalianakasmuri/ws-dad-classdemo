package demo.account.cooperation;

public class WithdrawTask implements Runnable {
	
	private Account account;
	
	public WithdrawTask(Account account) {
		
		this.account = account;
	}

	@Override
	public void run() {

		// Keep subtracting from the account
		while(true) {
			
			account.withdraw((int) (Math.random() * 10) + 1);
		}
	}

}
