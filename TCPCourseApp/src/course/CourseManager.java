package course;

public class CourseManager {
	
	
	public Course createCourse (Course course) {
			
		String courseCode = course.getCode().toUpperCase();
		course.setCode(courseCode);
		
		String name = course.getEnName().toUpperCase();
		course.setEnName(name);
		
		name = course.getMsName().toUpperCase();
		course.setMsName(name);
		
		// Get credit hour
		int creditHour = this.getCreditHour(course.getCode());
		course.setCreditHour(creditHour);
		
		// Get graduate level
		char graduateLevel = this.graduateLevel(course.getCode());
		course.setGraduateCode(graduateLevel);
		
		// Get graduate type
		char degreeType = course.getCode().charAt(0);
		course.setDegreeCode(degreeType);
		
		return course;
		
	}
	
	/**
	 * This method assigned graduate level code based on the course code
	 * 
	 * @param code
	 * @return
	 */
	private char graduateLevel (String code) {
		
		char firstChar = code.charAt(0);
		
		switch (firstChar) {
		
		case 'B':
		case 'D':
			return 'U';
		
		case 'M':
		case 'P':
			return 'P';
		
		default:
			return 'X';
		}
		
	}
	
	/**
	 * This method extracts credit hour from the course code
	 * @param code
	 * @return
	 */
	private int getCreditHour (String code) {
		
		int creditHour = Integer.parseInt(code.substring(4,5));
		
		return creditHour;
		
	}

}
