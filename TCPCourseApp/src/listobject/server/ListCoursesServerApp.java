package listobject.server;

import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import course.Course;
import course.CourseManager;

/**
 * This class represent a server-side application.
 * 
 * The application demonstrate reading and writing a list of object data using 
 * TCP and I/O streams.  
 * 
 * The program reads a list of object to be process from the client
 * and return it to the client.
 * 
 * How to run this program?
 * - Run this program Eclipse.
 * 
 * 
 * @author emalianakasmuri
 *
 */
public class ListCoursesServerApp {

	public static void main(String[] args) {
		
		CourseManager courseManager = new CourseManager();
		
		System.out.println("\n\nStarting ListCoursesServerApp");

		try {
			
			// Bind Serversocket to a port
			int portNo = 4229;
			ServerSocket serverSocket = new ServerSocket(portNo);
			
			// Server need to be alive forever
			while (true) {

				// Accept client request for connection
				Socket clientSocket = serverSocket.accept();
				
				// Read object from client, cast into Course
				ObjectInputStream ois = 
						new ObjectInputStream(clientSocket.getInputStream());
				@SuppressWarnings("unchecked")
				List<Course> courses = (List<Course>)ois.readObject();
				System.out.println("Processing objects from client: " + courses.size());
				
				// Process object
				List<Course> completeCourses = new ArrayList<Course>();
				int totalCredit = 0;
				for (Course course:courses) {
					
					Course completeCourse = courseManager.createCourse(course);
					completeCourses.add(completeCourse);
					
					// Update totalCredit
					totalCredit += completeCourse.getCreditHour();
				}
				
				// Return object to client using input stream
				ObjectOutputStream oos =
						new ObjectOutputStream(clientSocket.getOutputStream());
				oos.writeObject(completeCourses);
				
				DataOutputStream dos = 
						new DataOutputStream(clientSocket.getOutputStream());
				dos.writeInt(totalCredit);
				System.out.println("Respond to client request.");
				
				
				// Close all streams
				ois.close();
				oos.close();
				dos.close();
				
				System.out.println("Ready to server next request.");
			}

		} catch (Exception ex) {

			ex.printStackTrace();

		}
		
		
	}

}
