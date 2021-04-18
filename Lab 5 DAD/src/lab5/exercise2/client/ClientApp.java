package lab5.exercise2.client;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import lab5.exercise1.itemProduct;


public class ClientApp {
public static void main(String[] args) {
		
		System.out.println("ClientSideApp: Exercise 2\n");

		// Request data
		itemProduct Item1 = new itemProduct(); 
		Item1.setName("PhoneX12");

		try {

			// Data to establish connection to server
			int portNo = 4228;
			InetAddress serverAddress = InetAddress.getLocalHost();

			// Connect to the server at localhost, port 4228
			Socket socket = new Socket(serverAddress, portNo);

			// Open stream to send object
			ObjectOutputStream objectOS = new ObjectOutputStream(socket.getOutputStream());

			// Send request to server
			System.out.println("Send object to server: " + Item1);
			objectOS.writeObject(Item1);
			objectOS.flush();
			
			// Open stream to receive object
			ObjectInputStream objectIS = new ObjectInputStream(socket.getInputStream());
			
			// Get object from stream and display details
			Item1 = (itemProduct) objectIS.readObject();
			System.out.println ("Id for " + Item1.getName() + " is " + Item1.getItemProductid());
			
			// Close all closeable objects
			objectOS.close();
			objectIS.close();
			socket.close();

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("\nClientSideApp: End of application.\n");

	}
}
