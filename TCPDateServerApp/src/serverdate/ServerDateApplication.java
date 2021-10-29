package serverdate;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * To run this application on Terminal
 * cd TCPServerDateApp/bin/
 * java serverdate.ServerDateApplication
 * @author emalianakasmuri
 *
 */

public class ServerDateApplication {

	
	public static void main(String[] args) {
		
		
		// Launch the server frame
		ServerDateFrame serverFrame = new ServerDateFrame();
		serverFrame.setVisible(true);
		
		try {
			
			// Bind Serversocket to a port
			int portNo = 4228;
			ServerSocket serverSocket = new ServerSocket(portNo);

			DateGenerator dateGenerator = new DateGenerator();

			// Counter to keep track the number of requested connection
			int totalRequest = 0;

			// Server need to be alive forever
			while (true) {

				// Accept client request for connection
				Socket clientSocket = serverSocket.accept();

				// Get current date
				String currentDate = dateGenerator.getCurrentDate();


				// Create stream to write data on the network
				DataOutputStream outputStream = 
						new DataOutputStream(clientSocket.getOutputStream());

				// Send current date back to the client
				outputStream.writeBytes(currentDate);

				// Close the socket
				clientSocket.close();


				// Update the request status
				serverFrame.updateRequestStatus("Data sent to the client: " 
						+ currentDate);
				serverFrame.updateRequestStatus(
						"Accepted connection from the client.  "
						+ "Total request =" + ++totalRequest);
			}
			
		} catch (Exception exception) {

			System.out.println("Durian Tunggal, we got problem.");
			exception.printStackTrace();

		}
		

	}

}




















