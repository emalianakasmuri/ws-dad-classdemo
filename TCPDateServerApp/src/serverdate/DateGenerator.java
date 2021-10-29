package serverdate;

import java.util.Date;

public class DateGenerator {
	
	/**
	 * This method generates current date
	 * 
	 * @return current date
	 */
	public String getCurrentDate( ) {
		
		
		String currentDate = new Date().toString();
		
		return currentDate;
	}

}
