package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerTranslateApplication {

	/**
	 * Main entry point to the server side application
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		// Launch the server frame
		ServerTranslateFrame serverFrame = new ServerTranslateFrame();
		serverFrame.setVisible(true);
		
		// Binding to a port or any other port no you are fancy of
		
		ServerSocket serverSocket = null;
		int totalRequest = 0;
		
		try {
			int portNo = 4228;
			serverSocket = new ServerSocket(portNo);
			
			serverFrame.updateServerStatus(false);
			
		
		// Server needs to be alive forever
		while (true) {
			
			// Message to indicate server is alive
			serverFrame.updateServerStatus(false);
			
			
			// Accept client request for connection
			Socket clientSocket = serverSocket.accept();
			
			
			DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream());
			//Receive data from the client
			serverFrame.updateRequestStatus("\n > Waiting for client input");
			String language = inputStream.readUTF();
			String text = inputStream.readUTF();
			//System.out.println("test :"+  text  + language);
			Translator translator = new Translator();
			String translatetext = translator.translator(language, text);
			//System.out.println(text);
			
			// Create stream to write data on the network
			DataOutputStream outputStream = 
					new DataOutputStream(clientSocket.getOutputStream());
			outputStream.writeUTF(translatetext);
			outputStream.flush();
			
			// Close the socket
			clientSocket.close();
			outputStream.close();
			
			// Update the request status
			serverFrame.updateRequestStatus(
					"Data sent to the client: " + translatetext );
			serverFrame.updateRequestStatus("Accepted connection to from the "
					+ "client. Total request = " + ++totalRequest );
			
		}
		
		}
		catch(IOException ioe){
			
			if(serverSocket != null)
				serverSocket.close();
			
			ioe.printStackTrace();
		}

	}

}
