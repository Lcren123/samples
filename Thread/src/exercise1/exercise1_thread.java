package exercise1;

public class exercise1_thread {
	
public static void main(String[] args) {
		
		// Create objects of thread
		Thread printerThread1 = new TimePrinter();
		Thread printerThread2 = new TimePrinter();

		// Execute threads
		printerThread2.start();
		printerThread1.start();

	}
}
