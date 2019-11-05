import java.util.Scanner;
public class CoffeeMachineTester
{
   public static void main(String []args)
   {
   
      CoffeeMachine coffee=new CoffeeMachine(100);
      Scanner keyboardIn = new Scanner (System.in);
   
   // fill 
  
   System.out.println("FILL: "  );
   coffee.fill();
    
 System.out.println("DISPLAY STATS AFTER FILL : " + coffee.getStats() +"\n --------------------------------");
 
 /*--------------------------------------------------------------------------*/  
    
   //empty
   
    System.out.println("EMPTY: "  );
   coffee.empty();
    
 System.out.println("DISPLAY STATS AFTER EMPTY : " + coffee.getStats() +"\n --------------------------------");

   /*--------------------------------------------------------------------------*/  
 
  // fill 
  
   System.out.println("FILL UP AGAIN: " + "\n --------------------------------" );
   coffee.fill();
    
 
 /*--------------------------------------------------------------------------*/  

   
   
   //make an REGULAR espresso
      System.out.println("SELECT YOUR EXPRESSO, REGULAR OR LARGE????? "  );
      coffee.makeEspresso("Regular");
      
 System.out.println("DISPLAY STATS AFTER REGULAR EXPRESSO : " + coffee.getStats() +"\n --------------------------------");
 
  /*--------------------------------------------------------------------------*/  

   //make an LARGE espresso
      System.out.println("SELECT YOUR EXPRESSO, REGULAR OR LARGE????? "  );
      coffee.makeEspresso("LaRgE");
      
 System.out.println("DISPLAY STATS AFTER LARGE EXPRESSO : " + coffee.getStats() +"\n --------------------------------");



   
  
   
   
   
   
   }//end main method
}//end class
