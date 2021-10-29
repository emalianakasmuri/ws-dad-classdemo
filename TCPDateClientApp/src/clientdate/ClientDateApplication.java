package clientdate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Run this application from Eclipse.
 * 
 * 
 * @author emalianakasmuri
 *
 */


public class ClientDateApplication {

	public static void main(String[] args) throws UnknownHostException, 
		IOException {
		
		
		// Launch client-side frame
		ClientDateFrame clientDateFrame = new ClientDateFrame();
		clientDateFrame.setVisible(true);
		
		// Connect to the server at localhost, port 4228
		Socket socket = new Socket(InetAddress.getLocalHost(), 4228);
		
		// Update the status of the connection
		clientDateFrame.updateConnectionStatus(socket.isConnected());
		
		// Create input stream - filter and chain
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		
		
		// Read from the network and display the current date
		String currentDate = bufferedReader.readLine();
		clientDateFrame.updateServerDate(currentDate);
		
		// Close everything
		bufferedReader.close();
		socket.close();
		

	}

}
