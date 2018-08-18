package javaAssignment;

class Check
{
	int b[];
	
	Check(int[] a)
	{
		b=a;
	}
	

	public void compute()
	{
		boolean anr=true;
		int oddNum;
		int cnt=0;
		boolean res=true;
		int smallNum;
		int smallId=0;
		int j,i,k;
		
		for( i=0;i<b.length-1;i++)
		{
			
			
			for( j=i+1;j<b.length;j++)
			{
				if(b[j]<b[i])
				{
					for(k=j+1;k<b.length-1;k++)
					{
						if(b[k]<b[i])
						{
							
						}
					}
				}
				
				
					
			}
			
			
		}

		
		if(anr)
		{
			int temp=b[i];
			b[i]=b[smallId];
			b[smallId]=temp;
		}
		
		
		for( i=0;i<b.length;i++)
		{
			System.out.println(b[i]);
		}
		
	}
	
	
}



public class FirstSample 
{

	public static void main(String[] args) 
	{
		int[] a= {1,5,3,3,6};
		Check c=new Check(a);
		c.compute();
		
	}

}
