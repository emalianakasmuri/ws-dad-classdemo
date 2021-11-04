package listobject.client;

import java.io.DataInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import course.Course;

/**
 * 
 * This class represent a client-side application.
 * 
 * The application demonstrate reading and writing a list of object data 
 * using TCP and I/O streams.  
 * 
 * The program sends the list of object to be process to the  server-side 
 * program by writing in into an input stream.  
 * 
 * The program will received a list of processed objects from the 
 * server-side application by reading it from input stream.
 * 
 * How to run this program?
 * - Run this program from Terminal
 * - cd directory until bin
 * - java listobject.client.ListCoursesClientApp
 * 
 * 
 * 
 * @author emalianakasmuri
 *
 */
public class ListCoursesClientApp {
	
	
	public static void main(String args[]) {
		
		System.out.println("\n\nLaunching ListCoursesClientApp program");
		
		
		// Create new objects
		Course dad = new Course();
		dad.setCode("BITP3123");
		dad.setEnName("Distributed Application Development");
		dad.setMsName("Pembangunan Aplikasi Teragih");
		
		Course oop = new Course();
		oop.setCode("BITP3113");
		oop.setEnName("Object Oriented Programming");
		oop.setMsName("Pengaturcaraan Berorentasikan Object");
		
		Course aoa = new Course();
		aoa.setCode("MITP5113");
		aoa.setEnName("Analysis on Algorithm");
		aoa.setMsName("Analisa Algoritma");
		
		// Add to list
		List<Course> courses = new ArrayList<Course>();
		courses.add(aoa);
		courses.add(oop);
		courses.add(dad);
		
		
		
		try {
			
			// Connect to server-side program
			Socket socket = new Socket(InetAddress.getLocalHost(), 4229);
						
			// Send object to be processed by the server-side application
			ObjectOutputStream oos = 
					new ObjectOutputStream (socket.getOutputStream());
			oos.writeObject(courses);
			System.out.println("\nSending " + courses.size() 
				+ " courses to server-side application.\n");
			
			// Receive processed object
			ObjectInputStream ois =
					new ObjectInputStream(socket.getInputStream());
			@SuppressWarnings("unchecked")
			List<Course> processedCourses = (List<Course>) ois.readObject();
			
			DataInputStream dis =
					new DataInputStream(socket.getInputStream());
			int totalCredits = dis.readInt();			
			
			// Manipulate processed object
			for (Course processedCourse:processedCourses) {
				
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
				System.out.println();
			}
			
			System.out.println("Total credit hours: " + totalCredits);
			System.out.println("Total courses: " +  processedCourses.size());
			
			
			
			// Close all streams
			ois.close();
			oos.close();
			dis.close();
			socket.close();

		} catch (ConnectException connectException) {
			
			System.out.println("\n\nConnection is not establish. "
					+ "Re-run this application");
		
		} catch (Exception exception) {
			
			exception.printStackTrace();
		}
		
		System.out.println("Program ends\n\n");
		
	}

}
