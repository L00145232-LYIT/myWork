/*Question 2
A restaurant offers 4 main course options on its 
Christmas menu
1. Turkey and Ham
2. Steak (€5 supplement)
3. Nut roast (vegetarian)
4. Lasagne
A Java program is required that first displays the menu,
 and then ask the user to enter the number of people 
 in their party.
 For each person in the party the 
 program should read their choice of main course.
 The program should count and display the number of
each main course chosen, and the total cost of the booking.
 Each main course costs
€22.00, steak has a €5.00 euro supplement, and the vegetarian option has a €3.00
discount.*/
import java.util.*;


public class HappyChristmas {

    
   public static void main(String[] args) {
        
      Scanner keyboardIn = new Scanner(System.in);
      boolean quit= false;
      double sum=0;
      double coke=2.55,crisps=0.95,beer=4.22;
   
        
      do{
         System.out.println(" Christmas menu\n 1. Turkey and Ham\n 2. Steak (5 Euro supplement)\n 3. Nut roast (vegetarian)\n 4. Lasagne");      
         System.out.print("Please Enter an option: ");
         int choice=keyboardIn.nextInt();
            
      
            
         switch(choice){
            case 1:System.out.println("Coke"+"\n");
               sum=sum+coke;
                        
                        
               break;
            case 2:
               System.out.println("Crisps");
               sum=sum+crisps;
                  
                    
               break;
            case 3: System.out.print("What age are ye sir?  ");
               int age=keyboardIn.nextInt();
            
               if(age >=18){
                  System.out.println("Beer");
                  sum=sum+beer;
               }
               break;
               
            case 4:
               quit=true;
                     
               break;
            default:
               System.out.println("Wrong input");
         }
        
      }while(!quit);
       
        
      System.out.println("Your total bill="+sum);
        
      System.out.println("Thank you");
    
        
        
        
    
   }
    
}
