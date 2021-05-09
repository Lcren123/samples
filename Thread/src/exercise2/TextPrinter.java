package exercise2;

import java.util.Random;

public class TextPrinter implements Runnable {

	String Text[] = {"It ", "is ", "recommended ", "to ", "use ", "Calendar ","class "};
	
	public void printText() {

		for (int counter = 0; counter < 10; counter++) {
			
			for(int counter2 = 0 ; counter2 < counter ; counter2++) {
				if(counter2< 7)
			System.out.println(Text[counter2]);
				else;
			}
		}
	}
	
	public void printText(String currentThread) {

		for (int counter = 0; counter < 10; counter++) {
			
			for(int counter2 = 0 ; counter2 < counter ; counter2++) {
				if(counter2< 7)
			System.out.println(Text[counter2]+ "->" + currentThread);
				else;
			}
		}
	}
	
	public void printrandomText() {
		Random rand = new Random();
	int random = rand.nextInt(7);
	System.out.println(Text[random]);
}

		public void printrandomText(String currentThread) {
			try {
			Random rand = new Random();
		int random = rand.nextInt(7);
		System.out.println(Text[random] + "->" + currentThread);
		
		System.out.println("Thread is suspending");
		Thread.sleep(5000);
		
	}catch(Exception ex) {
		ex.printStackTrace();
	}
		}
		
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		Thread currentThread = Thread.currentThread();
		if(currentThread.getName() == "text")
		printText(currentThread.getName());
		if(currentThread.getName() == "word1"|| currentThread.getName() == "word2")
		printrandomText(currentThread.getName());
		
	}

}
