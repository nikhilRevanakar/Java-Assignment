package springdemov3;

public class KabbadiCoach implements Coach 
{
	private FortuneService fortuneService;
	
	private String name;
	
	
	
	public void setName(String theName)
	{
		name=theName;
	}
	
	public String getName()
	{
		return name;
	}
	
/*	KabbadiCoach(FortuneService theFortuneService)
	{
		fortuneService=theFortuneService;
	}
*/
	
	public void setFortuneService(FortuneService theFortuneService)
	{
		fortuneService=theFortuneService;
	}
	

	@Override
	public String getDailyWorkout()
	{
		return "Play kabbadi for 2 hrs";
	}


	@Override
	public String getDailyfortune() 
	{
		return fortuneService.getFortuneService();
	}

}
