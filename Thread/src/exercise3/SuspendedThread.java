package exercise3;

import exercise2.TextPrinter;

public class SuspendedThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Runnable textPrinter1 = new TextPrinter();
		Runnable randomText = new TextPrinter();
		Runnable randomText2 = new TextPrinter();
		
		// Create objects of thread with name
		Thread text = new Thread(textPrinter1,"text");
		Thread word1 = new Thread(randomText,"word1");
		Thread word2 = new Thread(randomText2,"word2");
		// Execiute thread
		text.start();
		word1.start();
		word2.start();
	}

}
