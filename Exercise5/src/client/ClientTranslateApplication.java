package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * This method launch the frame and manage the connection to the server.
 * 
 * @author emalianakasmuri
 *
 */

public class ClientTranslateApplication {

	public static void main(String[] args) 
			throws UnknownHostException, IOException, InterruptedException {
		
		try {
		// Launch client-side frame
		ClientTranslateFrame clientTranslateFrame = new ClientTranslateFrame();
		clientTranslateFrame.setVisible(true);
		
		// Connect to the server @ localhost, port 4228
		Socket socket = new Socket(InetAddress.getLocalHost(), 4228);
		
		// Update the status of the connection
		clientTranslateFrame.updateConnectionStatus(socket.isConnected());
		
		//create input stream to send data to server
		DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
		clientTranslateFrame.waitForInputs();
		String language = clientTranslateFrame.getlanguage();
		String text = clientTranslateFrame.gettext();
		//System.out.println("Text: " + language + text);
		
		//create output stream
		//Socket clientSocket = null;
		DataOutputStream outputStream = 
				new DataOutputStream(socket.getOutputStream());
		outputStream.writeUTF(language);
		outputStream.writeUTF(text);
	
		//Read from the network and display the current text
		String translatedText = dataInputStream.readUTF();
		
		//change the font to display korean word
		if(language.equals("korea"))			
			clientTranslateFrame.setKoreanFont();
		

		clientTranslateFrame.updateServerText(translatedText);
		
		// Close everything
		dataInputStream.close();
		outputStream.close();
		socket.close();

	}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
