package demo.account.cooperation;

public class DepositTask implements Runnable {

	private Account account;
	
	public DepositTask(Account account) {
		
		this.account = account;
	}
	
	@Override
	public void run() {
		
		try {
			
			// Keep adding money to the account
			while(true) {
				
				account.deposit((int) (Math.random() * 10) + 1);
				Thread.sleep(3000);
			}
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}

	}

}
