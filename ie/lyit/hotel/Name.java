package ie.lyit.hotel;

public class Name{//class start
   private String title;
   private String firstName;
   private String surname;
// Constructors to initialise the Instance Variables
//default Constructor
//==> called when a name object is created as follows -
// Name n1= new Name();
   public Name(){
      title=firstName=surname="";
   }
//overloaded constructor
//==> called when a name object is created as follows -
// Name n2= new Name("Mr","Joe","Cole"); 
   public Name(String t, String fN, String sN){
      title=t;
      firstName=fN;
      surname=sN;
   }

   public String toString(){
      return title+ ""+ firstName+""+surname;
   }


   @Override
   public boolean equals(Object obj){
      Name nObject;
      if(obj instanceof Name)
         nObject =(Name)obj;
      else
         return false;  
   
      return this.title.equals(nObject.title)
         &&  this.firstName.equals(nObject.firstName)
         &&  this.surname.equals(nObject.surname);
   }

   public void setTitle(String setT){
      title=setT;
   }

   public void setFirstName(String setF){
	   
	//   throw new IllegalArgumentException( "invalid input; please try again");+-	    
	   firstName=setF;
	   
   }

   public void setSurname(String setS){
	   
      surname=setS;
   
	   }
   
   public String getFirstName(){
	    return this.firstName=firstName;
	   }

   public String getSurname(){
	    return this.surname=surname;
	   }

   
   public boolean isFemale(){
      if(title.equalsIgnoreCase("Miss") ||
      title.equalsIgnoreCase("Ms") ||
      title.equalsIgnoreCase("Mrs"))
         return true;
      else
         return false;
   
   }
}
