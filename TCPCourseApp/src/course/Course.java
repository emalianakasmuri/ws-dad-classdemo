package course;

import java.io.Serializable;

/**
 * This class represents definition of a course offered in FTMK
 * 
 * @author emalianakasmuri
 *
 */
public class Course implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int courseId;
	private String code;
	private String enName;
	private String msName;
	private int creditHour;
	private char degreeCode;
	private char graduateCode;
	
	public int getCourseId() {
		return courseId;
	}
	
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getEnName() {
		return enName;
	}
	
	public void setEnName(String enName) {
		this.enName = enName;
	}
	
	public String getMsName() {
		return msName;
	}
	
	public void setMsName(String msName) {
		this.msName = msName;
	}
	
	public int getCreditHour() {
		return creditHour;
	}
	
	public void setCreditHour(int creditHour) {
		this.creditHour = creditHour;
	}
	
	public char getDegreeCode() {
		return degreeCode;
	}
	
	public void setDegreeCode(char degreeCode) {
		this.degreeCode = degreeCode;
	}
	
	public char getGraduateCode() {
		return graduateCode;
	}
	
	public void setGraduateCode(char graduateCode) {
		this.graduateCode = graduateCode;
	}
	
	
	
	
	
	

}
