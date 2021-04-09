
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamDemo {

	public static void main(String[] args) {
		
		// Declaration of target storage
		String targetStorage = "data2.dat";
		
		
		// Declaration of stream objects
		FileOutputStream fileOutputStream; 
		DataOutputStream dataOutputStream; 
		
		
		try {
			
			// Chaining two streams using filter
			fileOutputStream = new FileOutputStream(targetStorage);
			dataOutputStream = new DataOutputStream(fileOutputStream);
			
			// Record integer data
			dataOutputStream.writeInt(1000);
			dataOutputStream.writeInt(3000);
			dataOutputStream.writeInt(5000);
			
			// Record string data
			String text = "Writes the specified byte to this file output stream.";
			dataOutputStream.writeUTF(text);
			
			
			// Force to write
			dataOutputStream.flush();
			
			// Close all streams
			dataOutputStream.close();
			fileOutputStream.close();
			
		} catch (IOException ioException) {
			
			System.out.println("Durian Tunggal... we got problem");
			ioException.printStackTrace();
		}
		
		
		System.out.println("End of program.  Check out " + targetStorage);
		
		
		

	}

}
