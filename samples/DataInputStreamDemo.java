

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamDemo {

	public static void main(String[] args) {
		
		
		// Declaration of source storage
		String sourceStorage = "data2.dat";


		// Declaration of stream objects
		FileInputStream fileInputStream; 
		DataInputStream dataInputStream; 


		try {

			// Chaining two streams using filter
			fileInputStream = new FileInputStream(sourceStorage);
			dataInputStream = new DataInputStream(fileInputStream);

			// Record data
			System.out.println("Data from " + sourceStorage);
			int data1 = dataInputStream.readInt();
			System.out.println(data1);
			int data2 = dataInputStream.readInt();
			System.out.println(data2);
			int data3 = dataInputStream.readInt();
			System.out.println(data3);

			// Perform arithmetic operation
			int total = data1 + data2 + data3;
			System.out.println("Total of the above numbers is " + total);
			
			String text = dataInputStream.readUTF();
			System.out.println("\n\nLength of '" + text + "' is " + text.length() + " characters.");
			System.out.println("\n\n");
			
			
			
			// Close all streams
			dataInputStream.close();
			fileInputStream.close();

		} catch (IOException ioException) {

			System.out.println("Durian Tunggal... we got problem");
			ioException.printStackTrace();
		}


		System.out.println("End of program.  Check out " + sourceStorage + ". "
				+ "Compare the output from the console");

	}

}
