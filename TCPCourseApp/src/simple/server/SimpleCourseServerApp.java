package simple.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import course.Course;
import course.CourseManager;

/**
 * This class represent a server-side application.
 * 
 * The application demonstrate reading and writing object data using TCP
 * and I/O streams.  The program reads object to be process from the client
 * and return the processed object to the client.
 * 
 * How to run this program?
 * - Run this program Eclipse.
 * 
 * 
 * @author emalianakasmuri
 *
 */
public class SimpleCourseServerApp {

	public static void main(String[] args) {
		
		CourseManager courseManager = new CourseManager();
		
		System.out.println("Starting SimpleCourseServerApp");

		try {
			
			// Bind Serversocket to a port
			int portNo = 4228;
			ServerSocket serverSocket = new ServerSocket(portNo);
			
			// Server need to be alive forever
			while (true) {

				// Accept client request for connection
				Socket clientSocket = serverSocket.accept();
				
				// Read object from client, cast into Course
				ObjectInputStream ois = 
						new ObjectInputStream(clientSocket.getInputStream());
				Course course = (Course)ois.readObject();
				System.out.println("Processing object from client: " 
						+ course.getCode());
				
				// Process object
				course = courseManager.createCourse(course); 
				
				// Return object to client using input stream
				ObjectOutputStream oos =
						new ObjectOutputStream(clientSocket.getOutputStream());
				oos.writeObject(course);
				
				
				// Close all streams
				ois.close();
				oos.close();
				
				
			}

		} catch (Exception ex) {

			ex.printStackTrace();

		}
		
		
	}

}
