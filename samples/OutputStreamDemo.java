

/**
 * This program demonstrate the application of output stream that processed data as raw bytes.
 * The data is stored in a file.
 * 
 * @author emalianakasmuri
 * 
 */


import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStreamDemo {

	public static void main(String[] args) {
		
		
		// Declaration of target storage
		String targetStorage = "data1.dat";
		
		// Declaration of output stream object
		FileOutputStream fileOutputStream;
		
		try {
			
			// Create an output stream between this file and data.dat
			fileOutputStream = new FileOutputStream(targetStorage);
			
			// Write three characters 
			fileOutputStream.write(65);
			fileOutputStream.write(66);
			fileOutputStream.write(67);
			
			fileOutputStream.flush();
			
			// Write string
			String text = "Writes the specified byte to this file output stream.";
			byte textInBytes[ ] = text.getBytes();
			fileOutputStream.write(textInBytes);
			
			fileOutputStream.flush();
			
			// Close the stream
			fileOutputStream.close();  
	         
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		// Indicate end of program - Could be succcessful
		System.out.println("End of program.  Check out " + targetStorage);   
	}

}
