package gontustart2;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import gontustart2.validation.CourseCode;

public class Customer 
{
	@NotNull(message="is required")
	public String firstName;
	
	@NotNull(message="is required")
	@Size(min=1,message="is required")
	public String lastName;
	
	@NotNull(message="is required")
	@Min(value=0,message="must be greater than or equal to zero")
	@Max(value=10,message="must be lesser than or equal to ten")
	private Integer freePasses;
	
	@Pattern(regexp="^[A-Za-z0-9]{5}",message="must be only 5 chars/digits")
	public String postalCode;
	
	@CourseCode(value="Tops",message="must start with tops")
	private String courseCode;
	
	
	
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getFirstName() 
	{
		return firstName;
	}
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	public String getLastName() 
	{
		return lastName;
	}
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	public Integer getFreePasses() {
		return freePasses;
	}
	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	

}
