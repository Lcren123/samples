package exercise1;

public class TimePrinter extends Thread {
	
	public void printTime() {
		
		for (int counter = 0; counter < 10; counter++) {
			
			System.out.println(java.time.LocalTime.now());
		}
		
		
	}
	@Override
	public void run() {

		// Execute task to print statements
		printTime();

	}
}
