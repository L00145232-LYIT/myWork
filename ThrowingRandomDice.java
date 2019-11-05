import java.util.*;
public class ThrowingRandomDice
{
   public static void main(String[] args)
   {
      Random noGenerator = new Random(); 
      //declare variable to store random no between 0 and 6
      int randomNumber1, randomNumber2 ,randomNumber3,randomNumber4 ,
         randomNumber5,randomNumber6, total  ;
     
      randomNumber1 = noGenerator.nextInt(6);
      randomNumber2 = noGenerator.nextInt(6);
     
      randomNumber3 = noGenerator.nextInt(6);
      randomNumber4 = noGenerator.nextInt(6);
     
      randomNumber5 = noGenerator.nextInt(6);
      randomNumber6 = noGenerator.nextInt(6);
   
   
      System.out.println("Dice Number 1 : " + randomNumber1);
      System.out.println("Dice Number 2 : " + randomNumber2);
       
      total= randomNumber1 + randomNumber2;
      
      if((randomNumber1 == randomNumber2)) 
      {
         System.out.println("New Dice Number 1 : " + randomNumber3 );
         System.out.println("New Dice Number 2 : " + randomNumber4);
      
      }
      
      else if(total == 3 || total == 7 || total == 11)
      {
         System.out.println("New New Dice Number 1 : " + randomNumber5);
         System.out.println("New New Dice Number 2 : " + randomNumber6);
      
      }
   
   }
}