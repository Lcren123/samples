package clientSide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import serverSide.TextProcessor;

/**
 * This method launch the frame and manage the connection to the server.
 * 
 * @author emalianakasmuri
 *
 */

public class ClientTextApplication {
	
	public static void main(String[] args) 
			throws UnknownHostException, IOException, ClassNotFoundException {
		 ObjectOutputStream oos = null;
		    ObjectInputStream ois = null;
		    String request = "Executing Exercise 3";
	
		// Launch client-side frame
		ClientDateFrame clientDateFrame = new ClientDateFrame();
		clientDateFrame.setVisible(true);
		
		// Connect to the server @ localhost, port 4228
		Socket socket = new Socket(InetAddress.getLocalHost(), 4228);
		
		// Update the status of the connection
		clientDateFrame.updateConnectionStatus(socket.isConnected());
		
		//write to socket using ObjectOutputStream
        oos = new ObjectOutputStream(socket.getOutputStream());
        System.out.println("Sending request to Socket Server");
        System.out.println("Sent line : " + request);
        oos.writeObject(request);
        oos.writeObject("exit");
        
        //read the server response message
        ois = new ObjectInputStream(socket.getInputStream());
        String message = (String) ois.readObject();
        System.out.println("Message: " + message);
        
		// Read from network
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		
		// Display the current date
		//message = bufferedReader.readLine();
		clientDateFrame.updateServerDate(message);
		
		// Close everything
		 ois.close();
         oos.close();
		bufferedReader.close();
		//socket.close();

	}

}
