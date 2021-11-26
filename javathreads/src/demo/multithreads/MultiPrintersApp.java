package demo.multithreads;

import demo.extthr.StatementPrinter;
import demo.imprun.NumberPrinter;

public class MultiPrintersApp {

	public static void main(String[] args) {
		
		Thread statementThread = new StatementPrinter();
		
		Runnable numberable1 = new NumberPrinter();
		Thread numberThread1 = new Thread(numberable1, "Number 1");
		
		Thread numberThread2 = new Thread(numberable1, "Number 2");
		
	
		numberThread2.start();
		statementThread.start();
		numberThread1.start();

	}

}
