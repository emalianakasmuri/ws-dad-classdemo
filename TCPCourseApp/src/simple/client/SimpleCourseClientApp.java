package simple.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import course.Course;

/**
 * 
 * This class represent a client-side application.
 * 
 * The application demonstrate reading and writing object data using TCP
 * and I/O streams.  
 * 
 * The program sends the object to be process to the 
 * server-side program by writing in into an input stream.  
 * 
 * The program will
 * received the processed object from the server-side application by reading
 * from input stream.
 * 
 * How to run this program?
 * - Run this program from Terminal
 * - cd directory until bin
 * - java simple.client.SimpleCourseClientApp
 * 
 * 
 * 
 * @author emalianakasmuri
 *
 */
public class SimpleCourseClientApp {
	
	
	public static void main(String args[]) {
		
		System.out.println("Launching SimpleCourseClientApp program");
		
		
		// Create new object
		Course course = new Course();
		course.setCode("BITP3123");
		course.setEnName("Distributed Application Development");
		course.setMsName("Pembangunan Aplikasi Teragih");
		
		try {
			
			// Connect to server-side program
			Socket socket = new Socket(InetAddress.getLocalHost(), 4228);

			// Send object to be processed by the server-side application
			ObjectOutputStream oos = 
					new ObjectOutputStream (socket.getOutputStream());
			oos.writeObject(course);
			System.out.println("Sending " + course.getCode() + ":" 
					+ course.getEnName() + " to server-side application");
			
			// Receive processed object
			ObjectInputStream ois =
					new ObjectInputStream(socket.getInputStream());
			Course processedCourse = (Course) ois.readObject();
			
			// Manipulate processed object
			System.out.println("Course Information for " 
					+ processedCourse.getCode());
			System.out.println("Name (En) " 
					+ processedCourse.getEnName());
			System.out.println("Name (Ms) " 
					+ processedCourse.getMsName());
			System.out.println("Credit Hour " 
					+ processedCourse.getCreditHour());
			System.out.println("Graduate Code " 
					+ processedCourse.getGraduateCode());
			System.out.println("Degree Code " 
					+ processedCourse.getDegreeCode());
			
			
			// Close alll streams
			ois.close();
			oos.close();
			socket.close();

		} catch (Exception ex) {

		}
		
		
	}

}
