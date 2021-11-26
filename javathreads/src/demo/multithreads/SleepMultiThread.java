package demo.multithreads;

import demo.extthr.StatementPrinter;
import demo.imprun.NumberPrinter;

public class SleepMultiThread {

	public static void main(String[] args) {
		
		
		Runnable numberPrinter1 = new NumberPrinter();
		Thread numberThread = new Thread(numberPrinter1);
		
		Thread statementThread = new StatementPrinter();
		

		statementThread.start();
		numberThread.start();
	}

}
