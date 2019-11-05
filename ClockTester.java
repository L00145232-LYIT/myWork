/*
	Written by : James Kelly
	Date:
	Desc:
*/

public class ClockTester
{
   public static void main(String [] args)
   {  
	   // create an instance of type Clock
	   Clock myclock = new Clock();	  	   
	
      //to see the time have to call all three methods
      System.out.println("The time is : " +myclock.getHours() +":"
         + myclock.getMinutes() +":"  +myclock.getSeconds() ); 

      //System.out.println(myclock);  
		for(int i = 0; i < 10000; i++)
			myclock.tickTock();
			
		 System.out.println("The time is : " +myclock.getHours() +":"
         + myclock.getMinutes() +":"  +myclock.getSeconds() ); 
       
       
     //  System.out.println(myclock); 	//this calls .toString()
		
   }
}
