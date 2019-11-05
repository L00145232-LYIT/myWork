/*GET hours
GET rate
    
IF hours or rate is invalid
    DISPLAY error message         
ELSE
    CALC wages  (hours * rate)
         
    IF hours > 45
         CALC and ADD bonus 20%   (wage + (wages * .2)
    ELSE IF hours > 40
         CALC and ADD bonus 15%   (wage + (wages * .15)
    ELSE IF hours > 37
         CALC and ADD bonus 10%  (wage + (wages * .1)            
            
    DISPLAY wages
*/
import java.util.Scanner;
public class HoursRate
{ 
   public static void main(String[] args)
   { 
      Scanner keyboardIn= new Scanner(System.in);
      
      int hours;
      int rate;
      System.out.print( "Please enter amount of hrs: ") ;
      hours = keyboardIn.nextInt(); 
      System.out.print( "Please enter rate: ") ;
      rate = keyboardIn.nextInt(); 
      
      double wages = hours * rate;
       if( hours < 50 || hours < 30 )
      {
                System.out.print("invalid"); 
      } 

      if( hours > 45 )
      {
       wages = wages + ( wages * 0.2);
         System.out.print("your amount is " + wages); 
      } 
      else if( hours > 40) 
      
      {
       wages = wages + ( wages * 0.15);
         System.out.print( "your amount is " + wages); 
      } 
      
       else if( hours > 37) 
      
      {
       wages = wages + ( wages * 0.1);
         System.out.print( "your amount is " + wages); 
      } 

      
       
     
   }
}