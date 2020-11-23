package ie.lyit.testers;
import ie.lyit.hotel.*;
import java.util.*;
public class NameTester{//start class
   public static void main(String[] args){
      Name personA=new Name();
   
      System.out.println(personA);
   
      personA.setTitle("Mr");
      personA.setFirstName("Homer");
      personA.setSurname("Simpson");
   
      System.out.println(personA);
   
      Name personB=new Name("Mrs","Marge","Simpson");
   
      System.out.println(personA);
   
      if(personA.equals(personB))
         System.out.println(personA+" is same as "+personB);
      else
         System.out.println(personA+" is not same as "+personB);
   
      if(personA.isFemale())
         System.out.println(personA+" is female ");
      else
         System.out.println(personA+" is not female ");
   
      ArrayList<Name> names=new ArrayList<Name>();
      names.add(new Name("Mr","Bart","Simpson"));
      names.add(personA);
      names.add(personB);
      names.trimToSize();
      
//      for(Name tempName:names)
//         System.out.println(tempName);
//      
//      System.out.println(names);
//   
//      if(nameSearch(personA, names))
//            System.out.println("Found");
//            else
//                  System.out.println("Not found");
 }
////end main
// public static boolean nameSearch(Name nameSearch, ArrayList<Name> listOfNames)
// return listOfNames.contains(nameSearch);
}//end class
