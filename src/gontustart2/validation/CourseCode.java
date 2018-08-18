package gontustart2.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy= CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode
{
	//Definr default course code
	public String value() default "LUV";
	
	//Define default error msg
	public String message() default "must start with LUV";
	
	//Define default groups
	public Class<?>[] groups() default {};
	
	//Define default p ayload
	public Class<? extends Payload>[] payload() default{};

}
