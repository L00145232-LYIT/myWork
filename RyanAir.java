import java.util.Scanner;
public class RyanAir
{
   public static void main(String[] args)
   {
      Scanner keyboardIn = new Scanner (System.in);
   
   Scanner kIn = new Scanner(System.in);
      int[][] seats = new int[14][6];
      int row, seat, mChoice;
      
      do {
         System.out.println("Flight booking system");
         System.out.println("1. Book a seat");
         System.out.println("2. Cancel a seat");
         System.out.println("3. Show current booking status");
         System.out.println("4. Reset");
         System.out.println("0. Quit");
         System.out.print("\nenter Option: ");
         mChoice = kIn.nextInt();
         switch (mChoice)
         {
            case 0://quit
               System.out.println("\nGoodbye");
               break;
            case 1://book a seat
               System.out.print("Enter row number: ");
               row=kIn.nextInt();
               System.out.print("Enter seat number: ");
               seat=kIn.nextInt();
               if( seats[row-1][seat-1] == 0 )
               {
                  seats[row-1][seat-1]=1;
               }
               else
                  System.out.println("Seat not available");
               break;
            case 2://cancel seat
               System.out.print("Enter row number: ");
               row=kIn.nextInt();
               System.out.print("Enter seat number: ");
               seat=kIn.nextInt();
               if( seats[row-1][seat-1] ==1 ){
                  seats[row-1][seat-1]=0;
                  System.out.println("Seat cancelled");
               }
               else
                  System.out.println("Seat is not available");
               break;
            case 3://show current status
               for(row=0; row<seats.length; row++)
               {
                  for(seat=0; seat<seats[0].length; seat++)
                     System.out.print(seats[row][seat] + " ");
                  System.out.println();//skip line
               }
               break;
            case 4://reset
            for(row=0; row<seats.length; row++)
                  for(seat=0; seat<seats[0].length; seat++)
                      seats[row][seat]=0;
               break;
            default:
         } 
         
      } while (mChoice!=0);
      
      
   }
}


