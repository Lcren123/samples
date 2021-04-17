package serverSide;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//Author: Loh Chun Ren B031910372
public class ServerTextApplication {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		// Launch the server frame
				ServerDateFrame serverFrame = new ServerDateFrame();
				serverFrame.setVisible(true);
				
				// Binding to a port or any other port no you are fancy of
				int portNo = 4228;
				ServerSocket serverSocket = new ServerSocket(portNo);
	
				// Counter to keep track the number of requested connection
				int totalRequest = 0;
				
				// Server needs to be alive forever
				while (true) {
					
					// Message to indicate server is alive
					serverFrame.updateServerStatus(false);
					
					
					// Accept client request for connection
					Socket clientSocket = serverSocket.accept();
					
					// Generate what need to be done (process a length of a text)
					//read from socket to ObjectInputStream object
		            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
		            //convert ObjectInputStream object to String
		            String message = (String) ois.readObject();
		            System.out.println("Message Received: " + message);
		            int answer = TextProcessor.processText(message);
		            //create ObjectOutputStream object
		            ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
		            //write object to Socket  
		            oos.writeObject("The length of text is "+ answer);
		            
		            
					// Create stream to write data on the network
					/*DataOutputStream outputStream = 
							new DataOutputStream(clientSocket.getOutputStream());*/
					
					// Send current result back to the client
					
					
					// Close the socket
					clientSocket.close();
					serverSocket.close();
					oos.close();
					
					// Update the request status
					serverFrame.updateRequestStatus(
							"Data sent to the client: " + answer);
					serverFrame.updateRequestStatus("Accepted connection to from the "
							+ "client. Total request = " + ++totalRequest );
					
				}
	
	
	
	
	}

}
