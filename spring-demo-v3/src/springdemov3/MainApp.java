package springdemov3;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args)
	{
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		KabbadiCoach theCoach=context.getBean("kabbadiCoach",KabbadiCoach.class);
	
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyfortune());
		System.out.println(theCoach.getName());
	}

}
