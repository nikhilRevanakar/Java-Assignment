package javaAssignment;

import java.io.Console;
import java.util.ArrayList;

public class Test {
	 
	 public static void main(String[] args)
     {
         int[] val = { 1,5,2,3,6};
         int[] cpy=val;
         int i,j;
         int big=0;
         int small=0;
         int bID=0;
         int sID=0;
         int swap=0;
         boolean res=true;
         for(i=0;i<val.length;i++)
         {
        	 for( j=i+1;j<val.length;j++)
        	 {
        		 if(val[i]>cpy[j])
        		 {
        			 big=val[i];
        			 small=cpy[j];
        			 bID=i;
        			 sID=j;
        			 res=false;
        		 }
        		
        	 }
        	 if(!res)
        	 {
        		 break;
        	 }
         }
       
       
         int temp;
         temp=val[bID];
         val[bID]=cpy[sID];
         cpy[sID]=temp;
         
         for(int x:cpy)
         {
        	 System.out.println(x);
         }
         
         boolean nm=true;
         //check sorted
         for(i=0;i<cpy.length-1;i++)
         {
        	 if(nm==true)
        	 {
        	 for(j=i+1;j<cpy.length;j++)
        	 {
        	 if(cpy[i]>cpy[j])
        	 {
        		 nm=false;
        		 break;
        	 }
        	 else
        	 {
        		 nm=true;
        	 }
        	 }
         }
         }
         
         if(nm)
         {
        	 System.out.println("True");
         }
         else
         {
        	 System.out.println("False");
         }
         
         
     }
	 
}