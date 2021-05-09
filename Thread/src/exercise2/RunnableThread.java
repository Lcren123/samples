package exercise2;

public class RunnableThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create objects of runnable
		Runnable textPrinter1 = new TextPrinter();
		Runnable randomText = new TextPrinter();
		
		// Create objects of thread with name
		Thread text = new Thread(textPrinter1,"text");
		Thread word1 = new Thread(randomText,"word1");
		
		// Execute thread
		text.start();
		word1.start();
		
	}

}
