package ie.lyit.testers;
import ie.lyit.hotel.*;
public class GuestTester {

	public static void main(String[] args) {
		Guest  guestA= new Guest();
		Name gName=  new Name("Mr","Borat","Sagdiyev");
		Guest guestB = new Guest(gName, "087123456","borat@verynice.com");
		
		
		
		guestA.setName(new Name("Mr","Steve","Irwin"));
		guestA.setPhoneNo("086123456");
		guestA.setEmailAddress("sirwin@stingray.com");
		
		
		System.out.println("GUEST A"+guestA +"\n Guest b "+guestB);
		
		if(guestA.equals(guestB))
	System.out.println(guestA+" same as "+guestB);
		else
			System.out.println(guestA+" not same as "+guestB);
		
		
		if(guestA.getName().isFemale())
			   System.out.println(guestA+" is female ");
	      else
	         System.out.println(guestA+" is not female ");
	
	}
}

