package javaAssignment;


class Link
{
	int data;
	Link nextLink;
	Link(int d)
	{
		data=d;

	}
}

class LinkedList
{
	public int size=0;
	Link first=null;
	
	public void insert(int d)
	{
		Link temp=new Link(d);
		temp.nextLink=first;
		first=temp;
		size++;
	}
	
	public void display()
	{
		int c=size;
		Link current=first;
		System.out.println("Elements are:");
		while(c!=0)
		{
			System.out.println(current.data);
			current=current.nextLink;
			c--;
		}
		System.out.println("Number of Nodes are="+size);
	}
	
	
}

public class Test2 {
	 
	 public static void main(String[] args)
     {
		 LinkedList a=new LinkedList();
		 a.insert(20);
		 a.insert(30);
		 
		 a.display();
		 
		 
         
     }
	 
}