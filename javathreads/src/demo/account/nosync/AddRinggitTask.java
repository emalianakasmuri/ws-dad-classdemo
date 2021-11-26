package demo.account.nosync;

public class AddRinggitTask implements Runnable {

	private Account account;
	
	public AddRinggitTask (Account account) {
		
		this.account = account;
	}
	
	@Override
	public void run() {
		
		System.out.println("Adding a ringgit to " + account.getBalance());
		
		account.deposit(1); 
		
		System.out.println("New balance is " + account.getBalance());
	}

}
